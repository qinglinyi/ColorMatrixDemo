package com.qinglinyi.demo.colormatrix;

import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.SeekBar;

public class ScaleActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private ImageView mImageView;
    private SeekBar mRedSb;
    private SeekBar mGreenSb;
    private SeekBar mBlueSb;
    private SeekBar mAlphaSb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale);
        mImageView = (ImageView) findViewById(R.id.imageView);

        mRedSb = (SeekBar) findViewById(R.id.redSb);
        mGreenSb = (SeekBar) findViewById(R.id.greenSb);
        mBlueSb = (SeekBar) findViewById(R.id.blueSb);
        mAlphaSb = (SeekBar) findViewById(R.id.alphaSb);

        mRedSb.setOnSeekBarChangeListener(this);
        mGreenSb.setOnSeekBarChangeListener(this);
        mBlueSb.setOnSeekBarChangeListener(this);
        mAlphaSb.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        float progressR = mRedSb.getProgress() / 128f;// 0~2
        float progressG = mGreenSb.getProgress() / 128f;
        float progressB = mBlueSb.getProgress() / 128f;
        float progressA = mAlphaSb.getProgress() / 128f;

        ColorMatrix matrix = new ColorMatrix();
        matrix.setScale(progressR,progressG,progressB,progressA);

        //        float[] src = new float[]{
        //                progressR, 0, 0, 0, 0,
        //                0, progressG, 0, 0, 0,
        //                0, 0, progressB, 0, 0,
        //                0, 0, 0, progressA, 0};

        ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
        mImageView.setColorFilter(filter);

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
