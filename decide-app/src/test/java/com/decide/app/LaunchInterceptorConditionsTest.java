package com.decide.app;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

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

}
