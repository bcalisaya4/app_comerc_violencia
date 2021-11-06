package com.example.violencia_0_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

import java.util.HashMap;
import java.util.Map;

public class RegistroDenuncia extends AppCompatActivity {
    private EditText dni,nombre,apellidop,apellidom,telefonod,ocupaciond,correod,direcciond;
    private Spinner estado_civild;
    public Button btn_guardar;
    public FirebaseStorage firebaseStorage;
    public FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_denuncia);
        db = FirebaseFirestore.getInstance();
        firebaseStorage = FirebaseStorage.getInstance();
        //data
        dni = findViewById(R.id.editText_dni);
        nombre = findViewById(R.id.editText_name);
        apellidop = findViewById(R.id.editText_last_name_p);
        apellidom = findViewById(R.id.editText_last_name_m);
        ocupaciond = findViewById(R.id.editText_ocupacion);
        telefonod = findViewById(R.id.editText_telefono);
        correod = findViewById(R.id.editText_email);
        estado_civild = findViewById(R.id.spinner_estado_civil);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.estado_civil_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        estado_civild.setAdapter(adapter);

        direcciond = findViewById(R.id.editText_direccion);

        //save
        btn_guardar = findViewById(R.id.btn_save);

        btn_guardar.setOnClickListener((View vista) -> {
            denunciaAdd();
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
        });
    }

    public void denunciaAdd(){
        String dni_user = dni.getText().toString();
        String name_user = nombre.getText().toString();
        String last_name_p_user = apellidop.getText().toString();
        String last_name_m_user = apellidom.getText().toString();
        String ocupacion = ocupaciond.getText().toString();
        String telefono = telefonod.getText().toString();
        String correo = correod.getText().toString();
        String estado_civil = estado_civild.getText().toString();
        String direccion = direcciond.getText().toString();


        Map<String, Object> newdenuncia = new HashMap<>();
        newdenuncia.put("dni", dni_user);
        newdenuncia.put("nombre", name_user);
        newdenuncia.put("apellido_paterno",last_name_p_user);
        newdenuncia.put("apellido_materno",last_name_m_user);
        newdenuncia.put("ocupacion",ocupacion);
        newdenuncia.put("telefono",telefono);
        newdenuncia.put("correo",correo);
        newdenuncia.put("estado_civil",estado_civil);
        newdenuncia.put("direccion",direccion);


        db.collection("usuarios").document().set(newdenuncia);

    }
}