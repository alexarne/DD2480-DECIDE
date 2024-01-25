package com.decide.app;

public class LaunchInterceptorConditions {
    int NUMPOINTS;
    Point[] POINTS;
    Parameters PARAMETERS;

    public LaunchInterceptorConditions(int NUMPOINTS, Point[] POINTS, Parameters PARAMETERS) {
        this.NUMPOINTS = NUMPOINTS;
        this.POINTS = POINTS;
        this.PARAMETERS = PARAMETERS;
    }

    public boolean[] getConditionsMetVector() {
        boolean[] CMV = new boolean[]{
            getLaunchInterceptionCondition0(),
            getLaunchInterceptionCondition1(),
            getLaunchInterceptionCondition2(),
            getLaunchInterceptionCondition3(),
            getLaunchInterceptionCondition4(),
            getLaunchInterceptionCondition5(),
            getLaunchInterceptionCondition6(),
            getLaunchInterceptionCondition7(),
            getLaunchInterceptionCondition8(),
            getLaunchInterceptionCondition9(),
            getLaunchInterceptionCondition10(),
            getLaunchInterceptionCondition11(),
            getLaunchInterceptionCondition12(),
            getLaunchInterceptionCondition13(),
            getLaunchInterceptionCondition14()
        };
        return CMV;
    }
    
    public boolean getLaunchInterceptionCondition0() {
        return true;
    }

    public boolean getLaunchInterceptionCondition1() {
        return true;
    }

    public boolean getLaunchInterceptionCondition2() {
        return true;
    }

    public boolean getLaunchInterceptionCondition3() {
        return true;
    }

    public boolean getLaunchInterceptionCondition4() {
        return true;
    }

    public boolean getLaunchInterceptionCondition5() {
        return true;
    }

    public boolean getLaunchInterceptionCondition6() {
        return true;
    }

    public boolean getLaunchInterceptionCondition7() {
        return true;
    }

    public boolean getLaunchInterceptionCondition8() {
        return true;
    }

    public boolean getLaunchInterceptionCondition9() {
        return true;
    }

    public boolean getLaunchInterceptionCondition10() {
        return true;
    }

    public boolean getLaunchInterceptionCondition11() {
        return true;
    }

    public boolean getLaunchInterceptionCondition12() {
        return true;
    }

    public boolean getLaunchInterceptionCondition13() {
        return true;
    }

    public boolean getLaunchInterceptionCondition14() {
        return true;
    }
    
}
