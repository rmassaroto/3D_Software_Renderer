package br.com.renanmassaroto.projects.a3dtest.first_version;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

import br.com.renanmassaroto.projects.a3dtest.first_version.model.Camera;
import br.com.renanmassaroto.projects.a3dtest.first_version.model.Entity;


/**
 * Created by Renan Cardoso Massaroto on 29/05/2016.
 */
public class SurfaceView extends View {

    public static final int ROTATION_X = 180;
    public static final int ROTATION_Y = 0;
    public static final int ROTATION_Z = 0;

    public static final String TAG = "SurfaceView";

    float x, y, z;

    private Paint mPaint;

    public Camera camera;
    public ArrayList<Entity> entities;

    public SurfaceView(Context context) {
        super(context);

        x = (float) Math.toRadians(ROTATION_X);
        y = (float) Math.toRadians(ROTATION_Y);
        z = (float) Math.toRadians(ROTATION_Z);

        mPaint = new Paint();
    }

    public SurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);

        x = (float) Math.toRadians(ROTATION_X);
        y = (float) Math.toRadians(ROTATION_Y);
        z = (float) Math.toRadians(ROTATION_Z);

        mPaint = new Paint();
    }

    public SurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        x = (float) Math.toRadians(ROTATION_X);
        y = (float) Math.toRadians(ROTATION_Y);
        z = (float) Math.toRadians(ROTATION_Z);

        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setColor(Color.WHITE);
        canvas.drawRect(0, 0, canvas.getWidth() - 1, canvas.getHeight() - 1, mPaint);

//        mPaint.setColor(Color.RED);
//        canvas.drawCircle(canvas.getWidth() / 2, canvas.getHeight() / 2, 10, mPaint);

        if (entities != null && camera != null) {
            for (Entity entity : entities) {
                CustomCanvas customCanvas = new CustomCanvas();
                customCanvas.canvas = canvas;
                customCanvas.distances = new Double[canvas.getWidth()][canvas.getHeight()];

                entity.onDraw(customCanvas, camera);
            }
        }

    }

    public void setRotationX(float rotation) {
        x = rotation;
    }
}
