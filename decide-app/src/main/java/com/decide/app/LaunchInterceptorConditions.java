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
            double dx = Math.abs(POINTS[i].x - POINTS[i+1].x);
            double dy = Math.abs(POINTS[i].y - POINTS[i+1].y);
            double distance = Math.sqrt(dx*dx + dy*dy);
            if (distance > PARAMETERS.LENGTH1) return true;
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

    /*
     * There exists at least one set of N PTS consecutive data points such that at least one of the
     * points lies a distance greater than DIST from the line joining the first and last of these N PTS
     * points. If the first and last points of these N PTS are identical, then the calculated distance
     * to compare with DIST will be the distance from the coincident point to all other points of
     * the N PTS consecutive points. The condition is not met when NUMPOINTS < 3.
     * @return True if the condition is met, false otherwise.
     */
    public boolean getLaunchInterceptorCondition6() {
        if (NUMPOINTS<3) return false;
        Point[] p = new Point[PARAMETERS.N_PTS];
        for (int i = 0; i < NUMPOINTS-PARAMETERS.N_PTS+1; i++) {
            for (int j = 0; j < PARAMETERS.N_PTS; j++) {
                p[j] = POINTS[i+j]; 
            }
            Point first = new Point((p[0].x),(p[0].y));
            Point last = new Point((p[PARAMETERS.N_PTS - 1].x),(p[PARAMETERS.N_PTS - 1].y));
            Point line = new Point(last.x-first.x, last.y-first.y);
            for (int j = 1; j < PARAMETERS.N_PTS - 1; j++) {
                double x1 = first.x;
                double x2 = p[j].x;
                double y1 = first.y;
                double y2= p[j].y;
                Point v = new Point(x2 - x1, y2 - y1);
                double skal = (line.x * v.x) + (line.y * v.y);
                double lineNorm = Math.sqrt(line.x*line.x + line.y*line.y);
                double mult = skal / (lineNorm * lineNorm);
                Point proj = new Point(line.x * mult, line.y * mult);
                Point distance = new Point(v.x - proj.x, v.y-proj.y);
                double distanceNorm = Math.sqrt(distance.x*distance.x + distance.y * distance.y);
                if (distanceNorm > PARAMETERS.DIST) return true;
            }
        }
        return false;
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
        double dx = Math.abs(p1.x - p2.x);
        double dy = Math.abs(p1.y - p2.y);
        return Math.sqrt(dx*dx + dy*dy);
    }

}
