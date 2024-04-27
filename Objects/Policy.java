package Objects;

import Enums.PolicyType;

import java.util.concurrent.Callable;

public class Policy {

    String policyName;
    int policyValue;
    PolicyType policyType;
    boolean active;
    int opinionThreshold;

    public Policy(String policyName, int policyValue, PolicyType policyType, boolean active,int opinionThreshold) {
        this.policyName = policyName;
        this.policyValue = policyValue;
        this.policyType = policyType;
        this.active = active;
        this.opinionThreshold = opinionThreshold;
    }

    public String getPolicyName() {
        return policyName;
    }

    public int getPolicyValue() {
        return policyValue;
    }

    public PolicyType getPolicyType() {
        return policyType;
    }

    public boolean isActive() {
        return active;
    }

    public String toString(){//overriding the toString() method
        return policyName;
    }

    public int getOpinionThreshold() {
        return opinionThreshold;
    }
}
