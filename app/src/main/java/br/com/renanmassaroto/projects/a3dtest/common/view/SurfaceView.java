package br.com.renanmassaroto.projects.a3dtest.common.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;

import br.com.renanmassaroto.projects.a3dtest.common.model.Point3D;

/**
 * Created by Renan Cardoso Massaroto on 12/04/17.
 */

public class SurfaceView extends View {

    private boolean isDrawing = false;

    private Paint paint = new Paint();

    @NonNull
    public Point3D[] points;

    public SurfaceView(Context context) {
        super(context);

        points = new Point3D[0];
    }

    public SurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);

        points = new Point3D[0];
    }

    public SurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        points = new Point3D[0];
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SurfaceView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        points = new Point3D[0];
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        isDrawing = true;

        paint.setColor(Color.WHITE);
        canvas.drawRect(0, 0, canvas.getWidth() - 1, canvas.getHeight() - 1, paint);

        //Draw here
        for (Point3D point : points) {
            Point3D translatedPoint = Matrix.applyTranslationMatrix(point, new Point3D(canvas.getWidth() / 2, canvas.getHeight() / 2, 0));
            Point3D correctedPoint = getCorrectedPoint(canvas, translatedPoint);

            paint.setColor(correctedPoint.color);

            canvas.drawCircle(correctedPoint.x, correctedPoint.y, 1, paint);
        }

        isDrawing = false;
    }

    private Point3D getCorrectedPoint(@NonNull Canvas canvas, @NonNull Point3D point3D) {

    }
}
