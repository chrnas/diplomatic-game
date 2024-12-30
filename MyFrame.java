import Objects.*;
import Objects.Cities.FreeCity;
import Objects.Cities.MerchantCity;
import Objects.Cities.NobleCity;
import Objects.Cities.WarriorCity;
import Panels.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;


public class MyFrame extends JFrame implements MouseListener {

    JLabel label;
    JLabel background;
    Nation nation;

    Panels.cityPanel cityPanel;
    Panels.eventsPanel eventsPanel;
    Panels.buildingPanel buildingPanel;
    Panels.factionPanel factionPanel;
    Panels.diplomacyPanel diplomacyPanel;
    Panels.rulerPanel rulerPanel;
    Panels.statsPanel statsPanel;
    Panels.mainMenuPanel mainMenuPanel;
    Panels.attackPanel attackPanel;

    JButton mainMenuButton;

    panelComponentMaker panelMaker;

    Font cityMenuFont;

    City currentCity;
    Ruler currentRuler;
    Ruler currentPlayer;


    public MyFrame(String title, Nation nation) throws HeadlessException, IOException {
        super(title);
        this.nation = nation;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(1920, 1080));
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);

        panelMaker = new panelComponentMaker();

        mainMenuButton = panelMaker.standardPanelButton("Menu",1840,1060);
        this.add(mainMenuButton);
        mainMenuButton.setVisible(true);

        this.cityMenuFont = new Font("Helvetica",Font.ITALIC,10);
        cityPanel = new cityPanel();
        this.add(cityPanel);
        buildingPanel = new buildingPanel();
        this.add(buildingPanel);
        eventsPanel = new eventsPanel();
        this.add(eventsPanel);
        factionPanel = new factionPanel();
        this.add(factionPanel);
        rulerPanel = new rulerPanel();
        this.add(rulerPanel);
        diplomacyPanel = new diplomacyPanel();
        this.add(diplomacyPanel);
        statsPanel = new statsPanel();
        this.add(statsPanel);
        mainMenuPanel = new mainMenuPanel();
        this.add(mainMenuPanel);
        attackPanel = new attackPanel();
        this.add(attackPanel);

        configureStartingUI();
    }

    public void addCity(int x,int y) throws IOException {
        JLabel label = new JLabel();
        label.setBounds(x,y,35,20);
        label.setBackground(new Color(0,0,0,0));
        label.setOpaque(true);
        label.addMouseListener(this);
        Image image = ImageIO.read(new File("Res/City.png"));
        Image scaleImage = image.getScaledInstance(40, 40,Image.SCALE_DEFAULT);
        label.setIcon(new ImageIcon(scaleImage));
        this.getContentPane().add(label);
        label.setVisible(true);
    }

    public void searchForCity(int x, int y){
        System.out.println(x);
        System.out.println(y);
        for (Ruler ruler : nation.getRulers()) {
            for (City city : ruler.getCities()) {
                System.out.println(city.getPosition().x);
                System.out.println(city.getPosition().y);
                if((city.getPosition().x-50 < x && city.getPosition().x+50 > x) && (city.getPosition().y-50 < y && city.getPosition().y+50 > y)){
                    System.out.println("clicked"+city.getCityNr());
                    moveCityMenu(city.getPosition().x+35,city.getPosition().y-60);
                    configurePanels( city, ruler, nation.getPlayer());
                    configureBuildingPanelsStart();
                    configureDiplomacyPanelsStart();
                }
            }
        }
    }

    public void tickOneTurn(){
        nation.oneTurn();
        updatePanels();
    }

    public void addStartingCityMenu(City city,Ruler ruler){
        configureCityPanelButtons(city);
    }

    public void moveCityMenu(int x, int y){
        cityPanel.setLocation(x,y);
        buildingPanel.setLocation(x+100,y-40);
        eventsPanel.setLocation(x+100,y-40);
        factionPanel.setLocation(x+100,y-40);
        diplomacyPanel.setLocation(x+265,y-60);
        rulerPanel.setLocation(x+100,y-40);
        statsPanel.setLocation(x+100,y-40);
        attackPanel.setLocation(x+265,y-60);
        showPanel();
    }

    public void hideSecondaryPanels(){
        buildingPanel.setVisible(false);
        eventsPanel.setVisible(false);
        factionPanel.setVisible(false);
        diplomacyPanel.setVisible(false);
        rulerPanel.setVisible(false);
        statsPanel.setVisible(false);
    }

    public void showPanel(){
        cityPanel.setVisible(true);
    }

    public void configurePanels(City city, Ruler ruler, Ruler player){
        currentCity = city;
        currentRuler = ruler;
        currentPlayer = player;
        if(city != null) {
            configureCityPanelButtons(city);
            configureBuildingPanel(city,ruler);
            configureStatsPanelButtons(city);
            configureDiplomacyPanelButtons(player, ruler);
            configureRulerPanelButtons(ruler,player);
            configureEventPanel(city);
            configureFactionPanelButtons(city,player);
            configureFactionPanelInfo(city);
            configureAttackPanel(city,ruler);
        }
    }

    public void configureMainMenuPanel(){
        mainMenuPanel.setLocation(1840,940);
        mainMenuPanel.getEndTurnButton().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               tickOneTurn();
               updatePanelText(currentRuler);
           }
           });
        mainMenuPanel.getCloseButton().addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   mainMenuPanel.setVisible(false);
               }
           });
        mainMenuPanel.getExitGameButton().addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   System.exit(0);
               }
           });
        }

        public void configureStartingUI(){
            mainMenuButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mainMenuPanel.setVisible(true);
                }
            });
            configureMainMenuPanel();
        }

    public void configureBuildingPanelsStart(){
        if(buildingPanel.getBuildingManager().getItemCount() > 0) {
            buildingPanel.getBuildingInfo1().setText("Name: " + buildingPanel.getBuildingManager().getItemAt(0).getName());
            buildingPanel.getBuildingInfo2().setText("Type: " + buildingPanel.getBuildingManager().getItemAt(0).getType());
            buildingPanel.getBuildingInfo3().setText("Value: " + buildingPanel.getBuildingManager().getItemAt(0).getValue());
            buildingPanel.getBuildingInfo4().setText("Cost: " + buildingPanel.getBuildingManager().getItemAt(0).getCost());
            buildingPanel.getBuildingInfo5().setText("Built: " + buildingPanel.getBuildingManager().getItemAt(0).isBuilt());
        }
    }

    public void configureDiplomacyPanelsStart(){
        if(diplomacyPanel.getPolicyManager().getItemCount() > 0) {
            diplomacyPanel.getPolicyInfo1().setText("Name: " + diplomacyPanel.getPolicyManager().getItemAt(0).getPolicyName());
            diplomacyPanel.getPolicyInfo2().setText("Type: " + diplomacyPanel.getPolicyManager().getItemAt(0).getPolicyType());
            diplomacyPanel.getPolicyInfo3().setText("Value: " + diplomacyPanel.getPolicyManager().getItemAt(0).getPolicyValue());
            diplomacyPanel.getPolicyInfo4().setText("Active: " + diplomacyPanel.getPolicyManager().getItemAt(0).isActive());
            diplomacyPanel.getPolicyInfo5().setText("Opinion Threshold: " + diplomacyPanel.getPolicyManager().getItemAt(0).getOpinionThreshold());
        }
    }

    public void updatePanels(){
        configurePanels(currentCity, currentRuler, currentPlayer);
    }

    public void updatePanelText(Ruler ruler){
        if(buildingPanel.getBuildingManager().getItemCount() > 0){
            buildingPanel.getBuildingInfo1().setText("Name: " + ((Building) Objects.requireNonNull(buildingPanel.getBuildingManager().getSelectedItem())).getName());
            buildingPanel.getBuildingInfo2().setText("Type: " + ((Building) buildingPanel.getBuildingManager().getSelectedItem()).getType());
            buildingPanel.getBuildingInfo3().setText("Value: " + ((Building) buildingPanel.getBuildingManager().getSelectedItem()).getValue());
            buildingPanel.getBuildingInfo4().setText("Cost: " + ((Building) buildingPanel.getBuildingManager().getSelectedItem()).getCost());
            buildingPanel.getBuildingInfo5().setText("Built: " +  ((Building) buildingPanel.getBuildingManager().getSelectedItem()).isBuilt());
        }
        if(diplomacyPanel.getPolicyManager().getItemCount() > 0){
            diplomacyPanel.getPolicyInfo1().setText("Name: " + ((Policy) Objects.requireNonNull(diplomacyPanel.getPolicyManager().getSelectedItem())).getPolicyName());
            diplomacyPanel.getPolicyInfo2().setText("Type: " + ((Policy) diplomacyPanel.getPolicyManager().getSelectedItem()).getPolicyValue());
            diplomacyPanel.getPolicyInfo3().setText("Value: " + ((Policy) diplomacyPanel.getPolicyManager().getSelectedItem()).getPolicyType());
            diplomacyPanel.getPolicyInfo4().setText("Active: " + ((Policy) diplomacyPanel.getPolicyManager().getSelectedItem()).isActive());
            diplomacyPanel.getPolicyInfo5().setText("Opinion Threshold: " + ((Policy) diplomacyPanel.getPolicyManager().getSelectedItem()).getOpinionThreshold());
            rulerPanel.getRulerInfo1().setText("Name: " + ruler.getName());
            rulerPanel.getRulerInfo2().setText("Family Name: " + ruler.getFamilyName());
            rulerPanel.getRulerInfo3().setText("Age: " + ruler.getAge());
            rulerPanel.getRulerInfo4().setText("Stead Fast Factor: " + ruler.getSteadfastFactor());
            rulerPanel.getRulerInfo5().setText("Current: " + ruler.getCurrent());
            rulerPanel.getRulerInfo6().setText("Opinion: " + ruler.getRulerOpinions().get(currentPlayer.getName()));
        }
    }

    public void configureCityPanelButtons(City city){
        cityPanel.removeAllActionListeners();
        cityPanel.getCityName().setText(city.getCityName());
        cityPanel.getDiplomacyButton().addActionListener(e -> {
            hideSecondaryPanels();
            eventsPanel.setVisible(true);
        });
        cityPanel.getBuildingsButton().addActionListener(e -> {
            hideSecondaryPanels();
            buildingPanel.setVisible(true);
        });
        cityPanel.getRulerButton().addActionListener(e -> {
            hideSecondaryPanels();
            rulerPanel.setVisible(true);
        });
        cityPanel.getFactionButton().addActionListener(e -> {
            hideSecondaryPanels();
            factionPanel.setVisible(true);
        });
        cityPanel.getStatsButton().addActionListener(e -> {
            hideSecondaryPanels();
            statsPanel.setVisible(true);
        });
        cityPanel.getCloseButton().addActionListener(e -> {
            hideSecondaryPanels();
            cityPanel.setVisible(false);
        });
    }

    public void configureBuildingPanel(City city, Ruler ruler){
        buildingPanel.removeAllActionlisteners();
        buildingPanel.getBuildingManager().removeAllItems();

        for (Building building : city.getBuildings()) {
            buildingPanel.getBuildingManager().addItem(building);
        }

        buildingPanel.getBuildingManager().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(buildingPanel.getBuildingManager().getItemCount() != 0){
                    buildingPanel.getBuildingInfo1().setText("Name: " + ((Building) buildingPanel.getBuildingManager().getSelectedItem()).getName());
                    buildingPanel.getBuildingInfo2().setText("Type: " + ((Building) buildingPanel.getBuildingManager().getSelectedItem()).getType());
                    buildingPanel.getBuildingInfo3().setText("Value: " + ((Building) buildingPanel.getBuildingManager().getSelectedItem()).getValue());
                    buildingPanel.getBuildingInfo4().setText("Cost: " + ((Building) buildingPanel.getBuildingManager().getSelectedItem()).getCost());
                    buildingPanel.getBuildingInfo5().setText("Built: " +  ((Building) buildingPanel.getBuildingManager().getSelectedItem()).isBuilt());
                }
            }
        });
        buildingPanel.getProposeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(city.buildBuilding(((Building) Objects.requireNonNull(buildingPanel.getBuildingManager().getSelectedItem())),ruler)){
                    updatePanelText(ruler);
                }
            }
        });
        buildingPanel.getCloseButton().addActionListener(e -> buildingPanel.setVisible(false));
    }

    public void configureEventPanel(City city) {
        eventsPanel.getEventInfo1().setText(city.getEvents().getItem(0));
        eventsPanel.getEventInfo2().setText(city.getEvents().getItem(1));
        eventsPanel.getEventInfo3().setText(city.getEvents().getItem(2));
        eventsPanel.getEventInfo4().setText(city.getEvents().getItem(3));
        eventsPanel.getEventInfo5().setText(city.getEvents().getItem(4));
        eventsPanel.getCloseButton().addActionListener(e -> eventsPanel.setVisible(false));
    }

    public void configureDiplomacyPanelButtons(Ruler player, Ruler receivingRuler){
        diplomacyPanel.removeAllActionlisteners();
        diplomacyPanel.getPolicyManager().removeAllItems();
        diplomacyPanel.getPolicyManager().removeAll();

        if(!Objects.equals(player.getName(), receivingRuler.getName())) {
            for (Policy policy : receivingRuler.getRulerPolicies().get(player.getName())) {
                diplomacyPanel.getPolicyManager().addItem(policy);
            }
        }
        else{
            diplomacyPanel.getPolicyManager().removeAllItems();
        }
        diplomacyPanel.getPolicyManager().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(diplomacyPanel.getPolicyManager().getItemCount() != 0){
                    diplomacyPanel.getPolicyInfo1().setText("Name: " + ((Policy) diplomacyPanel.getPolicyManager().getSelectedItem()).getPolicyName());
                    diplomacyPanel.getPolicyInfo2().setText("Type: " + ((Policy) diplomacyPanel.getPolicyManager().getSelectedItem()).getPolicyValue());
                    diplomacyPanel.getPolicyInfo3().setText("Value: " + ((Policy) diplomacyPanel.getPolicyManager().getSelectedItem()).getPolicyType());
                    diplomacyPanel.getPolicyInfo4().setText("Active: " + ((Policy) diplomacyPanel.getPolicyManager().getSelectedItem()).isActive());
                    diplomacyPanel.getPolicyInfo5().setText("Opinion Threshold: " + ((Policy) diplomacyPanel.getPolicyManager().getSelectedItem()).getOpinionThreshold());
                }
            }
        });
        diplomacyPanel.getProposeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(receivingRuler.enactPolicy((Policy) diplomacyPanel.getPolicyManager().getSelectedItem(),player)){
                    updatePanelText(receivingRuler);
                }
            }
        });
        diplomacyPanel.getCloseButton().addActionListener(e -> diplomacyPanel.setVisible(false));
    }

    public void configureRulerPanelButtons(Ruler ruler,Ruler player){
        rulerPanel.removeAllActionListeners();
        rulerPanel.getRulerInfo1().setText("Name: " + ruler.getName());
        rulerPanel.getRulerInfo2().setText("Family Name: " + ruler.getFamilyName());
        rulerPanel.getRulerInfo3().setText("Age: " + ruler.getAge());
        rulerPanel.getRulerInfo4().setText("Stead Fast Factor: " + ruler.getSteadfastFactor());
        rulerPanel.getRulerInfo5().setText("Current: " + ruler.getCurrent());
        if(ruler != player){
            rulerPanel.getRulerInfo6().setText("Opinion: " + ruler.getRulerOpinions().get(player.getName()));
        }
        else{
            rulerPanel.getRulerInfo6().setText("Opinion: " + player.getRulerOpinions().get("bertil"));
        }
        rulerPanel.getDiplomacyButton().addActionListener(e ->diplomacyPanel.setVisible(true));
        rulerPanel.getCloseButton().addActionListener(e -> rulerPanel.setVisible(false));
    }

    public void configureStatsPanelButtons(City city){
        statsPanel.removeAllActionlisteners();
        statsPanel.getStatsLabel1().setText("City Name: " + city.getCityName());
        statsPanel.getStatsLabel2().setText("City Income: " + city.getBaseCityIncome());
        statsPanel.getStatsLabel3().setText("Popular Opinion: " + city.getPopularOpinion());
        statsPanel.getStatsLabel4().setText("City Nr: " + city.getCityNr());
        statsPanel.getStatsLabel5().setText("City Position: (" + city.getPosition().x + "," + city.getPosition().y + ")");
        switch (city.getType()){
            case FREE_CITY -> statsPanel.getStatsLabel6().setText("Freedom Factor: " + ((FreeCity) city).getFreedomFactor());
            case MERCHANT_CITY -> statsPanel.getStatsLabel6().setText("Trade Power: " + ((MerchantCity) city).getTradePower());
            case NOBLE_CITY -> statsPanel.getStatsLabel6().setText("Fame: " + ((NobleCity) city).getFame());
            case WARRIOR_CITY -> statsPanel.getStatsLabel6().setText("Warrior Spirit:: " + ((WarriorCity) city).getWarSpirit());
            default -> System.out.print("Fail");
        }
        statsPanel.getCloseButton().addActionListener(e -> statsPanel.setVisible(false));
    }

    public void configureFactionPanelButtons(City city,Ruler player){
        factionPanel.removeAllActionlisteners();
        configureFactionPanelInfo(city);
        factionPanel.getClergyInvestButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                city.getClergyFaction().increaseFactionPower(10);
                city.getTraderFaction().decreaseFactionPower(3);
                city.getMilitaryFaction().decreaseFactionPower(3);
                city.getClergyFaction().increaseFactionOpinion(10);
                player.decreaseCurrent(500);
                configureFactionPanelInfo(city);
            }
        });
        factionPanel.getClergyEnlistButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                city.getClergyFaction().increaseFactionPopulation(100);
                city.getMilitaryFaction().reduceFactionPopulation(50);
                city.getTraderFaction().reduceFactionPopulation(50);
                city.getMilitaryFaction().decreaseFactionOpinion(5);
                city.getTraderFaction().decreaseFactionOpinion(5);
                configureFactionPanelInfo(city);
            }
        });
        factionPanel.getMilitaryInvestButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                city.getMilitaryFaction().increaseFactionPower(10);
                city.getClergyFaction().decreaseFactionPower(3);
                city.getTraderFaction().decreaseFactionPower(3);
                city.getMilitaryFaction().increaseFactionOpinion(10);
                player.decreaseCurrent(500);
                configureFactionPanelInfo(city);
            }
        });
        factionPanel.getMilitaryEnlistButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                city.getMilitaryFaction().increaseFactionPopulation(100);
                city.getClergyFaction().reduceFactionPopulation(50);
                city.getTraderFaction().reduceFactionPopulation(50);
                city.getTraderFaction().decreaseFactionOpinion(5);
                city.getClergyFaction().decreaseFactionOpinion(5);
                configureFactionPanelInfo(city);
            }
        });
        factionPanel.getTraderInvestButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                city.getTraderFaction().increaseFactionPower(10);
                city.getClergyFaction().decreaseFactionPower(3);
                city.getMilitaryFaction().decreaseFactionPower(3);
                city.getTraderFaction().increaseFactionOpinion(10);
                player.decreaseCurrent(500);
                configureFactionPanelInfo(city);
            }
        });
        factionPanel.getTraderEnlistButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                city.getTraderFaction().increaseFactionPopulation(100);
                city.getMilitaryFaction().reduceFactionPopulation(50);
                city.getClergyFaction().reduceFactionPopulation(50);
                city.getClergyFaction().decreaseFactionOpinion(5);
                city.getTraderFaction().decreaseFactionOpinion(5);
                configureFactionPanelInfo(city);
            }
        });

        factionPanel.getAttackButton().addActionListener(e -> attackPanel.setVisible(true));
        factionPanel.getCloseButton().addActionListener(e -> factionPanel.setVisible(false));
    }

    public void configureFactionPanelInfo(City city){
        factionPanel.getMilitaryInfoLabel1().setText("Population:" + city.getMilitaryFaction().getPopulation());
        factionPanel.getMilitaryInfoLabel2().setText("Faction Power:" + city.getMilitaryFaction().getFactionPower());
        factionPanel.getClergyInfoLabel1().setText("Population: " + city.getClergyFaction().getPopulation());
        factionPanel.getClergyInfoLabel2().setText("Faction Power: " + city.getClergyFaction().getFactionPower());
        factionPanel.getTradersInfoLabel1().setText("Population: " + city.getTraderFaction().getPopulation());
        factionPanel.getTradersInfoLabel2().setText("Faction Power: " + city.getTraderFaction().getFactionPower());
    }

    public void configureAttackPanel(City city,Ruler ruler){
        attackPanel.removeAllActionListeners();
        attackPanel.getCloseButton().addActionListener(e -> attackPanel.setVisible(false));

        attackPanel.getTroopSlider().addChangeListener(e ->attackPanel.getTroopCount().setText("Troop Count: " + attackPanel.getTroopSlider().getValue()));

        attackPanel.getAttackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nation.combatSolver(ruler,city,currentPlayer, currentPlayer.getCities().get(0),attackPanel.getTroopSlider().getValue());
                configureFactionPanelInfo(city);
            }
        });
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Clicked");
        searchForCity(e.getXOnScreen(),e.getYOnScreen());
    }


    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Pressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Released");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Entered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Exited");
    }

}
