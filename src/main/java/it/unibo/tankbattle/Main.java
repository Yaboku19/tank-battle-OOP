package it.unibo.tankbattle;

import it.unibo.tankbattle.view.api.View;
import it.unibo.tankbattle.view.impl.javafx.controller.ViewController;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * 
 */
public class Main extends Application {

    /**
     * The main of the application.
     * @param args
     *              arguments
     */
    public static void main(final String[] args) {
        launch(args);
    }

    /**
    * {@inheritDoc}
    */
    @Override
    public void start(final Stage stage) {
        final View viewController = new ViewController();
        viewController.start(stage);
    }

}
