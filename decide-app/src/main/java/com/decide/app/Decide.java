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
        boolean[][] PUM = computePUM(CMV);
        boolean[] FUV = computeFUV(PUM);
        for (boolean value : FUV) {
            if (!value) return false;
        }
        return true;
    }

    public boolean[][] computePUM(boolean[] CMV) {
        boolean[][] PUM = new boolean[][]{{ true }};
        return PUM;
    }

    public boolean[] computeFUV(boolean[][] PUM) {
        boolean[] FUV = new boolean[]{ true };
        return FUV;
    }
}