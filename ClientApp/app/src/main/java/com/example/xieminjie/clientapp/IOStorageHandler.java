package com.example.xieminjie.clientapp;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by xieminjie on 20/03/2016.
 */
public class IOStorageHandler {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String FILE_HEADER_DATE = "DATE";
    private static final String FILE_HEADER_USER_LOG = "USERID,DATE";
    public static void printUserIDLog(String fs,String userID,String date,Context context){
        String filename = fs;
        String userid = userID;
        String adate = date;
        FileOutputStream outputStream;
        try {
            outputStream = context.openFileOutput(filename, Context.MODE_APPEND);
            //outputStream.write(FILE_HEADER_USER_LOG.getBytes());
            outputStream.write(userid.getBytes());
            outputStream.write(COMMA_DELIMITER.getBytes());
            outputStream.write(adate.getBytes());
            outputStream.write(NEW_LINE_SEPARATOR.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String readUserIDLog(String fs,Context context){
        FileInputStream inputStream;
        String data="";
        try{
            inputStream = context.openFileInput(fs);
            int c;
            while( (c = inputStream.read()) != -1){
                data = data + Character.toString((char)c);
            }
            Log.d("myActivity","userID "+data);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return data;
    }
    public static void printLog(String fs,String str,Context context){

        String filename = fs;
        String string = str;
        FileOutputStream outputStream;
        try {
            outputStream = context.openFileOutput(filename, Context.MODE_APPEND);
            outputStream.write(string.getBytes());
            outputStream.write(NEW_LINE_SEPARATOR.getBytes());
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
            Log.d("myActivity","This is "+data);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return data;
    }

}
