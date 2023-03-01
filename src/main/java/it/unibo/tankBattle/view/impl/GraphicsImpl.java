package it.unibo.tankBattle.view.impl;


import javax.swing.JPanel;
import java.awt.Toolkit;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.view.api.Graphics;

public class GraphicsImpl extends Graphics {
    private final FactoryGameScenes factory;
    private final JPanel menu;
    private final JPanel tutorial;
    private JPanel gameScene = new JPanel();
    private JPanel courrentPanel = new JPanel();

    public GraphicsImpl() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.factory = new FactoryGameScenes(this);
        menu = factory.menu();
        tutorial = factory.tutorial();
        this.setContentPane(menu);
        courrentPanel = menu;
        tutorial.setVisible(true);
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setResizable(false);
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
        this.setContentPane(tutorial);
        courrentPanel = tutorial;
        this.repaint();
    }

    @Override
    public void menu() {
        this.remove(courrentPanel);
        courrentPanel = menu;
        this.setContentPane(courrentPanel);
    }
    
}
