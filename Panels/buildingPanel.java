package Panels;

import Objects.Building;
import Objects.Policy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class buildingPanel extends JPanel {

    JLabel headLabel;

    JComboBox<Building> buildingManager;

    JButton proposeButton;

    JLabel buildingInfo1;
    JLabel buildingInfo2;
    JLabel buildingInfo3;
    JLabel buildingInfo4;
    JLabel buildingInfo5;

    JButton closeButton;

    panelComponentMaker componentMaker;

    Font cityMenuFont;
    Font cityMenuHeadFont;

    public buildingPanel() {
        this.cityMenuFont = new Font("helvetica",Font.ITALIC,10);
        this.cityMenuHeadFont = new Font("Copperplate Gothic Light",Font.BOLD,11);
        this.setBounds(190,40,150,190);
        this.setBackground(new Color(255,255,204));
        this.setOpaque(true);
        this.setLayout(null);

        componentMaker = new panelComponentMaker();

        headLabel = new JLabel();
        headLabel.setFont(cityMenuHeadFont);
        headLabel.setText("Diplomacy");
        headLabel.setBounds(0,0,80,10);
        this.add(headLabel);

        buildingManager = createBuildingManager(0,15);
        this.add(buildingManager);

        proposeButton = componentMaker.standardPanelButton("Propose",0,35);
        this.add(proposeButton);

        buildingInfo1 = componentMaker.createStandardPanelLabel("Policy Name: ", 0, 60);
        this.add(buildingInfo1);
        buildingInfo2 = componentMaker.createStandardPanelLabel("Policy Value: ", 0, 75);
        this.add(buildingInfo2);
        buildingInfo3 = componentMaker.createStandardPanelLabel("Policy Type: ", 0, 90);
        this.add(buildingInfo3);
        buildingInfo4 = componentMaker.createStandardPanelLabel("Active: ", 0, 105);
        this.add(buildingInfo4);
        buildingInfo5 = componentMaker.createStandardPanelLabel("Policy Info 5: ", 0, 120);
        this.add(buildingInfo5);

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

    public JComboBox<Building> getBuildingManager() {
        return buildingManager;
    }

    public JButton getProposeButton() {
        return proposeButton;
    }

    public JLabel getBuildingInfo1() {
        return buildingInfo1;
    }

    public JLabel getBuildingInfo2() {
        return buildingInfo2;
    }

    public JLabel getBuildingInfo3() {
        return buildingInfo3;
    }

    public JLabel getBuildingInfo4() {
        return buildingInfo4;
    }

    public JLabel getBuildingInfo5() {
        return buildingInfo5;
    }

    public JComboBox<Building> createBuildingManager(int x, int y){
        JComboBox<Building> newManager = new JComboBox<>();
        newManager.setBounds(x,y,150,15);
        newManager.setFont(cityMenuFont);
        newManager.setForeground(Color.BLACK);
        return newManager;
    }

    public void removeAllActionlisteners(){
        for( ActionListener al : proposeButton.getActionListeners() ) {
            proposeButton.removeActionListener( al );
        }
        for( ActionListener al : closeButton.getActionListeners() ) {
            closeButton.removeActionListener( al );
        }
    }
}

