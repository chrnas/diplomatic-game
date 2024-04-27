package Objects;

import Enums.BuildingType;

public class standardBuilding extends AbstractBuilding {

    public standardBuilding(String name, int cost, int value, BuildingType type,boolean built) {
        super(name, cost, value, type,built);
    }
}
