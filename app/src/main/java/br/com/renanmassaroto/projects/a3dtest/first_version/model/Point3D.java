package br.com.renanmassaroto.projects.a3dtest.first_version.model;

import android.graphics.Color;

/**
 * Created by Renan Cardoso Massaroto on 29/05/2016.
 */
public class Point3D {

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
//        return Math.sqrt(x * point3D.x + y * point3D.y + z * point3D.z);
        return Math.sqrt(Math.pow(point3D.x - x, 2) + Math.pow(point3D.y - y, 2) + Math.pow(point3D.z - z, 2));
    }
}