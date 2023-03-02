package it.unibo.tankBattle.view.impl;

import javax.swing.JButton;
import javax.swing.JPanel;
import it.unibo.tankBattle.view.api.Graphics;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.Dimension;

public class FactoryGameScenes {
    private final Graphics view;
    private final Dimension screenSize;

    protected FactoryGameScenes(Graphics view) {
        this.view = view;
        screenSize = view.getSize();
    }

    protected JPanel menu () {
        final JPanel menuPanel = new JPanel(new BorderLayout());
        menuPanel.setBackground(Color.BLACK);
    
        final JPanel centerPanel = new JPanel(new BorderLayout());
        setSize(centerPanel, screenSize.width/3, screenSize.height/2);
        setTrasparent(centerPanel);

        final JPanel northPanel = new JPanel();
        setSize(northPanel, screenSize.width, screenSize.height/4);
        setTrasparent(northPanel);

        final JPanel southPanel = new JPanel();
        setSize(southPanel, screenSize.width, screenSize.height/4);
        setTrasparent(southPanel);

        final JPanel westPanel = new JPanel();
        setSize(westPanel, screenSize.width/3, screenSize.height/2);
        setTrasparent(westPanel);

        final JPanel eastPanel = new JPanel();
        setSize(eastPanel, screenSize.width/3, screenSize.height/2);
        setTrasparent(eastPanel);

        final JButton playButton = new JButton("Play");
        final JButton tutorialButton = new JButton("Tutorial");
        
        playButton.setPreferredSize(new Dimension(view.getSize().width/3, view.getSize().height/6));
        tutorialButton.addActionListener(e ->{
            view.tutorial();
        });
        tutorialButton.setPreferredSize(new Dimension(view.getSize().width/3, view.getSize().height/6));

        centerPanel.add(playButton, BorderLayout.NORTH);
        centerPanel.add(tutorialButton, BorderLayout.SOUTH);

        menuPanel.add(northPanel, BorderLayout.NORTH);
        menuPanel.add(westPanel, BorderLayout.WEST);
        menuPanel.add(eastPanel, BorderLayout.EAST);
        menuPanel.add(southPanel, BorderLayout.SOUTH);
        menuPanel.add(centerPanel, BorderLayout.CENTER);
        
        return menuPanel;
    }

    protected JPanel tutorial () {
        final JPanel tutorialPanel = new JPanel();
        final JButton backButton = new JButton("Back");
        tutorialPanel.setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
        backButton.setPreferredSize(new Dimension(100,100));
        backButton.addActionListener(e ->{
            view.menu();
        });
        
        tutorialPanel.add(backButton);
        return tutorialPanel;
    }

    protected JPanel gameScene () {
        return null;
    }

    private void setSize(JPanel panel, int width, int height) {
        panel.setPreferredSize(new Dimension(width, height));
    }

    private void setTrasparent(JPanel panel) {
        panel.setBackground(new Color(0,0,0,125));
    }
}
