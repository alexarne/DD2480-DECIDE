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
     * are exactly LENGHT1 apart.
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

        /**
     * Positive test case. Ensure the radius of the circle through the
     * points is correct.
     */
    @Test
    public void findCircleRadiusCorrect() {
        Point p1 = new Point(1, 0);
        Point p2 = new Point(2, 1);
        Point p3 = new Point(3, 0);
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions();
        assertEquals(1, LIC.findCircleRadius(p1, p2, p3), 0.00001);
    }

    /**
     * Edge-case test case. Ensure the radius is correct when one of the lines formed by
     * the three points is a vertical line (slope = infinity).
     */
    @Test
    public void findCircleRadiusStraightLine() {
        Point p1 = new Point(1, 0);
        Point p2 = new Point(1, 2);
        Point p3 = new Point(2, 3);
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions();
        assertEquals(Math.sqrt(5), LIC.findCircleRadius(p1, p2, p3), 0.00001);
    }

    /**
     * Edge-case test case. Ensure the calculated radius from three points forming 
     * parallell lines is returned as NaN.
     */
    @Test
    public void findCircleRadiusParallelLines() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 2);
        Point p3 = new Point(3, 3);
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions();
        assertEquals(Double.NaN, LIC.findCircleRadius(p1, p2, p3), 0.00001);
    }



    /**
     * Invalid input test case, ensure the distance to a null object
     * causes an IllegalArgumentException to be thrown.
     */
    @Test
    public void findCircleRadiusThrowsIllegalArgumentExceptionOnNull() {
        Point p1 = new Point(0, 0);
        Point p2 = null;
        Point p3 = new Point(1, 3);
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions();
        assertThrows(
            IllegalArgumentException.class, 
            () -> { LIC.findCircleRadius(p1, p2, p3); }
        );
    }

}
