package com.example.violencia_0_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.violencia_0_app.models.Usuario;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.storage.FirebaseStorage;

public class login extends AppCompatActivity {
    private Button btn_intro;
    private TextView correo,contraseña;
    private FirebaseFirestore db;
    private FirebaseStorage firebaseStorage;
    //private daoUsuario dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //dao = new daoUsuario(this);
        db = FirebaseFirestore.getInstance();
        firebaseStorage = FirebaseStorage.getInstance();
        setContentView(R.layout.activity_login);
        correo = findViewById(R.id.editText_correo);
        contraseña = findViewById(R.id.editText_password);
        btn_intro = findViewById(R.id.btn_ingresar);

        btn_intro.setOnClickListener(new View.OnClickListener() {

            Class type_class = null;
            @Override
            public void onClick(View v) {
                db.collection("usuarios")
                        .whereEqualTo("correo",correo.getText().toString())
                        .whereEqualTo("contraseña",contraseña.getText().toString())
                        .get()
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                if (task.getResult().isEmpty()){
                                    Toast.makeText(getApplicationContext(), "no existe Usuario", Toast.LENGTH_SHORT).show();
                                }
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    Usuario usuario = document.toObject(Usuario.class);
                                    //dao.insertUsuario(usuario);
                                    Toast.makeText(getApplicationContext(), "correcto"+usuario.getCorreo(), Toast.LENGTH_SHORT).show();
                                    usuario.setId(document.getId());
                                    db.collection("usuarios").document(document.getId()).update("logueado",true);

                                    Intent intent = new Intent(getApplicationContext(), RegistroUsuarios.class);
                                    startActivity(intent);
                                }


                            }
                            else {
                                Log.w("Error", "Error getting documents.", task.getException());
                            }
                        });;
            }

        });

    }
}