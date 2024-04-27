package Makers;

import Enums.BuildingType;
import Enums.CityType;
import Enums.PolicyType;
import Objects.*;
import Objects.Cities.FreeCity;
import Objects.Cities.MerchantCity;
import Objects.Cities.NobleCity;
import Objects.Cities.WarriorCity;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class KingdomOfXeroxMaker {

    Scanner reader;
    int readCount;
    int cityNr = 1;

    public KingdomOfXeroxMaker(String file) throws FileNotFoundException {
        this.reader = new Scanner(new File(file));
    }

    public Nation makeTestKingdom() throws IOException {
        List<Ruler> rulers = new ArrayList<>();

        List<City> cities = new ArrayList<>();
        ArrayList<Building> buildingList1 = new ArrayList<>();
        buildingList1.add(new standardBuilding("Theater",6000,300, BuildingType.POPULAR_OPINION,false));
        buildingList1.add(new standardBuilding("Market",4000,200, BuildingType.INCOME,false));
        buildingList1.add(new standardBuilding("Forum",200,200, BuildingType.POPULAR_OPINION,false));
        buildingList1.add(new standardBuilding("Clothing Workshop",4000,200, BuildingType.INCOME,false));
        buildingList1.add(new standardBuilding("Farm",50,100, BuildingType.INCOME,false));

        FreeCity freeCity = new FreeCity("Lubeck",60,500,buildingList1,70,new Point(100,400),1, CityType.FREE_CITY);
        cities.add(freeCity);
        rulers.add(new standardRuler(20, "albert", "Bolsonaro", 50, false,cities));

        ArrayList<Building> buildingList2 = new ArrayList<>();
        buildingList2.add(new standardBuilding("Market",4000,200, BuildingType.INCOME,true));
        buildingList2.add(new standardBuilding("Harbour",3000,200, BuildingType.INCOME,false));
        buildingList2.add(new standardBuilding("Coin Maker",1000,100, BuildingType.INCOME,false));
        buildingList2.add(new standardBuilding("Palace",20,200, BuildingType.POPULAR_OPINION,false));
        buildingList2.add(new standardBuilding("Baths",2000,100, BuildingType.POPULAR_OPINION,false));

        List<City> merchantCities = new ArrayList<>();
        MerchantCity merchantCity = new MerchantCity("Hambourg",60,500,buildingList2,70,new Point(600,700),2,CityType.MERCHANT_CITY);
        merchantCities.add(merchantCity);
        rulers.add(new standardRuler(20, "bertil", "Bolsonaro", 50, false,merchantCities));

        Nation nation = new Nation(rulers);

        for (Ruler currentRuler: nation.getRulers()) {
            for (Ruler ruler: nation.getRulers()) {
                if(!Objects.equals(currentRuler.getName(), ruler.getName())){
                    currentRuler.getRulerPolicies().put(ruler.getName(),createStandardPolicyList());
                    currentRuler.getRulerOpinions().put(ruler.getName(),50);
                }
            }
        }

        return nation;
    }

    public void readAllLines() throws IOException {
        String nextLine = reader.nextLine();
        while(reader.hasNextLine()){
            System.out.print(nextLine);
            nextLine = reader.nextLine();
        }
    }

    public Nation makeTestKingdomFromTextFile() throws IOException {
        List<Ruler> rulers = new ArrayList<>();
        while(reader.hasNextLine()){
            rulers.add(createRulerFromFile());
        }
        reader.close();

        Nation nation = new Nation(rulers);

        for (Ruler currentRuler: nation.getRulers()) {
            for (Ruler ruler: nation.getRulers()) {
                if(!Objects.equals(currentRuler.getName(), ruler.getName())){
                    currentRuler.getRulerPolicies().put(ruler.getName(),createStandardPolicyList());
                    currentRuler.getRulerOpinions().put(ruler.getName(),50);
                }
            }
        }
        return nation;
    }

    public ArrayList<Building> createBuildingsFromFile() throws IOException {
        ArrayList<Building> buildings = new ArrayList<>();
        while(!(Objects.equals(reader.nextLine(), "CityInit:"))){
            buildings.add(createBuildingFromFile());
            reader.nextLine();
        }
        return buildings;
    }

    public List<City> createCitiesFromFile() throws IOException {
        List<City> cities = new ArrayList<>();
        while(!Objects.equals(reader.nextLine(), "RulerInit:")){
            cities.add(createCityFromFile(cityNr));
            cityNr++;
            reader.nextLine();
        }
        return cities;
    }

    public City createCityFromFile(int cityNr) throws IOException {
        ArrayList<Building> buildings = createBuildingsFromFile();
        String name = reader.nextLine().split(":")[1];
        int popularOpinion = Integer.parseInt(reader.nextLine().split(":")[1]);
        int baseCityIncome = Integer.parseInt(reader.nextLine().split(":")[1]);
        int cityFactor = Integer.parseInt(reader.nextLine().split(":")[1]);
        int positionX = Integer.parseInt(reader.nextLine().split(":")[1]);
        int positionY = Integer.parseInt(reader.nextLine().split(":")[1]);
        String type = reader.nextLine().split(":")[1];
        return switch (type) {
            case "MERCHANT_CITY" -> new MerchantCity(name, popularOpinion, baseCityIncome, buildings, cityFactor, new Point(positionX, positionY), cityNr, CityType.MERCHANT_CITY);
            case "FREE_CITY" -> new FreeCity(name, popularOpinion, baseCityIncome, buildings, cityFactor, new Point(positionX, positionY), cityNr, CityType.FREE_CITY);
            case "WARRIOR_CITY" -> new WarriorCity(name, popularOpinion, baseCityIncome, buildings, cityFactor, new Point(positionX, positionY), cityNr, CityType.WARRIOR_CITY);
            default -> new NobleCity(name, popularOpinion, baseCityIncome, buildings, cityFactor, new Point(positionX, positionY), cityNr, CityType.NOBLE_CITY);
        };
    }

    public BuildingType createBuildingTypeFromString(String type){
        switch(type){
            case "INCOME":
                return BuildingType.INCOME;
            case "POPULAR_OPINION":
                return BuildingType.POPULAR_OPINION;
            default:  return BuildingType.INCOME;

        }
    }
    public Building createBuildingFromFile() throws IOException {
        String name = reader.nextLine().split(":")[1];
        int cost = Integer.parseInt(reader.nextLine().split(":")[1]);
        int value =  Integer.parseInt(reader.nextLine().split(":")[1]);
        BuildingType type = createBuildingTypeFromString(reader.nextLine().split(":")[1]);
        boolean built = reader.nextLine().split(":")[1].equals("built");
        return new standardBuilding(name,cost,value,type,built);
    }

    
    public Ruler createRulerFromFile() throws IOException {
        List<City> cities = createCitiesFromFile();
        String name = reader.nextLine().split(":")[1];
        String familyName = reader.nextLine().split(":")[1];
        int age = Integer.parseInt(reader.nextLine().split(":")[1]);
        int steadfastFactor = Integer.parseInt(reader.nextLine().split(":")[1]);
        boolean king = reader.nextLine().split(":")[1].equals("true");
        return new standardRuler(age,name,familyName,steadfastFactor,king,cities);
    }

    public List<Policy> createStandardPolicyList(){
        List<Policy> policies = new ArrayList<>();
        policies.add(new Policy("Declaration of friendship",15, PolicyType.OPINION,false,40));
        policies.add(new Policy("Trade Agreement",100, PolicyType.INCOME,false,60));
        policies.add(new Policy("Partnership",25, PolicyType.OPINION,false,50));
        policies.add(new Policy("Non-Aggression pact",40, PolicyType.ACTION,false,70));
        policies.add(new Policy("Defensive Alliance",60, PolicyType.ACTION,false,120));
        return policies;
    }
}
