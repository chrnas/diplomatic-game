package Objects;

import java.util.List;
import java.util.Map;

public interface Ruler {

    public int getAge();

    public String getName();

    public String getFamilyName();

    public int getSteadfastFactor();

    public boolean isKing();

    List<City> getCities();

    public Map<String, List<Policy>> getRulerPolicies();

    public Map<String, Integer> getRulerOpinions();

    public int getCurrent();

    public boolean enactPolicy(Policy policy, Ruler approachingRuler);

    public void increaseCurrent(int increase);

    public void decreaseCurrent(int decrease);

    public int getBaseRulerIncome();

    public void increaseBaseIncome(int increase);
}
