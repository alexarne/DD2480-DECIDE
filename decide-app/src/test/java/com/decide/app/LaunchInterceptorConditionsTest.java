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


    @Ignore
    @Test
    public void positiveLIC1Test() {
        // Setup
        Parameters PARAMETERS = new Parameters();
        PARAMETERS.RADIUS1 = 4.0;
        int NUMPOINTS = 3;
        Point[] POINTS = new Point[]{ new Point(1, 2), new Point(3, 4), new Point(4, 4) };
        
        // Processing
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        
        // Assertion
        assertTrue(LIC.getLaunchInterceptorCondition1());
    }

    @Ignore
    @Test
    public void negativeLIC1Test() {
        // Setup
        Parameters PARAMETERS = new Parameters();
        PARAMETERS.RADIUS1 = 2.0;
        int NUMPOINTS = 4;
        Point[] POINTS = new Point[]{ new Point(6, 1), new Point(5, 2.5), new Point(3, 5), new Point(0, 0) };
        
        // Processing
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        
        // Assertion
        assertFalse(LIC.getLaunchInterceptorCondition1());
    }

    @Ignore
    @Test
    public void edgeCasePointsOnCircleExtremitiesLIC1Test() {
        // Setup
        Parameters PARAMETERS = new Parameters();
        PARAMETERS.RADIUS1 = 3.0;
        int NUMPOINTS = 3;
        Point[] POINTS = new Point[]{ new Point(4, 4), new Point(4, 1), new Point(1, 4) };
        
        // Processing
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        
        // Assertion
        assertTrue(LIC.getLaunchInterceptorCondition1());
    }

    @Ignore
    @Test
    public void incoherentInputLIC1Test() {
        // Setup
        Parameters PARAMETERS = new Parameters();
        PARAMETERS.RADIUS1 = 4.0;
        int NUMPOINTS = 3;
        Point[] POINTS = new Point[]{ new Point(1, 2), new Point(3, 4) };
        
        // Processing
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        
        // Assertion
        assertFalse(LIC.getLaunchInterceptorCondition1());  // May be changed for an Exception raised
    }

    @Ignore
    @Test
    public void unsufficientInputLIC1Test() {
        // Setup
        Parameters PARAMETERS = new Parameters();
        PARAMETERS.RADIUS1 = 10.0;
        int NUMPOINTS = 2;
        Point[] POINTS = new Point[]{ new Point(1, 2), new Point(3, 4) };
        
        // Processing
        LaunchInterceptorConditions LIC = new LaunchInterceptorConditions(NUMPOINTS, POINTS, PARAMETERS);
        
        // Assertion
        assertFalse(LIC.getLaunchInterceptorCondition1());
    }

}
