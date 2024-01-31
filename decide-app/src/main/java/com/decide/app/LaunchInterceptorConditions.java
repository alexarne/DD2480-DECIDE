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

    /**
     * Conditions Met Vector:
     * The Conditions Met Vector (CMV) should be set according to the 
     * results of each Launch Interceptor Condition. CMV[i] should be 
     * set to true if and only if the i:th LIC is met.
     * @return Boolean array where the i:th element gives the value
     * for the i:th Launch Interceptor Condition.
     */
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
        if (PARAMETERS.AREA1 < 0) throw new IllegalArgumentException();
        for (int i = 0; i < NUMPOINTS-2; i++) {
            double distance1 = distance(POINTS[i], POINTS[i+1]);
            double distance2 = distance(POINTS[i+1], POINTS[i+2]);
            double distance3 = distance(POINTS[i], POINTS[i+2]);
            double S = (distance1+distance2+distance3)/2;
            double Area = Math.sqrt(S*(S-distance1)*(S-distance2)*(S-distance3));
            if (Area > PARAMETERS.AREA1) return true;
        }
        return false;
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

/**
     * Launch Interceptor Condition 7:
     * There exists at least one set of two data points separated
     * by exactly K PTS consecutive intervening points that are a
     * distance greater than the length, LENGTH1, apart. The condition
     * is not met when NUMPOINTS < 3.
     * Constraint: 1 ≤ K PTS ≤ (NUMPOINTS − 2)
     * @return True if the condition is met, false otherwise.
     */
    public boolean getLaunchInterceptorCondition7() {
        if(NUMPOINTS < 3) {
            return false;
        }
        if (PARAMETERS.LENGTH1 < 0) throw new IllegalArgumentException("LENGTH1 is strictly negative");
        if (PARAMETERS.K_PTS < 1 || PARAMETERS.K_PTS > NUMPOINTS - 2) {
            throw new IllegalArgumentException("K_PTS is either negative, null or strictly superior to NUMPOINTS - 2");
        }

        // implementation
        for(int i = 0; i < NUMPOINTS - PARAMETERS.K_PTS - 1; i++) {
            Point p1 = POINTS[i];
            Point p2 = POINTS[i+PARAMETERS.K_PTS+1];
            if (distance(p1, p2) > PARAMETERS.LENGTH1) return true;
        }

        return false;
    }

    public boolean getLaunchInterceptorCondition8() {
        return true;
    }

    public boolean getLaunchInterceptorCondition9() {
        return true;
    }

    /**
     * Launch Interceptor Condition 10:
     * There exists at least one set of three data points separated
     * by exactly E_PTS and F_PTS consecutive intervening points,
     * respectively, that are the vertices of a triangle with area
     * greater than AREA1. The condition is not met when NUMPOINTS < 5.
     * Constraints:
     * 1 ≤ E_PTS, 1 ≤ F_PTS
     * E_PTS + F_PTS ≤ NUMPOINTS − 3
     * @return True if the condition is met, false otherwise.
     */
    public boolean getLaunchInterceptorCondition10() {
        if (NUMPOINTS < 5) {
            return false;
        }
        if (PARAMETERS.AREA1 < 0) throw new IllegalArgumentException("AREA is strictly negative");
        if (PARAMETERS.E_PTS < 1 || PARAMETERS.F_PTS < 1) {
            throw new IllegalArgumentException("E_PTS or F_PTS is negative or null");
        }
        if (PARAMETERS.E_PTS + PARAMETERS.F_PTS > NUMPOINTS - 3) {
            throw new IllegalArgumentException("The sum of E_PTS and F_PTS is stricyl superior to NUMPOINTS - 3");
        }

        // implementation
        for(int i = 0; i < NUMPOINTS - PARAMETERS.E_PTS - PARAMETERS.F_PTS - 2; i++) {
            Point p1 = POINTS[i];
            Point p2 = POINTS[i+PARAMETERS.E_PTS+1];
            Point p3 = POINTS[i+PARAMETERS.E_PTS+1+PARAMETERS.F_PTS+1];
            double distance1 = distance(p1, p2);
            double distance2 = distance(p2, p3);
            double distance3 = distance(p1, p3);
            double S = (distance1+distance2+distance3)/2;
            double Area = Math.sqrt(S*(S-distance1)*(S-distance2)*(S-distance3));
            if (Area > PARAMETERS.AREA1) return true;
        }

        return false;
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
