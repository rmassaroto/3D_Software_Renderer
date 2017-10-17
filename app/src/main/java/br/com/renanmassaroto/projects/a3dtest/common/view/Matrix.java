package br.com.renanmassaroto.projects.a3dtest.common.view;

import br.com.renanmassaroto.projects.a3dtest.common.model.Point3D;

/**
 * Created by Renan Cardoso Massaroto on 12/04/17.
 */

public class Matrix {

    public static Point3D applyScalingMatrix(Point3D point3D, Point3D scaling) {
        
        Point3D transformedPoint = new Point3D(
                (float) (point3D.x * scaling.x + point3D.y * 0 + point3D.z * 0),
                (float) (point3D.x * 0 + point3D.y * scaling.y + point3D.z * 0),
                (float) (point3D.x * 0 + point3D.y * 0 + point3D.z * scaling.z),
                point3D.color
        );

        return transformedPoint;
    }

    public static Point3D applyTranslationMatrix(Point3D point3D, Point3D translation) {

        Point3D transformedPoint = new Point3D(
                (float) (point3D.x * 1 + point3D.y * 0 + point3D.z * 0 + 1 * translation.x),
                (float) (point3D.x * 0 + point3D.y * 1 + point3D.z * 0 + 1 * translation.y),
                (float) (point3D.x * 0 + point3D.y * 0 + point3D.z * 1 + 1 * translation.z),
                point3D.color
        );

        return transformedPoint;
    }

    public static Point3D applyXRotationMatrix(Point3D point3D, Point3D rotation) {

        Point3D transformedPoint = new Point3D(
                (float) (point3D.x * 1 + point3D.y * 0 + point3D.z * 0),
                (float) (point3D.x * 0 + point3D.y * Math.cos(rotation.x) + point3D.z * Math.sin(rotation.x)),
                (float) (point3D.x * 0 + point3D.y * (Math.sin(rotation.x) * -1) + point3D.z * Math.cos(rotation.x)),
                point3D.color
        );

        return transformedPoint;
    }

    public static Point3D applyYRotationMatrix(Point3D point3D, Point3D rotation) {

        Point3D transformedPoint = new Point3D(
                (float) (point3D.x * Math.cos(rotation.y) + point3D.y * 0 + point3D.z * (Math.sin(rotation.y) * -1)),
                (float) (point3D.x * 0 + point3D.y * 1 + point3D.z * 0),
                (float) (point3D.x * Math.sin(rotation.y) + point3D.y * 0 + point3D.z * Math.cos(rotation.y)),
                point3D.color
        );

        return transformedPoint;
    }

    public static Point3D applyZRotationMatrix(Point3D point3D, Point3D rotation) {

        Point3D transformedPoint = new Point3D(
                (float) (point3D.x * Math.cos(rotation.z) + point3D.y * Math.sin(rotation.z) + point3D.z * 0),
                (float) (point3D.x * (Math.sin(rotation.z) * -1) + point3D.y * Math.cos(rotation.z) + point3D.z * 0),
                (float) (point3D.x * 0 + point3D.y * 0 + point3D.z * 1),
                point3D.color
        );

        return transformedPoint;
    }

    public static Point3D applyProjectionMatrix(Point3D point3D) {

        Point3D transformedPoint = new Point3D(
                (float) (point3D.x * 1 + point3D.y * 0 + point3D.z * 0),
                (float) (point3D.x * 0 + point3D.y * 1 + point3D.z * 0),
                (float) (point3D.x * 0 + point3D.y * 0 + point3D.z * 0),
                point3D.color
        );

        return transformedPoint;
    }
}
