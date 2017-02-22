package com.example.sp.shahezaddemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by SP on 2/22/17.
 */

public class StandardModeActivity extends MainActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        int viewId = v.getId();
        switch (viewId) {
            case R.id.standard:
                startActivity(new Intent(this, StandardModeActivity.class));
                break;

            case R.id.singleTop:
                startActivity(new Intent(this, SingleTopActivity.class));
                break;

            case R.id.singleInstance:
                startActivity(new Intent(this, SingleInstanceActivity.class));
                break;

            case R.id.singleTask:
                startActivity(new Intent(this, SingleTaskActivity.class));
                break;


        }


    }
}
