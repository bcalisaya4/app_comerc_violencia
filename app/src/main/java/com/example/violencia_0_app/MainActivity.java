package com.example.violencia_0_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn_registro,btn_panico,btn_login,btn_info,btn_otros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_registro =findViewById(R.id.btn_register);
        btn_login=findViewById(R.id.btn_login);
        btn_info=findViewById(R.id.btn_inf);
        btn_otros=findViewById(R.id.btn_other);
        //btn_panico=findViewById(R.id.btn_panic);
        // action button
        btn_registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),RegistroUsuarios.class));
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),login.class));
            }
        });

    }
}