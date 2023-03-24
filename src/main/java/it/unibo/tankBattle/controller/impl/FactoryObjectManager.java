package it.unibo.tankBattle.controller.impl;

import java.io.File;
import java.net.URISyntaxException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import it.unibo.tankBattle.model.gameSetup.impl.MapData;
import it.unibo.tankBattle.model.gameSetup.impl.MapDataList;
import it.unibo.tankBattle.model.gameSetup.impl.TankData;
import it.unibo.tankBattle.model.gameSetup.impl.TankDataList;

public class FactoryObjectManager {
    
    public ObjectsManagerImpl<TankData> tankManager() throws URISyntaxException {
        return new ObjectsManagerImpl<TankData>(ClassLoader.getSystemResource("config/tankConfig.xml").toURI()) {
            @Override
            public void read() {
                TankDataList tankList = getUnmarshaller(TankDataList.class, getConfig());
                for (int i = 0; i < tankList.getData().size(); i++) {
                    getMap().put(tankList.getData().get(i).getName(), tankList.getData().get(i));
                    getKeysOrdered().add(tankList.getData().get(i).getName());
                }
            }
            
        };
    }

    public ObjectsManagerImpl<MapData> MapManager() throws URISyntaxException{
        return new ObjectsManagerImpl<MapData>(ClassLoader.getSystemResource("config/mapConfig.xml").toURI()) {
            @Override
            public void read() {
                MapDataList mapList = getUnmarshaller(MapDataList.class, getConfig());
                for (int i = 0; i < mapList.getData().size(); i++) {
                    getMap().put(mapList.getData().get(i).getName(), mapList.getData().get(i));
                    getKeysOrdered().add(mapList.getData().get(i).getName());
                }
            }
            
        };
    }

    @SuppressWarnings("unchecked")
    private <T> T getUnmarshaller(Class<T> C, File config) {
        try {
            final JAXBContext jaxbContext = JAXBContext.newInstance(C);
            final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            var dataList = (T) unmarshaller.unmarshal(config);
            return dataList;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
