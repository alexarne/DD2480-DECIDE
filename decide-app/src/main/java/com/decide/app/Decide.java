package com.decide.app;

public class Decide {
    int NUMPOINTS;
    Point[] POINTS;
    Parameters PARAMETERS;
    Connector[][] LCM;
    boolean[] PUV;

    public Decide() {

    }

    public Decide(int NUMPOINTS, Point[] POINTS, Parameters PARAMETERS, Connector[][] LCM, boolean[] PUV) {
        this.NUMPOINTS = NUMPOINTS;
        this.POINTS = POINTS;
        this.PARAMETERS = PARAMETERS;
        this.LCM = LCM;
        this.PUV = PUV;
    }

    public boolean DECIDE() {
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        boolean[] CMV = LIC.getConditionsMetVector();
        boolean[][] PUM = getPreliminaryUnlockingMatrix(CMV);
        boolean[] FUV = getFinalUnlockingVector(PUM);
        boolean decision = getLaunchDecision(FUV);
        return decision;
    }

    public boolean[][] getPreliminaryUnlockingMatrix(boolean[] CMV) {
        boolean[][] PUM = new boolean[][]{{ true }};
        return PUM;
    }

    public boolean[] getFinalUnlockingVector(boolean[][] PUM) {
        boolean[] FUV = new boolean[]{ true };
        return FUV;
    }

    /**
     * Final launch decision:
     * The decision to launch requires that all elements in the 
     * Final Unlocking Vector be true.
     * @param FinalUnlockingVector The Final Unlocking Vector.
     * @return True if all values in FinalUnlockingVector are true.
     */
    public boolean getLaunchDecision(boolean[] FinalUnlockingVector) {
        for (boolean value : FinalUnlockingVector) {
            if (value == false) return false;
        }
        return true;
    }
}