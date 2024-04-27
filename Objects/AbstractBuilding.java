package Objects;

import Enums.BuildingType;

public abstract class AbstractBuilding implements Building{
    String name;
    int cost;
    int value;
    BuildingType type;
    boolean built;

    public AbstractBuilding(String name, int cost, int value, BuildingType type,boolean built) {
        this.name = name;
        this.cost = cost;
        this.value = value;
        this.type = type;
        this.built = built;
    }

    public int getCost() {
        return cost;
    }

    public BuildingType getType() {
        return type;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public boolean isBuilt() {
        return built;
    }

    public void buildBuilding(){
        built = true;
    }

    public void tearBuilding(){
        built = false;
    }

    public String toString(){//overriding the toString() method
        return name;
    }
}
