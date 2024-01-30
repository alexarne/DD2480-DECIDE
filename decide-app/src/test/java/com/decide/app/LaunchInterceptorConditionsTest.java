package com.decide.app;

import static org.junit.Assert.assertTrue;

import org.junit.Before;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class LaunchInterceptorConditionsTest {
    Parameters PARAMETERS;

    @Before
    public void setUp() {
        PARAMETERS = new Parameters();
    }

    /**
     * =========================== [ CMV ] ===========================
     */

    /**
     * Ensure the value of the i:th element in the Conditions Met Vector
     * is the same as the i:th Launch Interceptor Condition.
     */
    @Test
    public void ConditionsMetVectorSameAsEachLIC() {
        Parameters PARAMETERS = new Parameters();
        Point[] POINTS = new Point[]{
            new Point(1, 2), 
            new Point(2, 2), 
            new Point(21, 1), 
            new Point(14, 5)
        };
        int NUMPOINTS = POINTS.length;
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        boolean[] CMV = LIC.getConditionsMetVector();
        assertTrue(CMV[0] == LIC.getLaunchInterceptorCondition0());
        assertTrue(CMV[1] == LIC.getLaunchInterceptorCondition1());
        assertTrue(CMV[2] == LIC.getLaunchInterceptorCondition2());
        assertTrue(CMV[3] == LIC.getLaunchInterceptorCondition3());
        assertTrue(CMV[4] == LIC.getLaunchInterceptorCondition4());
        assertTrue(CMV[5] == LIC.getLaunchInterceptorCondition5());
        assertTrue(CMV[6] == LIC.getLaunchInterceptorCondition6());
        assertTrue(CMV[7] == LIC.getLaunchInterceptorCondition7());
        assertTrue(CMV[8] == LIC.getLaunchInterceptorCondition8());
        assertTrue(CMV[9] == LIC.getLaunchInterceptorCondition9());
        assertTrue(CMV[10] == LIC.getLaunchInterceptorCondition10());
        assertTrue(CMV[11] == LIC.getLaunchInterceptorCondition11());
        assertTrue(CMV[12] == LIC.getLaunchInterceptorCondition12());
        assertTrue(CMV[13] == LIC.getLaunchInterceptorCondition13());
        assertTrue(CMV[14] == LIC.getLaunchInterceptorCondition14());
    }

    /**
     * ========================== [ LIC 0 ] ==========================
     */

    /**
     * Positive test case, ensure LIC0 is satisfied when two consecutive
     * points are more than LENGTH1 apart.
     */
    @Test
    public void LIC0TrueOnDistanceGreaterThanLENGTH1() {
        PARAMETERS.LENGTH1 = 4;
        Point[] POINTS = new Point[]{
            new Point(1, 2), 
            new Point(1, 2+PARAMETERS.LENGTH1+1)
        };
        int NUMPOINTS = POINTS.length;
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertTrue(LIC.getLaunchInterceptorCondition0());
    }

    /**
     * Negative test case, ensure LIC0 is not satisfied when no two 
     * consecutive points are more than LENGTH1 apart.
     */
    @Test
    public void LIC0FalseOnDistanceSmallerThanLENGTH1() {
        PARAMETERS.LENGTH1 = 4;
        Point[] POINTS = new Point[]{ 
            new Point(1, 2), 
            new Point(1, 2+PARAMETERS.LENGTH1-1)
        };
        int NUMPOINTS = POINTS.length;
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertFalse(LIC.getLaunchInterceptorCondition0());
    }

    /**
     * Edge-case test case, ensure LIC0 is not satisfied when points
     * are exactly LENGTH1 apart.
     */
    @Test
    public void LIC0FalseOnDistanceEqualToLENGTH1() {
        PARAMETERS.LENGTH1 = 2;
        Point[] POINTS = new Point[]{
            new Point(1, 2), 
            new Point(1, 2+PARAMETERS.LENGTH1)
        };
        int NUMPOINTS = POINTS.length;
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertFalse(LIC.getLaunchInterceptorCondition0());
    }

    /**
     * Edge-case test case, ensure LIC0 is not satisfied when there
     * is only one point.
     */
    @Test
    public void LIC0FalseOnOnlyOnePoint() {
        PARAMETERS.LENGTH1 = 2;
        Point[] POINTS = new Point[]{
            new Point(1, 2)
        };
        int NUMPOINTS = POINTS.length;
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertFalse(LIC.getLaunchInterceptorCondition0());
    }

    /**
     * Invalid input test case, ensure LIC0 throws IllegalArgumentException
     * if the supplied parameter LENGTH1 is less than 0.
     */
    @Test
    public void LIC0ThrowsIllegalArgumentExceptionOnInvalidParameter() {
        PARAMETERS.LENGTH1 = -1;
        Point[] POINTS = new Point[]{
            new Point(1, 2),
            new Point(2, 2),
            new Point(2, 3)
        };
        int NUMPOINTS = POINTS.length;
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertThrows(
            IllegalArgumentException.class, 
            () -> { LIC.getLaunchInterceptorCondition0(); }
        );
    }

    /**
     * ========================== [ LIC 1 ] ==========================
     */

    

    /**
     * ========================== [ LIC 2 ] ==========================
     */

    

    /**
     * ========================== [ LIC 3 ] ==========================
     */

    

    /**
     * ========================== [ LIC 4 ] ==========================
     */

    

    /**
     * ========================== [ LIC 5 ] ==========================
     */

    

    /**
     * ========================== [ LIC 6 ] ==========================
     */

    

    /**
     * ========================== [ LIC 7 ] ==========================
     */

    /**
     * Positive test case, ensure LIC7 is satisfied when two points seperated by
     * exactly K_PTS consecutive points are striclty more than LENGTH1 apart.
     */
    @Test
    public void LIC7TrueOnPointsSeparatedByKptsPointsMoreThanLength1Apart() {
        PARAMETERS.K_PTS = 2;
        PARAMETERS.LENGTH1 = 3;
        Point[] POINTS = new Point[]{
            new Point(4, 2),
            new Point(1, 2),
            new Point(2, 5),
            new Point(10, 7),
            new Point(1, 10)
        };
        int NUMPOINTS = POINTS.length;

        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);

        assertTrue(LIC.getLaunchInterceptorCondition7());
    }

    /**
     * Negative test case, ensure LIC7 is not satisfied when all seta of two
     * points seperated by exactly K_PTS consecutive points are no more than
     * LENGTH1 apart.
     */
    @Test
    public void LIC7FalseOnPointsSeparatedByKptsPointsLessThanLength1Apart() {
        PARAMETERS.K_PTS = 1;
        PARAMETERS.LENGTH1 = 20;
        Point[] POINTS = new Point[]{
            new Point(4, 2),
            new Point(1, 2),
            new Point(2, 5),
            new Point(10, 7),
            new Point(1, 10)
        };
        int NUMPOINTS = POINTS.length;

        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        
        assertFalse(LIC.getLaunchInterceptorCondition7());
    }

    /**
     * Edge-case test case, ensure LIC7 is not satisfied when there exists two points
     * separated by exactly K_PTS consecutive points that are exactly at a distance
     * of LENGTH1 of each other
     */
    @Test
    public void LIC7FalseOnPointsSeparatedByKptsPointsExactlyLength1Apart() {
        PARAMETERS.K_PTS = 1;
        PARAMETERS.LENGTH1 = 5;
        Point[] POINTS = new Point[]{
            new Point(0, 0),
            new Point(1, 2),
            new Point(0, 5),
        };
        int NUMPOINTS = POINTS.length;

        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        
        assertFalse(LIC.getLaunchInterceptorCondition7());
    }

    /**
     * Unsufficient input test case for LIC7, must return false when there are two or less
     * points
     */
    @Test
    public void LIC7UnsufficientInputNotEnoughPoints() {
        Point[] POINTS = new Point[]{
            new Point(0, 0),
            new Point(1, 2)
        };
        int NUMPOINTS = POINTS.length;

        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        
        assertFalse(LIC.getLaunchInterceptorCondition7());
    }

    /**
     * Illegal argument value test case for LIC7, ensures an exception is raised if the
     * value of LENGTH1 is strictly negative.
     */
    @Test
    public void LIC7InvalidArgumentStrictlyNegativeLength() {
        PARAMETERS.LENGTH1 = -5;
        Point[] POINTS = new Point[]{
            new Point(0, 0),
            new Point(1, 2),
            new Point(0, 5),
        };
        int NUMPOINTS = POINTS.length;


        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        
        assertThrows(
            IllegalArgumentException.class, 
            () -> { LIC.getLaunchInterceptorCondition7(); }
        );
    }


    /**
     * Illegal argument value test case for LIC7, ensures an exception is raised if the
     * value of K_PTS is negative or null.
     */
    @Test
    public void LIC7InvalidArgumentKptsMegativeOrNull() {
        PARAMETERS.K_PTS = 0;
        PARAMETERS.LENGTH1 = 5;
        Point[] POINTS = new Point[]{
            new Point(0, 0),
            new Point(1, 2),
            new Point(0, 5),
        };
        int NUMPOINTS = POINTS.length;


        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        
        assertThrows(
            IllegalArgumentException.class, 
            () -> { LIC.getLaunchInterceptorCondition7(); }
        );
    }

    /**
     * Illegal argument value test case for LIC7, ensures an exception is raised if the
     * value of K_PTS is stricyl superior to NUMPOINTS-2.
     */
    @Test
    public void LIC7InvalidArgumentKptsStrictlySuperiorToNumpointsMinusTwo() {
        PARAMETERS.LENGTH1 = 5;
        Point[] POINTS = new Point[]{
            new Point(0, 0),
            new Point(1, 2),
            new Point(0, 5),
        };
        int NUMPOINTS = POINTS.length;
        PARAMETERS.K_PTS = NUMPOINTS;


        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        
        assertThrows(
            IllegalArgumentException.class, 
            () -> { LIC.getLaunchInterceptorCondition7(); }
        );
    }

    /**
     * ========================== [ LIC 8 ] ==========================
     */

    

    /**
     * ========================== [ LIC 9 ] ==========================
     */

    

    /**
     * ========================= [ LIC 10 ] ==========================
     */

    

    /**
     * ========================= [ LIC 11 ] ==========================
     */

    

    /**
     * ========================= [ LIC 12 ] ==========================
     */

    /**
     * Positive test case, ensure LIC12 is satisfied when two points separated
     * by K_PTS intervening points are farther than LENGTH1 apart, and a set 
     * of points with K_PTS intervening points are closer than LENGTH2 apart. 
     */
    @Test
    public void LIC12TrueWhenSatisfied() {
        PARAMETERS.K_PTS = 2;
        PARAMETERS.LENGTH1 = 5;
        PARAMETERS.LENGTH2 = 7;
        Point[] POINTS = new Point[]{
            new Point(2,0),
            new Point(1,3),
            new Point(2,0),
            new Point(2,0),
            new Point(6,7)
        };
        int NUMPOINTS = POINTS.length;
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertTrue(LIC.getLaunchInterceptorCondition12());
    }

    /**
     * Negative test case, ensure LIC12 is not satisfied when the sets of points
     * are exactly on the boundary of LENGTH1 and LENGTH2 apart. 
     */
    @Test
    public void LIC12FalseOnBoundaryDistances() {
        PARAMETERS.K_PTS = 1;
        PARAMETERS.LENGTH1 = 5;
        PARAMETERS.LENGTH2 = 5;
        Point[] POINTS = new Point[]{
            new Point(0,0),
            new Point(1,3),
            new Point(0,5),
        };
        int NUMPOINTS = POINTS.length;
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertFalse(LIC.getLaunchInterceptorCondition12());
    }

    /**
     * Negative test case, ensure LIC12 returns false if there are
     * only 2 points.
     */
    @Test
    public void LIC12FalseWhenTwoPoints() {
        PARAMETERS.K_PTS = 1;
        PARAMETERS.LENGTH1 = 5;
        PARAMETERS.LENGTH2 = 5000;
        Point[] POINTS = new Point[]{
            new Point(0,3),
            new Point(1,70)
        };
        int NUMPOINTS = POINTS.length;
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertFalse(LIC.getLaunchInterceptorCondition12());
    }

    /**
     * Invalid input test case, ensure LIC3 throws IllegalArgumentException
     * if the supplied parameter AREA1 is less than 0.
     */
    @Test
    public void LIC12ThrowsIllegalArgumentExceptionOnInvalidInput() {
        PARAMETERS.LENGTH1 = -1;
        PARAMETERS.LENGTH2 = -1;
        PARAMETERS.K_PTS = 0;
        Point[] POINTS = new Point[]{
            new Point(0, 0),
            new Point(1, 0),
            new Point(0, 1)
        };
        int NUMPOINTS = POINTS.length;
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertThrows(
            IllegalArgumentException.class, 
            () -> { LIC.getLaunchInterceptorCondition12(); }
        );
    }

    /**
     * ========================= [ LIC 13 ] ==========================
     */

    

    /**
     * ========================= [ LIC 14 ] ==========================
     */
  

    /**
     * ========================== [ LIC 3 ] ==========================
     */

    /**
     * Positive test case, ensure LIC3 is satisfied when three consecutive
     * points are the vertices of a triangle with area greater than AREA1.
     */
    @Test
    public void LIC3TrueOnAreaGreaterThanAREA1() {
        Parameters PARAMETERS = new Parameters();
        PARAMETERS.AREA1 = 1.9;
        Point[] POINTS = new Point[]{
            new Point(0,0),
            new Point(2,0),
            new Point(0,2)
        };
        int NUMPOINTS = POINTS.length;
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertTrue(LIC.getLaunchInterceptorCondition3());
    }

    /**
     * Negative test case, ensure LIC3 is not satisfied when three consecutive
     * points are the vertices of a triangle with area lower than AREA1
     */
     @Test
     public void LIC3FalseOnAreaLowerThanAREA1() {
         Parameters PARAMETERS = new Parameters();
         PARAMETERS.AREA1 = 2.1;
         Point[] POINTS = new Point[]{
             new Point(0,0),
             new Point(2,0),
             new Point(0,2)
         };
         int NUMPOINTS = POINTS.length;
         LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
         assertFalse(LIC.getLaunchInterceptorCondition3());
     }

    /**
     * Invalid input test case, ensure LIC3 throws IllegalArgumentException
     * if the supplied parameter AREA1 is less than 0.
     */
    @Test
    public void LIC3ThrowsIllegalArgumentExceptionOnInvalidAREA1() {
        Parameters PARAMETERS = new Parameters();
        PARAMETERS.AREA1 = -1;
        Point[] POINTS = new Point[]{
            new Point(0, 0),
            new Point(1, 0),
            new Point(0, 1)
        };
        int NUMPOINTS = POINTS.length;
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertThrows(
            IllegalArgumentException.class, 
            () -> { LIC.getLaunchInterceptorCondition3(); }
        );
    }

    /** 
     * Edge-case test case, ensure LIC3 is not satisfied when three consecutive
     * points are the vertices of a triangle with area EQUAL than AREA1
     */
     @Test
     public void LIC3FalseOnAreaEqualsAREA1() {
         Parameters PARAMETERS = new Parameters();
         PARAMETERS.AREA1 = 2;
         Point[] POINTS = new Point[]{
             new Point(0,0),
             new Point(2,0),
             new Point(0,2)
         };
         int NUMPOINTS = POINTS.length;
         LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
         assertFalse(LIC.getLaunchInterceptorCondition3());
     }

    /** 
     * Edge-case test case, ensure LIC3 is not satisfied when receives
     * less than three points 
     */
     @Test
     public void LIC3FalseForLessThanThreePoints() {
         Parameters PARAMETERS = new Parameters();
         PARAMETERS.AREA1 = 0;
         Point[] POINTS = new Point[]{
             new Point(0,0),
             new Point(2,0)
         };
         int NUMPOINTS = POINTS.length;
         LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
         assertFalse(LIC.getLaunchInterceptorCondition3());
     }
    

    /**
     * ========================= [ HELPERS ] =========================
     */

    /**
     * Positive test case, ensure the distance between two points is correct.
     */
    @Test
    public void distanceCorrect() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 3);
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions();
        assertEquals(1, LIC.distance(p1, p2), 0.00001);
    }

    /**
     * Negative test case, ensure the distance between two points is not incorrect.
     */
    @Test
    public void distanceIncorrect() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 0);
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions();
        assertNotEquals(1, LIC.distance(p1, p2), 0.00001);
    }

    /**
     * Positive test case, ensure the distance between two diagonal points is correct.
     */
    @Test
    public void diagonalDistanceCorrect() {
        Point p1 = new Point(3, 3);
        Point p2 = new Point(0,-1);
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions();
        assertEquals(5, LIC.distance(p1, p2), 0.00001);
    }

    /**
     * Invalid input test case, ensure the distance to a null object
     * causes an IllegalArgumentException to be thrown.
     */
    @Test
    public void distanceThrowsIllegalArgumentExceptionOnNull() {
        Point p1 = new Point(0, 0);
        Point p2 = null;
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions();
        assertThrows(
            IllegalArgumentException.class, 
            () -> { LIC.distance(p1, p2); }
        );
    }

}
