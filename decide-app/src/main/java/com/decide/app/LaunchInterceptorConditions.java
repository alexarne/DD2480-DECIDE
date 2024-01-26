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
            getLaunchInterceptorCondition0(),
            getLaunchInterceptorCondition1(),
            getLaunchInterceptorCondition2(),
            getLaunchInterceptorCondition3(),
            getLaunchInterceptorCondition4(),
            getLaunchInterceptorCondition5(),
            getLaunchInterceptorCondition6(),
            getLaunchInterceptorCondition7(),
            getLaunchInterceptorCondition8(),
            getLaunchInterceptorCondition9(),
            getLaunchInterceptorCondition10(),
            getLaunchInterceptorCondition11(),
            getLaunchInterceptorCondition12(),
            getLaunchInterceptorCondition13(),
            getLaunchInterceptorCondition14()
        };
        return CMV;
    }
    
    public boolean getLaunchInterceptorCondition0() {
        return true;
    }

    public boolean getLaunchInterceptorCondition1() {
        return true;
    }

    public boolean getLaunchInterceptorCondition2() {
        return true;
    }

    public boolean getLaunchInterceptorCondition3() {
        return true;
    }

    public boolean getLaunchInterceptorCondition4() {
        return true;
    }

    public boolean getLaunchInterceptorCondition5() {
        return true;
    }

    public boolean getLaunchInterceptorCondition6() {
        return true;
    }

    public boolean getLaunchInterceptorCondition7() {
        return true;
    }

    public boolean getLaunchInterceptorCondition8() {
        return true;
    }

    public boolean getLaunchInterceptorCondition9() {
        return true;
    }

    public boolean getLaunchInterceptorCondition10() {
        return true;
    }

    public boolean getLaunchInterceptorCondition11() {
        return true;
    }

    public boolean getLaunchInterceptorCondition12() {
        return true;
    }

    public boolean getLaunchInterceptorCondition13() {
        return true;
    }

    public boolean getLaunchInterceptorCondition14() {
        return true;
    }
    
}
