package Panels;

import javax.swing.*;
import java.awt.*;

public class eventsPanel extends JPanel {

    JLabel headLabel;

    JLabel eventInfo1;
    JLabel eventInfo2;
    JLabel eventInfo3;
    JLabel eventInfo4;
    JLabel eventInfo5;

    JButton closeButton;

    panelComponentMaker componentMaker;

    Font cityMenuFont;
    Font cityMenuHeadFont;

    public eventsPanel() {
        this.cityMenuFont = new Font("helvetica",Font.ITALIC,10);
        this.cityMenuHeadFont = new Font("Copperplate Gothic Light",Font.BOLD,11);
        this.setBounds(60,40,150,190);
        this.setBackground(new Color(255,255,204));
        this.setOpaque(true);
        this.setLayout(null);

        componentMaker = new panelComponentMaker();

        headLabel = new JLabel();
        headLabel.setFont(cityMenuHeadFont);
        headLabel.setText("Events");
        headLabel.setBounds(0,0,80,10);
        this.add(headLabel);

        eventInfo1 = componentMaker.createStandardPanelLabel("Event1: ",0,15);
        this.add(eventInfo1);

        eventInfo2 = componentMaker.createStandardPanelLabel("Event2: ",0,30);
        this.add(eventInfo2);

        eventInfo3 = componentMaker.createStandardPanelLabel("Event3: ",0,45);
        this.add(eventInfo3);

        eventInfo4 = componentMaker.createStandardPanelLabel("Event4: ",0,60);
        this.add(eventInfo4);

        eventInfo5 = componentMaker.createStandardPanelLabel("Event5: ",0,75);
        this.add(eventInfo5);

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

    public JLabel getEventInfo1() {
        return eventInfo1;
    }

    public JLabel getEventInfo2() {
        return eventInfo2;
    }

    public JLabel getEventInfo3() {
        return eventInfo3;
    }

    public JLabel getEventInfo4() {
        return eventInfo4;
    }

    public JLabel getEventInfo5() {
        return eventInfo5;
    }
}

