package Panels;

import Objects.Policy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class diplomacyPanel extends JPanel {

    JLabel headLabel;

    JComboBox<Policy> policyManager;

    JButton proposeButton;

    JLabel policyInfo1;
    JLabel policyInfo2;
    JLabel policyInfo3;
    JLabel policyInfo4;
    JLabel policyInfo5;

    JButton closeButton;

    panelComponentMaker componentMaker;

    Font cityMenuFont;
    Font cityMenuHeadFont;

    public diplomacyPanel() {
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

        policyManager = createPolicyManager(0,15);
        this.add(policyManager);

        proposeButton = componentMaker.standardPanelButton("Propose",0,35);
        this.add(proposeButton);

        policyInfo1 = componentMaker.createStandardPanelLabel("Policy Name: ", 0, 60);
        this.add(policyInfo1);
        policyInfo2 = componentMaker.createStandardPanelLabel("Policy Value: ", 0, 75);
        this.add(policyInfo2);
        policyInfo3 = componentMaker.createStandardPanelLabel("Policy Type: ", 0, 90);
        this.add(policyInfo3);
        policyInfo4 = componentMaker.createStandardPanelLabel("Active: ", 0, 105);
        this.add(policyInfo4);
        policyInfo5 = componentMaker.createStandardPanelLabel("Policy Info 5: ", 0, 120);
        this.add(policyInfo5);

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

    public JComboBox<Policy> getPolicyManager() {
        return policyManager;
    }

    public JButton getProposeButton() {
        return proposeButton;
    }

    public JLabel getPolicyInfo1() {
        return policyInfo1;
    }

    public JLabel getPolicyInfo2() {
        return policyInfo2;
    }

    public JLabel getPolicyInfo3() {
        return policyInfo3;
    }

    public JLabel getPolicyInfo4() {
        return policyInfo4;
    }

    public JLabel getPolicyInfo5() {
        return policyInfo5;
    }

    public JComboBox<Policy> createPolicyManager(int x, int y){
        JComboBox<Policy> newManager = new JComboBox<>();
        newManager.setBounds(x,y,150,15);
        newManager.setFont(cityMenuFont);
        newManager.setForeground(Color.BLACK);
        return newManager;
    }

    public void removeAllActionlisteners(){
        for( ActionListener al : proposeButton.getActionListeners() ) {
            proposeButton.removeActionListener( al );
        }
    }
}

