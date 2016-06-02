package br.com.renanmassaroto.projects.a3dtest.util;

import android.util.Log;

import br.com.renanmassaroto.projects.a3dtest.model.Point3D;

/**
 * Created by Appfactory on 31/05/16.
 */
public class Matrix {

    public static final String TAG = "Matrix";

    public static Point3D transform(Point3D point3D, Point3D rotation, boolean applyProjection) {
        Point3D transformedPoint = point3D.clone();

        if (applyProjection) {
            return applyProjectionMatrix(
                    applyZRotationMatrix(
                            applyYRotationMatrix(
                                    applyXRotationMatrix(transformedPoint, rotation),
                                    rotation
                            ),
                            rotation
                    )
            );
        } else {
            return applyZRotationMatrix(
                            applyYRotationMatrix(
                                    applyXRotationMatrix(transformedPoint, rotation),
                                    rotation
                            ),
                            rotation
                    );
        }
    }

    public static Point3D applyXRotationMatrix(Point3D point3D, Point3D rotation) {
//        Log.d(TAG, "applyXRotationMatrix: before " + point3D.toString());

        Point3D transformedPoint = new Point3D(
                (float) (point3D.x * 1 + point3D.y * 0 + point3D.z * 0),
                (float) (point3D.x * 0 + point3D.y * Math.cos(rotation.x) + point3D.z * Math.sin(rotation.x)),
                (float) (point3D.x * 0 + point3D.y * (Math.sin(rotation.x) * -1) + point3D.z * Math.cos(rotation.x)),
                point3D.color
        );

//        Log.d(TAG, "applyXRotationMatrix: after " + transformedPoint.toString());

        return transformedPoint;
    }

    public static Point3D applyYRotationMatrix(Point3D point3D, Point3D rotation) {
//        Log.d(TAG, "applyYRotationMatrix: before " + point3D.toString());

        Point3D transformedPoint = new Point3D(
                (float) (point3D.x * Math.cos(rotation.y) + point3D.y * 0 + point3D.z * (Math.sin(rotation.y) * -1)),
                (float) (point3D.x * 0 + point3D.y * 1 + point3D.z * 0),
                (float) (point3D.x * Math.sin(rotation.y) + point3D.y * 0 + point3D.z * Math.cos(rotation.y)),
                point3D.color
        );

//        Log.d(TAG, "applyYRotationMatrix: after " + transformedPoint.toString());

        return transformedPoint;
    }

    public static Point3D applyZRotationMatrix(Point3D point3D, Point3D rotation) {
//        Log.d(TAG, "applyZRotationMatrix: before " + point3D.toString());

        Point3D transformedPoint = new Point3D(
                (float) (point3D.x * Math.cos(rotation.z) + point3D.y * Math.sin(rotation.z) + point3D.z * 0),
                (float) (point3D.x * (Math.sin(rotation.z) * -1) + point3D.y * Math.cos(rotation.z) + point3D.z * 0),
                (float) (point3D.x * 0 + point3D.y * 0 + point3D.z * 1),
                point3D.color
        );

//        Log.d(TAG, "applyZRotationMatrix: after " + transformedPoint.toString());

        return transformedPoint;
    }

    public static Point3D applyProjectionMatrix(Point3D point3D) {
//        Log.d(TAG, "applyProjectionMatrix: before " + point3D.toString());

        Point3D transformedPoint = new Point3D(
                (float) (point3D.x * 1 + point3D.y * 0 + point3D.z * 0),
                (float) (point3D.x * 0 + point3D.y * 1 + point3D.z * 0),
                (float) (point3D.x * 0 + point3D.y * 0 + point3D.z * 0),
                point3D.color
        );

//        Log.d(TAG, "applyProjectionMatrix: after " + transformedPoint.toString());

        return transformedPoint;
    }

    public static Point3D applyScalingMatrix(Point3D point3D, Point3D scaling) {
        Point3D transformedPoint = new Point3D(
                (float) (point3D.x * scaling.x + point3D.y * 0 + point3D.z * 0),
                (float) (point3D.x * 0 + point3D.y * scaling.y + point3D.z * 0),
                (float) (point3D.x * 0 + point3D.y * 0 + point3D.z * scaling.z),
                point3D.color
        );

        return transformedPoint;
    }
}
