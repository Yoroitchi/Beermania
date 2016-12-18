package com.example.leguern_boy_33.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by r1leg on 14/11/2016.
 */
public class BierUpdate extends BroadcastReceiver {

        CheckDownload listener;
        public BierUpdate(CheckDownload listener){
            this.listener = listener;
        }

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,R.string.fin,Toast.LENGTH_SHORT).show();
        listener.DlFinished();
    }
}
