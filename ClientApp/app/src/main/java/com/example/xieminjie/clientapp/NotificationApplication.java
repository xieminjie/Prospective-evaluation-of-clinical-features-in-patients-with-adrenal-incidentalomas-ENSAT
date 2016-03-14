package com.example.xieminjie.clientapp;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by xieminjie on 14/03/2016.
 */
public class NotificationApplication extends Application{
    public void getToast(String msg){
        Context context = getApplicationContext();
        CharSequence text = msg;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
