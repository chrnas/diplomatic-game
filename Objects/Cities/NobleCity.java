package Objects.Cities;

import Enums.CityType;
import Objects.AbstractCity;
import Objects.Building;

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;

public class NobleCity extends AbstractCity {

    int fame;

    public NobleCity(String cityName, int popularOpinion, int baseCityIncome, ArrayList<Building> buildings, int fame, Point position, int cityNr, CityType type) throws FileNotFoundException {
        super(cityName, popularOpinion, baseCityIncome, buildings, position,cityNr,type);
        this.fame = fame;
    }

    public int getFame() {
        return fame;
    }
}
