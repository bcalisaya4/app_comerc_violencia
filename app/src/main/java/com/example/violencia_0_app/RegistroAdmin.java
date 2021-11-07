package com.example.violencia_0_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

public class RegistroAdmin extends AppCompatActivity {
    private EditText dni,nombrec,organizacion,cargo,correo,contraseña;
    public Button btn_guardar;
    public FirebaseStorage firebaseStorage;
    public FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_admin);
    }
}