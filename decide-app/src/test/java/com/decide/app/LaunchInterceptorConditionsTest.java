package com.decide.app;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class LaunchInterceptorConditionsTest {

    /**
     * ========================== [ LIC 0 ] ==========================
     */

    /**
     * Positive test case, ensure LIC0 is satisfied when two consecutive
     * points are more than LENGTH1 apart.
     */
    @Test
    public void LIC0TrueOnDistanceGreaterThanLENGTH1() {
        int NUMPOINTS = 2;
        Parameters PARAMETERS = new Parameters();
        PARAMETERS.LENGTH1 = 4;
        Point[] POINTS = new Point[]{
            new Point(1, 2), 
            new Point(1, 2+PARAMETERS.LENGTH1+1)
        };
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertTrue(LIC.getLaunchInterceptorCondition0());
    }

    /**
     * Negative test case, ensure LIC0 is not satisfied when no two 
     * consecutive points are more than LENGTH1 apart.
     */
    @Test
    public void LIC0FalseOnDistanceSmallerThanLENGTH1() {
        int NUMPOINTS = 2;
        Parameters PARAMETERS = new Parameters();
        PARAMETERS.LENGTH1 = 4;
        Point[] POINTS = new Point[]{ 
            new Point(1, 2), 
            new Point(1, 2+PARAMETERS.LENGTH1-1)
        };
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertFalse(LIC.getLaunchInterceptorCondition0());
    }

    /**
     * Edge-case test case, ensure LIC0 is not satisfied when points
     * are exactly LENGHT1 apart.
     */
    @Test
    public void LIC0FalseOnDistanceEqualToLENGTH1() {
        int NUMPOINTS = 1;
        Parameters PARAMETERS = new Parameters();
        PARAMETERS.LENGTH1 = 2;
        Point[] POINTS = new Point[]{
            new Point(1, 2), 
            new Point(1, 2+PARAMETERS.LENGTH1)
        };
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertFalse(LIC.getLaunchInterceptorCondition0());
    }

    /**
     * Edge-case test case, ensure LIC0 is not satisfied when there
     * is only one point.
     */
    @Test
    public void LIC0FalseOnOnlyOnePoint() {
        int NUMPOINTS = 1;
        Parameters PARAMETERS = new Parameters();
        PARAMETERS.LENGTH1 = 2;
        Point[] POINTS = new Point[]{
            new Point(1, 2)
        };
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertFalse(LIC.getLaunchInterceptorCondition0());
    }

    /**
     * Invalid input test case, ensure LIC0 throws IllegalArgumentException
     * if the supplied parameter LENGTH1 is less than 0.
     */
    @Test
    public void LIC0ThrowsIllegalArgumentExceptionOnInvalidParameter() {
        int NUMPOINTS = 1;
        Parameters PARAMETERS = new Parameters();
        PARAMETERS.LENGTH1 = -1;
        Point[] POINTS = new Point[]{
            new Point(1, 2),
            new Point(2, 2),
            new Point(2, 3)
        };
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertThrows(
            IllegalArgumentException.class, 
            () -> { LIC.getLaunchInterceptorCondition0(); }
        );
    }
  
    /**
     * ========================== [ LIC 4 ] ==========================
     */

    /**
     * Positive test case, ensure LIC4 is satisfied when receives three points with at least two
     * of them in different Quads
     */
    @Test
    public void LIC4TruewithThreePointsAndTwoQuads() {
        Parameters PARAMETERS = new Parameters();
        PARAMETERS.QUADS = 1;
        PARAMETERS.Q_PTS = 3;
        Point[] POINTS = new Point[]{
            new Point(1, 2), 
            new Point(-1, 2),
            new Point(2,-1)
        };
        int NUMPOINTS = POINTS.length;
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertTrue(LIC.getLaunchInterceptorCondition4());
    }

    /**
     * Negative test case, ensure LIC4 is not satisfied when receives three points 
     * which are in the same Quad
     */
    @Test
    public void LIC4FalsewithThreePointsInSameQuad() {
        Parameters PARAMETERS = new Parameters();
        PARAMETERS.QUADS = 1;
        PARAMETERS.Q_PTS = 3;
        Point[] POINTS = new Point[]{
            new Point(1, 2), 
            new Point(10, 20),
            new Point(2,1)
        };
        int NUMPOINTS = POINTS.length;
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertFalse(LIC.getLaunchInterceptorCondition4());
    }
    
    /**
    * edge case, if the number of Q_PTS is lower than the number
    * of QUADS, the test should be FALSE  
    */
    @Test
    public void LIC4FalseWithMoreQuadsThanPoints() {
        Parameters PARAMETERS = new Parameters();
        PARAMETERS.QUADS = 3;
        PARAMETERS.Q_PTS = 2;
        Point[] POINTS = new Point[]{
            new Point(1, 2), 
            new Point(-10, 20)
        };
        int NUMPOINTS = POINTS.length;
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertFalse(LIC.getLaunchInterceptorCondition4());
    }

    /**
    * WhichQuad is expected to return the Quad where the point is.
    */
    @Test
    public void WhichQuad() {
        Point p1 = new Point(2,-1);
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions();
        assertEquals(4, LIC.whichQuad(p1), 0.00001);
    }

    /**
    * Edge-case, for point (0,0) should return 1
    */
    @Test
    public void WhichQuadCenter() {
        Point p1 = new Point(0,0);
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions();
        assertEquals(1, LIC.whichQuad(p1), 0.00001);
    }

    /**
    * Edge-case, for point (0,1) should return 1
    */
    @Test
    public void WhichQuadBetweenQuadIAndQuadII() {
        Point p1 = new Point(0,1);
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions();
        assertEquals(1, LIC.whichQuad(p1), 0.00001);
    }

    /**
    * Edge-case, for point (1,0) should return 1
    */
    @Test
    public void WhichQuadBetweenQuadIAndQuadIV() {
        Point p1 = new Point(1,0);
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions();
        assertEquals(1, LIC.whichQuad(p1), 0.00001);
    }

    /**
    * Edge-case, for point (-1,0) should return 2
    */
    @Test
    public void WhichQuadBetweenQuadIIAndQuadIII() {
        Point p1 = new Point(-1,0);
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions();
        assertEquals(2, LIC.whichQuad(p1), 0.00001);
    }

    /**
    * Edge-case, for point (0,-1) should return 3
    */
    @Test
    public void WhichQuadBetweenQuadIIIAndQuadIV() {
        Point p1 = new Point(0,-1);
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions();
        assertEquals(3, LIC.whichQuad(p1), 0.00001);
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
