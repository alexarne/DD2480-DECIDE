package com.decide.app;

import static org.junit.Assert.assertTrue;

import static org.junit.Assert.assertFalse;

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

}
