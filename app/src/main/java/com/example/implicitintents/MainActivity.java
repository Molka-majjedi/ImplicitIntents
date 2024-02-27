package com.example.implicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.Button;
import androidx.appcompat.app.WindowDecorActionBar;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.app.ShareCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.net.HttpCookie;

public class MainActivity extends AppCompatActivity {
    Button WEBSITE;
    Button  LOCATION;
    Button SHARE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Button WEBSITE = findViewById(R.id.open_website_button);
       Button LOCATION = findViewById(R.id.open_location_button);
       Button SHARE = findViewById(R.id.share_text_button);
       EditText zone1=findViewById(R.id.website_edittext);
       String webPge=zone1.getText().toString();
       EditText zone2=findViewById(R.id.location_edittext);
       String loc=zone2.getText().toString();
       EditText zone3=findViewById(R.id.share_edittext);
       String share=zone3.getText().toString();


       WEBSITE.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(webPge));
               if (intent.resolveActivity(getPackageManager()) != null) {
                   startActivity(intent);
               } else {
                   Log.d("ImplicitIntents", "Can't handle this intent !");
               }
           }
       });
    LOCATION.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            AppCompatTextView mLocationEditText = null;
            String loc =mLocationEditText.getText().toString();
            Uri addressUri = Uri.parse("geo:0,0?q="+loc);
            Intent intent = new Intent(Intent.ACTION_VIEW,addressUri );
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                Log.d("ImplicitIntents", "Can't handle this intent !");
            }

        }
    });

    SHARE.setOnClickListener(new View.OnClickListener(){



        @Override
        public void onClick(View view) {
            String txt = zone3.getText().toString();
            String mimeType="text/plain";
            ShareCompat.IntentBuilder
                    .from(MainActivity.this)
                    .setType(mimeType)
                    .setText(txt)
                    .startChooser();



        }

    });
    }}







