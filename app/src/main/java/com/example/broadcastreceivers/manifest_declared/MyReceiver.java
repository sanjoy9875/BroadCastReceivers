package com.example.broadcastreceivers.manifest_declared;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

//        String action = intent.getAction();
//        Toast.makeText(context,action,Toast.LENGTH_SHORT).show();

        String time_zone = intent.getStringExtra("time-zone");
        Toast.makeText(context,time_zone,Toast.LENGTH_SHORT).show();



    }
}