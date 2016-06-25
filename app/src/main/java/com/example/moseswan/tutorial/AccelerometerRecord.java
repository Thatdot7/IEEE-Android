package com.example.moseswan.tutorial;

/**
 * Created by moseswan on 25/06/2016.
 */
public class AccelerometerRecord {

    public double x,y,z;

    public double getAngleofTilt() {

        double tilt = Math.acos(z/Math.sqrt(x*x + y*y + z*z));

        return tilt;
    }

    public String toString() {
        return "x=" + x + " y=" + y + " z=" + z;
    }
}
