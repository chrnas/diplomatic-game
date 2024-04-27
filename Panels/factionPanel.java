package Panels;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class factionPanel extends JPanel {

    JLabel headLabel;
    Image AttackImage = ImageIO.read(new File("Res/AttackIcon.png")).getScaledInstance(30,30,0);
    ImageIcon AttackImageIcon = new ImageIcon(AttackImage);
    JLabel MilitaryHeadLabel;
    JLabel MilitaryInfoLabel1;
    JLabel MilitaryInfoLabel2;

    JButton MilitaryInvestButton;
    JButton MilitaryEnlistButton;

    JLabel TradersHeadLabel;
    JLabel TradersInfoLabel1;
    JLabel TradersInfoLabel2;

    JButton TraderInvestButton;
    JButton TraderEnlistButton;

    JLabel ClergyHeadLabel;
    JLabel ClergyInfoLabel1;
    JLabel ClergyInfoLabel2;

    JButton ClergyInvestButton;
    JButton ClergyEnlistButton;

    JButton attackButton;

    JButton closeButton;

    panelComponentMaker buttonMaker;

    Font cityMenuFont;
    Font cityMenuHeadFont;

    public factionPanel() throws IOException {
        this.cityMenuFont = new Font("helvetica",Font.ITALIC,10);
        this.cityMenuHeadFont = new Font("Copperplate Gothic Light",Font.BOLD,11);
        this.setBounds(60,40,150,190);
        this.setBackground(new Color(255,255,204));
        this.setOpaque(true);
        this.setLayout(null);

        buttonMaker = new panelComponentMaker();

        headLabel = new JLabel();
        headLabel.setFont(cityMenuHeadFont);
        headLabel.setText("Factions");
        headLabel.setBounds(0,0,80,10);
        this.add(headLabel);


        MilitaryHeadLabel = buttonMaker.createStandardHeadPanelLabel("Military", 0, 10);
        this.add(MilitaryHeadLabel);
        MilitaryInfoLabel1 = buttonMaker.createStandardPanelLabel("Power: ", 0, 20);
        this.add(MilitaryInfoLabel1);
        MilitaryInfoLabel2 = buttonMaker.createStandardPanelLabel("Faction Population: ", 0, 30);
        this.add(MilitaryInfoLabel2);
        MilitaryInvestButton = buttonMaker.smallStandardPanelButton("Invest",0,45);
        this.add(MilitaryInvestButton);
        MilitaryEnlistButton = buttonMaker.smallStandardPanelButton("Enlist",60,45);
        this.add(MilitaryEnlistButton);

        TradersHeadLabel = buttonMaker.createStandardHeadPanelLabel("Traders", 0, 65);
        this.add(TradersHeadLabel);
        TradersInfoLabel1 = buttonMaker.createStandardPanelLabel("Faction Power: ", 0, 75);
        this.add(TradersInfoLabel1);
        TradersInfoLabel2 = buttonMaker.createStandardPanelLabel("Faction Population: ", 0, 85);
        this.add(TradersInfoLabel2);
        TraderInvestButton = buttonMaker.smallStandardPanelButton("Invest",0,100);
        this.add(TraderInvestButton);
        TraderEnlistButton = buttonMaker.smallStandardPanelButton("Enlist",60,100);
        this.add(TraderEnlistButton);

        ClergyHeadLabel = buttonMaker.createStandardHeadPanelLabel("Clergy", 0, 120);
        this.add(ClergyHeadLabel);
        ClergyInfoLabel1 = buttonMaker.createStandardPanelLabel("Faction Power: ", 0, 130);
        this.add(ClergyInfoLabel1);
        ClergyInfoLabel2 = buttonMaker.createStandardPanelLabel("Faction Population: ", 0, 140);
        this.add(ClergyInfoLabel2);
        ClergyInvestButton = buttonMaker.smallStandardPanelButton("Invest",0,155);
        this.add(ClergyInvestButton);
        ClergyEnlistButton = buttonMaker.smallStandardPanelButton("Enlist",60,155);
        this.add(ClergyEnlistButton);

        attackButton = buttonMaker.standardPanelPicButton(AttackImageIcon,120,0);
        this.add(attackButton);

        closeButton = buttonMaker.standardPanelButton("Close",32,175);
        this.add(closeButton);

        this.setVisible(false);
    }

    public JLabel getMilitaryHeadLabel() {
        return MilitaryHeadLabel;
    }

    public JLabel getMilitaryInfoLabel1() {
        return MilitaryInfoLabel1;
    }

    public JLabel getMilitaryInfoLabel2() {
        return MilitaryInfoLabel2;
    }

    public JButton getMilitaryInvestButton() {
        return MilitaryInvestButton;
    }

    public JLabel getTradersHeadLabel() {
        return TradersHeadLabel;
    }

    public JLabel getTradersInfoLabel1() {
        return TradersInfoLabel1;
    }

    public JLabel getTradersInfoLabel2() {
        return TradersInfoLabel2;
    }

    public JButton getTraderInvestButton() {
        return TraderInvestButton;
    }

    public JLabel getClergyHeadLabel() {
        return ClergyHeadLabel;
    }

    public JLabel getClergyInfoLabel1() {
        return ClergyInfoLabel1;
    }

    public JLabel getClergyInfoLabel2() {
        return ClergyInfoLabel2;
    }

    public JButton getClergyInvestButton() {
        return ClergyInvestButton;
    }

    public JLabel getHeadLabel() {
        return headLabel;
    }

    public JButton getCloseButton() {
        return closeButton;
    }

    public panelComponentMaker getButtonMaker() {
        return buttonMaker;
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

    public JButton getMilitaryEnlistButton() {
        return MilitaryEnlistButton;
    }

    public JButton getTraderEnlistButton() {
        return TraderEnlistButton;
    }

    public JButton getClergyEnlistButton() {
        return ClergyEnlistButton;
    }

    public void removeAllActionlisteners(){
        for( ActionListener al : attackButton.getActionListeners() ) {
            attackButton.removeActionListener( al );
        }
        for( ActionListener al : closeButton.getActionListeners() ) {
            closeButton.removeActionListener( al );
        }
        for( ActionListener al : MilitaryInvestButton.getActionListeners() ) {
            MilitaryInvestButton.removeActionListener( al );
        }
        for( ActionListener al : MilitaryEnlistButton.getActionListeners() ) {
            MilitaryEnlistButton.removeActionListener( al );
        }
        for( ActionListener al : ClergyInvestButton.getActionListeners() ) {
            ClergyInvestButton.removeActionListener( al );
        }
        for( ActionListener al : ClergyEnlistButton.getActionListeners() ) {
            ClergyEnlistButton.removeActionListener( al );
        }
        for( ActionListener al : TraderInvestButton.getActionListeners() ) {
            TraderInvestButton.removeActionListener( al );
        }
        for( ActionListener al : TraderEnlistButton.getActionListeners() ) {
            TraderEnlistButton.removeActionListener( al );
        }

    }
}
