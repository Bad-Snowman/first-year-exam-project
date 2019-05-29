package com.example.demo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

// Pure fabrication class to contain two methods which collects and returns the current date and time
public class LocalDateAndTime {


    // A method which uses an object of the Date class to collect the current date.
    public static String getCurrentTime() {
        Date date = new Date();
        String strDateFormat = "HH:mm:ss";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String localTime = dateFormat.format(date);
        return localTime;
    }

    // A method which uses an object of the Date class to collect the current time.
    public static String getCurrentDate() {
        Date date = new Date();
        String strDateFormat = "dd-MM-yyyy";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String localDate = dateFormat.format(date);
        return localDate;
    }
}
