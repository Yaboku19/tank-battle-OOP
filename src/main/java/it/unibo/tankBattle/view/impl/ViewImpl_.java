package it.unibo.tankBattle.view.impl;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.common.input.api.Directions;
import it.unibo.tankBattle.common.input.api.InputController;
import it.unibo.tankBattle.common.input.impl.KeyboardInputController;
import it.unibo.tankBattle.common.input.impl.Movement;
import it.unibo.tankBattle.common.input.impl.Shoot;
import it.unibo.tankBattle.controller.api.GameEngine;
import it.unibo.tankBattle.view.api.View;
import static java.awt.event.KeyEvent.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ViewImpl_{
    /*private final FactoryGameScenes factory;
    private final JPanel mainPanel;
    private final JPanel menuPanel;
    private final JPanel tutorialPanel;
    private final JPanel gameChoosePanel;
    private JPanel gameScenePanel = new JPanel();
    private JPanel courrentPanel = new JPanel();*/
    private InputController playerController1;
    private InputController playerController2;
    //private final Image imgBackGround = Toolkit.getDefaultToolkit().getImage("C:\\Users\\marte\\OneDrive\\Desktop\\OOP-Project\\src\\main\\java\\it\\unibo\\tankBattle\\view\\impl\\download.jpg");
    //private final Image tankImage = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Tomas\\Documents\\Università\\2anno\\1\\OOP\\Progetto\\tank-battle-OOP\\src\\main\\java\\it\\unibo\\tankBattle\\view\\impl\\Resources\\tank1.gif");
    //Icon icon = new ImageIcon("C:\\Users\\Tomas\\Documents\\Università\\2anno\\1\\OOP\\Progetto\\tank-battle-OOP\\src\\main\\java\\it\\unibo\\tankBattle\\view\\impl\\Resources\\tank1.gif");
    //JLabel label = new JLabel(icon);
    

    private final GameEngine controller;
    /************************ */

    public ViewImpl_(final GameEngine controller){
        this.controller = controller;
        //this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        //this.factory = new FactoryGameScenes(this);

        this.playerController1 = new KeyboardInputController(VK_UP,VK_DOWN,VK_LEFT,VK_RIGHT, VK_SPACE);
        this.playerController2 = new KeyboardInputController(VK_W,VK_S,VK_A,VK_D, VK_CONTROL);
    }


       /*menuPanel = factory.menu();
        tutorialPanel = factory.tutorial();
        gameChoosePanel = factory.gameChoose();
        mainPanel = new JPanel();
        mainPanel.setPreferredSize(this.getSize());
        mainPanel.setBackground(Color.BLACK);
         
        this.setContentPane(new JPanel() {
            
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                //g.drawImage(tankImage, -150, -150, getWidth(), getHeight(), null);
                /*g.drawImage(imgBackGround, 0, 0, getWidth(), getHeight(), null);*/
                /*g.drawRect(position.getX(), position.getY(), 50, 50);
                g.fillRect(position.getX(), position.getY(), 50, 50);
                g.setColor(Color.BLACK);
            }
         });
        mainPanel.add(menuPanel);
        mainPanel.add(tutorialPanel);
        mainPanel.add(gameChoosePanel);
        courrentPanel = menuPanel;
        //mainPanel.setVisible(false);
        menuPanel.setVisible(false);
        tutorialPanel.setVisible(false);
        gameScenePanel.setVisible(false);

        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("TankBattle");
        this.add(mainPanel);
        addKeyListener(this);
        setFocusable(true);
        
    }*/

    
    public void drawMap() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'drawMap'");
    }

    
    public void drawTank(P2d position) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'drawTank'");
    }

    
    public void drawBullet(P2d position) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'drawBullet'");
    }


    public void chooseMenu() {
        /*courrentPanel.setVisible(false);
        courrentPanel = gameChoosePanel;
        this.setVisible(true);
        label.setPreferredSize(new Dimension(icon.getIconHeight(), icon.getIconWidth()));
        his.add(label);
        mainPanel.setVisible(false);
        courrentPanel.setVisible(true);
        this.repaint();*/
    }

    public void bugSolve() {
        /*courrentPanel.setVisible(true);
        repaint();*/
    }

    public void startGame(){
        controller.startGame();
        /*gameScenePanel.add(gameScenePanel);*/
    }

    /*
    public void keyPressed(KeyEvent e) {
        System.out.println("keypressed");

        /*controller.getControllers().forEach((p,k) -> {
            if(k.getKeyCodes().contains(e.getKeyCode())){
                switch(e.getKeyCode()){
                    case VK_UP, VK_W: 
                        controller.notifyCommand(p, new Movement(Directions.UP));
                        break;
                    case VK_DOWN, VK_S:
                        controller.notifyCommand(p, new Movement(Directions.DOWN));
                        break;
                    case VK_LEFT, VK_A:
                        controller.notifyCommand(p, new Movement(Directions.LEFT));
                        break;
                    case VK_RIGHT, VK_D:
                        controller.notifyCommand(p, new Movement(Directions.RIGHT));
                        break;
                    case VK_SPACE, VK_CONTROL:
                        controller.notifyCommand(p, new Shoot());
                        break;
                }
            }
        });*/

/*
        if(e.getKeyCode() == KeyEvent.VK_W){
            //controller.notifyCommand(e.getKeyCode());
            position = new P2d(position.getX(), position.getY()-1);
            this.repaint();
            System.out.println("move up");
        }
        if(e.getKeyCode() == KeyEvent.VK_A){
            //controller.notifyCommand(e.getKeyCode());
            position = new P2d(position.getX()-1, position.getY());
            this.repaint();
            System.out.println("move left");
        }
        if(e.getKeyCode() == KeyEvent.VK_D){
            //controller.notifyCommand(e.getKeyCode());
            position = new P2d(position.getX()+1, position.getY());
            this.repaint();
            System.out.println("move right");
        }
        if(e.getKeyCode() == KeyEvent.VK_S){
            //controller.notifyCommand(e.getKeyCode());
            position = new P2d(position.getX(), position.getY()+1);
            this.repaint();
            System.out.println("move down");
        }
    }

    
    public void keyReleased(KeyEvent e) {
        System.out.println("key released");
        //throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }

    
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }*/

    
    public InputController getInputControllerPlayer1() {
        return playerController1;
    }
    
    
    public InputController getInputControllerPlayer2() {
        return playerController2;
    }

    
    public void handle(Event event) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'handle'");
    }

    
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("src\\main\\resources\\layouts\\primaSchermata.fxml"));
    
        Scene scene = new Scene(root, 300, 275);
    
        stage.setTitle("FXML Welcome");
        stage.setScene(scene);
        stage.show();
    }


}
