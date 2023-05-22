package com.maemtal.lesson_school;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;

public class MainActivity extends Activity {
    private static final int REQUEST_PHONE_CALL = 1;
    ImageLoader loader;
    ImageView resim;
    EditText myText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       resim=(ImageView)findViewById(R.id.imageView);
        loader=ImageLoader.getInstance();
       myText=(EditText)findViewById(R.id.editTextTextMultiLine);
      //  loader.displayImage("https://wildboyzphotography.com/wp-content/uploads/brizy/imgs/Freemont-Cottonwood-Supai-1170x1560x0x0x1170x1560x1597607534.jpg?x57213",resim);
        /*if ( Build.VERSION.SDK_INT >= 23 &&
                ContextCompat.checkSelfPermission( this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED ) {
            ActivityCompat.requestPermissions(this, new
                    String[]{Manifest.permission.CALL_PHONE},55);
        }*/
        if(!Izinler.Check_PhoneCall(MainActivity.this))
        {
            //if not permisson granted so request permisson with request code
           Izinler.Request_PhoneCall(MainActivity.this,22);
        }
        if(!Izinler.Check_SendSMS(MainActivity.this))
        {
            //if not permisson granted so request permisson with request code
            Izinler.Request_SendSMS(MainActivity.this,23);
        }
        if(!Izinler.Check_STORAGE(MainActivity.this))
        {
            //if not permisson granted so request permisson with request code
            Izinler.Request_STORAGE(MainActivity.this,25);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 22:
                if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "Telefon için izin Verildi", Toast.LENGTH_SHORT).show();
                }
                break;
            case 23:
                if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "Sms için izin Verildi", Toast.LENGTH_SHORT).show();
                }
                break;
            case 25:
                if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "Depo  kullanımı  için izin Verildi", Toast.LENGTH_SHORT).show();
                }
                break;

        }
    }
int x=1;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == pic_id) {
            // BitMap is data structure of image file which store the image in memory
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            // Set the image in imageview for display
            Dosya.resimKaydet(this,photo,"CetinYalcin"+x);
           resim.setImageBitmap(photo);



        }
    }

    int pic_id=24;
    public void KameraAc(View v){
        Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Start the activity with camera_intent, and request pic id
        startActivityForResult(camera_intent, pic_id);
    }
    public void MessageGonder(View v){
       /* Intent smsIntent = new Intent(android.content.Intent.ACTION_VIEW);
        smsIntent.setType("vnd.android-dir/mms-sms");
        smsIntent.putExtra("address","05443078427");
        smsIntent.putExtra("sms_body",myText.getText().toString());
        smsIntent.setFlags(android.content.Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(smsIntent);*/
       /* Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms","05443078427", null));
        smsIntent.putExtra("sms_body",myText.getText().toString());
        startActivity(smsIntent);*/
        sendSMS("05443078427",myText.getText().toString());
    }

    public void sendSMS(String phoneNo, String msg) {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, msg, null, null);
            Toast.makeText(getApplicationContext(), "Message Sent",
                    Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(),ex.getMessage().toString(),
                    Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }
    }
    public void Ara(View v){
     Intent cintent=new Intent(Intent.ACTION_CALL,Uri.parse("tel:+905448640702"));
     startActivity(cintent);
    }
}