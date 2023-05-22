package com.maemtal.schoollesson;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Veritabani extends SQLiteOpenHelper {
    Context _context;
    private static final String tablo = "Personel";
    private static final String DBNAME = "personel.DB";
    private static final int dbversion = 1;
    private static final String tablo_olustur = "Create table personel(id INTEGER not null primary key AUTOINCREMENT,ad varchar(50),soyad varchar(40),resim varchar(500))";
    private static SQLiteDatabase veritabani;
    private static final String tabloAdi = "personel";


    public Veritabani(Context context) {
        super(context, DBNAME, null, dbversion);
        _context = context;
    }

    public Veritabani(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DBNAME, factory, dbversion);
        _context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        veritabani = db;
        db.execSQL(tablo_olustur);
    }

    public void tabloyaEkle(String ad, String soyad) {
        veritabani = getWritableDatabase();
        veritabani.execSQL("insert into " + tabloAdi + "(ad,soyad) values('" + ad + "','" + soyad + "')");
        Toast.makeText(_context, "Veritabanina Kayıt Eklendi", Toast.LENGTH_SHORT).show();
    }

    public void Add(String ad, String soyad) {
        veritabani = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ad", ad);
        values.put("soyad", soyad);
        values.put("resim","https://thumbs.dreamstime.com/z/fire-flames-black-background-fire-background-fire-abstract-134109576.jpg");
        veritabani.insert(tabloAdi, null, values);
        veritabani.close();
        Toast.makeText(_context, "Veritabanina Kayıt Eklendi", Toast.LENGTH_SHORT).show();
    }

    public ArrayList veriGetir() {
        veritabani = getWritableDatabase();
        String sql = "Select *from " + tabloAdi;
        Cursor cursor = veritabani.rawQuery(sql, null);
        ArrayList<Satir> veriler=new ArrayList<Satir>();
        while (cursor.moveToNext()) {
            System.out.println(cursor.getString(1));
            System.out.println(cursor.getString(2));
            Satir satir=new Satir(cursor.getString(1),cursor.getString(2),cursor.getString(3));
            veriler.add(satir);
        }

        return veriler;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists personel");
    }
}
