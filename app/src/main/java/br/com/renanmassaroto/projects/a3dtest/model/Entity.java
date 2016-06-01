package br.com.renanmassaroto.projects.a3dtest.model;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import br.com.renanmassaroto.projects.a3dtest.CustomCanvas;
import br.com.renanmassaroto.projects.a3dtest.util.Matrix;

/**
 * Created by Appfactory on 31/05/16.
 */
public class Entity {

    public Point3D position, rotation;
    public Model model;

    public Paint paint;

    public Entity() {
        super();
    }

    public Entity(Point3D position, Point3D rotation, Model model, Paint paint) {
        this.position = position;
        this.rotation = rotation;
        this.model = model;
        this.paint = paint;
    }

    public void onDraw(CustomCanvas canvas, Camera camera) {
        for (Point3D point : model.points) {
            paint.setColor(point.color);

            Point3D relativeTransformedPoint = Matrix.transform(point, this.rotation, false);

            Point3D unfinishedPoint = Matrix.transform(relativeTransformedPoint, camera.rotation, false);
            Point3D finishedPoint = Matrix.transform(relativeTransformedPoint, camera.rotation, true);

            int x = (int) finishedPoint.x + (canvas.canvas.getWidth() / 2);
            int y = (int) finishedPoint.y + (canvas.canvas.getHeight() / 2);

            double distance = unfinishedPoint.getDistance(camera.position);
            Double pixelDistance = canvas.distances[x][y];

            if (pixelDistance == null || distance < pixelDistance) {
                canvas.distances[x][y] = distance;

                canvas.canvas.drawCircle(finishedPoint.x + (canvas.canvas.getWidth() / 2), finishedPoint.y + (canvas.canvas.getHeight() / 2), 10, paint);
            }
        }
    }
}