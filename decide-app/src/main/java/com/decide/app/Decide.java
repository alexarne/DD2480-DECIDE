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

    /**
     * Final Unlocking Vector:
     * The Preliminary Unlocking Matrix indicates whether the corresponding 
     * LIC is to be considered as a factor in signaling interceptor launch. 
     * FUV[i] should be set to true if PUV[i] is false (indicating that the 
     * associated LIC should not hold back launch) or if all elements in 
     * PUM row i are true.
     * @param PreliminaryUnlockingMatrix The Preliminary Unlocking Matrix.
     * @return The Final Unlocking Vector, an array of boolean values.
     */
    public boolean[] getFinalUnlockingVector(boolean[][] PreliminaryUnlockingMatrix) {
        int n = PUV.length;
        if (PreliminaryUnlockingMatrix.length < n) throw new IllegalArgumentException();
        boolean[] FUV = new boolean[n];
        for (int i = 0; i < FUV.length; ++i) {
            FUV[i] = true;
            if (PUV[i] == false) continue;
            for (int j = 0; j < PreliminaryUnlockingMatrix[i].length; ++j) {
                FUV[i] = FUV[i] && PreliminaryUnlockingMatrix[i][j];
            }
        }
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