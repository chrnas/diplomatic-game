package Panels;

import Objects.Policy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class attackPanel extends JPanel {

    JLabel headLabel;

    JButton attackButton;

    JSlider troopSlider;

    JLabel troopCount;
    
    JButton closeButton;

    panelComponentMaker componentMaker;

    Font cityMenuFont;
    Font cityMenuHeadFont;

    public attackPanel() {
        this.cityMenuFont = new Font("helvetica",Font.ITALIC,10);
        this.cityMenuHeadFont = new Font("Copperplate Gothic Light",Font.BOLD,11);
        this.setBounds(190,40,150,190);
        this.setBackground(new Color(255,255,204));
        this.setOpaque(true);
        this.setLayout(null);

        componentMaker = new panelComponentMaker();

        headLabel = new JLabel();
        headLabel.setFont(cityMenuHeadFont);
        headLabel.setText("Attack");
        headLabel.setBounds(0,0,80,10);
        this.add(headLabel);

        troopSlider = componentMaker.createStandardSlider();
        troopSlider.setBounds(20,110,120,10);
        this.add(troopSlider);
        
        troopCount = componentMaker.createStandardPanelLabel("Troop count",32,60);
        this.add(troopCount);

        attackButton = componentMaker.standardPanelButton("attack",32, 80);
        this.add(attackButton);

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

    public JButton getAttackButton() {
        return attackButton;
    }

    public JSlider getTroopSlider() {
        return troopSlider;
    }

    public JLabel getTroopCount() {
        return troopCount;
    }

    public void removeAllActionListeners(){
        for( ActionListener al : attackButton.getActionListeners() ) {
            attackButton.removeActionListener( al );
        }
        for( ActionListener al : closeButton.getActionListeners() ) {
            closeButton.removeActionListener( al );
        }
    }
}

