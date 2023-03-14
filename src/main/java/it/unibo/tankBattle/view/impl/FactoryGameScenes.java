package it.unibo.tankBattle.view.impl;

import javax.swing.JButton;
import javax.swing.JPanel;
import it.unibo.tankBattle.view.api.View;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

public class FactoryGameScenes {
    /*private final View view;
    private final Dimension screenSize;

    protected FactoryGameScenes(View view) {
        this.view = view;
        screenSize = view.getSize();
    }

    protected JPanel menu () {
        final JPanel menuPanel = new JPanel(new BorderLayout());
        setTrasparent(menuPanel);
    
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

        playButton.addActionListener(e ->{
            view.chooseMenu();
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
        tutorialPanel.setPreferredSize(screenSize);
        setTrasparent(tutorialPanel);

        final JButton backButton = new JButton("Back");
        backButton.addActionListener(e ->{
            view.menu();
        });
        
        tutorialPanel.add(backButton);
        return tutorialPanel;
    }

    protected JPanel gameChoose () {
        final JPanel gameChoosePanel = new JPanel(new GridLayout(3,1));
        gameChoosePanel.setPreferredSize(screenSize);
        setTrasparent(gameChoosePanel);

        final JPanel topPanel = new JPanel(new GridLayout(1,3));
        setTrasparent(topPanel);

        final JPanel middlePanel = new JPanel(new GridLayout(1,3));
        setTrasparent(middlePanel);

        final JPanel bottomPanel = new JPanel(new GridLayout(1,3));
        setTrasparent(bottomPanel);

        final JPanel playerOnePanel = new JPanel(new BorderLayout());
        setTrasparent(playerOnePanel);

        final JPanel emptyPanel1 = new JPanel(new BorderLayout());
        setTrasparent(emptyPanel1);

        final JPanel emptyPanel2 = new JPanel(new BorderLayout());
        setTrasparent(emptyPanel2);

        final JPanel emptyPanel3 = new JPanel(new BorderLayout());
        setTrasparent(emptyPanel3);

        final JPanel emptyPanel4 = new JPanel(new BorderLayout());
        setTrasparent(emptyPanel4);

        final JPanel playerTwoPanel = new JPanel(new BorderLayout());
        setTrasparent(playerTwoPanel);

        final JPanel mapPanel = new JPanel(new BorderLayout());
        setTrasparent(mapPanel);

        final JButton leftPlayerOne = new JButton("Left");
        final JButton RightPlayerOne = new JButton("Right");

        final JButton leftPlayerTwo = new JButton("Left");
        final JButton RightPlayerTwo = new JButton("Right");

        final JButton leftMap = new JButton("left");
        final JButton rightMap = new JButton("Right");

        final JButton backButton = new JButton("Back");
        final JButton startButton = new JButton("Start");
        backButton.addActionListener(e -> {
            view.menu();
        });
        
        startButton.addActionListener(e -> {
            view.startGame();
        });
        playerOnePanel.add(leftPlayerOne, BorderLayout.WEST);
        playerOnePanel.add(RightPlayerOne, BorderLayout.EAST);

        playerTwoPanel.add(leftPlayerTwo, BorderLayout.WEST);
        playerTwoPanel.add(RightPlayerTwo, BorderLayout.EAST);

        topPanel.add(playerOnePanel);
        topPanel.add(emptyPanel1);
        topPanel.add(playerTwoPanel);

        mapPanel.add(leftMap, BorderLayout.WEST);
        mapPanel.add(rightMap, BorderLayout.EAST);

        middlePanel.add(emptyPanel2);
        middlePanel.add(mapPanel);
        middlePanel.add(emptyPanel3);

        bottomPanel.add(backButton);
        bottomPanel.add(emptyPanel4);
        bottomPanel.add(startButton);

        gameChoosePanel.add(topPanel);
        gameChoosePanel.add(middlePanel);
        gameChoosePanel.add(bottomPanel);
        gameChoosePanel.setVisible(false);

        return gameChoosePanel;
    }

    protected JPanel gameScene () {
        return null;
    }

    private void setSize(JPanel panel, int width, int height) {
        panel.setPreferredSize(new Dimension(width, height));
    }

    private void setTrasparent(JPanel panel) {
        panel.setBackground(new Color(0,0,0,0));
    }*/
}
