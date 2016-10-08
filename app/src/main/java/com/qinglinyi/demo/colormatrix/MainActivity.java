package com.qinglinyi.demo.colormatrix;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.setSaturation:
                startActivity(new Intent(this, SaturationActivity.class));
                break;
            case R.id.setScale:
                startActivity(new Intent(this, ScaleActivity.class));
                break;
            case R.id.setRotate:
                startActivity(new Intent(this, RotateActivity.class));
                break;
            default:

                break;
        }
    }
}
