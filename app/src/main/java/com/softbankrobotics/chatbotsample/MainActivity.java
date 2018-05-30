/*
 *  Copyright (C) 2018 Softbank Robotics Europe
 *  See COPYING for the license
 */
package com.softbankrobotics.chatbotsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.aldebaran.qi.sdk.QiSDK;

/**
 * Main activity of the application.
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    Robot robot = new Robot();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // In this sample, instead of implementing robotlicycle callbacks in the main activity,
        // we delegate them to a robot dedicated class.

        QiSDK.register(this, robot);
    }

    @Override
    protected void onDestroy() {
        QiSDK.unregister(this, robot);
        super.onDestroy();
    }

}
