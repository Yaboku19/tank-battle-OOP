package it.unibo.tankBattle.view.impl;

import javax.swing.JButton;
import javax.swing.JPanel;

import it.unibo.tankBattle.view.api.Graphics;

import java.awt.Toolkit;
import java.awt.Dimension;

public class FactoryGameScenes {
    private final Graphics view;

    protected FactoryGameScenes(Graphics view) {
        this.view = view;
    }

    public JPanel menu () {
        final JPanel menuPanel = new JPanel();
        final JButton playButton = new JButton("Play");
        final JButton tutorialButton = new JButton("Tutorial");
        
        menuPanel.setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
        playButton.setPreferredSize(new Dimension(1000,100));
        tutorialButton.addActionListener(e ->{
            view.tutorial();
        });
        tutorialButton.setPreferredSize(new Dimension(1000,100));
        menuPanel.add(playButton);
        menuPanel.add(tutorialButton);
        return menuPanel;
    }

    public JPanel tutorial () {
        /*final JPanel tutorialPanel = new JPanel();
        final JButton backButton = new JButton("Back");
        tutorialPanel.setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
        backButton.setPreferredSize(new Dimension(100,100));
        backButton.addActionListener(e ->{
            view.menu();
        });
        
        tutorialPanel.add(backButton);
        return tutorialPanel;*/
        final JPanel menuPanel = new JPanel();
        final JButton playButton = new JButton("Play2");
        final JButton tutorialButton = new JButton("Tutorial2");
        
        menuPanel.setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
        playButton.setPreferredSize(new Dimension(1000,100));
        tutorialButton.addActionListener(e ->{
            view.tutorial();
        });
        tutorialButton.setPreferredSize(new Dimension(1000,100));
        menuPanel.add(playButton);
        menuPanel.add(tutorialButton);
        return menuPanel;
    }

    public JPanel gameScene () {
        return null;
    }
}
