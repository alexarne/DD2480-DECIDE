package com.decide.app;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LICTest {

    @Test
    public void shouldAnswerWithTrue()
    {
        int NUMPOINTS = 1;
        Point[] POINTS = new Point[]{ new Point(1, 2) };
        Parameters PARAMETERS = new Parameters();
        LIC lic = new LIC(NUMPOINTS, POINTS, PARAMETERS);
        assertTrue(lic.LIC0());
    }

}
