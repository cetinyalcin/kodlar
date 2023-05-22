package com.maemtal.schoollesson;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.Vector;

public class Crud extends Activity {
    EditText Ad, Soyad;
    ListView list;
    Listeadaptor adaptor = null;
    ArrayList<Satir> veriler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crud);
        Ad = (EditText) findViewById(R.id.isim);
        Soyad = (EditText) findViewById(R.id.soyisim);
        list = (ListView) findViewById(R.id.isimler);
        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(this));
        veriGetir(null);

    }

    public void Kaydet(View v) {
        Veritabani vt = new Veritabani(this);
        //vt.tabloyaEkle(Ad.getText().toString(),Soyad.getText().toString() );
        vt.Add(Ad.getText().toString(), Soyad.getText().toString());
        if (adaptor != null)
            adaptor.notifyDataSetChanged();
    }

    public void veriGetir(View v) {
        Veritabani vt = new Veritabani(this);
        veriler = vt.veriGetir();
        adaptor = new Listeadaptor(this, 0, veriler);
        list.setAdapter(adaptor);
        adaptor.notifyDataSetChanged();
    }

}
