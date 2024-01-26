package com.decide.app;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.Ignore;

public class LaunchInterceptorConditionsTest {

    @Test
    public void shouldAnswerWithTrue()
    {
        int NUMPOINTS = 1;
        Point[] POINTS = new Point[]{ new Point(1, 2) };
        Parameters PARAMETERS = new Parameters();
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertTrue(LIC.getLaunchInterceptorCondition0());
    }

    @Ignore
    @Test
    public void LIC0TrueDistanceGreaterThanLENGTH1(){
        int NUMPOINTS = 2;
        Parameters PARAMETERS = new Parameters();
        PARAMETERS.LENGTH1 = 4;
        Point[] POINTS = new Point[]{ new Point(1, 2) , new Point(1, 2+PARAMETERS.LENGTH1+1)};
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertTrue(LIC.getLaunchInterceptorCondition0());
    }

    @Ignore
    @Test
    public void LIC0FalseDistanceSmallerThanLENGTH1(){
        int NUMPOINTS = 2;
        Parameters PARAMETERS = new Parameters();
        PARAMETERS.LENGTH1 = 4;
        Point[] POINTS = new Point[]{ new Point(1, 2) , new Point(1, 2+PARAMETERS.LENGTH1-1)};
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertFalse(LIC.getLaunchInterceptorCondition0());
    }

    @Ignore
    @Test
    public void LIC0FalseOnlyOnePoint(){
        int NUMPOINTS = 1;
        Parameters PARAMETERS = new Parameters();
        PARAMETERS.LENGTH1 = 2;
        Point[] POINTS = new Point[]{ new Point(1, 2)};
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertFalse(LIC.getLaunchInterceptorCondition0());
    }

    @Ignore
    @Test
    public void LIC0FalseDistanceEqualToLENGTH1(){
        int NUMPOINTS = 1;
        Parameters PARAMETERS = new Parameters();
        PARAMETERS.LENGTH1 = 2;
        Point[] POINTS = new Point[]{ new Point(1, 2), new Point(1, 2+PARAMETERS.LENGTH1)};
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertFalse(LIC.getLaunchInterceptorCondition0());
    }


    @Test
    public void distanceCorrect(){
        Point[] POINTS = new Point[]{ new Point(1, 2), new Point(1, 3)};
        int NUMPOINTS = 2;
        Parameters PARAMETERS = new Parameters();
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertEquals(1, LIC.distance(POINTS[0], POINTS[1]), 0.00001);
    }

    @Test
    public void distanceIncorrect(){
        Point[] POINTS = new Point[]{ new Point(1, 2), new Point(1, 3)};
        int NUMPOINTS = 2;
        Parameters PARAMETERS = new Parameters();
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertNotEquals(3, LIC.distance(POINTS[0], POINTS[1]), 0.00001);
    }

    @Test
    public void diagonalDistanceCorrect(){
        Point[] POINTS = new Point[]{ new Point(3, 3), new Point(0,-1)};
        int NUMPOINTS = 2;
        Parameters PARAMETERS = new Parameters();
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        assertEquals(5, LIC.distance(POINTS[0], POINTS[1]), 0.00001);

    }

}
