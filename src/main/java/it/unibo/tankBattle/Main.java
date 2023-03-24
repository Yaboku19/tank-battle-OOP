package it.unibo.tankBattle;

import java.io.IOException;

import it.unibo.tankBattle.controller.api.GameEngine;
import it.unibo.tankBattle.controller.impl.BasicGameEngine;
import it.unibo.tankBattle.view.api.View;
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
        FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("layout/mainScene.fxml"));
        Parent root;
        try {
            root = loader.load();
            final View view = loader.getController();
            final GameEngine controller = new BasicGameEngine(view);
            view.setController(controller);
            final Scene scene = new Scene(root);
            view.setMainMenuScene(scene);
            stage.setTitle("Tank-Battle");
            stage.setScene(scene);
            stage.setOnCloseRequest(e -> {
                Platform.exit();
                System.exit(0);
            });
            stage.show();
            //loader.getController();
            
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        //scene.setOnKeyPressed(this);
    }

}
