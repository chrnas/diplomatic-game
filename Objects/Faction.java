package Objects;

public class Faction {

    String factionName;
    int population;
    int factionPower;
    int factionOpinion;
    boolean factionLoyalty;

    public Faction(String factionName, int population, int factionPower, int factionOpinion, boolean factionLoyalty) {
        this.factionName = factionName;
        this.population = population;
        this.factionPower = factionPower;
        this.factionOpinion = factionOpinion;
        this.factionLoyalty = factionLoyalty;
    }

    public int getPopulation() {
        return population;
    }

    public int getFactionPower() {
        return factionPower;
    }

    public String getFactionName() {
        return factionName;
    }

    public int getFactionOpinion() {
        return factionOpinion;
    }

    public boolean isFactionLoyalty() {
        return factionLoyalty;
    }

    public void setFactionName(String factionName) {
        this.factionName = factionName;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setFactionPower(int factionPower) {
        this.factionPower = factionPower;
    }

    public void setFactionOpinion(int factionOpinion) {
        this.factionOpinion = factionOpinion;
    }

    public void setFactionLoyalty(boolean factionLoyalty) {
        this.factionLoyalty = factionLoyalty;
    }

    public void increaseFactionPower(int increase){
        this.factionPower += increase;
        this.factionPower = comparisonLimit(this.factionPower,100);
    }

    public void decreaseFactionPower(int decrease){
        this.factionPower -= decrease;
        this.factionPower = comparisonLimit(this.factionPower,100);
    }

    public void increaseFactionOpinion(int increase) {
        this.factionOpinion += increase;
        this.factionOpinion = comparisonLimit(this.factionOpinion,100);
    }

    public void decreaseFactionOpinion ( int decrease){
        this.factionOpinion -= decrease;
        this.factionOpinion = comparisonLimit(this.factionOpinion,100);
    }

    public void reduceFactionPopulation ( int decrease){
        this.population -= decrease;
        this.population = comparisonLimit(this.population,1000);
    }

    public void increaseFactionPopulation ( int increase){
        this.population += increase;
        this.population = comparisonLimit(this.population,1000);
    }
    public int comparisonLimit(int number,int compareLimit){
        if(number < 0){
            return 0;
        }
        else if(number > compareLimit){
            return compareLimit;
        }
        else{
            return number;
        }
    }
}