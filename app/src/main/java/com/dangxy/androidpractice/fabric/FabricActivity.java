package com.dangxy.androidpractice.fabric;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.dangxy.androidpractice.R;

public class FabricActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fabric);
    }
    public void forceCrash(View view) {
        throw new RuntimeException("This is a crash");
    }

}
