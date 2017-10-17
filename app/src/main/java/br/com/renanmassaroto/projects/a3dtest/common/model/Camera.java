package br.com.renanmassaroto.projects.a3dtest.common.model;

import android.graphics.Paint;

import br.com.renanmassaroto.projects.a3dtest.first_version.CustomCanvas;

/**
 * Created by Appfactory on 31/05/16.
 */
public class Camera extends Entity {

    public Camera(Point3D position, Point3D rotation) {
        super(position, rotation, null, null);
    }
}
