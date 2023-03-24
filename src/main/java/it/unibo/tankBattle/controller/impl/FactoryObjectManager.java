package it.unibo.tankBattle.controller.impl;

import java.net.URISyntaxException;
import it.unibo.tankBattle.model.gameSetup.impl.MapData;
import it.unibo.tankBattle.model.gameSetup.impl.MapDataList;
import it.unibo.tankBattle.model.gameSetup.impl.TankData;
import it.unibo.tankBattle.model.gameSetup.impl.TankDataList;

public class FactoryObjectManager {
    
    public ObjectsManagerImpl<TankData, TankDataList> tankManager() throws URISyntaxException {
        var toReturn = new ObjectsManagerImpl<TankData,TankDataList>(ClassLoader.getSystemResource("config/tankConfig.xml").toURI());
        toReturn.read(TankDataList.class);
        return toReturn;
    }

    public ObjectsManagerImpl<MapData, MapDataList> MapManager() throws URISyntaxException{
        var toReturn = new ObjectsManagerImpl<MapData,MapDataList>(ClassLoader.getSystemResource("config/mapConfig.xml").toURI());
        toReturn.read(MapDataList.class);
        return toReturn;
    }
}
