package com.decide.app;

public class LaunchInterceptorConditions {
    int NUMPOINTS;
    Point[] POINTS;
    Parameters PARAMETERS;

    public LaunchInterceptorConditions() {

    }

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
    
    /**
     * Launch Interceptor Condition 0:
     * There exists at least one set of two consecutive data points 
     * that are a distance greater than the length, LENGTH1, apart.
     * @return True if the condition is met, false otherwise.
     */
    public boolean getLaunchInterceptorCondition0() {
        if (PARAMETERS.LENGTH1 < 0) throw new IllegalArgumentException();
        for (int i = 0; i < NUMPOINTS-1; i++) {
            Point p1 = POINTS[i];
            Point p2 = POINTS[i+1];
            if (distance(p1, p2) > PARAMETERS.LENGTH1) return true;
        }
        return false;
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
        if(NUMPOINTS < 5) return false;
        // Check parameters
        if(PARAMETERS.RADIUS1 < 0) throw new IllegalArgumentException();
        if(PARAMETERS.A_PTS < 1 || PARAMETERS.B_PTS < 1 || PARAMETERS.A_PTS + PARAMETERS.B_PTS > NUMPOINTS - 3) throw new IllegalArgumentException();

        double d1;
        double d2;
        double d3;
        Point p1;
        Point p2;
        Point p3;
        int interveningPointsA = PARAMETERS.A_PTS + 1;
        int interveningPointsB = interveningPointsA + PARAMETERS.B_PTS + 1;

        for(int i = 0; i < NUMPOINTS-interveningPointsB; i++){
            p1 = POINTS[i];
            p2 = POINTS[i+interveningPointsA];
            p3 = POINTS[i+interveningPointsB];
            d1 = distance(p1, p2);
            d2 = distance(p1, p3);
            d3 = distance(p2, p3);

            if(d1 > PARAMETERS.RADIUS1*2 || d2 > PARAMETERS.RADIUS1*2 || d3 > PARAMETERS.RADIUS1*2) return true;
        }
        return false;
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
  
  

    /**
     * ========================= [ HELPERS ] =========================
     */

    /**
     * 
     * @param p1 The first point.
     * @param p2 The second point.
     * @return The Euclidean distance between the points.
     */
    public double distance(Point p1, Point p2) {
        if (p1 == null || p2 == null) throw new IllegalArgumentException();
        double dx = Math.abs(p1.getX() - p2.getX());
        double dy = Math.abs(p1.getY() - p2.getY());
        return Math.sqrt(dx*dx + dy*dy);
    }

}
