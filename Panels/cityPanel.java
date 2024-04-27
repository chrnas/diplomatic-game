package Panels;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

public class cityPanel extends JPanel {

    JLabel cityName;

    JButton eventsButton;
    JButton rulerButton;
    JButton factionButton;
    JButton buildingsButton;
    JButton statsButton;
    JButton closeButton;

    Font cityMenuFont;
    Font cityMenuHeadFont;

    public cityPanel() {
        this.cityMenuFont = new Font("helvetica",Font.ITALIC,10);
        this.cityMenuHeadFont = new Font("Copperplate Gothic Light",Font.BOLD,11);
        this.setBounds(0,0,85,140);
        this.setBackground(new Color(255,255,204));
        this.setOpaque(true);
        this.setLayout(null);

        cityName = new JLabel();
        cityName.setFont(cityMenuHeadFont);
        cityName.setText("City Name");
        cityName.setBounds(0,0,85,20);
        this.add(cityName);

        rulerButton = createCityPanelButton("Ruler",0,20);
        this.add(rulerButton);
        eventsButton = createCityPanelButton("Events",0,40);
        this.add(eventsButton,null);
        factionButton = createCityPanelButton("Factions",0,60);
        this.add(factionButton);
        buildingsButton = createCityPanelButton("Buildings",0,80);
        this.add(buildingsButton);
        statsButton = createCityPanelButton("Stats",0,100);
        this.add(statsButton);
        closeButton = createCityPanelButton("Close",0,120);
        this.add(closeButton);

        this.setVisible(false);
    }

    public JLabel getCityName() {
        return cityName;
    }

    public JButton getDiplomacyButton() {
        return eventsButton;
    }

    public JButton getRulerButton() {
        return rulerButton;
    }

    public JButton getFactionButton() {
        return factionButton;
    }

    public JButton getBuildingsButton() {
        return buildingsButton;
    }

    public JButton getStatsButton() {
        return statsButton;
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

    public JButton createCityPanelButton(String buttonText, int x, int y){
        JButton cityPanelButton = new JButton();
        cityPanelButton.setBounds(x,y,85,20);
        cityPanelButton.setBackground(Color.BLACK);
        cityPanelButton.setOpaque(true);
        cityPanelButton.setText(buttonText);
        cityPanelButton.setForeground(Color.WHITE);
        cityPanelButton.setFont(cityMenuFont);
        return cityPanelButton;
    }

    public void removeAllActionListeners(){
        for( ActionListener al : closeButton.getActionListeners() ) {
            closeButton.removeActionListener( al );
        }
        for( ActionListener al : statsButton.getActionListeners() ) {
            statsButton.removeActionListener( al );
        }
        for( ActionListener al : buildingsButton.getActionListeners() ) {
            buildingsButton.removeActionListener( al );
        }
        for( ActionListener al : rulerButton.getActionListeners() ) {
            rulerButton.removeActionListener( al );
        }
        for( ActionListener al : eventsButton.getActionListeners() ) {
            eventsButton.removeActionListener( al );
        }
        for( ActionListener al : factionButton.getActionListeners() ) {
            factionButton.removeActionListener( al );
        }


    }
}


