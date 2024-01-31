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

    /**
     * Preliminary Unlocking Matrix:
     * The entries in the LCM represent the logical connectors to 
     * be used between pairs of LICs to determine the corresponding 
     * entry in the PUM, i.e. LCM[i,j] represents the boolean operator 
     * to be applied to CMV[i] and CMV[j]. PUM[i,j] is set according 
     * to the result of this operation. If LCM[i,j] is NOTUSED, then 
     * PUM[i,j] should be set to true.
     * @param ConditionsMetVector The Conditions Met Vector (length n)
     * @return Preliminary Unlocking Matrix: Matrix (n x n) of boolean values.
     */
    public boolean[][] getPreliminaryUnlockingMatrix(boolean[] ConditionsMetVector) {
        int n = ConditionsMetVector.length;
        if (LCM.length < n) throw new IllegalArgumentException();
        boolean[][] PUM = new boolean[n][n];
        for (int i = 0; i < PUM.length; ++i) {
            if (LCM[i].length < n) throw new IllegalArgumentException();
            for (int j = 0; j < PUM[i].length; ++j) {
                if (LCM[i][j] == Connector.ANDD) 
                    PUM[i][j] = ConditionsMetVector[i] && ConditionsMetVector[j];
                if (LCM[i][j] == Connector.ORR) 
                    PUM[i][j] = ConditionsMetVector[i] || ConditionsMetVector[j];
                if (LCM[i][j] == Connector.NOTUSED) 
                    PUM[i][j] = true;
            }
        }
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