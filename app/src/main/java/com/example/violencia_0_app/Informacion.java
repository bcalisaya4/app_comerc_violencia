package com.example.violencia_0_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Informacion extends AppCompatActivity {
    public Button btn_CEM,btn_linea_100,btn_chat_100,btn_SAU,btn_HRT;
    private String CEM,linea_100,chat_100,SAU,HRT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);

        btn_CEM=findViewById(R.id.btn_CEM);
        btn_linea_100=findViewById(R.id.btn_linea_100);
        btn_chat_100=findViewById(R.id.btn_chat_100);
        btn_SAU=findViewById(R.id.btn_SAU);
        btn_HRT=findViewById(R.id.btn_HRT);

        CEM="https://www.gob.pe/480-ayuda-contra-la-violencia-familiar-y-sexual-centros-de-emergencia-mujer-cem";
        linea_100="https://www.gob.pe/481-denunciar-violencia-familiar-y-sexual-linea-100";
        chat_100="https://www.gob.pe/482-denunciar-violencia-familiar-y-sexual-chat-100";
        SAU="https://www.gob.pe/484-denunciar-violencia-familiar-y-sexual-servicio-de-atencion-urgente";
        HRT="https://www.gob.pe/12458-denunciar-violencia-familiar-y-sexual-hogar-de-refugio-temporal-hrt";

        btn_CEM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri= Uri.parse(CEM);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        btn_linea_100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri= Uri.parse(linea_100);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        btn_chat_100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri= Uri.parse(chat_100);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        btn_SAU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri= Uri.parse(SAU);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        btn_HRT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri= Uri.parse(HRT);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

    }

    public void onClickLlamada(View v) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:100"));
        startActivity(intent);
    }
}