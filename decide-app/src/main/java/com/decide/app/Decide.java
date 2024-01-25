package com.decide.app;

public class Decide {
    int NUMPOINTS;
    Point[] POINTS;
    Parameters PARAMETERS;
    Connector[][] LCM;
    boolean[] PUV;

    public Decide(int NUMPOINTS, Point[] POINTS, Parameters PARAMETERS, Connector[][] LCM, boolean[] PUV) {
        this.NUMPOINTS = NUMPOINTS;
        this.POINTS = POINTS;
        this.PARAMETERS = PARAMETERS;
        this.LCM = LCM;
        this.PUV = PUV;
    }

    public boolean DECIDE() {
        LIC lic = new LIC(NUMPOINTS, POINTS, PARAMETERS);
        boolean[] CMV = lic.getCMV();
        boolean[][] PUM = getPUM(CMV);
        boolean[] FUV = getFUV(PUM);
        boolean decision = launch(FUV);
        return decision;
    }

    public boolean[][] getPUM(boolean[] CMV) {
        boolean[][] PUM = new boolean[][]{{ true }};
        return PUM;
    }

    public boolean[] getFUV(boolean[][] PUM) {
        boolean[] FUV = new boolean[]{ true };
        return FUV;
    }

    public boolean launch(boolean[] FUV) {
        for (boolean value : FUV) {
            if (!value) return false;
        }
        return true;
    }
}