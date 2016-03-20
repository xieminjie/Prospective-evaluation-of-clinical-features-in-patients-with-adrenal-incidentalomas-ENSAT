package com.example.xieminjie.clientapp;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by xieminjie on 20/03/2016.
 */
public class IOStorageHandler {
    public static void printLog(String fs,String str,Context context){
        String filename = fs;
        String string = str;
        FileOutputStream outputStream;
        FileInputStream inputStream;
        try {
            outputStream = context.openFileOutput(filename, Context.MODE_APPEND);
            outputStream.write(string.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String readLog(String fs,Context context){
        FileInputStream inputStream;
        String data="";
        try{
            inputStream = context.openFileInput(fs);
            int c;
            while( (c = inputStream.read()) != -1){
                data = data + Character.toString((char)c);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return data;
    }

}
