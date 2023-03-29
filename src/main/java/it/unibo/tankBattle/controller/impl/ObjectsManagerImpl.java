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
import it.unibo.tankbattle.model.gameSetup.api.Data;
import it.unibo.tankbattle.model.gameSetup.api.DataList;
/**
 * javadoc.
 * @param <T> param
 * @param <C> param
 */
public class ObjectsManagerImpl<T extends Data, C extends DataList<T>> implements ObjectsManager<T, C> {
    private final File config;
    private final Map<String, T> dataMap = new HashMap<String, T>();
    private final List<String> keyOrder = new ArrayList<>();
    private int index = 0;

    /**
     * javadoc.
     * @param path param
     * @param clas prama
     * @throws JAXBException throws
     */
    public ObjectsManagerImpl(final URI path, final Class<C> clas) throws JAXBException {
        config = new File(path);
        read(clas);
    }

    /**
     * javadoc.
     * @param c param
     * @throws JAXBException throws
     */
    @SuppressWarnings("unchecked")
    private void read(final Class<C> c) throws JAXBException {
        final JAXBContext jaxbContext = JAXBContext.newInstance(c);
        final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        var dataList = (C) unmarshaller.unmarshal(config);
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
