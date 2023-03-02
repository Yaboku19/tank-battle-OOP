package it.unibo.tankBattle.view.impl;


import javax.swing.JPanel;
import java.awt.Toolkit;
import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.view.api.Graphics;

public class GraphicsImpl extends Graphics {
    private final FactoryGameScenes factory;
    private final JPanel mainPanel;
    private final JPanel menuPanel;
    private final JPanel tutorialPanel;
    private final JPanel gameChoosePanel;
    private JPanel gameScenePanel = new JPanel();
    private JPanel courrentPanel = new JPanel();

    public GraphicsImpl() {
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.factory = new FactoryGameScenes(this);
        menuPanel = factory.menu();
        tutorialPanel = factory.tutorial();
        gameChoosePanel = factory.gameChoose();
        mainPanel = new JPanel();
        mainPanel.setPreferredSize(this.getSize());

        this.setContentPane(mainPanel);
        mainPanel.add(menuPanel);
        mainPanel.add(tutorialPanel);
        mainPanel.add(gameChoosePanel);
        courrentPanel = menuPanel;

        menuPanel.setVisible(true);
        tutorialPanel.setVisible(false);

        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("TankBattle");
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
    
}
