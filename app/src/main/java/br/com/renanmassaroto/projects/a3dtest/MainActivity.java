package br.com.renanmassaroto.projects.a3dtest;

import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.renanmassaroto.projects.a3dtest.model.Camera;
import br.com.renanmassaroto.projects.a3dtest.model.Entity;
import br.com.renanmassaroto.projects.a3dtest.model.Model;
import br.com.renanmassaroto.projects.a3dtest.model.Point3D;

public class MainActivity extends AppCompatActivity {

    private SurfaceView mSurfaceView;

    private SeekBar mObjectXAxisSeekBar, mObjectYAxisSeekBar, mObjectZAxisSeekBar,
            mCameraXAxisSeekBar, mCameraYAxisSeekBar, mCameraZAxisSeekBar;
    private TextView mObjectXAxisTextView, mObjectYAxisTextView, mObjectZAxisTextView,
            mCameraXAxisTextView, mCameraYAxisTextView, mCameraZAxisTextView, mScalingTextView;
    private Button mMinusScalingButton, mPlusScalingButton;

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

        mCamera = new Camera(new Point3D(0, 0, -500), new Point3D(0, 0, 0));
        mSurfaceView.camera = mCamera;

        mEntities = new ArrayList<>();
        Model model = new Model();


        int totalPoints = 25;

        model.points = new Point3D[(totalPoints * totalPoints) * 6];

        int index = 0;
        for (int row = 0; row < totalPoints; row++) {
            for (int col = 0; col < totalPoints; col++) {
                model.points[index] = new Point3D(row - (totalPoints / 2), col - (totalPoints / 2), (totalPoints / 2), Color.RED);

                index++;
            }
        }

        for (int row = 0; row < totalPoints; row++) {
            for (int col = 0; col < totalPoints; col++) {
                model.points[index] = new Point3D(row - (totalPoints / 2), col - (totalPoints / 2), -(totalPoints / 2), Color.BLUE);

                index++;
            }
        }

        for (int row = 0; row < totalPoints; row++) {
            for (int col = 0; col < totalPoints; col++) {
                model.points[index] = new Point3D((totalPoints / 2), row - (totalPoints / 2), col - (totalPoints / 2), Color.YELLOW);

                index++;
            }
        }

        for (int row = 0; row < totalPoints; row++) {
            for (int col = 0; col < totalPoints; col++) {
                model.points[index] = new Point3D(-(totalPoints / 2), row - (totalPoints / 2), col - (totalPoints / 2), Color.GREEN);

                index++;
            }
        }

        for (int row = 0; row < totalPoints; row++) {
            for (int col = 0; col < totalPoints; col++) {
                model.points[index] = new Point3D(row - (totalPoints / 2), -(totalPoints / 2), col - (totalPoints / 2), Color.BLACK);

                index++;
            }
        }

        for (int row = 0; row < totalPoints; row++) {
            for (int col = 0; col < totalPoints; col++) {
                model.points[index] = new Point3D(row - (totalPoints / 2), (totalPoints / 2), col - (totalPoints / 2), Color.CYAN);

                index++;
            }
        }

        mEntities.add(new Entity(new Point3D(0, 0, 0), new Point3D(0, 0, 0), new Point3D(4, 4, 4), model, new Paint()));

        mSurfaceView.entities = new ArrayList<>();
        mSurfaceView.entities.add(mEntities.get(0));
    }

    private void setXAxisControls() {
        mObjectXAxisSeekBar = (SeekBar) findViewById(R.id.object_axis_x_seek_bar);
        mObjectXAxisTextView = (TextView) findViewById(R.id.object_axis_x_text_view);

        mObjectXAxisSeekBar.setProgress(0);
        mObjectXAxisSeekBar.setMax(360);
        mObjectXAxisTextView.setText("0");
        mObjectXAxisSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mEntities.get(0).rotation.x = (float) Math.toRadians(progress);
                mObjectXAxisTextView.setText(Integer.toString(progress));
                mSurfaceView.invalidate();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mCameraXAxisSeekBar = (SeekBar) findViewById(R.id.camera_axis_x_seek_bar);
        mCameraXAxisTextView = (TextView) findViewById(R.id.camera_axis_x_text_view);

        mCameraXAxisSeekBar.setProgress(0);
        mCameraXAxisSeekBar.setMax(360);
        mCameraXAxisTextView.setText("0");
        mCameraXAxisSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mCamera.rotation.x = (float) Math.toRadians(progress);
                mCameraXAxisTextView.setText(Integer.toString(progress));
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
        mObjectYAxisSeekBar = (SeekBar) findViewById(R.id.object_axis_y_seek_bar);
        mObjectYAxisTextView = (TextView) findViewById(R.id.object_axis_y_text_view);

        mObjectYAxisSeekBar.setProgress(0);
        mObjectYAxisSeekBar.setMax(360);
        mObjectYAxisTextView.setText("0");
        mObjectYAxisSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mEntities.get(0).rotation.y = (float) Math.toRadians(progress);
                mObjectYAxisTextView.setText(Integer.toString(progress));
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
        mObjectZAxisSeekBar = (SeekBar) findViewById(R.id.object_axis_z_seek_bar);
        mObjectZAxisTextView = (TextView) findViewById(R.id.object_axis_z_text_view);

        mObjectZAxisSeekBar.setProgress(0);
        mObjectZAxisSeekBar.setMax(360);
        mObjectZAxisTextView.setText("0");
        mObjectZAxisSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mEntities.get(0).rotation.z = (float) Math.toRadians(progress);
                mObjectZAxisTextView.setText(Integer.toString(progress));
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
