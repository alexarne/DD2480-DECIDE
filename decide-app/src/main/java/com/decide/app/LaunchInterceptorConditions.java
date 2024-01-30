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
        if (PARAMETERS.Q_PTS < 2 || PARAMETERS.Q_PTS>NUMPOINTS) throw new IllegalArgumentException("incorrect No. of Points");
        if (PARAMETERS.QUADS < 0 || PARAMETERS.QUADS > 3) throw new IllegalArgumentException("incorrect No. of Quads");

        if(PARAMETERS.QUADS>PARAMETERS.Q_PTS) return false;
        for (int i = 0; i < NUMPOINTS-(PARAMETERS.Q_PTS-1); i++) {
            int Q1=0;
            int Q2=0;
            int Q3=0;
            int Q4=0;
            for (int j = i; j < PARAMETERS.Q_PTS; j++){
                if (whichQuad(POINTS[j])==1) {Q1+=1;}
                else if (whichQuad(POINTS[j])==2) {Q2+=2;}
                else if (whichQuad(POINTS[j])==3) {Q3+=3;}
                else {Q4+=1;}
            }
            
            if (Q1+Q2+Q3+Q4 > PARAMETERS.QUADS && checkQuadrantDistribution(Q1,Q2,Q3,Q4)) return true;
            
        }
        return false;
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
        double dx = Math.abs(p1.x - p2.x);
        double dy = Math.abs(p1.y - p2.y);
        return Math.sqrt(dx*dx + dy*dy);
    }

    public int whichQuad(Point p) {
        if (p.x >=0 && p.y >=0) return 1;
        else if (p.x <0 && p.y >=0) return 2;
        else if (p.x <=0 && p.y <0) return 3;
        else return 4;
    }

    public boolean checkQuadrantDistribution(int Q1,int Q2,int Q3,int Q4){
        if (Q1<=Math.ceil((float)PARAMETERS.Q_PTS/(PARAMETERS.QUADS+1)) && Q2<=Math.ceil((float)PARAMETERS.Q_PTS/(PARAMETERS.QUADS+1))
        && Q3<=Math.ceil((float)PARAMETERS.Q_PTS/(PARAMETERS.QUADS+1)) && Q4<=Math.ceil((float)PARAMETERS.Q_PTS/(PARAMETERS.QUADS+1))) return true;
        return false;
    }
    
}
