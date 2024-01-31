package com.decide.app;

import static org.junit.Assert.assertTrue;

import org.junit.Before;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import java.lang.Math;

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
     * Positive test case. Ensure LIC1 satisfied when three consecutive data points
     * can not be contained within a circle of radius RADIUS1.
     */
    @Test
    public void LIC1TruePointsNotInRadius() {
        // Setup
        PARAMETERS.RADIUS1 = 2.0;
        Point[] POINTS = new Point[]{ new Point(6, 1), new Point(5, 2.5), new Point(3, 5), new Point(0, 0) };
        int NUMPOINTS = POINTS.length;
        // Processing
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        // Assertion
        assertTrue(LIC.getLaunchInterceptorCondition1());
    }

    /**
     * Negative test case. Ensure LIC1 not satisfied when three consecutive data points
     * can be contained within a circle of radius RADIUS1.
     */
    @Test
    public void LIC1FalsePointsInRadius() {
        // Setup
        PARAMETERS.RADIUS1 = 4.0;
        Point[] POINTS = new Point[]{ new Point(1, 2), new Point(3, 4), new Point(4, 4) };
        int NUMPOINTS = POINTS.length;
         // Processing
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
         // Assertion
        assertFalse(LIC.getLaunchInterceptorCondition1());
    }

    /**
     * Edge-case test case. Ensure LIC1 not satisfied when three consecutive data points
     * are on the edge of the circle of radius RADIUS1.
     */
    @Test
    public void LIC1FalsePointsOnCircleExtremities() {
        // Setup
        PARAMETERS.RADIUS1 = Math.sqrt(1.25);
        Point[] POINTS = new Point[]{ new Point(1, 0), new Point(1, 1), new Point(3, 0)};
        int NUMPOINTS = POINTS.length;
          // Processing
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
         // Assertion
        assertFalse(LIC.getLaunchInterceptorCondition1());
    }

    /**
     * Edge-case test case. Ensure LIC1 satisfied when three consecutive data points
     * form a equilateral triangle with side length = RADIUS1*2
     * and can not be contained within a circle of radius RADIUS1.
     */
    @Test
    public void LIC1TrueEquilateralTriangleSideEqualsRadius() {
        // Setup
        PARAMETERS.RADIUS1 = 1.0;
        Point[] POINTS = new Point[]{ new Point(0, 0), new Point(2, 0), new Point(1, Math.sqrt(3))};
        int NUMPOINTS = POINTS.length;
        // Processing
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        // Assertion
        assertTrue(LIC.getLaunchInterceptorCondition1());
    }

    /**
     * Invalid input test case. Ensure LIC1 not satisfied when only two data points are provided.
     */
    @Test
    public void LIC1FalseInsufficientInput() {
        // Setup
        PARAMETERS.RADIUS1 = 10.0;
        Point[] POINTS = new Point[]{ new Point(1, 2), new Point(3, 4) };
        int NUMPOINTS = POINTS.length;
        // Processing
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        // Assertion
        assertFalse(LIC.getLaunchInterceptorCondition1());
    }

    /**
     * Invalid input test case, ensure LIC1 throws IllegalArgumentException
     * if the supplied parameter RADIUS1 is less than 0.
     */
    @Test
    public void LIC1ThrowsIllegalArgumentExceptionOnInvalidParameter() {
        PARAMETERS.RADIUS1 = -1;
        Point[] POINTS = new Point[]{ new Point(6, 1), new Point(5, 2.5), new Point(3, 5), new Point(0, 0) };
        int NUMPOINTS = POINTS.length;
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertThrows(
            IllegalArgumentException.class, 
            () -> { LIC.getLaunchInterceptorCondition1(); }
        );
    }

    /**
     * ========================== [ LIC 2 ] ==========================
     */


    /**
     * Positive test case. Ensure LIC2 satisfied when angle between points smaller than
     * Pi - EPSILON.
     */
    @Test
    public void LIC2TrueAngleSmallerThanLowerLimit(){
        int NUMPOINTS = 3;
        Parameters PARAMETERS = new Parameters();
        PARAMETERS.EPSILON = 0.01;
        Point[] POINTS = new Point[]{ new Point(0, 1), new Point(1,1), new Point(2, 1.2)};
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertTrue(LIC.getLaunchInterceptorCondition2());

    }

    /**
     * Positive test case. Ensure LIC2 satisfied when angle between points larger than
     * EPSILON + Pi.
     */
    @Test
    public void LIC2TrueAngleGreaterThanUpperLimit(){
        int NUMPOINTS = 3;
        Parameters PARAMETERS = new Parameters();
        PARAMETERS.EPSILON = 0.01;
        Point[] POINTS = new Point[]{ new Point(0, 1), new Point(1,1), new Point(2, 0.8)};
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertTrue(LIC.getLaunchInterceptorCondition2());
        
    }

    /**
     * Negative test case. Ensure LIC2 not satisfied when angle between points is
     * between Pi - EPSILON and EPSILON + Pi.
     */
    @Test
    public void LIC2FalseAngleBetweenLimits(){
        int NUMPOINTS = 3;
        Parameters PARAMETERS = new Parameters();
        PARAMETERS.EPSILON = 0.01;
        Point[] POINTS = new Point[]{ new Point(2, 1), new Point(1,1), new Point(0, 1)};
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertFalse(LIC.getLaunchInterceptorCondition2());
        
    }

    /**
     * Edge-case test case. Ensure LIC2 not satisfied when one of the two points
     * coincide with the vertex. 
     */
    @Test
    public void LIC2FalsePointEqualsVertex(){
        int NUMPOINTS = 3;
        Parameters PARAMETERS = new Parameters();
        PARAMETERS.EPSILON = 0.01;
        Point[] POINTS = new Point[]{ new Point(1, 1), new Point(1,1), new Point(2, 1.2)};
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertFalse(LIC.getLaunchInterceptorCondition2());
    }

    /**
     * Edge-case test case. Ensure LIC2 not satisfied when angle between points is
     * exactly Pi - EPSILON
     */
    @Test
    public void LIC2FalseAngleEqualToLimit(){
        int NUMPOINTS = 3;
        Parameters PARAMETERS = new Parameters();
        PARAMETERS.EPSILON = 0.0;
        Point[] POINTS = new Point[]{ new Point(2, 1), new Point(1,1), new Point(0, 1)};
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertFalse(LIC.getLaunchInterceptorCondition2());
        
    }

    /**
     * Invalid input test case, ensure LIC2 throws IllegalArgumentException
     * if the supplied parameter EPSILON is less than 0.
     */
    @Test
    public void LIC2ThrowsIllegalArgumentExceptionOnInvalidParameterSmall() {
        PARAMETERS.EPSILON = -1.0;
        Point[] POINTS = new Point[]{ new Point(0, 1), new Point(1,1), new Point(2, 1.2)};
        int NUMPOINTS = POINTS.length;
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertThrows(
            IllegalArgumentException.class, 
            () -> { LIC.getLaunchInterceptorCondition2(); }
        );
    }

    /**
     * Invalid input test case, ensure LIC2 throws IllegalArgumentException
     * if the supplied parameter EPSILON is equal to Pi. 
     */
    @Test
    public void LIC2ThrowsIllegalArgumentExceptionOnInvalidParameterLarge() {
        PARAMETERS.EPSILON = Math.PI;
        Point[] POINTS = new Point[]{ new Point(0, 1), new Point(1,1), new Point(2, 1.2)};
        int NUMPOINTS = POINTS.length;
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertThrows(
            IllegalArgumentException.class, 
            () -> { LIC.getLaunchInterceptorCondition2(); }
        );
    }

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
     * ========================== [ LIC 4 ] ==========================
     */

    

    /**
     * ========================== [ LIC 5 ] ==========================
     */
    /**
     * Positive test case, ensure LIC5 is satisfied when two consecutive
     * points follow that X[J] - X[i] < 0. with J = I+1
     */
    @Test
    public void LIC5TruewithX2lowerThanX1() {
        Point[] POINTS = new Point[]{
            new Point(1, 2), 
            new Point(0, 4)
        };
        int NUMPOINTS = POINTS.length;
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertTrue(LIC.getLaunchInterceptorCondition5());
    }

    /**
     * Negative test case, ensure LIC5 is not satisfied when two consecutive
     * points don't follow that X[J] - X[i] < 0. with J = I+1
     */
    @Test
    public void LIC5FalseWithX2HigherThanX1() {
        Point[] POINTS = new Point[]{
            new Point(0, 2), 
            new Point(1, 4)
        };
        int NUMPOINTS = POINTS.length;
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertFalse(LIC.getLaunchInterceptorCondition5());
    }

     /**
     * Egde-case test, ensure LIC5 is not satisfied when two consecutive
     * points are in the same X position.
     */
    @Test
    public void LIC5FalseWithEqualX() {
        Point[] POINTS = new Point[]{
            new Point(1, 2), 
            new Point(1, 4)
        };
        int NUMPOINTS = POINTS.length;
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertFalse(LIC.getLaunchInterceptorCondition5());
    }

    @Test
    public void LIC5FalseWithLessThanTwoPoints() {
        Point[] POINTS = new Point[]{
            new Point(1, 2)
        };
        int NUMPOINTS = POINTS.length;
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertFalse(LIC.getLaunchInterceptorCondition5());
    }
    
   

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
     * Positive test case. Ensure LIC8 is satisfied when three points separated by 
     * exactly A_PTS and B_PTS consecutive intervening points, respectively, 
     * cannot be contained within or on a circle of radius RADIUS1.
     */
    @Test 
    public void LIC8TruePointsNotInRadius(){
        PARAMETERS.RADIUS1 = 2.0;
        PARAMETERS.A_PTS = 1;
        PARAMETERS.B_PTS = 2;
        Point[] POINTS = new Point[]{ new Point(6, 1), new Point(0, 0), new Point(5, 2.5), new Point(1, 2), new Point(3, 3), new Point(3, 5), new Point(0, 0) };
        int NUMPOINTS = POINTS.length;
        // Processing
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        // Assertion
        assertTrue(LIC.getLaunchInterceptorCondition8());

    }

    /**
     * Negative test case. Ensure LIC8 is not satisfied when three points separated by 
     * exactly A_PTS and B_PTS consecutive intervening points, respectively, 
     * can be contained within or on a circle of radius RADIUS1.
     */
    @Test 
    public void LIC8FalsePointsInRadius(){
        PARAMETERS.RADIUS1 = 4.0;
        PARAMETERS.A_PTS = 1;
        PARAMETERS.B_PTS = 2;
        Point[] POINTS = new Point[]{ new Point(1, 2), new Point(0, 0), new Point(1, 2.5), new Point(1, 2), new Point(3, 3), new Point(1, 3), new Point(0, 0)  };
        int NUMPOINTS = POINTS.length;
        // Processing
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        // Assertion
        assertFalse(LIC.getLaunchInterceptorCondition8());
    }

    /**
     * Edge case test case. Ensure LIC8 is not satisfied when three points separated by 
     * exactly A_PTS and B_PTS consecutive intervening points, respectively, 
     * are on the edge of a circle of radius RADIUS1.
     */
    @Test 
    public void LIC8FalsePointsOnRadiusEdge(){
        PARAMETERS.RADIUS1 = 3.0;
        PARAMETERS.A_PTS = 1;
        PARAMETERS.B_PTS = 1;
        Point[] POINTS = new Point[]{ new Point(7, 4), new Point(10, 10), new Point(4, 1), new Point(0, 7), new Point(1, 4) };
        int NUMPOINTS = POINTS.length;
          // Processing
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
         // Assertion
        assertFalse(LIC.getLaunchInterceptorCondition8());
        
    }

    /**
     * Incorrect input test case. Ensure LIC8 is not satisfied when less than 5 points
     * are supplied.
     */
    @Test 
    public void LIC8FalseLessThan5Points(){
        PARAMETERS.RADIUS1 = 2.0;
        PARAMETERS.A_PTS = 1;
        PARAMETERS.B_PTS = 1;
        Point[] POINTS = new Point[]{ new Point(6, 1), new Point(4, 2), new Point(1, 2), new Point(3, 5)};
        int NUMPOINTS = POINTS.length;
        // Processing
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        // Assertion
        assertFalse(LIC.getLaunchInterceptorCondition8());

    }

    /**
     * Invalid input test case. Ensure LIC8 throws IllegalArgumentException when
     * A_PTS is less than 1.
     */
    @Test 
    public void LIC8ThrowsIllegalArgumentExceptionOnInvalidA_PTS(){
        PARAMETERS.A_PTS = 0;
        Point[] POINTS = new Point[]{ new Point(6, 1), new Point(0, 0), new Point(5, 2.5), new Point(1, 2), new Point(3, 3), new Point(3, 5), new Point(0, 0) };
        int NUMPOINTS = POINTS.length;
        // Processing
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        // Assertion
        assertThrows(
            IllegalArgumentException.class, 
            () -> { LIC.getLaunchInterceptorCondition8(); }
        );

    }

    /**
     * Invalid input test case. Ensure LIC8 throws IllegalArgumentException when
     * B_PTS is less than 1.
     */
    @Test 
    public void LIC8ThrowsIllegalArgumentExceptionOnInvalidB_PTS(){
        PARAMETERS.B_PTS = -2;
        Point[] POINTS = new Point[]{ new Point(6, 1), new Point(0, 0), new Point(5, 2.5), new Point(1, 2), new Point(3, 3), new Point(3, 5), new Point(0, 0) };
        int NUMPOINTS = POINTS.length;
        // Processing
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        // Assertion
        assertThrows(
            IllegalArgumentException.class, 
            () -> { LIC.getLaunchInterceptorCondition8(); }
        );
    }

    /**
     * Invalid input test case. Ensure LIC8 throws IllegalArgumentException when
     * A_PTS + B_PTS > NUMPOINTS-3.
     */
    @Test 
    public void LIC8ThrowsIllegalArgumentExceptionOnInvalidNUMPOINTS(){
        PARAMETERS.A_PTS = 1;
        Point[] POINTS = new Point[]{ new Point(6, 1), new Point(0, 0), new Point(5, 2.5), new Point(1, 2), new Point(3, 3), new Point(3, 5), new Point(0, 0) };
        int NUMPOINTS = POINTS.length;
        PARAMETERS.B_PTS = NUMPOINTS-2-PARAMETERS.A_PTS;
        // Processing
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        // Assertion
        assertThrows(
            IllegalArgumentException.class, 
            () -> { LIC.getLaunchInterceptorCondition8(); }
        );
    }
    

    /**
     * ========================== [ LIC 9 ] ==========================
     */

    

    /**
     * ========================= [ LIC 10 ] ==========================
     */

    /**
     * Positive test case, ensure LIC10 is satisfied when three points seperated by
     * exactly E_PTS and F_PTS consecutive points respectively form a triangle of area
     * striclty superior to AREA1.
     */
    @Test
    public void LIC10TrueTriangleOfAreaStrictlySuperiorToArea1() {
        PARAMETERS.E_PTS = 2;
        PARAMETERS.F_PTS = 2;
        PARAMETERS.AREA1 = 3;
        Point[] POINTS = new Point[]{
            new Point(4, 2),
            new Point(1, 2),
            new Point(2, 5),
            new Point(10, 7),
            new Point(1, 10),
            new Point(1, 1),
            new Point(-1, -7)
        };
        int NUMPOINTS = POINTS.length;

        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);

        assertTrue(LIC.getLaunchInterceptorCondition10());
    }


    /**
     * Negative test case, ensure LIC10 is not satisfied when three points seperated by
     * exactly E_PTS and F_PTS consecutive points respectively form a triangle of area
     * inferior to AREA1.
     */
    @Test
    public void LIC10FalseTriangleOfAreaInferiorToArea1() {
        PARAMETERS.E_PTS = 2;
        PARAMETERS.F_PTS = 2;
        PARAMETERS.AREA1 = 3;
        Point[] POINTS = new Point[]{
            new Point(0, 1),
            new Point(1, 2),
            new Point(2, 5),
            new Point(0, 0),
            new Point(1, 10),
            new Point(1, 2),
            new Point(1, 0)
        };
        int NUMPOINTS = POINTS.length;

        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);

        assertFalse(LIC.getLaunchInterceptorCondition10());
    }


    /**
     * Edge-case test case, ensure LIC10 is not satisfied when three points seperated by
     * exactly E_PTS and F_PTS consecutive points respectively form a triangle of area
     * equals to AREA1.
     */
    @Test
    public void LIC10FalseTriangleOfAreaEqualToArea1() {
        PARAMETERS.E_PTS = 2;
        PARAMETERS.F_PTS = 2;
        PARAMETERS.AREA1 = 2;
        Point[] POINTS = new Point[]{
            new Point(0, 2),
            new Point(1, 2),
            new Point(2, 5),
            new Point(0, 0),
            new Point(1, 10),
            new Point(1, 2),
            new Point(2, 0)
        };
        int NUMPOINTS = POINTS.length;

        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);

        assertFalse(LIC.getLaunchInterceptorCondition10());
    }

    /**
     * Unsufficient input test for LIC10, must return false if there are 5 points or less
     */
    @Test
    public void LIC10FalseOn5PointsOrLess() {
        Point[] POINTS = new Point[]{
            new Point(0, 2),
            new Point(1, 2)
        };
        int NUMPOINTS = POINTS.length;

        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);

        assertFalse(LIC.getLaunchInterceptorCondition10());
    }

    /**
     * Illegal argument value test case for LIC10, ensures an exception is raised if the
     * value of AREA1 is strictly negative.
     */
    @Test
    public void LIC10InvalidArgumentStrictlyNegativeArea() {
        PARAMETERS.AREA1 = -1;
        Point[] POINTS = new Point[]{
            new Point(0, 2),
            new Point(1, 2),
            new Point(2, 5),
            new Point(0, 0),
            new Point(1, 10),
            new Point(1, 2),
            new Point(2, 0)
        };
        int NUMPOINTS = POINTS.length;

        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);

        assertThrows(
            IllegalArgumentException.class, 
            () -> { LIC.getLaunchInterceptorCondition10(); }
        );
    }

    /**
     * Illegal argument value test case for LIC10, ensures an exception is raised if the
     * value of E_PTS is negative or null.
     */
    @Test
    public void LIC10InvalidArgumentNegativeOrNullEpts() {
        PARAMETERS.E_PTS = 0;
        PARAMETERS.AREA1 = 1;
        Point[] POINTS = new Point[]{
            new Point(0, 2),
            new Point(1, 2),
            new Point(2, 5),
            new Point(0, 0),
            new Point(1, 10),
            new Point(1, 2),
            new Point(2, 0)
        };
        int NUMPOINTS = POINTS.length;

        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);

        assertThrows(
            IllegalArgumentException.class, 
            () -> { LIC.getLaunchInterceptorCondition10(); }
        );
    }

    /**
     * Illegal argument value test case for LIC10, ensures an exception is raised if the
     * value of F_PTS is negative or null.
     */
    @Test
    public void LIC10InvalidArgumentNegativeOrNullFpts() {
        PARAMETERS.E_PTS = 1;
        PARAMETERS.F_PTS = -1;
        PARAMETERS.AREA1 = 1;
        Point[] POINTS = new Point[]{
            new Point(0, 2),
            new Point(1, 2),
            new Point(2, 5),
            new Point(0, 0),
            new Point(1, 10),
            new Point(1, 2),
            new Point(2, 0)
        };
        int NUMPOINTS = POINTS.length;

        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);

        assertThrows(
            IllegalArgumentException.class, 
            () -> { LIC.getLaunchInterceptorCondition10(); }
        );
    }

    /**
     * Illegal argument value test case for LIC10, ensures an exception is raised if
     * E_PTS + F_PTS > NUMPOINTS - 3.
     */
    @Test
    public void LIC10InvalidArgumentNegativeSumOfEptsAndFptsTooBig() {
        PARAMETERS.AREA1 = 10;
        Point[] POINTS = new Point[]{
            new Point(0, 2),
            new Point(1, 2),
            new Point(2, 5),
            new Point(0, 0),
            new Point(1, 10),
            new Point(1, 2),
            new Point(2, 0)
        };
        int NUMPOINTS = POINTS.length;
        PARAMETERS.E_PTS = NUMPOINTS;
        PARAMETERS.F_PTS = NUMPOINTS;

        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);

        assertThrows(
            IllegalArgumentException.class, 
            () -> { LIC.getLaunchInterceptorCondition10(); }
        );
    }

    
    /**
     * ========================= [ LIC 11 ] ==========================
     */

    /**
     * Positive test case, ensure LIC11 returns true when there is a set
     * of points with G_PTS intervening points such that their x-difference
     * is negative.
     */
    @Test
    public void LIC11TrueWhenSatisfied() {
        PARAMETERS.G_PTS = 4;
        Point[] POINTS = new Point[]{
            new Point(0,0),
            new Point(2,0),
            new Point(0,2),
            new Point(0,2),
            new Point(0,2),
            new Point(0,2),
            new Point(0,2)
        };
        int NUMPOINTS = POINTS.length;
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertTrue(LIC.getLaunchInterceptorCondition11());
    }

    /**
     * Negative test case, ensure LIC11 returns false if there are
     * only 2 points.
     */
    @Test
    public void LIC11FalseWhenTwoPoints() {
        PARAMETERS.G_PTS = 1;
        Point[] POINTS = new Point[]{
            new Point(0,3),
            new Point(1,70)
        };
        int NUMPOINTS = POINTS.length;
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertFalse(LIC.getLaunchInterceptorCondition11());
    }

    /**
     * Negative test case, ensure LIC11 returns false if all points are
     * non-decreasing in x-value.
     */
    @Test
    public void LIC11FalseWhenIncreasingX() {
        PARAMETERS.G_PTS = 1;
        Point[] POINTS = new Point[]{
            new Point(0,3),
            new Point(1,70),
            new Point(1,2),
            new Point(2,22),
            new Point(2.2,2),
            new Point(3,24),
            new Point(4,2)
        };
        int NUMPOINTS = POINTS.length;
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertFalse(LIC.getLaunchInterceptorCondition11());
    }

    /**
     * Invalid input test case, ensure LIC11 throws IllegalArgumentException
     * if G_PTS is out of bounds.
     */
    @Test
    public void LIC11ThrowsExceptionOnInvalidParameter() {
        PARAMETERS.G_PTS = 0;
        Point[] POINTS = new Point[]{
            new Point(0,3),
            new Point(1,70),
            new Point(1,2)
        };
        int NUMPOINTS = POINTS.length;
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertThrows(
            IllegalArgumentException.class, 
            () -> { LIC.getLaunchInterceptorCondition11(); }
        );
    }

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
     * Invalid input test case, ensure LIC12 throws IllegalArgumentException
     * if the supplied parameters LENGTH1, LENGTH2, or K_PTS are out of bounds.
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
     * Positive test case, ensure LIC13 is satisfied when the points can be
     * contained in a circle of radius RADIUS2, but not of RADIUS1.  
     */
    @Test
    public void LIC13TrueWhenSatisfied() {
        PARAMETERS.A_PTS = 1;
        PARAMETERS.B_PTS = 1;
        PARAMETERS.RADIUS1 = 0.9;
        PARAMETERS.RADIUS2 = 1.1;
        Point[] POINTS = new Point[]{
            new Point(0,0),
            new Point(1,3),
            new Point(1,0.5),
            new Point(2,0),
            new Point(2,0)
        };
        int NUMPOINTS = POINTS.length;
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertTrue(LIC.getLaunchInterceptorCondition13());
    }

    /**
     * Negative test case, ensure LIC13 is not satisfied when the points 
     * can be contained in a circle with radius exactly RADIUS1.  
     */
    @Test
    public void LIC13FalseOnBoundary() {
        PARAMETERS.A_PTS = 1;
        PARAMETERS.B_PTS = 1;
        PARAMETERS.RADIUS1 = 1;
        PARAMETERS.RADIUS2 = 1;
        Point[] POINTS = new Point[]{
            new Point(0,0),
            new Point(1,3),
            new Point(1,0.5),
            new Point(2,0),
            new Point(2,0)
        };
        int NUMPOINTS = POINTS.length;
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertFalse(LIC.getLaunchInterceptorCondition13());
    }

    /**
     * Negative test case, ensure LIC13 is not satisfied when the points 
     * require a larger circle to be contained. 
     */
    @Test
    public void LIC13FalseOnTooSmallRADIUS2() {
        PARAMETERS.A_PTS = 1;
        PARAMETERS.B_PTS = 1;
        PARAMETERS.RADIUS1 = 1;
        PARAMETERS.RADIUS2 = 1;
        Point[] POINTS = new Point[]{
            new Point(0,0),
            new Point(1,3),
            new Point(1,2.5),
            new Point(2,0),
            new Point(2,0)
        };
        int NUMPOINTS = POINTS.length;
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertFalse(LIC.getLaunchInterceptorCondition13());
    }

    /**
     * Invalid input test case, ensure LIC12 throws IllegalArgumentException
     * if the supplied parameters LENGTH1, LENGTH2, or K_PTS are out of bounds.
     */
    @Test
    public void LIC13ThrowsIllegalArgumentExceptionOnInvalidInput() {
        PARAMETERS.A_PTS = 0;
        PARAMETERS.B_PTS = 0;
        PARAMETERS.RADIUS1 = -1;
        PARAMETERS.RADIUS2 = -1;
        Point[] POINTS = new Point[]{
            new Point(0,0),
            new Point(1,3),
            new Point(1,2.5),
            new Point(2,0),
            new Point(2,0)
        };
        int NUMPOINTS = POINTS.length;
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertThrows(
            IllegalArgumentException.class, 
            () -> { LIC.getLaunchInterceptorCondition13(); }
        );
    }

    /**
     * ========================= [ LIC 14 ] ==========================
     */
    


  
    
    /**
     * ========================= [ HELPERS ] =========================
     */
    

    /**
     * ======================== [ Distance ] =========================
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
     * ==================== [ ContainedInCircle ] =====================
     */
  
    /**
     * Positive test case. Ensure containedInCircle returns true when
     * it is possible to contain the points in a circle of radius R.
     */
    @Test
    public void containedInCircleCorrectWhenPossible() {
        Point p1 = new Point(1, 0);
        Point p2 = new Point(2, 0.5);
        Point p3 = new Point(3, 0);
        double R = 1;
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions();
        assertTrue(LIC.containedInCircle(p1, p2, p3, R));
    }
  
    /**
     * Positive test case. Ensure containedInCircle returns true when
     * it is possible to contain points, distributed on a line, in a 
     * circle of radius R.
     */
    @Test
    public void containedInCircleCorrectWhenPointsOnLine() {
        Point p1 = new Point(1, 0);
        Point p2 = new Point(2, 0);
        Point p3 = new Point(3, 0);
        double R = 1;
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions();
        assertTrue(LIC.containedInCircle(p1, p2, p3, R));
    }
  
    /**
     * Negative test case. Ensure containedInCircle returns false when
     * it is not possible to contain the points in a circle of radius R.
     */
    @Test
    public void containedInCircleCorrectWhenNotPossible() {
        Point p1 = new Point(1, 0);
        Point p2 = new Point(2, 2.5);
        Point p3 = new Point(3, 0);
        double R = 1;
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions();
        assertFalse(LIC.containedInCircle(p1, p2, p3, R));
    }
  
    /**
     * Invalid input test case. Ensure containedInCircle throws
     * IllegalArgumentException if either point is null or the radius
     * is negative.
     */
    @Test
    public void containedInCircleThrowsExceptionOnInvalidInput() {
        Point p1 = null;
        Point p2 = null;
        Point p3 = null;
        double R = -1;
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions();
        assertThrows(
            IllegalArgumentException.class, 
            () -> { LIC.containedInCircle(p1, p2, p3, R); }
        );
    }
  
    /**
     * Invalid input test case. Ensure containedInCircle throws
     * IllegalArgumentException if input radius is NaN.
     */
    @Test
    public void containedInCircleThrowsExceptionOnNaNRadius() {
        Point p1 = new Point(1, 0);
        Point p2 = new Point(2, 0);
        Point p3 = new Point(3, 0);
        double R = Double.NaN;
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions();
        assertThrows(
            IllegalArgumentException.class, 
            () -> { LIC.containedInCircle(p1, p2, p3, R); }
        );
    }

    /**
     * ======================= [ CircleRadius ] =======================
     */
  
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

    /**
     * ======================= [ TriangleArea ] =======================
     */
          
    /**
     * Positive test case, ensure that the area of a simple triangle is correct.
     */
    @Test
    public void triangleAreaCorrectOnNormalTriangle() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 3);
        Point p3 = new Point(3, 0);
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions();
        assertEquals(4.5, LIC.triangleArea(p1, p2, p3), 0.00001);
    }

    /**
     * Positive test case, ensure that the area of a simple triangle is correct.
     */
    @Test
    public void triangleAreaCorrectOnSkewedTriangle() {
        Point p1 = new Point(4, 2);
        Point p2 = new Point(3, 5);
        Point p3 = new Point(1, 2);
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions();
        assertEquals(4.5, LIC.triangleArea(p1, p2, p3), 0.00001);
    }

    /**
     * Positive test case, ensure that the area of a slim triangle is 0.
     */
    @Test
    public void triangleAreaCorrectOnSlimTriangle() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(2, 2);
        Point p3 = new Point(3, 3);
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions();
        assertEquals(0, LIC.triangleArea(p1, p2, p3), 0.00001);
    }

    /**
     * Invalid input test case, ensure the triangle area with a null vertex
     * causes an IllegalArgumentException to be thrown.
     */
    @Test
    public void triangleAreaThrowsExceptionOnNull() {
        Point p1 = new Point(0, 0);
        Point p2 = null;
        Point p3 = new Point(0, 0);
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions();
        assertThrows(
            IllegalArgumentException.class, 
            () -> { LIC.triangleArea(p1, p2, p3); }
        );
    }

    /**
     * ======================= [ Angle ] =======================
     */
          
    /**
     * Positive test case, ensure that the angle of a right angle is correct.
     */
    @Test
    public void angleCorrectOnRightAngle() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 0);
        Point p3 = new Point(0, 0);
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions();
        double ang = LIC.angle(p1, p2, p3);
        assertEquals(ang, Math.PI / 2, 0.00001);
    }
    
    /**
     * Positive test case, ensure that the angle of an acute angle is correct.
     */
    @Test
    public void angleCorrectOnAcuteAngle() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 2);
        Point p3 = new Point(2, 1);
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions();
        double ang = LIC.angle(p1, p2, p3);
        assertEquals(ang, Math.PI / 4, 0.00001);
    }

    /**
     * Positive test case, ensure that the angle of an obtuse angle is correct.
     */
    @Test
    public void angleCorrectOnObtuseAngle() {
        Point p1 = new Point(5, 2);
        Point p2 = new Point(3, 2);
        Point p3 = new Point(1, 4);
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions();
        double ang = LIC.angle(p1, p2, p3);
        assertEquals(ang, 3* Math.PI / 4, 0.00001);
    }

    /**
     * Edge-case test case, ensure that the angle of equal start and end point is zero.
     */
    @Test
    public void angleCorrectOnZeroAngle() {
        Point p1 = new Point(7, 3);
        Point p2 = new Point(2, 4);
        Point p3 = new Point(7, 3);
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions();
        double ang = LIC.angle(p1, p2, p3);
        assertEquals(ang, 0, 0.00001);
    }

    /**
     * Invalid input test case, ensure a null point
     * causes an IllegalArgumentException to be thrown.
     */
    @Test
    public void angleThrowsExceptionOnNull() {
        Point p1 = new Point(0, 0);
        Point p2 = null;
        Point p3 = new Point(0, 0);
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions();
        assertThrows(
            IllegalArgumentException.class, 
            () -> { LIC.angle(p1, p2, p3); }
        );
    }

    /**
     * Invalid input test case, ensure no angle being formed
     * causes an IllegalArgumentException to be thrown.
     */
    @Test
    public void angleThrowsExceptionOnNoAngle() {
        Point p1 = new Point(1, 5);
        Point p2 = new Point(2, 1);
        Point p3 = new Point(2, 1);
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions();
        assertThrows(
            IllegalArgumentException.class, 
            () -> { LIC.angle(p1, p2, p3); }
        );
    }

}
