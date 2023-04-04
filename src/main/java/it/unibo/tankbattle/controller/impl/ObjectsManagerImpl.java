package it.unibo.tankbattle.controller.impl;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import it.unibo.tankbattle.common.NextAndPrevious;
import it.unibo.tankbattle.controller.api.ObjectsManager;
import it.unibo.tankbattle.model.gamesetup.api.Data;
import it.unibo.tankbattle.model.gamesetup.api.DataList;

/**
 * An implementation of ObjectsManger {@link ObjectsManager}.
 * @param <T> data type
 * @param <C> dataList type
 */
public class ObjectsManagerImpl<T extends Data, C extends DataList<T>> implements ObjectsManager<T, C> {
    private final File config;
    private final Map<String, T> dataMap = new HashMap<>();
    private final List<String> keyOrder = new ArrayList<>();
    private int index;

    /**
     * The costructor of ObjectManagerImpl.
     * @param path the path for the xml file
     * @param clas the type for the read
     * @throws JAXBException when the JAXBContext has some error
     */
    public ObjectsManagerImpl(final URI path, final Class<C> clas) throws JAXBException {
        config = new File(path);
        read(clas);
    }

    @SuppressWarnings("unchecked")
    private void read(final Class<C> c) throws JAXBException {
        final JAXBContext jaxbContext = JAXBContext.newInstance(c);
        final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        final var dataList = (C) unmarshaller.unmarshal(config);
        for (int i = 0; i < dataList.getData().size(); i++) {
            dataMap.put(dataList.getData().get(i).getName(), dataList.getData().get(i));
            keyOrder.add(dataList.getData().get(i).getName());
        }
    }

    /**
    * {@inheritDoc}
    */
    @Override
    public T getActual() {
        return dataMap.get(keyOrder.get(index));
    }

    /**
    * {@inheritDoc}
    */
    @Override
    public void update(final NextAndPrevious delta) {
        index += delta.getDelta();
        if (index >= keyOrder.size()) {
            index = 0;
        }
        if (index < 0) {
            index = keyOrder.size() - 1;
        }
    }
}
