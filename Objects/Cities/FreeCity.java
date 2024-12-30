package Objects.Cities;

import Enums.CityType;
import Objects.AbstractCity;
import Objects.Building;

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;

public class FreeCity extends AbstractCity {

    int freedomFactor;

    public FreeCity(String cityName, int popularOpinion, int baseCityIncome, ArrayList<Building> buildings, int freedomFactor, Point position, int cityNr, CityType type) throws FileNotFoundException {
        super(cityName,popularOpinion, baseCityIncome, buildings, position, cityNr,type);
        this.freedomFactor = freedomFactor;
    }

    public int getFreedomFactor() {
        return freedomFactor;
    }

    public int countCityIncome(){
        return super.getBaseCityIncome() + (super.getPopularOpinion()*freedomFactor)/10;
    }
}
