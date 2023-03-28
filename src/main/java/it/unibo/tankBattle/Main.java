package it.unibo.tankBattle;

import it.unibo.tankBattle.view.api.View;
import it.unibo.tankBattle.view.impl.javafx.controller.ViewController;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * 
 */
public class Main extends Application {

    private View viewController;

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
        viewController = new ViewController();
        viewController.start(stage);
    }

}
