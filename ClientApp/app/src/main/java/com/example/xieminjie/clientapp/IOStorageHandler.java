package com.example.xieminjie.clientapp;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Created by xieminjie on 20/03/2016.
 */
public class IOStorageHandler {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String FILE_HEADER_USER_LOG = "problem,ill,palpitations,weight_gain,high_blood_pressure," +
            "muscle_weakness,sweating,flushing,headache,chest_pain,back_pain,bruising,fatigue,panic,sadness," +
            "record_date";
    private static final String FILE_HEADER_USERID = "USERID";
    public static DateHandler dateHandler;
    public static void printUserID(String fs,String userID,Context context){
        String filename = fs;
        FileOutputStream outputStream;
        try{
            outputStream = context.openFileOutput(filename, Context.MODE_PRIVATE);
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
    public static void printRecordLog(String fs,Message message,Context context){
        String filename = fs;
        FileOutputStream outputStream;
        try {
            outputStream = context.openFileOutput(filename, Context.MODE_APPEND);
          /*  outputStream.write(FILE_HEADER_USER_LOG.getBytes());
            outputStream.write(NEW_LINE_SEPARATOR.getBytes());*/
            outputStream.write(String.valueOf(message.getProblem()).getBytes());
            outputStream.write(COMMA_DELIMITER.getBytes());
            outputStream.write(String.valueOf(message.getIll()).getBytes());
            outputStream.write(COMMA_DELIMITER.getBytes());
            outputStream.write(String.valueOf(message.getPalpitations()).getBytes());
            outputStream.write(COMMA_DELIMITER.getBytes());
            outputStream.write(String.valueOf(message.getWeight_gain()).getBytes());
            outputStream.write(COMMA_DELIMITER.getBytes());
            outputStream.write(String.valueOf(message.getHigh_blood_pressure()).getBytes());
            outputStream.write(COMMA_DELIMITER.getBytes());
            outputStream.write(String.valueOf(message.getMuscle_weakness()).getBytes());
            outputStream.write(COMMA_DELIMITER.getBytes());
            outputStream.write(String.valueOf(message.getSweating()).getBytes());
            outputStream.write(COMMA_DELIMITER.getBytes());
            outputStream.write(String.valueOf(message.getFlushing()).getBytes());
            outputStream.write(COMMA_DELIMITER.getBytes());
            outputStream.write(String.valueOf(message.getHeadache()).getBytes());
            outputStream.write(COMMA_DELIMITER.getBytes());
            outputStream.write(String.valueOf(message.getChest_pain()).getBytes());
            outputStream.write(COMMA_DELIMITER.getBytes());
            outputStream.write(String.valueOf(message.getBack_pain()).getBytes());
            outputStream.write(COMMA_DELIMITER.getBytes());
            outputStream.write(String.valueOf(message.getBruising()).getBytes());
            outputStream.write(COMMA_DELIMITER.getBytes());
            outputStream.write(String.valueOf(message.getFatigue()).getBytes());
            outputStream.write(COMMA_DELIMITER.getBytes());
            outputStream.write(String.valueOf(message.getPanic()).getBytes());
            outputStream.write(COMMA_DELIMITER.getBytes());
            outputStream.write(String.valueOf(message.getSadness()).getBytes());
            outputStream.write(COMMA_DELIMITER.getBytes());
            outputStream.write(dateHandler.getCurrentData().toString().getBytes());
            outputStream.write(NEW_LINE_SEPARATOR.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<Record> readRecordLog(String fs,Context context){
        ArrayList<Record> arrayList = new ArrayList<Record>();
        try{
            FileInputStream inputStream = context.openFileInput(fs);
            InputStreamReader isr = new InputStreamReader(inputStream,"UTF-8");
            BufferedReader bufferedReader = new BufferedReader(isr);
            String line;
            while((line=bufferedReader.readLine())!=null){
                String[] tokens = line.split(COMMA_DELIMITER);
                if(tokens.length>0){
                    arrayList.add(new Record(
                            Integer.parseInt(tokens[0]),
                            Integer.parseInt(tokens[1]),
                            Integer.parseInt(tokens[2]),
                            Integer.parseInt(tokens[3]),
                            Integer.parseInt(tokens[4]),
                            Integer.parseInt(tokens[5]),
                            Integer.parseInt(tokens[6]),
                            Integer.parseInt(tokens[7]),
                            Integer.parseInt(tokens[8]),
                            Integer.parseInt(tokens[9]),
                            Integer.parseInt(tokens[10]),
                            Integer.parseInt(tokens[11]),
                            Integer.parseInt(tokens[12]),
                            Integer.parseInt(tokens[13]),
                            Integer.parseInt(tokens[14]),
                            tokens[15].toString()
                    ));
                }
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
    public static ArrayList<String> readData(String fs,int item,Context context){
        ArrayList<String> arrayList = new ArrayList();
        try{
            FileInputStream inputStream = context.openFileInput(fs);
            InputStreamReader isr = new InputStreamReader(inputStream,"UTF-8");
            BufferedReader bufferedReader = new BufferedReader(isr);
            String line;
            while((line=bufferedReader.readLine())!=null){
                String[] tokens = line.split(COMMA_DELIMITER);
                if(tokens.length>0){
                    arrayList.add((tokens[item].toString()));
                }
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }


}
