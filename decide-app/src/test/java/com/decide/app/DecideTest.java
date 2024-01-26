package com.decide.app;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class DecideTest {
    Parameters PARAMETERS;

    @Before
    public void setUp() {
        PARAMETERS = new Parameters();
    }

    @Test
    public void shouldAnswerWithTrue() {
        Point[] POINTS = new Point[]{
            new Point(1, 2)
        };
        int NUMPOINTS = POINTS.length;
        PARAMETERS.AREA1 = 1.0;
        Connector[][] LCM = new Connector[][]{{ Connector.ANDD }};
        boolean[] PUV = new boolean[]{ false };
        Decide decide = new Decide(NUMPOINTS, POINTS, PARAMETERS, LCM, PUV);
        assertTrue(decide.DECIDE());
    }
}
