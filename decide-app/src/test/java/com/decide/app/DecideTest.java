package com.decide.app;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class DecideTest {
    Parameters PARAMETERS;

    @Before
    public void setUp() {
        PARAMETERS = new Parameters();
    }

    /**
     * ========================= [ LAUNCH ] ==========================
     */

    /**
     * Negative test case, ensure that the final launch decision is
     * false if not all elements in the Final Unlocking Vector are true.
     */
    @Test
    public void LaunchIsFalseIfFinalUnlockingVectorIsFalse() {
        Decide decide = new Decide();
        boolean[] FUV = new boolean[]{
            true,
            true,
            true,
            true,
            true,
            true,
            false,
            true,
            true,
            true,
            true,
            true,
            true,
            true,
            true,
        };
        assertFalse(decide.getLaunchDecision(FUV));
    }

    /**
     * Positive test case, ensure that the final launch decision is
     * true if all elements in the Final Unlocking Vector are true.
     */
    @Test
    public void LaunchIsTrueIfFinalUnlockingVectorIsTrue() {
        Decide decide = new Decide();
        boolean[] FUV = new boolean[]{
            true,
            true,
            true,
            true,
            true,
            true,
            true,
            true,
            true,
            true,
            true,
            true,
            true,
            true,
            true,
        };
        assertTrue(decide.getLaunchDecision(FUV));
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
