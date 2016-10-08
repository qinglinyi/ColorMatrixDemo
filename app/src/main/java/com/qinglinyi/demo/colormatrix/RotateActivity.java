package com.qinglinyi.demo.colormatrix;

import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.SeekBar;

public class RotateActivity extends AppCompatActivity {

    private ImageView mImageView;
    private SeekBar rotateSb;
    private int axis = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotate);

        mImageView = (ImageView) findViewById(R.id.imageView);
        rotateSb = (SeekBar) findViewById(R.id.rotateSb);
        rotateSb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                setRotate(axis, progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        RadioGroup rg = (RadioGroup) findViewById(R.id.rg);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.r:
                        axis = 0;
                        break;
                    case R.id.g:
                        axis = 1;
                        break;
                    case R.id.b:
                        axis = 2;
                        break;
                }
                setRotate(axis, rotateSb.getProgress());
            }
        });
    }

    private void setRotate(int axis, float degrees) {
        ColorMatrix matrix = new ColorMatrix();
        matrix.setRotate(axis, degrees);
        mImageView.setColorFilter(new ColorMatrixColorFilter(matrix));
    }
}
