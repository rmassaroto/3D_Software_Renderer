package br.com.renanmassaroto.projects.a3dtest.common.model;

import android.graphics.Color;
import android.util.Log;

/**
 * Created by Renan Cardoso Massaroto on 29/05/2016.
 */
public class Point3D {

    private static final String TAG = "Point3D";

    public float x, y, z;
    public int color;

    public Point3D(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.color = Color.TRANSPARENT;
    }

    public Point3D(float x, float y, float z, int color) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.color = color;
    }

    public Point3D clone() {
        return new Point3D(x, y, z, color);
    }

    @Override
    public String toString() {
        return "(" + Double.toString(x) + ", " + Double.toString(y) + ", " + Double.toString(z) + ")";
    }

    public double getDistance(Point3D point3D) {
        Log.d(TAG, "Distance betwen this point [" + toString() + "] and point [" + point3D.toString() + "]");

        return Math.sqrt(
                Math.pow(x - point3D.x, 2) + Math.pow(y - point3D.y, 2) + Math.pow(z - point3D.z, 2)
        );
    }
}
