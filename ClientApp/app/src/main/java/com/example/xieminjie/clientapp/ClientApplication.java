package com.example.xieminjie.clientapp;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import java.net.URISyntaxException;
import io.socket.client.IO;
import io.socket.client.Socket;

/**
 * Created by xieminjie on 3/03/2016.
 */
public class ClientApplication extends Application {
    private Socket socket;
    {
        try {
            socket = IO.socket(Params.CHAT_SERVER_URL);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
    public Socket getSocket(){
        return socket;
    }
    public void getToast(String msg){
        Context context = getApplicationContext();
        CharSequence text = msg;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
