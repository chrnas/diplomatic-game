package Objects.Cities;

import Enums.CityType;
import Objects.AbstractCity;
import Objects.Building;

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;


public class MerchantCity extends AbstractCity {

    int tradePower;

    public MerchantCity(String cityName, int popularOpinion, int baseCityIncome, ArrayList<Building> buildings, int tradePower, Point position, int cityNr, CityType type) throws FileNotFoundException {
        super(cityName,popularOpinion, baseCityIncome, buildings, position,cityNr,type);
        this.tradePower = tradePower;
    }

    public int getTradePower() {
        return tradePower;
    }
}
