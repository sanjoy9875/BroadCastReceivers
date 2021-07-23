package com.example.broadcastreceivers.long_running_task;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

public class MyReceiver extends BroadcastReceiver {

    /**
     * currently onReceive() method gives us 16 milliseconds of time to do our work.
     * if you want to do some long running task then you can use async task with pending result.
     **/

    @Override
    public void onReceive(Context context, Intent intent) {

        PendingResult pendingResult = goAsync();
        new Task(pendingResult,intent).execute();

    }

    private static class Task extends AsyncTask<Void,Void,Void>{

        PendingResult pendingResult;
        Intent intent;

        public Task(PendingResult pendingResult,Intent intent){
            this.pendingResult=pendingResult;
            this.intent=intent;
        }


        @Override
        protected Void doInBackground(Void... voids) {

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            pendingResult.finish();
        }
    }
}

