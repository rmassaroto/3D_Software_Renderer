package br.com.renanmassaroto.projects.a3dtest.first_version.model;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import br.com.renanmassaroto.projects.a3dtest.first_version.CustomCanvas;
import br.com.renanmassaroto.projects.a3dtest.first_version.util.Matrix;


/**
 * Created by Renan Cardoso Massaroto on 31/05/16.
 */
public class Entity {

    public Point3D position, rotation, scaling;
    public Model model;

    public Paint paint;

    public Entity() {
        super();
    }

    public Entity(Point3D position, Point3D rotation, Point3D scaling, Model model, Paint paint) {
        this.position = position;
        this.rotation = rotation;
        this.scaling = scaling;
        this.model = model;
        this.paint = paint;
    }

    public void onDraw(CustomCanvas canvas, Camera camera) {
        try {
            for (Point3D point : model.points) {
                paint.setColor(point.color);

//                Point3D newPosition = Matrix.applyPerspectiveProjectionMatrix(position, camera);
//                Point3D transformedPoint = Matrix.applyTranslationMatrix(point, newPosition);

                Point3D transformedPoint = Matrix.applyScalingMatrix(point, scaling);
                transformedPoint = Matrix.transform(transformedPoint, this.rotation, false);
                transformedPoint = Matrix.applyTranslationMatrix(transformedPoint, position);

                double distance = transformedPoint.getDistance(camera.position);

                transformedPoint = Matrix.applyProjectionMatrix(transformedPoint);

                int x = Math.round(transformedPoint.x + (canvas.canvas.getWidth() / 2));
                int y = Math.round(transformedPoint.y + (canvas.canvas.getHeight() / 2));

                Double pixelDistance = canvas.distances[x][y];

                if (pixelDistance == null || distance < pixelDistance) {
                    canvas.distances[x][y] = distance;

                    canvas.canvas.drawCircle(x, y, 1, paint);
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
    }
}