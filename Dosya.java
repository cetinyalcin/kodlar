package com.maemtal.lesson_school;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Dosya {
    public static File resimKaydet(Context con, Bitmap bmp, String name) {

        String resimAdres = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath();
        File f = new File(resimAdres + "/resimlerim");
        try {
            if (!f.isDirectory()) {
                f.mkdir();
            }
        } catch (Exception e) {
            Log.e("Hata ", e.getLocalizedMessage());
        }
        OutputStream outStream = null;
        // String temp = null;
        File file = new File(f.getAbsolutePath(), name + ".png");
        if (file.exists()) {
            file.delete();
            file = new File(f.getAbsolutePath(), name + ".png");

        }

        try {
            outStream = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.PNG, 100, outStream);
            outStream.flush();
            outStream.close();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return file;
    }
}
