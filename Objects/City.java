package Objects;

import Enums.CityType;

import java.awt.*;
import java.util.ArrayList;

public interface City {

    ArrayList<Building> getBuildings();

    int getBaseCityIncome();

    int getPopularOpinion();

    Point getPosition();

    int getCityNr();

    String getCityName();

    void newBuilding(Building building);

    CityType getType();

    public List getEvents();

    Faction getMilitaryFaction();
    Faction getTraderFaction();
    Faction getClergyFaction();

    boolean buildBuilding(Building building,Ruler ruler);

    int countCityIncome();

    void changeOwnership(Ruler prevOwner,Ruler newOwner);
}
