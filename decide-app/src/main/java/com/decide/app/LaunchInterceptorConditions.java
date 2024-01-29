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

    /**
     * Launch Interceptor Condition 2:
     * There exists at least one set of three consecutive data points
     * which form an angle such that:
     * angle < (PI−EPSILON) or angle > (PI+EPSILON)
     * The second of the three consecutive points is always the vertex of the angle. 
     * If a point coincides with the vertex, the angle is undefined and the LIC is not satisfied.
     * @return True if the condition is met, false otherwise.
     */
    public boolean getLaunchInterceptorCondition2() {
        if (PARAMETERS.EPSILON < 0 || PARAMETERS.EPSILON >= Math.PI) throw new IllegalArgumentException();
        double a;
        Point vertex;
        double x1;
        double x2;
        double y1;
        double y2;
        for(int i = 0; i < NUMPOINTS-2; i++){
            vertex = POINTS[i+1];
            if(POINTS[i].getX() == vertex.getX() && POINTS[i].getY() == vertex.getY()
            || POINTS[i+2].getX() == vertex.getX() && POINTS[i+2].getY() == vertex.getY()) return false;
            x1 = (POINTS[i].getX() - vertex.getX());
            y1 = (POINTS[i].getY() - vertex.getY());
            x2 = (POINTS[i+2].getX() - vertex.getX());
            y2 = (POINTS[i+2].getY() - vertex.getY());
            a = Math.abs(Math.atan2(y2,x2) - Math.atan2(y1, x1));
            if(a < Math.PI - PARAMETERS.EPSILON) return true;
            else if(a > PARAMETERS.EPSILON + Math.PI) return true;
        }
        return false;
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
