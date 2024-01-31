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
        for(int i = 0; i < NUMPOINTS-2; i++){
            Point vertex = POINTS[i+1];
            double x1 = (POINTS[i].getX() - vertex.getX());
            double y1 = (POINTS[i].getY() - vertex.getY());
            double x2 = (POINTS[i+2].getX() - vertex.getX());
            double y2 = (POINTS[i+2].getY() - vertex.getY());
            double a = Math.abs(Math.atan2(y2,x2) - Math.atan2(y1, x1));
            if((a < Math.PI - PARAMETERS.EPSILON || a > PARAMETERS.EPSILON + Math.PI)
                && !(POINTS[i].getX() == vertex.getX() && POINTS[i].getY() == vertex.getY()
                || POINTS[i+2].getX() == vertex.getX() && POINTS[i+2].getY() == vertex.getY())) return true;
        }
        return false;
    }

    public boolean getLaunchInterceptorCondition3() {
        if (PARAMETERS.AREA1 < 0) throw new IllegalArgumentException();
        for (int i = 0; i < NUMPOINTS-2; i++) {
            double area = triangleArea(POINTS[i], POINTS[i+1], POINTS[i+2]);
            if (area > PARAMETERS.AREA1) return true;
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
            double Area = triangleArea(p1, p2, p3);
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
     * Find the Euclidean distance between two points.
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

    /**
     * Find the radius of a circle which intersects three points.
     * @param p1 The first point.
     * @param p2 The second point.
     * @param p3 The third point.
     * @return The radius of the circle through points p1, p2 and p3.
     */
    public double findCircleRadius(Point p1, Point p2, Point p3){
        if (p1 == null || p2 == null || p3 == null) throw new IllegalArgumentException();
        double x1 = p1.getX();
        double y1 = p1.getY();
        double x2 = p2.getX();
        double y2 = p2.getY();
        double x3 = p3.getX();
        double y3 = p3.getY();

        //two lines A through p1-p2 and B through p2-p3
        double slopeA = (y2-y1)/(x2-x1);
        double slopeB = (y3-y2)/(x3-x2);

        // slopes parallel
        if(slopeA == slopeB) return Double.NaN;
        
        // if slope is infinite, line is vertical. Change order of points. 
        if(Double.isInfinite(slopeA)){
            double tempx = x3;
            double tempy = y3;
            x3 = x2;
            y3 = y2;
            x2 = tempx;
            y2 = tempy;
            slopeA = (y2-y1)/(x2-x1);
            slopeB = (y3-y2)/(x3-x2);
        }
        if(Double.isInfinite(slopeB)){
            double tempx = x1;
            double tempy = y1;
            x1 = x2;
            y1 = y2;
            x2 = tempx;
            y2 = tempy;
            slopeA = (y2-y1)/(x2-x1);
            slopeB = (y3-y2)/(x3-x2);
        }

        // Intersection of two lines perpendicular to and passing through midpoints of A and B
        // is center of circle.
        double x = ((slopeA*slopeB*(y1-y3)) + slopeB*(x1+x2) - slopeA*(x2+x3))/(2*(slopeB-slopeA));
        double y = (-1/slopeA)*(x-((x1+x2)/2)) + (y1+y2)/2;
        // If slopeA is 0, use slopeB to calculate y. 
        if(slopeA == 0){
            y = (-1/slopeB)*(x-(x2+x3)/2) + (y2+y3)/2;
        }
        return distance(new Point(x, y), p1);
    }
  
    /**
     * Find the area of a triangle formed by three points.
     * Using Heron's formula: 
     * https://www.geeksforgeeks.org/area-of-a-triangle-coordinate-geometry/
     * @param p1 The first corner point.
     * @param p2 The second corner point.
     * @param p3 The third corner point.
     * @return The area of the triangle.
     */
    public double triangleArea(Point p1, Point p2, Point p3) {
        if (p1 == null || p2 == null || p3 == null) 
            throw new IllegalArgumentException();
        double distance1 = distance(p1, p2);
        double distance2 = distance(p2, p3);
        double distance3 = distance(p1, p3);
        double S = (distance1+distance2+distance3)/2;
        double area = Math.sqrt(S*(S-distance1)*(S-distance2)*(S-distance3));
        return area;
    }

}
