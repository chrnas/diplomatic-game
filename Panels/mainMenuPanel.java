package Panels;

import javax.swing.*;
import java.awt.*;

public class mainMenuPanel extends JPanel {

    JLabel headLabel;

    JButton endTurnButton;
    JButton exitGameButton;
    JButton closeButton;

    panelComponentMaker maker;

    Font cityMenuFont;
    Font cityMenuHeadFont;

    public mainMenuPanel() {
        this.cityMenuFont = new Font("Garamond",Font.ROMAN_BASELINE,11);
        this.cityMenuHeadFont = new Font("Copperplate Gothic Light",Font.BOLD,11);
        this.setBounds(60,40,85,140);
        this.setBackground(new Color(255,255,204));
        this.setOpaque(true);
        this.setLayout(null);

        maker = new panelComponentMaker();

        headLabel = new JLabel();
        headLabel.setFont(cityMenuHeadFont);
        headLabel.setText("Main Menu");
        headLabel.setBounds(0,0,80,10);
        this.add(headLabel);

        endTurnButton = maker.standardPanelButton("End Turn",0,60);
        exitGameButton = maker.standardPanelButton("Exit Game",0,80);
        closeButton = maker.standardPanelButton("Close",0,100);
        this.add(endTurnButton);
        this.add(exitGameButton);
        this.add(closeButton);

        this.setVisible(false);
    }

    public JLabel getHeadLabel() {
        return headLabel;
    }

    public JButton getCloseButton() {
        return closeButton;
    }

    public Font getCityMenuFont() {
        return cityMenuFont;
    }

    public Font getCityMenuHeadFont() {
        return cityMenuHeadFont;
    }

    public JButton getEndTurnButton() {
        return endTurnButton;
    }

    public JButton getExitGameButton() {
        return exitGameButton;
    }

    public panelComponentMaker getMaker() {
        return maker;
    }
}
