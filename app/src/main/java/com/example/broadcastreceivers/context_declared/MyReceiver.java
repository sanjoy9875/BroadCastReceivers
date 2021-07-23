package com.example.broadcastreceivers.context_declared;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        boolean isOn = intent.getBooleanExtra("state",false);
        if (isOn) {
            Toast.makeText(context, "airplane mode is on", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "airplane mode is off", Toast.LENGTH_SHORT).show();

        }
    }
}