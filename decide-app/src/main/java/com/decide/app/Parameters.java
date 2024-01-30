package com.decide.app;

public class Parameters {
    public double LENGTH1;         // Length in LICs 0, 7, 12
    public double RADIUS1;         // Radius in LICs 1, 8, 13
    public double EPSILON;         // Deviation from PI in LICs 2, 9
    public double AREA1;           // Area in LICs 3, 10, 14
    public int Q_PTS;              // No. of consecutive points in LIC 4
    public int QUADS;              // No. of quadrants in LIC 4
    public double DIST;            // Distance in LIC 6
    public int N_PTS;              // No. of consecutive pts. in LIC 6
    public int K_PTS;              // No. of int. pts. in LICs 7, 12
    public int A_PTS;              // No. of int. pts. in LICs 8, 13
    public int B_PTS;              // No. of int. pts. in LICs 8, 13
    public int C_PTS;              // No. of int. pts. in LIC 9
    public int D_PTS;              // No. of int. pts. in LIC 9
    public int E_PTS;              // No. of int. pts. in LICs 10, 14
    public int F_PTS;              // No. of int. pts. in LICs 10, 14
    public int G_PTS;              // No. of int. pts. in LIC 11
    public double LENGTH2;         // Maximum length in LIC 12
    public double RADIUS2;         // Maximum radius in LIC 13
    public double AREA2;           // Maximum area in LIC 14

    public Parameters() {
        // Default assignments, assumes lowest value if 0 is not allowed
        LENGTH1 = 0;
        RADIUS1 = 0;
        EPSILON = 0;
        AREA1 = 0;
        Q_PTS = 0;
        QUADS = 0;
        DIST = 0;
        N_PTS = 1;
        K_PTS = 1;
        A_PTS = 1;
        B_PTS = 1;
        C_PTS = 1;
        D_PTS = 1;
        E_PTS = 1;
        F_PTS = 1;
        G_PTS = 1;
        LENGTH2 = 0;
        RADIUS2 = 0;
        AREA2 = 0;
    }
}
