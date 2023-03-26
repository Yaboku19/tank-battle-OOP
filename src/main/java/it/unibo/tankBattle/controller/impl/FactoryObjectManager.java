package it.unibo.tankBattle.controller.impl;

import java.net.URISyntaxException;

import javax.xml.bind.JAXBException;

import it.unibo.tankBattle.model.gameSetup.impl.MapData;
import it.unibo.tankBattle.model.gameSetup.impl.MapDataList;
import it.unibo.tankBattle.model.gameSetup.impl.TankData;
import it.unibo.tankBattle.model.gameSetup.impl.TankDataList;

public class FactoryObjectManager {
    
    public ObjectsManagerImpl<TankData, TankDataList> tankManager() throws URISyntaxException, JAXBException {
        return new ObjectsManagerImpl<TankData,TankDataList>
            (ClassLoader.getSystemResource("config/tankConfig.xml").toURI()
            , TankDataList.class);
    }

    public ObjectsManagerImpl<MapData, MapDataList> MapManager() throws URISyntaxException, JAXBException{
        return new ObjectsManagerImpl<MapData,MapDataList>
            (ClassLoader.getSystemResource("config/mapConfig.xml").toURI()
            , MapDataList.class);
    }
}
