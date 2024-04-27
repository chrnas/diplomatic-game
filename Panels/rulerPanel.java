package Panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class rulerPanel extends JPanel {

    JLabel headLabel;

    JLabel rulerInfo1;
    JLabel rulerInfo2;
    JLabel rulerInfo3;
    JLabel rulerInfo4;
    JLabel rulerInfo5;
    JLabel rulerInfo6;
    JLabel rulerInfo7;

    JButton familyButton;

    JButton diplomacyButton;

    JButton closeButton;

    panelComponentMaker componentMaker;

    Font cityMenuFont;
    Font cityMenuHeadFont;

    public rulerPanel() {
        this.cityMenuFont = new Font("helvetica",Font.ITALIC,10);
        this.cityMenuHeadFont = new Font("Copperplate Gothic Light",Font.BOLD,11);
        this.setBounds(60,40,150,190);
        this.setBackground(new Color(255,255,204));
        this.setOpaque(true);
        this.setLayout(null);

        componentMaker = new panelComponentMaker();

        headLabel = new JLabel();
        headLabel.setFont(cityMenuHeadFont);
        headLabel.setText("Ruler");
        headLabel.setBounds(0,0,80,10);
        this.add(headLabel);

        rulerInfo1 = componentMaker.createStandardPanelLabel("Name: ", 0, 20);
        this.add(rulerInfo1);
        rulerInfo2 = componentMaker.createStandardPanelLabel("Family Name:: ", 0, 35);
        this.add(rulerInfo2);
        rulerInfo3 = componentMaker.createStandardPanelLabel("Age: ", 0, 50);
        this.add(rulerInfo3);
        rulerInfo4 = componentMaker.createStandardPanelLabel("Stead Fast Factor: ", 0, 65);
        this.add(rulerInfo4);
        rulerInfo5 = componentMaker.createStandardPanelLabel("King: ", 0, 80);
        this.add(rulerInfo5);
        rulerInfo6 = componentMaker.createStandardPanelLabel("Opinion: ",0,95);
        this.add(rulerInfo6);
        rulerInfo7 = componentMaker.createStandardPanelLabel("",0,110);
        this.add(rulerInfo6);

        familyButton = componentMaker.standardPanelButton("Family",32,130);
        this.add(familyButton);

        diplomacyButton = componentMaker.standardPanelButton("Diplomacy", 32 , 150);
        this.add(diplomacyButton);

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

    public JButton getDiplomacyButton() {
        return diplomacyButton;
    }

    public JLabel getRulerInfo1() {
        return rulerInfo1;
    }

    public JLabel getRulerInfo2() {
        return rulerInfo2;
    }

    public JLabel getRulerInfo3() {
        return rulerInfo3;
    }

    public JLabel getRulerInfo4() {
        return rulerInfo4;
    }

    public JLabel getRulerInfo5() {
        return rulerInfo5;
    }

    public JLabel getRulerInfo6() {
        return rulerInfo6;
    }

    public JLabel getRulerInfo7() {
        return rulerInfo7;
    }

    public JButton getFamilyButton() {
        return familyButton;
    }

    public void removeAllActionListeners(){
        for( ActionListener al :  diplomacyButton.getActionListeners() ) {
            diplomacyButton.removeActionListener( al );
        }
        for( ActionListener al : closeButton.getActionListeners() ) {
            closeButton.removeActionListener( al );
        }
    }
}

