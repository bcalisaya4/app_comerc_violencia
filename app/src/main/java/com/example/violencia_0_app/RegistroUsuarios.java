package com.example.violencia_0_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

import java.util.HashMap;
import java.util.Map;

public class RegistroUsuarios extends AppCompatActivity {
    private EditText dni,nombre,apellidop,apellidom,fecha,correo,contraseña;
    public Button btn_guardar;
    public FirebaseStorage firebaseStorage;
    public FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuarios);
        db = FirebaseFirestore.getInstance();
        firebaseStorage = FirebaseStorage.getInstance();
        dni = findViewById(R.id.editText_dni);
        nombre = findViewById(R.id.editText_name);
        apellidop = findViewById(R.id.editText_last_name_p);
        apellidom = findViewById(R.id.editText_last_name_m);
        fecha = findViewById(R.id.editText_date);
        correo = findViewById(R.id.editText_email);
        contraseña = findViewById(R.id.editText_password);
        btn_guardar = findViewById(R.id.btn_save);

        btn_guardar.setOnClickListener((View vista) -> {
            usuarioAdd();
            startActivity(new Intent(getApplicationContext(),login.class));
        });
    }
    public void usuarioAdd(){
        String dni_user = dni.getText().toString();
        String name_user = nombre.getText().toString();
        String last_name_p_user = apellidop.getText().toString();
        String last_name_m_user = apellidom.getText().toString();
        String date_born_user = fecha.getText().toString();
        String email_user = correo.getText().toString();
        String password = contraseña.getText().toString();

        Map<String, Object> newusers = new HashMap<>();
        newusers.put("dni", dni_user);
        newusers.put("nombre", name_user);
        newusers.put("apellido_paterno",last_name_p_user);
        newusers.put("apellido_materno",last_name_m_user);
        newusers.put("fecha_nacimiento", date_born_user);
        newusers.put("correo", email_user);
        newusers.put("contraseña",password);
        db.collection("usuarios").document().set(newusers);

    }
}