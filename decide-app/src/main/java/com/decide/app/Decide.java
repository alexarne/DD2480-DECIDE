package com.decide.app;

public class Decide {
    int NUMPOINTS;
    Point[] POINTS;
    Parameters PARAMETERS;
    Connector[][] LCM;
    boolean[] PUV;

    /**
     * Default constructor
     */
    public Decide() {

    }

    /**
     * Contruct the Decide object
     * @param NUMPOINTS Number of points
     * @param POINTS Array of Point objects
     * @param PARAMETERS Parameters object with relevant parameter fields
     * @param LCM Logical Connector matrix
     * @param PUV Boolean array, Preliminary Unlocking Vector
     */
    public Decide(int NUMPOINTS, Point[] POINTS, Parameters PARAMETERS, Connector[][] LCM, boolean[] PUV) {
        this.NUMPOINTS = NUMPOINTS;
        this.POINTS = POINTS;
        this.PARAMETERS = PARAMETERS;
        this.LCM = LCM;
        this.PUV = PUV;
    }

    /**
     * Get the boolean signal of whether or not to launch an interceptor, 
     * given the current input from initialization.
     * @return True if an interceptor should be launched, false otherwise.
     */
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