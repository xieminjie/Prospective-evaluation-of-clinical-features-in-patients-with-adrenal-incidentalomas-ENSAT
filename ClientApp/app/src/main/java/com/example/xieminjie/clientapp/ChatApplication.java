package com.example.xieminjie.clientapp;

import android.app.Application;
import java.net.URISyntaxException;
import io.socket.client.IO;
import io.socket.client.Socket;

/**
 * Created by xieminjie on 3/03/2016.
 */
public class ChatApplication extends Application {
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
}
