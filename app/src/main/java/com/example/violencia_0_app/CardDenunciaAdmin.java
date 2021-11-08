package com.example.violencia_0_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.violencia_0_app.models.Denuncias;

import java.util.List;

public class CardDenunciaAdmin extends RecyclerView.Adapter<CardDenunciaAdmin.ViewHolder>{
    private final List<Denuncias> mValues;
    public Denuncias usermod;
    private final ListaDenunciasAdmin.OnListFragmentInteractionListener mListener;
    private final Context context;

    public CardDenunciaAdmin(Context context, List<Denuncias> items, ListaDenunciasAdmin.OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_card_denuncia_admin, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(final CardDenunciaAdmin.ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        holder.descripcion_denuncia.setText(mValues.get(position).getDescripcion());
        holder.estado_denuncia.setText(mValues.get(position).getEstado());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vista) {
                //if (null != mListener) {
                //    mListener.onListFragmentInteraction(holder.mItem);
                //Toast.makeText(context.getApplicationContext(),usermod.getNombre(), Toast.LENGTH_SHORT).show();
                    /*
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("objVehiculo", mValues.get(position));
                    //Navigation.findNavController(vista).navigate(R.id.ListForBrandVehiculo, bundle);
                    Intent intent = new Intent(context, ListForBrandVehiculo.class);
                    intent.putExtra("usuario_objeto",bundle);

                Intent intent = new Intent(context, ListaDenuncias.class);
                intent.putExtra("marca_vehiculo", mValues.get(position).getDescripcion());
                intent.putExtra("tipo_vehiculo", mValues.get(position).getEstado());
                context.startActivity(intent);
                //}*/
            }
        });

    }


    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView descripcion_denuncia;
        public final TextView estado_denuncia;
        public Denuncias mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            descripcion_denuncia = view.findViewById(R.id.tv_descripcion_admin);
            estado_denuncia = view.findViewById(R.id.tv_estado_admin);
        }

    }
}