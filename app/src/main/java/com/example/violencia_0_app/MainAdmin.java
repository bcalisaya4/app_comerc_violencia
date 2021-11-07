package com.example.violencia_0_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainAdmin extends AppCompatActivity {
    private Button btn_lista_denuncia,btn_lista_alerta;
    public FloatingActionButton btn_salir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);
        btn_lista_denuncia = findViewById(R.id.btn_lista_denun);
        btn_lista_alerta = findViewById(R.id.btn_lista_alert);
        btn_salir = findViewById(R.id.btn_back_admin_panel);


        btn_lista_denuncia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ListaDenunciasAdmin.class));
            }
        });
        btn_lista_alerta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ListaAlertasAdmin.class));
            }
        });
        btn_salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
}
}