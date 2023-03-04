package it.unibo.tankBattle.view.impl;

import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.controller.api.GameEngine;
import it.unibo.tankBattle.controller.impl.BasicGameEngine;
import it.unibo.tankBattle.view.api.View;

import java.awt.Color;
import java.awt.Graphics;


public class ViewImpl extends View implements KeyListener{
    private final FactoryGameScenes factory;
    private final JPanel mainPanel;
    private final JPanel menuPanel;
    private final JPanel tutorialPanel;
    private final JPanel gameChoosePanel;
    private JPanel gameScenePanel = new JPanel();
    private JPanel courrentPanel = new JPanel();
    //private final Image imgBackGround = Toolkit.getDefaultToolkit().getImage("C:\\Users\\marte\\OneDrive\\Desktop\\OOP-Project\\src\\main\\java\\it\\unibo\\tankBattle\\view\\impl\\download.jpg");
    private final GameEngine controller;

    public ViewImpl(final GameEngine controller){
        this.controller = controller;
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.factory = new FactoryGameScenes(this);

        menuPanel = factory.menu();
        tutorialPanel = factory.tutorial();
        gameChoosePanel = factory.gameChoose();
        mainPanel = new JPanel();
        mainPanel.setPreferredSize(this.getSize());
        mainPanel.setBackground(Color.BLACK);
        /*this.setContentPane(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
               super.paintComponent(g);
               g.drawImage(imgBackGround, 0, 0, getWidth(), getHeight(), null);
            }
         });*/

        mainPanel.add(menuPanel);
        mainPanel.add(tutorialPanel);
        mainPanel.add(gameChoosePanel);
        courrentPanel = menuPanel;
        menuPanel.setVisible(false);
        tutorialPanel.setVisible(false);
        gameScenePanel.setVisible(false);

        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("TankBattle");
        this.add(mainPanel);
        addKeyListener(this);
        setFocusable(true);
        
    }

    @Override
    public void drawMap() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'drawMap'");
    }

    @Override
    public void drawTank(P2d position) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'drawTank'");
    }

    @Override
    public void drawBullet(P2d position) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'drawBullet'");
    }

    @Override
    public void tutorial() {
        courrentPanel.setVisible(false);
        courrentPanel = tutorialPanel;
        courrentPanel.setVisible(true);
        this.repaint();
    }

    @Override
    public void menu() {
        courrentPanel.setVisible(false);
        courrentPanel = menuPanel;
        courrentPanel.setVisible(true);
        this.repaint();
    }

    public void chooseMenu() {
        courrentPanel.setVisible(false);
        courrentPanel = gameChoosePanel;
        courrentPanel.setVisible(true);
        this.repaint();
    }

    public void bugSolve() {
        courrentPanel.setVisible(true);
        repaint();
    }

    public void startGame(){
        controller.startGame();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("keypressed");
        if(e.getKeyCode() == KeyEvent.VK_W){
            //controller.notifyCommand(e.getKeyCode());
            System.out.println("move up");
        }
        if(e.getKeyCode() == KeyEvent.VK_A){
            //controller.notifyCommand(e.getKeyCode());
            System.out.println("move left");
        }
        if(e.getKeyCode() == KeyEvent.VK_D){
            //controller.notifyCommand(e.getKeyCode());
            System.out.println("move right");
        }
        if(e.getKeyCode() == KeyEvent.VK_S){
            //controller.notifyCommand(e.getKeyCode());
            System.out.println("move down");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("key released");
        //throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }
    
}
