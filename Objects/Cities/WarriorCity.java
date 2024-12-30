package Objects.Cities;

import Enums.CityType;
import Objects.AbstractCity;
import Objects.Building;

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class WarriorCity extends AbstractCity {

    int warSpirit;

    public WarriorCity(String cityName, int popularOpinion, int baseCityIncome, ArrayList<Building> buildings, int warSpirit, Point position, int cityNr, CityType type) throws FileNotFoundException {
        super(cityName, popularOpinion, baseCityIncome, buildings, position,cityNr,type);
        this.warSpirit = warSpirit;
    }

    public int getWarSpirit() {
        return warSpirit;
    }
    public int countCityIncome(){
        return super.getBaseCityIncome() + ((super.getMilitaryFaction().getFactionPower() + super.getMilitaryFaction().getPopulation())/10);
    }
}
