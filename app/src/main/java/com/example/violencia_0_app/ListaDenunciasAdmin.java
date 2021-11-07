package com.example.violencia_0_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.violencia_0_app.models.Denuncias;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class ListaDenunciasAdmin extends AppCompatActivity {

    private ListaDenunciasAdmin.OnListFragmentInteractionListener mListener;
    private RecyclerView recyclerView;
    private List<Denuncias> milista;
    HashMap<String, Denuncias> milista2 = new HashMap<String, Denuncias>();
    Collection<Denuncias> valores;
    private FirebaseFirestore db;
    private FloatingActionButton regresar,salir;
    public String descripcion_denuncia,estado_denuncia,dni;
    public Denuncias vehiculoObj;
    public Button btn_denunciar;
    public FloatingActionButton btn_salir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_denuncias_admin);
        Intent intent = getIntent();

        descripcion_denuncia = intent.getStringExtra("descripcion");
        estado_denuncia = intent.getStringExtra("estado");
        Denuncias denunciaObj = (Denuncias) getIntent().getSerializableExtra("denuncia_objeto");



        db = FirebaseFirestore.getInstance();
        milista = new ArrayList<>();
        recyclerView = findViewById(R.id.list_admin);
        btn_salir= findViewById(R.id.btn_back_admin);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LlenaMILista(denunciaObj);
        btn_salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);            }
        });

    }
    private void LlenaMILista(Denuncias denunciaObj) {

        db.collection("denuncias")
                //.whereEqualTo("dni","72169324")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        if (task.getResult().isEmpty()){
                            Toast.makeText(this , dni, Toast.LENGTH_SHORT).show();
                            Toast.makeText(this , "No hay Denuncias", Toast.LENGTH_SHORT).show();
                        }
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            Denuncias denuncia = document.toObject(Denuncias.class);
                            denuncia.setId_denuncia(document.getId());
                            //milista2.put(denuncia.getDescripcion(),denuncia);
                            //aux.add(equipment.getModelo());
                            milista.add(denuncia);
                        }
                        valores = milista2.values();
                        //milista=new ArrayList<>(valores);
                        recyclerView.setAdapter(new CardDenunciaAdmin(this, milista, mListener));
                    }
                    else {
                        Log.w("Error", "Error getting documents.", task.getException());
                    }
                });
    }
    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(Denuncias item);
    }
}