package br.com.renanmassaroto.projects.a3dtest;

import android.graphics.Canvas;
import android.util.Log;

import br.com.renanmassaroto.projects.a3dtest.model.Point3D;

/**
 * Created by Appfactory on 31/05/16.
 */
public class CustomCanvas {

    public static final String TAG = "CustomCanvas";

    public Canvas canvas;
    public Double[][] distances;

    public CustomCanvas () {
        super();
    }

    public void printDistanceMap() {
        if (distances != null) {
            for (int row = 0; row < distances.length; row++) {
                for (int col = 0; col < distances[row].length; col++) {
                    if (distances[row][col] != null) {
                        Log.d(TAG, "printDistanceMap: distances[" + Integer.toString(row) +
                                "][" + Integer.toString(col) + "] = " + Double.toString(distances[row][col]));
                    } else {
//                        rowLog = rowLog + ";" + Double.toString(-1);
                    }
                }
            }
        }
    }
}
