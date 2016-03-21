package com.example.xieminjie.clientapp;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by xieminjie on 20/03/2016.
 */
public class DateHandler {

    public static String getCurrentData(){
        String strDate;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("yyyy/MM/dd");
        strDate = mdformat.format(calendar.getTime());
        return strDate;
    }
}
