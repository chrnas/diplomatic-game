package Objects;

import Enums.BuildingType;

public interface Building {

    int getCost();

    BuildingType getType();

    int getValue();

    String getName();

    boolean isBuilt();

    void buildBuilding();

    void tearBuilding();

    String toString();
}
