package com.example.violencia_0_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Button;
import android.widget.TextView;

public class UploadAudio extends AppCompatActivity {
    private TextView lat,lon;
    private Button btn_grabar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_audio);
        lat = findViewById(R.id.textView_lan);
        lon = findViewById(R.id.textView_lon);
        btn_grabar = findViewById(R.id.btn_grab);

        //Intent intent = getIntent();
        String intLat = getIntent().getStringExtra("lat");
        String intLon = getIntent().getStringExtra("lon");
        System.out.println("longitud <-----------///////////////////////////-");
        System.out.println(intLat+"<-----------------------------");
        lat.setText(intLat);
        lon.setText(intLon);
    }
}