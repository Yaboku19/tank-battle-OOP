package it.unibo.tankBattle.controller.impl;

import it.unibo.tankBattle.model.gameSetup.MapData;
import it.unibo.tankBattle.model.gameSetup.MapDataList;
import it.unibo.tankBattle.model.gameSetup.TankData;

import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import it.unibo.tankBattle.model.gameSetup.TankDataList;

public class FactoryObjectManager {
    
    public ObjectsManagerImpl<TankData> tankManager() throws URISyntaxException {
        return new ObjectsManagerImpl<TankData>(ClassLoader.getSystemResource("config/tankConfig.xml").toURI()) {
            private TankDataList tankList = new TankDataList();
            @Override
            public void read() {
                tankList.setTank(new ArrayList<TankData>());
                try {
                    final JAXBContext jaxbContext = JAXBContext.newInstance(TankDataList.class);
                    final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        
                    /*if (!config.exists()) {
                        copyVirusConfig();
                    }*/
                    tankList = (TankDataList) unmarshaller.unmarshal(config);
                    for (int i = 0; i < tankList.getTanks().size(); i++) {
                        tankMap.put(tankList.getTanks().get(i).getName(), tankList.getTanks().get(i));
                        keyOrder.add(tankList.getTanks().get(i).getName());
                    }
                } catch (JAXBException e) {
                    e.printStackTrace();
                }
            }
            
        };
    }

    public ObjectsManagerImpl<MapData> MapManager() throws URISyntaxException{
        return new ObjectsManagerImpl<MapData>(ClassLoader.getSystemResource("config/mapConfig.xml").toURI()) {
            private MapDataList mapList = new MapDataList();
            @Override
            public void read() {
                mapList.setMap(new ArrayList<MapData>());
                try {
                    final JAXBContext jaxbContext = JAXBContext.newInstance(MapDataList.class);
                    final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        
                    /*if (!config.exists()) {
                        copyVirusConfig();
                    }*/
                    mapList = (MapDataList) unmarshaller.unmarshal(config);
                    for (int i = 0; i < mapList.getMaps().size(); i++) {
                        tankMap.put(mapList.getMaps().get(i).getName(), mapList.getMaps().get(i));
                        keyOrder.add(mapList.getMaps().get(i).getName());
                    }
                } catch (JAXBException e) {
                    e.printStackTrace();
                }
            }
            
        };
    }

    private <T, P> void readCommon() {

    }
}
