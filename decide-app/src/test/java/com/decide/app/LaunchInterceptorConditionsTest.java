package com.decide.app;

import static org.junit.Assert.assertTrue;

import org.junit.Before;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;
import org.junit.Ignore;

public class LaunchInterceptorConditionsTest {
    Parameters PARAMETERS;

    @Before
    public void setUp() {
        PARAMETERS = new Parameters();
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
     * ========================== [ LIC 7 ] ==========================
     */

    /**
     * Positive test case, ensure LIC7 is satisfied when two points seperated by
     * exactly K_PTS consecutive points are striclty more than LENGTH1 apart.
     */
    @Ignore
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
    @Ignore
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
    @Ignore
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
    @Ignore
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
    @Ignore
    @Test
    public void LIC7InvalidArgumentStrictlyNegativeLength() {
        PARAMETERS.LENGTH1 = -5;
        Point[] POINTS = new Point[]{
            new Point(0, 0),
            new Point(1, 2)
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
    @Ignore
    @Test
    public void LIC7InvalidArgumentKptsMegativeOrNull() {
        PARAMETERS.K_PTS = 0;
        PARAMETERS.LENGTH1 = 5;
        Point[] POINTS = new Point[]{
            new Point(0, 0),
            new Point(1, 2)
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
