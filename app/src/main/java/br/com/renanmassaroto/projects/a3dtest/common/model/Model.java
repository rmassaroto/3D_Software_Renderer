package br.com.renanmassaroto.projects.a3dtest.common.model;

import android.support.annotation.NonNull;

/**
 * Created by Appfactory on 31/05/16.
 */
public class Model {

    @NonNull
    public Vertex[] vertices;

    public Model(@NonNull Vertex[] vertices) {
        this.vertices = vertices;
    }
}
