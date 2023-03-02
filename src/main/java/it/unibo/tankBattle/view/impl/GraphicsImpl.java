package it.unibo.tankBattle.view.impl;


import javax.swing.JPanel;
import javax.swing.text.View;

import java.awt.Toolkit;
import java.awt.Dimension;
import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.view.api.Graphics;

public class GraphicsImpl extends Graphics {
    private final FactoryGameScenes factory;
    private final JPanel mainPanel;
    private final JPanel menu;
    private final JPanel tutorial;
    private JPanel gameScene = new JPanel();
    private JPanel courrentPanel = new JPanel();

    public GraphicsImpl() {
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.factory = new FactoryGameScenes(this);
        menu = factory.menu();
        tutorial = factory.tutorial();
        mainPanel = new JPanel();
        mainPanel.setPreferredSize(this.getSize());

        this.setContentPane(mainPanel);
        mainPanel.add(menu);
        mainPanel.add(tutorial);
        courrentPanel = menu;

        menu.setVisible(true);
        tutorial.setVisible(false);

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
        courrentPanel = tutorial;
        courrentPanel.setVisible(true);
        this.repaint();
    }

    @Override
    public void menu() {
        courrentPanel.setVisible(false);
        courrentPanel = menu;
        courrentPanel.setVisible(true);
        this.repaint();
    }
    
}
