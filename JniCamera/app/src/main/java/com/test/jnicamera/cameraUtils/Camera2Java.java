package com.test.jnicamera.cameraUtils;


import android.app.Activity;
import android.os.Bundle;

import com.test.jnicamera.R;

public class Camera2Java extends Activity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        if (null == savedInstanceState) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.container, new Camera2RawFragment())
                    .commit();
        }
    }

}
