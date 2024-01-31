package com.decide.app;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DecideTest 
{
    @Test
    public void shouldAnswerWithTrue()
    {
        int NUMPOINTS = 3;
        Point[] POINTS = new Point[]{ new Point(1, 2),new Point(-1, 2),new Point(1, -2) };
        Parameters PARAMETERS = new Parameters();
        PARAMETERS.AREA1 = 1.0;
        Connector[][] LCM = new Connector[][]{{ Connector.ANDD }};
        boolean[] PUV = new boolean[]{ true };
        Decide decide = new Decide(NUMPOINTS, POINTS, PARAMETERS, LCM, PUV);
        assertTrue(decide.DECIDE());
    }
}
