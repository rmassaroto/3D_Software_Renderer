package br.com.renanmassaroto.projects.a3dtest.model;

import android.graphics.Canvas;
import android.graphics.Paint;

import br.com.renanmassaroto.projects.a3dtest.CustomCanvas;

/**
 * Created by Appfactory on 31/05/16.
 */
public class Camera extends Entity {

    public Camera() {
        super();
    }

    public Camera(Point3D position, Point3D rotation) {
        super(position, rotation, null, new Paint());
    }

    @Override
    public void onDraw(CustomCanvas canvas, Camera camera) {

    }
}
