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
    private static final String FILE_HEADER_USER_LOG = "problem,ill,palpitations,weight_gain,high_blood_pressure," +
            "muscle_weakness,sweating,flushing,headache,chest_pain,back_pain,bruising,fatigue,panic,sadness," +
            "user_record,record_date";
    private static final String FILE_HEADER_USERID = "USERID";
    public static void printUserID(String fs,String userID,Context context){
        String filename = fs;
        FileOutputStream outputStream;
        try{
            outputStream = context.openFileOutput(filename,Context.MODE_PRIVATE);
            outputStream.write(userID.getBytes());
            outputStream.flush();
            outputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static String readUserID(String fs,Context context){
        FileInputStream inputStream;
        String data="";
        try{
            inputStream = context.openFileInput(fs);
            int c;
            while( (c = inputStream.read()) != -1){
                data = data + Character.toString((char)c);
            }
            Log.d("myActivity", "userID " + data);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return data;
    }
    public static void printRecordLog(String fs,Context context){
        String filename = fs;
        FileOutputStream outputStream;
        try {
            outputStream = context.openFileOutput(filename, Context.MODE_APPEND);
            outputStream.write(FILE_HEADER_USER_LOG.getBytes());
            outputStream.write(NEW_LINE_SEPARATOR.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String readRecordLog(String fs,Context context){
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

}
