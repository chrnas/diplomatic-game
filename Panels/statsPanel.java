package Panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class statsPanel extends JPanel {

    JLabel headLabel;

    JLabel statsLabel1;
    JLabel statsLabel2;
    JLabel statsLabel3;
    JLabel statsLabel4;
    JLabel statsLabel5;
    JLabel statsLabel6;

    JButton closeButton;

    panelComponentMaker componentMaker;

    Font cityMenuFont;
    Font cityMenuHeadFont;

    public statsPanel() {
        this.cityMenuFont = new Font("helvetica",Font.ITALIC,10);
        this.cityMenuHeadFont = new Font("Copperplate Gothic Light",Font.BOLD,11);
        this.setBounds(60,40,150,190);
        this.setBackground(new Color(255,255,204));
        this.setOpaque(true);
        this.setLayout(null);

        componentMaker = new panelComponentMaker();

        headLabel = new JLabel();
        headLabel.setFont(cityMenuHeadFont);
        headLabel.setText("Stats");
        headLabel.setBounds(0,0,80,10);
        this.add(headLabel);

        statsLabel1 = componentMaker.createStandardPanelLabel("City Name: ",0,15);
        this.add(statsLabel1);

        statsLabel2 = componentMaker.createStandardPanelLabel("City Income: ",0,30);
        this.add(statsLabel2);

        statsLabel3 = componentMaker.createStandardPanelLabel("Popular Opinion: ",0,45);
        this.add(statsLabel3);

        statsLabel4 = componentMaker.createStandardPanelLabel("City Nr: ",0,60);
        this.add(statsLabel4);

        statsLabel5 = componentMaker.createStandardPanelLabel("City Position: ",0,75);
        this.add(statsLabel5);

        statsLabel6 = componentMaker.createStandardPanelLabel("City Factor: ",0,90);
        this.add(statsLabel6);

        closeButton = componentMaker.standardPanelButton("Close",32,170);
        this.add(closeButton);

        this.setVisible(false);
    }

    public JLabel getHeadLabel() {
        return headLabel;
    }

    public JButton getCloseButton() {
        return closeButton;
    }

    public panelComponentMaker getComponentMaker() {
        return componentMaker;
    }

    public Font getCityMenuFont() {
        return cityMenuFont;
    }

    public Font getCityMenuHeadFont() {
        return cityMenuHeadFont;
    }

    public JLabel getStatsLabel1() {
        return statsLabel1;
    }

    public JLabel getStatsLabel2() {
        return statsLabel2;
    }

    public JLabel getStatsLabel3() {
        return statsLabel3;
    }

    public JLabel getStatsLabel4() {
        return statsLabel4;
    }

    public JLabel getStatsLabel5() {
        return statsLabel5;
    }

    public JLabel getStatsLabel6() {
        return statsLabel6;
    }

    public void removeAllActionlisteners(){
        for( ActionListener al : closeButton.getActionListeners() ) {
            closeButton.removeActionListener( al );
        }
    }
}

