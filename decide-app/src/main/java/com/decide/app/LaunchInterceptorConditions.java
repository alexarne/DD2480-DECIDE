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

    /**
     * Launch Interceptor Condition 9:
     * There exists at least one set of three data points separated 
     * by exactly C_PTS and D_PTS consecutive intervening points, 
     * respectively, that form an angle such that:
     * angle < (PI − EPSILON) or angle > (PI + EPSILON)
     * The second point of the set of three points is always the vertex 
     * of the angle. If either the first point or the last point (or both) 
     * coincide with the vertex, the angle is undefined and the LIC is not 
     * satisfied by those three points. When NUMPOINTS < 5, the condition is not met.
     * Constraints: 1 ≤ C_PTS, 1 ≤ D_PTS, C_PTS + D_PTS ≤ NUMPOINTS − 3
     * @return True if the condition is met, false otherwise.
     */
    public boolean getLaunchInterceptorCondition9() {
        if(NUMPOINTS < 5) return false;
        if(PARAMETERS.EPSILON < 0 || PARAMETERS.EPSILON >= Math.PI) throw new IllegalArgumentException();
        if(PARAMETERS.C_PTS < 1 || PARAMETERS.D_PTS < 1 || PARAMETERS.C_PTS + PARAMETERS.D_PTS > NUMPOINTS - 3) throw new IllegalArgumentException();
        
        int interveningPointsC = PARAMETERS.C_PTS + 1;
        int interveningPointsD = interveningPointsC + PARAMETERS.D_PTS + 1;

        for(int i = 0; i < NUMPOINTS-interveningPointsD; i++){
            Point vertex = POINTS[i+interveningPointsC];
            Point p1 = POINTS[i];
            Point p2 = POINTS[i+interveningPointsD];
            double x1 = (p1.getX() - vertex.getX());
            double y1 = (p1.getY() - vertex.getY());
            double x2 = (p2.getX() - vertex.getX());
            double y2 = (p2.getY() - vertex.getY());
            double a = Math.abs(Math.atan2(y2,x2) - Math.atan2(y1, x1));
            if((a < Math.PI - PARAMETERS.EPSILON || a > PARAMETERS.EPSILON + Math.PI)
                && !(p1.getX() == vertex.getX() && p1.getY() == vertex.getY()
                || p2.getX() == vertex.getX() && p2.getY() == vertex.getY())) return true;
        }
        return false;
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
