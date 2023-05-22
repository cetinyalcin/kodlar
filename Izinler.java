package com.maemtal.lesson_school;

import android.app.Activity;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;

public class Izinler {

    public static void Request_SendSMS(Activity act,int code){
        ActivityCompat.requestPermissions(act, new
                String[]{Manifest.permission.SEND_SMS},code);
    }
    public static void Request_PhoneCall(Activity act,int code){
        ActivityCompat.requestPermissions(act, new
                String[]{Manifest.permission.CALL_PHONE},code);
    }
    //Request Permisson
    public static void Request_STORAGE(Activity act, int code)
    {

        ActivityCompat.requestPermissions(act, new
                String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE},code);
    }
    public static void Request_CAMERA(Activity act,int code)
    {
        ActivityCompat.requestPermissions(act, new
                String[]{Manifest.permission.CAMERA},code);
    }
    public static void Request_FINE_LOCATION(Activity act,int code)
    {
        ActivityCompat.requestPermissions(act, new
                String[]{Manifest.permission.ACCESS_FINE_LOCATION},code);
    }
    public static void Request_READ_SMS(Activity act,int code)
    {
        ActivityCompat.requestPermissions(act, new
                String[]{Manifest.permission.READ_SMS},code);
    }
    public static void Request_READ_CONTACTS(Activity act,int code)
    {
        ActivityCompat.requestPermissions(act, new
                String[]{Manifest.permission.READ_CONTACTS},code);
    }
    public static void Request_READ_CALENDAR(Activity act,int code)
    {
        ActivityCompat.requestPermissions(act, new
                String[]{Manifest.permission.READ_CALENDAR},code);
    }
    public static void Request_RECORD_AUDIO(Activity act,int code)
    {
        ActivityCompat.requestPermissions(act, new
                String[]{Manifest.permission.RECORD_AUDIO},code);
    }

    //Check Permisson

    public static boolean Check_SendSMS(Activity act)
    {
        int result = ContextCompat.checkSelfPermission(act, Manifest.permission.SEND_SMS);
        return result == PackageManager.PERMISSION_GRANTED;
    }

    public static boolean Check_PhoneCall(Activity act)
    {
        int result = ContextCompat.checkSelfPermission(act, Manifest.permission.CALL_PHONE);
        return result == PackageManager.PERMISSION_GRANTED;
    }
    public static boolean Check_STORAGE(Activity act)
    {
        int result = ContextCompat.checkSelfPermission(act,android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        return result == PackageManager.PERMISSION_GRANTED;
    }
    public static boolean Check_CAMERA(Activity act)
    {
        int result = ContextCompat.checkSelfPermission(act, Manifest.permission.CAMERA);
        return result == PackageManager.PERMISSION_GRANTED;
    }
    public static boolean Check_FINE_LOCATION(Activity act)
    {
        int result = ContextCompat.checkSelfPermission(act, Manifest.permission.ACCESS_FINE_LOCATION);
        return result == PackageManager.PERMISSION_GRANTED;
    }
    public static boolean Check_READ_SMS(Activity act)
    {
        int result = ContextCompat.checkSelfPermission(act, Manifest.permission.READ_SMS);
        return result == PackageManager.PERMISSION_GRANTED;
    }
    public static boolean Check_READ_CONTACTS(Activity act)
    {
        int result = ContextCompat.checkSelfPermission(act, Manifest.permission.READ_CONTACTS);
        return result == PackageManager.PERMISSION_GRANTED;
    }
    public static boolean Check_READ_CALENDAR(Activity act)
    {
        int result = ContextCompat.checkSelfPermission(act, Manifest.permission.READ_CALENDAR);
        return result == PackageManager.PERMISSION_GRANTED;
    }
    public static boolean Check_RECORD_AUDIO(Activity act)
    {
        int result = ContextCompat.checkSelfPermission(act, Manifest.permission.RECORD_AUDIO);
        return result == PackageManager.PERMISSION_GRANTED;
    }
}
