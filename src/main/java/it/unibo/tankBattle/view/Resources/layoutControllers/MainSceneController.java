package it.unibo.tankBattle.view.resources.layoutControllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainSceneController {//implements EventHandler<KeyEvent>{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button playButton;

    @FXML
    private Button tutorialButton;

    @FXML
    void play(ActionEvent event) {
        try{
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../layout/game.fxml"));
            Scene game = new Scene(fxmlLoader.load(), 600, 400);
            stage.setScene(game); 
            stage.setFullScreen(true);
            stage.setResizable(true); 

        }catch(Exception e){
            System.out.println(e.toString());
        }
    }

    @FXML
    void tutorial(ActionEvent event) {
        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../layout/tutorial.fxml"));
            Scene tutorial = new Scene(fxmlLoader.load(), 600, 400);
            stage.setScene(tutorial);
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }

    @FXML
    void initialize() {
        assert playButton != null : "fx:id=\"playButton\" was not injected: check your FXML file 'mainScene.fxml'.";
        assert tutorialButton != null : "fx:id=\"tutorialButton\" was not injected: check your FXML file 'mainScene.fxml'.";

    }

/*    @Override
    public void handle(KeyEvent e) {
        System.out.println("keyPressed");

            if(e.getCode() == KeyCode.RIGHT){
                newX = newX + 10;
                circle.setTranslateX(newX);
            }
            else if(e.getCode() == KeyCode.LEFT){
                newX = newX - 10;
                circle.setTranslateX(newX);
            }
            else if(e.getCode() == KeyCode.UP){
                newY = newY - 10;
                circle.setTranslateY(newY);
            }
            else if(e.getCode() == KeyCode.DOWN){
                newY = newY + 10;
                circle.setTranslateY(newY);
            }
    }*/

}
