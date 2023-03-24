package it.unibo.tankBattle.controller.impl;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import it.unibo.tankBattle.common.NextAndPrevious;
import it.unibo.tankBattle.controller.api.ObjectsManager;
import it.unibo.tankBattle.model.gameSetup.api.Data;
import it.unibo.tankBattle.model.gameSetup.api.DataList;

public class ObjectsManagerImpl<T extends Data, C extends DataList<T>> implements ObjectsManager<T, C> {

    //private final File folder = new File(System.getProperty("user.home"), ".TB");
    private final File config;

    //private final String path;// = "config/tankConfig.xml";

    private final Map<String, T> dataMap = new HashMap<String, T>();
    private final List<String> keyOrder = new ArrayList<>();
    private int index = 0;

    /**
     * Constructor method.
     * 
     */
    public ObjectsManagerImpl(URI path) {
        config = new File(path);
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    @Override
    public void read(Class<C> c) {
        try {
            final JAXBContext jaxbContext = JAXBContext.newInstance(c);
            final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            var dataList = (C) unmarshaller.unmarshal(config);
            for (int i = 0; i < dataList.getData().size(); i++) {
                getMap().put(dataList.getData().get(i).getName(), dataList.getData().get(i));
                getKeysOrdered().add(dataList.getData().get(i).getName());
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public T getActual() {
        return dataMap.get(keyOrder.get(index));
    }
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

    protected File getConfig() {
        return config;
    }

    protected List<String> getKeysOrdered() {
        return keyOrder;
    }

    protected Map<String, T> getMap() {
        return dataMap;
    }
}
