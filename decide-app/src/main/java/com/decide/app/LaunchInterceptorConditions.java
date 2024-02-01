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

    /**
     * Launch Interceptor Condition 1:
     * There exists at least one set of three consecutive data points that cannot all be contained
     * within or on a circle of radius RADIUS1.
     * @return True if the condition is met, false otherwise.
     */
    public boolean getLaunchInterceptorCondition1() {
        if (PARAMETERS.RADIUS1 < 0) throw new IllegalArgumentException();
        if (NUMPOINTS != POINTS.length) return false;
        for (int i = 0; i < NUMPOINTS-2; i++) {
            Point p1 = POINTS[i];
            Point p2 = POINTS[i+1];
            Point p3 = POINTS[i+2];
            if (!containedInCircle(p1, p2, p3, PARAMETERS.RADIUS1))
                return true;
        }
        return false;
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
            Point p1 = POINTS[i];
            Point vertex = POINTS[i+1];
            Point p3 = POINTS[i+2];
            if (p1.getX() == vertex.getX() && p1.getY() == vertex.getY()) continue;
            if (p3.getX() == vertex.getX() && p3.getY() == vertex.getY()) continue;
            double a = angle(p1, vertex, p3);
            if(a < Math.PI - PARAMETERS.EPSILON || a > PARAMETERS.EPSILON + Math.PI) return true;
        }
        return false;
    }

    /**
     * Launch Interceptor Condition 3:
     * There exists at least one set of three consecutive data points 
     * that are the vertices of a triangle with area greater than AREA1.
     * @return True if the condition is met, false otherwise.
     */
    public boolean getLaunchInterceptorCondition3() {
        if (PARAMETERS.AREA1 < 0) throw new IllegalArgumentException();
        for (int i = 0; i < NUMPOINTS-2; i++) {
            double area = triangleArea(POINTS[i], POINTS[i+1], POINTS[i+2]);
            if (area > PARAMETERS.AREA1) return true;
        }
        return false;
    }

    /**
     * Launch Interceptor Condition 4:
     * There exists at least one set of Q_PTS consecutive data points that 
     * lie in more than QUADS quadrants. Where there is ambiguity as to 
     * which quadrant contains a given point, priority of decision will be 
     * by quadrant number, i.e., I, II, III, IV. For example, the data 
     * point (0,0) is in quadrant I, the point (-l,0) is in quadrant II, 
     * the point (0,-l) is in quadrant III, the point (0,1) is in 
     * quadrant I and the point (1,0) is in quadrant I.
     * @return True if the condition is met, false otherwise.
     */
    public boolean getLaunchInterceptorCondition4() {
        if (PARAMETERS.Q_PTS < 2 || PARAMETERS.Q_PTS>NUMPOINTS) throw new IllegalArgumentException("incorrect No. of Points");
        if (PARAMETERS.QUADS < 1 || PARAMETERS.QUADS > 3) throw new IllegalArgumentException("incorrect No. of Quads");

        if(PARAMETERS.QUADS>=PARAMETERS.Q_PTS) return false;
        for (int i = 0; i < NUMPOINTS-(PARAMETERS.Q_PTS-1); i++) {
            int Q1=0;
            int Q2=0;
            int Q3=0;
            int Q4=0;
            int countQuads = 0;
            for (int j = i; j < i+PARAMETERS.Q_PTS; j++){
                if (whichQuad(POINTS[j])==1) {
                    Q1+=1;
                    if (Q1==1) countQuads+=1;
                }
                else if (whichQuad(POINTS[j])==2) {
                    Q2+=1;
                    if (Q2==1) countQuads+=1;
                }
                else if (whichQuad(POINTS[j])==3) {
                    Q3+=1;
                    if (Q3==1) countQuads+=1;
                }
                else {
                    Q4+=1;
                    if (Q4==1) countQuads+=1;
                }
            }
            
            if (countQuads>PARAMETERS.QUADS) return true;
            
        }
        return false;
    }

    /**
     * Launch Interceptor Condition 5:
     * There exists at least one set of two consecutive data points, 
     * (X[i],Y[i]) and (X[j],Y[j]), such that X[j] - X[i] < 0. (where i = j-1)
     * @return True if the condition is met, false otherwise.
     */
    public boolean getLaunchInterceptorCondition5() {
        for (int i = 0; i < NUMPOINTS-1; i++) {
            Point p1 = POINTS[i];
            Point p2 = POINTS[i+1];
            if ((p2.getX()-p1.getX())<0) return true;
        }
        return false;
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
        if (PARAMETERS.N_PTS > NUMPOINTS || PARAMETERS.N_PTS < 3 || PARAMETERS.DIST < 0) throw new IllegalArgumentException();
        for (int i = 0; i < NUMPOINTS-PARAMETERS.N_PTS+1; i++) {
            for (int j = 0; j < PARAMETERS.N_PTS; j++) {
                p[j] = POINTS[i+j]; 
            }

            Point first = new Point((p[0].getX()),(p[0].getY()));
            double x1 = first.getX();
            double y1 = first.getY();
            Point last = new Point((p[PARAMETERS.N_PTS - 1].getX()),(p[PARAMETERS.N_PTS - 1].getY()));
            double xLast = last.getX();
            double yLast = last.getY();
            if (x1 == xLast && y1 == yLast){
                for (int j = 1; j < PARAMETERS.N_PTS - 1; j++) {
                    double x2 = p[j].getX();
                    double y2= p[j].getY();
                    Point v = new Point(x2 - x1, y2 - y1);
                    double vNorm = Math.sqrt(v.getX()*v.getX() + v.getY() * v.getY());
                    if (vNorm > PARAMETERS.DIST) return true;
                }
            }
            else {
                Point line = new Point(last.getX()-x1, last.getY()-y1);
                double xLine = line.getX();
                double yLine = line.getY();
                for (int j = 1; j < PARAMETERS.N_PTS - 1; j++) {
                    double x2 = p[j].getX();
                    double y2= p[j].getY();
                    Point v = new Point(x2 - x1, y2 - y1);
                    double skal = (xLine * v.getX()) + (yLine * v.getY());
                    double lineNorm = Math.sqrt(xLine*xLine + yLine*yLine);
                    double mult = skal / (lineNorm * lineNorm);
                    Point proj = new Point(xLine * mult, yLine * mult);
                    Point distance = new Point(v.getX() - proj.getX(), v.getY()-proj.getY());
                    double distanceNorm = Math.sqrt(distance.getX()*distance.getX() + distance.getY() * distance.getY());
                    if (distanceNorm > PARAMETERS.DIST) return true;
                }
            }
        }
        return false;
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

    /**
     * Launch Interceptor Condition 8:
     * There exists at least one set of three data points separated 
     * by exactly A_PTS and B_PTS consecutive intervening points, 
     * respectively, that cannot be contained within or on a circle 
     * of radius RADIUS1. The condition is not met when NUMPOINTS < 5.
     * @return True if the condition is met, false otherwise.
     */
    public boolean getLaunchInterceptorCondition8() {
        if(NUMPOINTS < 5) return false;
        // Check parameters
        if(PARAMETERS.RADIUS1 < 0) throw new IllegalArgumentException();
        if(PARAMETERS.A_PTS < 1 || PARAMETERS.B_PTS < 1 || PARAMETERS.A_PTS + PARAMETERS.B_PTS > NUMPOINTS - 3) throw new IllegalArgumentException();

        int interveningPointsA = PARAMETERS.A_PTS + 1;
        int interveningPointsB = interveningPointsA + PARAMETERS.B_PTS + 1;

        for(int i = 0; i < NUMPOINTS-interveningPointsB; i++){
            Point p1 = POINTS[i];
            Point p2 = POINTS[i+interveningPointsA];
            Point p3 = POINTS[i+interveningPointsB];
            if (!containedInCircle(p1, p2, p3, PARAMETERS.RADIUS1))
                return true;
        }
        return false;
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
            Point p1 = POINTS[i];
            Point vertex = POINTS[i+interveningPointsC];
            Point p2 = POINTS[i+interveningPointsD];
            if (p1.getX() == vertex.getX() && p1.getY() == vertex.getY()) continue;
            if (p2.getX() == vertex.getX() && p2.getY() == vertex.getY()) continue;
            double a = angle(p1, vertex, p2);
            if (a < Math.PI - PARAMETERS.EPSILON || a > PARAMETERS.EPSILON + Math.PI) 
                return true;
        }
        return false;
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

    /**
     * Launch Interceptor Condition 11:
     * There exists at least one set of two data points, (X[i],Y[i]) 
     * and (X[j],Y[j]), separated by exactly G_PTS consecutive 
     * intervening points, such that X[j] - X[i] < 0. (where i < j) 
     * The condition is not met when NUMPOINTS < 3.
     * @return True if the condition is met, false otherwise.
     */
    public boolean getLaunchInterceptorCondition11() {
        if (NUMPOINTS < 3) return false;
        if (PARAMETERS.G_PTS < 1 || PARAMETERS.G_PTS > NUMPOINTS-2) 
            throw new IllegalArgumentException();
        for (int i = 0; i < NUMPOINTS-PARAMETERS.G_PTS-1; ++i) {
            Point pi = POINTS[i];
            Point pj = POINTS[i + PARAMETERS.G_PTS + 1];
            if (pj.getX() - pi.getX() < 0) return true;
        }
        return false;
    }

    /**
     * Launch Interceptor Condition 12:
     * There exists at least one set of two data points, separated by 
     * exactly K_PTS consecutive intervening points, which are a distance 
     * greater than the length, LENGTH1, apart. In addition, there exists 
     * at least one set of two data points (which can be the same or 
     * different from the two data points just mentioned), separated 
     * by exactly K_PTS consecutive intervening points, that are a distance 
     * less than the length, LENGTH2, apart. Both parts must be true for 
     * the LIC to be true
     * @return True if the condition is met, false otherwise.
     */
    public boolean getLaunchInterceptorCondition12() {
        if (PARAMETERS.LENGTH1 < 0) throw new IllegalArgumentException();
        if (PARAMETERS.LENGTH2 < 0) throw new IllegalArgumentException();
        if (NUMPOINTS < 3) return false;
        if (PARAMETERS.K_PTS < 1 || PARAMETERS.K_PTS > NUMPOINTS-2)
            throw new IllegalArgumentException();
        boolean L1_condition = false;
        boolean L2_condition = false;
        for (int i = 0; i < NUMPOINTS-PARAMETERS.K_PTS-1; ++i) {
            Point p1 = POINTS[i];
            Point p2 = POINTS[i + PARAMETERS.K_PTS + 1];
            if (distance(p1, p2) > PARAMETERS.LENGTH1) L1_condition = true;
            if (distance(p1, p2) < PARAMETERS.LENGTH2) L2_condition = true;
        }
        return L1_condition && L2_condition;
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

    public int whichQuad(Point p) {
        if (p.getX() >=0 && p.getY() >=0) return 1;
        else if (p.getX() <0 && p.getY() >=0) return 2;
        else if (p.getX() <=0 && p.getY() <0) return 3;
        else return 4;
    }
    /**
     * Tell whether or not three points can be contained on or inside a
     * circle with specified radius.
     * @param p1 The first point.
     * @param p2 The second point.
     * @param p3 The third point.
     * @param r The radius of the circle.
     * @return True if all points can be contained on or inside the circle.
     */
    public boolean containedInCircle(Point p1, Point p2, Point p3, double R) {
        if (p1 == null || p2 == null || p3 == null) throw new IllegalArgumentException();
        if (Double.isNaN(R) || R < 0) throw new IllegalArgumentException();
        double d1 = distance(p1, p2);
        double d2 = distance(p1, p3);
        double d3 = distance(p2, p3);
        if (d1 > 2*R || d2 > 2*R || d3 > 2*R) return false;

        // Midpoints (Act as centers)
        Point m12 = new Point(p1.getX()/2 + p2.getX()/2, p1.getY()/2 + p2.getY());
        Point m23 = new Point(p2.getX()/2 + p3.getX()/2, p2.getY()/2 + p3.getY());
        Point m13 = new Point(p1.getX()/2 + p3.getX()/2, p1.getY()/2 + p3.getY());
        if (distance(m12, p3) <= R) return true;
        if (distance(m23, p1) <= R) return true;
        if (distance(m13, p2) <= R) return true;

        double circleRadius = findCircleRadius(p1, p2, p3);
        if (Double.isNaN(circleRadius)) return false;
        if (circleRadius > R) return false;
        return true;
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

    /**
     * Find the angle formed by 3 points, at point 2.
     * @param p1 The first point.
     * @param p2 The second point.
     * @param p3 The third point.
     * @return The angle formed by 3 points, at point 2.
     */
    public double angle(Point p1, Point p2, Point p3) {
        if (p1 == null || p2 == null || p3 == null || (p2.getX() == p1.getX()) && (p2.getY() == p1.getY()) ||  (p2.getX() == p3.getX()) && (p2.getY() == p3.getY()))  throw new IllegalArgumentException();
        if (p1.getX() == p3.getX() && p1.getY() == p3.getY()) return 0;
        double[] v1 = {p1.getX()-p2.getX(), p1.getY()-p2.getY()};
        double[] v2 = {p3.getX()-p2.getX(), p3.getY()-p2.getY()};
        double scal = v1[0]*v2[0] + v1[1] * v2[1];
        double norm1 = Math.sqrt(v1[0]*v1[0]+v1[1]*v1[1]);
        double norm2 = Math.sqrt(v2[0]*v2[0]+v2[1]*v2[1]);
        double ang = Math.acos(scal / (norm1 * norm2));
        return ang;
    }

}
