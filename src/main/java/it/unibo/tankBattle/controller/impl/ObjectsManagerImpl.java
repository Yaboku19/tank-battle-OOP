package it.unibo.tankBattle.controller.impl;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;

import java.io.OutputStream;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import it.unibo.tankBattle.controller.api.ObjectsManager;
import it.unibo.tankBattle.model.gameSetup.TankData;
import it.unibo.tankBattle.model.gameSetup.TankDataList;
import it.unibo.tankBattle.view.impl.javafx.controller.ChooseMenu;

/*import model.virus.Virus;
import model.virus.VirusData;
import model.virus.VirusDataList;
import model.virus.VirusFactory;
import model.virus.VirusFactoryImpl;
import view.VirusSetup;*/

public class ObjectsManagerImpl<T,P> implements ObjectsManager<T,P> {

    private final File folder = new File(System.getProperty("user.home"), ".TB");

    private final File config = new File(folder, "gameConfig.xml");

    private final String path;// = "config/tankConfig.xml";

    private TankDataList tankList = new TankDataList();
    private final Map<String, TankData> tankMap = new HashMap<String, TankData>();

    /**
     * Constructor method.
     * 
     */
    public ObjectsManagerImpl(String path) {
        this.path = path;
        tankList.setTank(new ArrayList<TankData>());
    }

    /**
     *
     */
    @Override
    public void read() {
        try {
            final JAXBContext jaxbContext = JAXBContext.newInstance(TankDataList.class);
            final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            /*if (!config.exists()) {
                copyVirusConfig();
            }*/
            tankList = (TankDataList) unmarshaller.unmarshal(config);
            for (int i = 0; i < tankList.getTanks().size(); i++) {
                tankMap.put(tankList.getTanks().get(i).getName(), tankList.getTanks().get(i));
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public T getActual() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getActual'");
    }

    @Override
    public void next() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'next'");
    }

    @Override
    public void previous() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'previous'");
    }

}
