package Objects;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import static java.lang.Math.abs;

public class Nation {
    Ruler player;
    List<Ruler> rulers;
    Image backgroundImage;
    Image cityImage;
    Image treeImage;

    Random RND;

    public Nation(List<Ruler> rulers) throws IOException {
        this.rulers = rulers;
        this.player = rulers.get(0);
        player.getCities().get(0).getMilitaryFaction().setPopulation(1000);
        this.backgroundImage = ImageIO.read(new File("Res/KingdomOfXeron2.0.png"));
        this.cityImage = ImageIO.read(new File("Res/City.png"));
        this.treeImage = (ImageIO.read(new File("Res/TreeXeron.png"))).getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        RND = new Random();
    }

    public List<Ruler> getRulers() {
        return rulers;
    }

    public Image getBackgroundImage() {
        return backgroundImage;
    }

    public Image getCityImage() {
        return cityImage;
    }

    public Image getTreeImage() {
        return treeImage;
    }

    public Ruler getPlayer() {
        return player;
    }

    public void oneTurn() {
        for (Ruler ruler : rulers) {
            handleIncome(ruler);
            if(!Objects.equals(ruler.getName(), player.getName())){
                rulerAIInteractions(ruler, rulers);
                rulerAIBuildings(ruler);
                randomFactionInteraction(ruler);
                randomAttackInteractions(ruler, rulers);
            }
        }
    }

    public void handleIncome(Ruler ruler) {
        int rulerIncome = 0;
        rulerIncome += ruler.getBaseRulerIncome();
        for (City city : ruler.getCities()) {
            rulerIncome += city.countCityIncome();
        }
        ruler.increaseCurrent(rulerIncome);
    }

    public void randomAttackInteractions(Ruler ruler, List<Ruler> rulers){
        for (Ruler ruler2 : rulers) {
            int randomNr = RND.nextInt(5);
            int randomDefendingCityNr = 0;
            int randomAttackingCityNr = 0;
            if (!Objects.equals(ruler.getName(), ruler2.getName()) && randomNr == 1 && !ruler.getCities().isEmpty() && !ruler2.getCities().isEmpty()) {
                if (ruler2.getCities().size() > 1) {
                    randomDefendingCityNr = RND.nextInt(ruler2.getCities().size() - 1);
                }
                if (ruler.getCities().size() > 1) {
                    randomAttackingCityNr = RND.nextInt(ruler.getCities().size() - 1);
                }
                City defendingCity = ruler2.getCities().get(randomDefendingCityNr);
                City attackingCity = ruler.getCities().get(randomAttackingCityNr);
                if (attackingCity.getMilitaryFaction().getPopulation() > 500) {
                    int troopCount = RND.nextInt(500, attackingCity.getMilitaryFaction().getPopulation());
                    combatSolver(ruler2, defendingCity, ruler, attackingCity, troopCount);
                    System.out.println("battle");
                }
            }
        }
    }

    public void rulerAIInteractions(Ruler ruler, List<Ruler> rulers) {
        for (Ruler ruler2 : rulers) {
            int randomNr = RND.nextInt(2);
            if (!Objects.equals(ruler.getName(), ruler2.getName()) && randomNr == 1) {
                randomPolicyInteraction(ruler, ruler2);
            }
        }
    }

    public void randomPolicyInteraction(Ruler ruler, Ruler ruler2) {
        for (Policy policy : ruler.getRulerPolicies().get(ruler2.getName())) {
            int randomNr = RND.nextInt(2);
            if (!policy.isActive() && randomNr == 1) {
                ruler.enactPolicy(policy, ruler2);
            }
        }
    }

    public void rulerAIBuildings(Ruler ruler) {
        for(City city : ruler.getCities()) {
            for(Building building : city.getBuildings()){
                int randomNr = RND.nextInt(6);
                if(randomNr == 1) {
                    city.buildBuilding(building, ruler);
                }
            }
        }
    }

    public void randomFactionInteraction(Ruler ruler){
        int randomNr = RND.nextInt(6);
        for(City city : ruler.getCities()){
            switch (randomNr){
                case 0:
                    if(ruler.getCurrent() >= 1000) {
                        clergyInvestAction(ruler, city);
                    }
                    break;
                case 1:
                    if (ruler.getCurrent() >= 500) {
                        clergyEnlistAction(ruler,city);
                    }
                    break;
                case 2:
                    if(ruler.getCurrent() >= 1000){
                        militaryInvestAction(ruler,city);
                    }
                    break;
                case 3:
                    if (ruler.getCurrent() >= 500) {
                        militaryEnlistAction(ruler, city);
                    }
                    break;
                case 4:
                    if(ruler.getCurrent() >= 1000){
                        traderInvestAction(ruler,city);
                    }
                    break;
                case 5:
                    if (ruler.getCurrent() >= 500) {
                        traderEnlistAction(ruler, city);
                    }
                    break;
                default:
                    break;
            }
        }
    }

    public void clergyInvestAction(Ruler ruler, City city){
        city.getClergyFaction().increaseFactionPower(10);
        city.getTraderFaction().decreaseFactionPower(3);
        city.getMilitaryFaction().decreaseFactionPower(3);
        city.getClergyFaction().increaseFactionOpinion(10);
        ruler.decreaseCurrent(1000);
    }
    public void clergyEnlistAction(Ruler ruler, City city){
        city.getClergyFaction().increaseFactionPower(10);
        city.getTraderFaction().decreaseFactionPower(3);
        city.getMilitaryFaction().decreaseFactionPower(3);
        city.getClergyFaction().increaseFactionOpinion(10);
        ruler.decreaseCurrent(500);
    }
    public void militaryInvestAction(Ruler ruler, City city){
        city.getMilitaryFaction().increaseFactionPower(10);
        city.getClergyFaction().decreaseFactionPower(3);
        city.getTraderFaction().decreaseFactionPower(3);
        city.getMilitaryFaction().increaseFactionOpinion(10);
        ruler.decreaseCurrent(1000);
    }
    public void militaryEnlistAction(Ruler ruler, City city){
        city.getMilitaryFaction().increaseFactionPopulation(100);
        city.getClergyFaction().reduceFactionPopulation(25);
        city.getTraderFaction().reduceFactionPopulation(25);
        city.getTraderFaction().decreaseFactionOpinion(5);
        city.getClergyFaction().decreaseFactionOpinion(5);
        ruler.decreaseCurrent(500);
    }

    public void traderInvestAction(Ruler ruler, City city){
        city.getTraderFaction().increaseFactionPower(10);
        city.getClergyFaction().decreaseFactionPower(3);
        city.getMilitaryFaction().decreaseFactionPower(3);
        city.getTraderFaction().increaseFactionOpinion(10);
        ruler.decreaseCurrent(1000);
    }
    public void traderEnlistAction(Ruler ruler, City city){
        city.getTraderFaction().increaseFactionPopulation(100);
        city.getMilitaryFaction().reduceFactionPopulation(25);
        city.getClergyFaction().reduceFactionPopulation(25);
        city.getClergyFaction().decreaseFactionOpinion(5);
        city.getTraderFaction().decreaseFactionOpinion(5);
        ruler.decreaseCurrent(500);
    }

    public void combatSolver(Ruler defendingRuler,City defendingCity,Ruler attackingRuler, City attackingCity,int troopCount){
        double attackingDamageModifier = 0.7;
        double defenderDamageModifier = 0.7;

        double randomDefendingDiceNr = RND.nextInt(1,6);
        double defendingDiceModifier = (randomDefendingDiceNr/10)+1;
        int defendingTroopCount = defendingCity.getMilitaryFaction().getPopulation();
        double defendingMilitaryPowerModifier = ((float) defendingCity.getMilitaryFaction().getFactionPower()/100)+1;
        double defendingPower = defendingTroopCount * defendingMilitaryPowerModifier * defendingDiceModifier;

        double randomAttackingDiceNr = RND.nextInt(6);
        double attackingDiceModifier = (randomAttackingDiceNr/10)+1;
        double attackingMilitaryPowerModifier = ((float) attackingCity.getMilitaryFaction().getFactionPower()/100)+1;
        double attackingPower = troopCount * attackingMilitaryPowerModifier * attackingDiceModifier;
        /*
        attackingDamageModifier -= attackingMilitaryPowerModifier/10;
        attackingDamageModifier += defendingMilitaryPowerModifier/10;
        attackingDamageModifier *= attackingDiceModifier;

        defendingDiceModifier -= attackingMilitaryPowerModifier/10;
        defendingDiceModifier += defendingMilitaryPowerModifier/10;
        defendingDiceModifier *= attackingDiceModifier;
        */
        if(defendingPower < attackingPower){
            defendingCity.changeOwnership(defendingRuler,attackingRuler);
            defenderDamageModifier -= 0.45;
        }
        else{
            attackingDamageModifier -= 0.45;
        }
        int defendingTroopsLeft = (int) (defendingTroopCount * defenderDamageModifier);
        int attackingTroopLoss = (int) (troopCount - (troopCount * attackingDamageModifier));

        attackingCity.getMilitaryFaction().reduceFactionPopulation(attackingTroopLoss);
        defendingCity.getMilitaryFaction().setPopulation(defendingTroopsLeft);

    }
}


