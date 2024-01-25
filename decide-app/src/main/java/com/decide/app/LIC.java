package com.decide.app;

public class LIC {
    int NUMPOINTS;
    Point[] POINTS;
    Parameters PARAMETERS;

    public LIC(int NUMPOINTS, Point[] POINTS, Parameters PARAMETERS) {
        this.NUMPOINTS = NUMPOINTS;
        this.POINTS = POINTS;
        this.PARAMETERS = PARAMETERS;
    }

    public boolean[] getCMV() {
        boolean[] CMV = new boolean[]{
            LIC0(),
            LIC1(),
            LIC2(),
            LIC3(),
            LIC4(),
            LIC5(),
            LIC6(),
            LIC7(),
            LIC8(),
            LIC9(),
            LIC10(),
            LIC11(),
            LIC12(),
            LIC13(),
            LIC14()
        };
        return CMV;
    }

    public boolean LIC0() {
        return true;
    }

    public boolean LIC1() {
        return true;
    }

    public boolean LIC2() {
        return true;
    }

    public boolean LIC3() {
        return true;
    }

    public boolean LIC4() {
        return true;
    }

    public boolean LIC5() {
        return true;
    }

    public boolean LIC6() {
        return true;
    }

    public boolean LIC7() {
        return true;
    }

    public boolean LIC8() {
        return true;
    }

    public boolean LIC9() {
        return true;
    }

    public boolean LIC10() {
        return true;
    }

    public boolean LIC11() {
        return true;
    }

    public boolean LIC12() {
        return true;
    }

    public boolean LIC13() {
        return true;
    }

    public boolean LIC14() {
        return true;
    }

}
