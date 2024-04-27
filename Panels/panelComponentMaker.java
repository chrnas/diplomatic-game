package Panels;

import javax.swing.*;
import java.awt.*;

public class panelComponentMaker {

    Font cityMenuFont;
    Font cityMenuHeadFont;

    Font menuSubHeadFont;

    public panelComponentMaker() {
        this.cityMenuFont = new Font("Garamond",Font.ROMAN_BASELINE,11);
        this.cityMenuHeadFont = new Font("Copperplate Gothic Light",Font.BOLD,11);
        this.menuSubHeadFont = new Font("Copperplate Gothic Light",Font.BOLD,10);
    }

    public JButton standardPanelButton(String buttonText, int x, int y){
        JButton cityPanelButton = new JButton();
        cityPanelButton.setBounds(x,y,85,20);
        cityPanelButton.setBackground(Color.BLACK);
        cityPanelButton.setOpaque(true);
        cityPanelButton.setText(buttonText);
        cityPanelButton.setForeground(Color.WHITE);
        cityPanelButton.setFont(cityMenuFont);
        return cityPanelButton;
    }

    public JButton smallStandardPanelButton(String buttonText, int x, int y){
        JButton cityPanelButton = new JButton();
        cityPanelButton.setBounds(x,y,60,20);
        cityPanelButton.setBackground(Color.BLACK);
        cityPanelButton.setOpaque(true);
        cityPanelButton.setText(buttonText);
        cityPanelButton.setForeground(Color.WHITE);
        cityPanelButton.setFont(cityMenuFont);
        return cityPanelButton;
    }

    public JButton standardPanelPicButton(ImageIcon image, int x, int y){
        JButton cityPanelButton = new JButton();
        cityPanelButton.setBounds(x,y,30,30);
        cityPanelButton.setBackground(Color.BLACK);
        cityPanelButton.setOpaque(true);
        cityPanelButton.setIcon(image);
        cityPanelButton.setForeground(Color.WHITE);
        cityPanelButton.setFont(cityMenuFont);
        return cityPanelButton;
    }

    public JLabel createStandardPanelLabel(String buttonText, int x, int y){
        JLabel newLabel = new JLabel();
        newLabel.setBounds(x,y,150,15);
        newLabel.setFont(cityMenuFont);
        newLabel.setForeground(Color.BLACK);
        newLabel.setText(buttonText);
        return newLabel;
    }

    public JLabel createStandardHeadPanelLabel(String buttonText, int x, int y){
        JLabel newLabel = new JLabel();
        newLabel.setBounds(x,y,150,15);
        newLabel.setFont(menuSubHeadFont);
        newLabel.setForeground(Color.BLACK);
        newLabel.setText(buttonText);
        return newLabel;
    }

    public JButton createExitButton(int x, int y){
        JButton exitButton = new JButton("X");
        exitButton.setBackground(Color.BLACK);
        exitButton.setBounds(x,y,20,20);
        exitButton.setOpaque(true);
        exitButton.setFont(cityMenuFont);
        exitButton.setForeground(Color.WHITE);
        exitButton.setText("X");
        return exitButton;
    }

    public JSlider createStandardSlider(){
        JSlider slider = new JSlider(0,1000);
        slider.setFont(cityMenuFont);
        slider.setBackground(Color.BLACK);
        slider.setForeground(Color.white);
        slider.setMajorTickSpacing(100);
        return slider;
    }
}
