package it.unibo.tankBattle.controller.impl;

import java.io.File;
import java.net.URISyntaxException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import it.unibo.tankBattle.model.gameSetup.api.Data;
import it.unibo.tankBattle.model.gameSetup.api.DataList;
import it.unibo.tankBattle.model.gameSetup.impl.MapData;
import it.unibo.tankBattle.model.gameSetup.impl.MapDataList;
import it.unibo.tankBattle.model.gameSetup.impl.TankData;
import it.unibo.tankBattle.model.gameSetup.impl.TankDataList;

public class FactoryObjectManager {
    
    public ObjectsManagerImpl<TankData> tankManager() throws URISyntaxException {
        return new ObjectsManagerImpl<TankData>(ClassLoader.getSystemResource("config/tankConfig.xml").toURI()) {
            @Override
            public void read() {
                getUnmarshaller(TankDataList.class, getConfig(), this);
            }
            
        };
    }

    public ObjectsManagerImpl<MapData> MapManager() throws URISyntaxException{
        return new ObjectsManagerImpl<MapData>(ClassLoader.getSystemResource("config/mapConfig.xml").toURI()) {
            @Override
            public void read() {
                getUnmarshaller(MapDataList.class, getConfig(), this);
            }
        };
    }

    @SuppressWarnings("unchecked")
    private <T extends DataList<C>, C extends Data> void getUnmarshaller(Class<T> c, File config, ObjectsManagerImpl<C> setup) {
        try {
            final JAXBContext jaxbContext = JAXBContext.newInstance(c);
            final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            var dataList = (T) unmarshaller.unmarshal(config);
            for (int i = 0; i < dataList.getData().size(); i++) {
                setup.getMap().put(dataList.getData().get(i).getName(), dataList.getData().get(i));
                setup.getKeysOrdered().add(dataList.getData().get(i).getName());
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
