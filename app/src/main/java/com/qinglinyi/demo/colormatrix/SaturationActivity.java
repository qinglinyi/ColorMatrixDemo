package com.qinglinyi.demo.colormatrix;

import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.SeekBar;

public class SaturationActivity extends AppCompatActivity {

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saturation);

        mImageView = (ImageView) findViewById(R.id.imageView);


        SeekBar saturationSb = (SeekBar) findViewById(R.id.saturationSb);

        saturationSb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                ColorMatrix matrix = new ColorMatrix();
                matrix.setSaturation(i);
                ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
                mImageView.setColorFilter(filter);
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
