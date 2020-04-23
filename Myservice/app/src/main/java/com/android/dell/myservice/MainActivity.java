package com.android.dell.myservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent();
        //intent.setAction("com.android.dell.myservice.aidl");
        intent.setClassName("com.android.dell.myservice","com.android.dell.myservice.MyService");
        startService(intent);
    }
}
