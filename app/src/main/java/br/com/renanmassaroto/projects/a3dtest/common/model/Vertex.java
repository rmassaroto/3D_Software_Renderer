package br.com.renanmassaroto.projects.a3dtest.common.model;

import android.graphics.Matrix;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by Appfactory on 31/05/16.
 */
public class Vertex {

    @NonNull
    public Point3D point1;
    public Point3D point2;

    @Nullable
    public Point3D[] points;

    public Vertex(@NonNull Point3D point1, Point3D point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public void calculatePoints() {

        float x1 = point1.x;
        float x2 = point2.x;

        float y1 = point1.y;
        float y2 = point2.y;

        float z1 = point1.z;
        float z2 = point2.z;

        double distance = point1.getDistance(point2);
        float factor = 0.5f;
        int index = 0;

        try {
            points = new Point3D[(int) distance + 2];
            points[index] = point1;
            points[points.length - 1] = point2;

            index++;

            while (distance > 0) {
                Point3D newPoint = new Point3D(
                        (x1 != x2 ? (x1 > x2 ? x1 - factor : x1 + factor) : x1),
                        (y1 != y2 ? (y1 > y2 ? y1 - factor : y1 + factor) : y1),
                        (z1 != z2 ? (z1 > z2 ? x1 - factor : z1 + factor) : z1)
                );

                points[index] = newPoint;

                factor = factor + 0.5f;
                index++;
                distance = distance - 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
