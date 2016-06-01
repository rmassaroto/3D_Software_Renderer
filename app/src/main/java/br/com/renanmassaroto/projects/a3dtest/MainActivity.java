package br.com.renanmassaroto.projects.a3dtest;

import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.renanmassaroto.projects.a3dtest.model.Camera;
import br.com.renanmassaroto.projects.a3dtest.model.Entity;
import br.com.renanmassaroto.projects.a3dtest.model.Model;
import br.com.renanmassaroto.projects.a3dtest.model.Point3D;

public class MainActivity extends AppCompatActivity {

    private SurfaceView mSurfaceView;

    private SeekBar mXAxisSeekBar, mYAxisSeekBar, mZAxisSeekBar;
    private TextView mXAxisTextView, mYAxisTextView, mZAxisTextView;

    private Camera mCamera;
    public ArrayList<Entity> mEntities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSurfaceView = (SurfaceView) findViewById(R.id.surface_view);
        setXAxisControls();
        setYAxisControls();
        setZAxisControls();

        mCamera = new Camera(new Point3D(0, 0, 0), new Point3D(0, 0, 0));
        mSurfaceView.camera = mCamera;

        mEntities = new ArrayList<>();
        Model model = new Model();
        model.points = new Point3D[600];
        for (int i = 0; i < model.points.length; i++) {
            if (i < 200) {
                model.points[i] = new Point3D(i - 100, 0, 0, Color.parseColor("#FF0000"));
            } else if (i < 400) {
                model.points[i] = new Point3D(0, i - 300, 0, Color.parseColor("#00FF00"));
            } else {
                model.points[i] = new Point3D(0, 0, i - 500, Color.parseColor("#0000FF"));
            }
        }

        mEntities.add(new Entity(new Point3D(0, 0, 0), new Point3D(0, 0, 0), model, new Paint()));

        mSurfaceView.entities = new ArrayList<>();
        mSurfaceView.entities.add(mEntities.get(0));
    }

    private void setXAxisControls() {
        mXAxisSeekBar = (SeekBar) findViewById(R.id.axis_x_seek_bar);
        mXAxisTextView = (TextView) findViewById(R.id.axis_x_text_view);

        mXAxisSeekBar.setProgress(0);
        mXAxisSeekBar.setMax(360);
        mXAxisTextView.setText("0");
        mXAxisSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mCamera.rotation.x = (float) Math.toRadians(progress);
                mXAxisTextView.setText(Integer.toString(progress));
                mSurfaceView.invalidate();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void setYAxisControls() {
        mYAxisSeekBar = (SeekBar) findViewById(R.id.axis_y_seek_bar);
        mYAxisTextView = (TextView) findViewById(R.id.axis_y_text_view);

        mYAxisSeekBar.setProgress(0);
        mYAxisSeekBar.setMax(360);
        mYAxisTextView.setText("0");
        mYAxisSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mCamera.rotation.y = (float) Math.toRadians(progress);
                mYAxisTextView.setText(Integer.toString(progress));
                mSurfaceView.invalidate();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void setZAxisControls() {
        mZAxisSeekBar = (SeekBar) findViewById(R.id.axis_z_seek_bar);
        mZAxisTextView = (TextView) findViewById(R.id.axis_z_text_view);

        mZAxisSeekBar.setProgress(0);
        mZAxisSeekBar.setMax(360);
        mZAxisTextView.setText("0");
        mZAxisSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mCamera.rotation.z = (float) Math.toRadians(progress);
                mZAxisTextView.setText(Integer.toString(progress));
                mSurfaceView.invalidate();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
