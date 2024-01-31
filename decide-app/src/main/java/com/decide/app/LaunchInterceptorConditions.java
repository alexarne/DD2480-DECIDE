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

        /**
     * 
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

        // Points are on a vertical or horizontal line. Cannot form a circle
        if((x1 == x2 && x2 == x3) || (y1 == y2 && y2 == y3)){
            return Double.NaN;
        }
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

}
