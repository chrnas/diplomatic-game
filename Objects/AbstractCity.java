package Objects;

import Enums.BuildingType;
import Enums.CityType;

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public abstract class AbstractCity implements City {
    String cityName;
    int popularOpinion;
    int baseCityIncome;
    ArrayList<Building> buildings;
    Point position;
    int cityNr;
    CityType type;
    List events;

    Faction militaryFaction;
    Faction clergyFaction;
    Faction traderFaction;

    public AbstractCity(String cityName,int popularOpinion, int baseCityIncome,  ArrayList<Building> buildings, Point position,int cityNr,CityType type) throws FileNotFoundException {
        this.cityName = cityName;
        this.cityNr = cityNr;
        this.popularOpinion = popularOpinion;
        this.baseCityIncome = baseCityIncome;
        this.buildings = buildings;
        this.position = position;
        this.type = type;
        this.events = new List();
        for (int i = 0; i < 5; i++) {
            events.add("");
        }

        militaryFaction = new Faction("military",500,50,50,true);
        clergyFaction = new Faction("military",200,50,50,true);
        traderFaction = new Faction("military",300,50,50,true);
    }

    public int getPopularOpinion() {
        return popularOpinion;
    }

    public int getBaseCityIncome() {
        return baseCityIncome;
    }

    public  ArrayList<Building> getBuildings() {
        return buildings;
    }

    public Point getPosition() {
        return position;
    }

    public int getCityNr() {
        return cityNr;
    }

    public Faction getMilitaryFaction() {
        return militaryFaction;
    }

    public Faction getClergyFaction() {
        return clergyFaction;
    }

    public Faction getTraderFaction() {
        return traderFaction;
    }

    public String getCityName() {
        return cityName;
    }
    public void newBuilding(Building building){
        switch(building.getType()){
            case INCOME:
                baseCityIncome += building.getValue();
            case POPULAR_OPINION:
                popularOpinion += building.getValue();
        }
        building.buildBuilding();
        events.add("built " + building.getName(),0);
        if(events.getItemCount() > 5){
            events.remove(5);
        }
    }

    public boolean buildBuilding(Building building,Ruler ruler){
        if(building.getCost() <= ruler.getCurrent() && !building.isBuilt()) {
            ruler.increaseCurrent(-building.getCost());
            newBuilding(building);
            return true;
        }
        return false;
    }

    public CityType getType() {
        return type;
    }

    public List getEvents() {
        return events;
    }

    public int countCityIncome(){
        int cityIncome = baseCityIncome;
        for (Building building: buildings) {
            if(building.getType() == BuildingType.INCOME){
                cityIncome += building.getValue();
            }
        }
        return cityIncome;
    }

    public void changeOwnership(Ruler prevOwner, Ruler newOwner){
        prevOwner.getCities().remove(this);
        newOwner.getCities().add(this);
    }
}
