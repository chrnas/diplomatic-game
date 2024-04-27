package Panels;

import javax.swing.*;
import java.awt.*;

public class mainMenuPanel extends JPanel {

    JLabel headLabel;

    JButton endTurnButton;
    JButton button1;
    JButton button2;
    JButton button3;
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

        endTurnButton = maker.standardPanelButton("endTurn",0,20);
        button1 = maker.standardPanelButton("button",0,40);
        button2 = maker.standardPanelButton("button",0,60);
        button3 = maker.standardPanelButton("button",0,80);
        exitGameButton = maker.standardPanelButton("Exit Game",0,100);
        closeButton = maker.standardPanelButton("Close",0,120);
        this.add(endTurnButton);
        this.add(button1);
        this.add(button2);
        this.add(button3);
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

    public JButton getButton1() {
        return button1;
    }

    public JButton getButton2() {
        return button2;
    }

    public JButton getButton3() {
        return button3;
    }

    public JButton getexitGameButton() {
        return exitGameButton;
    }

    public panelComponentMaker getMaker() {
        return maker;
    }
}
