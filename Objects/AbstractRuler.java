package Objects;

import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public abstract class AbstractRuler implements Ruler {
    int age;
    String name;
    String familyName;
    int steadfastFactor;
    boolean king;
    int current;
    int baseRulerIncome;
    List<City> cities;
    Map<String, List<Policy>> rulerPolicies;
    Map<String, Integer> rulerOpinions;

    public AbstractRuler(int age, String name, String familyName, int steadfastFactor, boolean king, List<City> cities) {
        this.age = age;
        this.name = name;
        this.familyName = familyName;
        this.steadfastFactor = steadfastFactor;
        this.king = king;
        this.cities = cities;
        baseRulerIncome = 0;
        rulerPolicies = new HashMap<>();
        rulerOpinions = new HashMap<>();
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public int getSteadfastFactor() {
        return steadfastFactor;
    }

    public boolean isKing() {
        return king;
    }

    public List<City> getCities() {
        return cities;
    }

    public int getBaseRulerIncome() {
        return baseRulerIncome;
    }

    public Map<String, List<Policy>> getRulerPolicies() {
        return rulerPolicies;
    }

    public Map<String, Integer> getRulerOpinions() {
        return rulerOpinions;
    }

    public int getCurrent() {
        return current;
    }

    public void increaseCurrent(int increase) {
        current += increase;
    }

    public void decreaseCurrent(int decrease){
        current -= decrease;
    }

    public void increaseBaseIncome(int increase){
        baseRulerIncome += increase;
    }

    public boolean enactPolicy(Policy policy, Ruler approachingRuler) {
        if (!rulerOpinions.isEmpty() && !approachingRuler.getRulerOpinions().isEmpty()) {
            int currentReceivingRulerOpinion = rulerOpinions.get(approachingRuler.getName());
            int currentApproachingPlayerOpinion = approachingRuler.getRulerOpinions().get(name);
            if (currentReceivingRulerOpinion > policy.opinionThreshold && currentApproachingPlayerOpinion > policy.opinionThreshold && !policy.active) {
                switch (policy.getPolicyType()) {

                    case OPINION -> {
                        rulerOpinions.replace(approachingRuler.getName(), currentReceivingRulerOpinion + policy.getPolicyValue());
                        approachingRuler.getRulerOpinions().replace(name, currentApproachingPlayerOpinion + policy.getPolicyValue());
                        policy.active = true;
                    }

                    case INCOME -> {
                        baseRulerIncome += policy.getPolicyValue();
                        approachingRuler.increaseBaseIncome(policy.getPolicyValue());
                        policy.active = true;
                    }


                    case ACTION -> {
                        System.out.print("Action");
                        policy.active = true;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
