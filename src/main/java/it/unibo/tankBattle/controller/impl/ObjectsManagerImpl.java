package it.unibo.tankBattle.controller.impl;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.unibo.tankBattle.common.NextAndPrevious;
import it.unibo.tankBattle.controller.api.ObjectsManager;

public abstract class ObjectsManagerImpl<T> implements ObjectsManager<T> {

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
    @Override
    abstract public void read();

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
