package it.unibo.tankBattle;

import java.io.IOException;

import it.unibo.tankBattle.controller.api.GameEngine;
import it.unibo.tankBattle.controller.impl.BasicGameEngine;
import it.unibo.tankBattle.view.api.View;
import it.unibo.tankBattle.view.impl.javafx.controller.ViewController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * 
 */
public class Main extends Application{

    private View viewController;

    /**
     * The main of the application.
     * @param args
     *              arguments
     */
    public static void main(final String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage){
        viewController = new ViewController();
        viewController.start(stage);
    }

}
