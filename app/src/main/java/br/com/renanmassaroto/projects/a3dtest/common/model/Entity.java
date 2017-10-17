package br.com.renanmassaroto.projects.a3dtest.common.model;

import android.graphics.Paint;
import android.support.annotation.Nullable;

import br.com.renanmassaroto.projects.a3dtest.first_version.CustomCanvas;
import br.com.renanmassaroto.projects.a3dtest.first_version.util.Matrix;

/**
 * Created by Appfactory on 31/05/16.
 */
public class Entity {

    @Nullable
    public Point3D position;

    @Nullable
    public Point3D rotation;

    @Nullable
    public Point3D scaling;

    @Nullable
    public Model model;

    public Entity() {
        super();
    }

    public Entity(@Nullable Point3D position, @Nullable Point3D rotation, @Nullable Point3D scaling, @Nullable Model model) {
        this.position = position;
        this.rotation = rotation;
        this.scaling = scaling;
        this.model = model;
    }
}
