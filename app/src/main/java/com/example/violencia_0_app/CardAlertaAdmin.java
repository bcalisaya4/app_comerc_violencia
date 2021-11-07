package com.example.violencia_0_app;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.violencia_0_app.models.Alerta;

import java.util.List;

public class CardAlertaAdmin extends RecyclerView.Adapter<CardAlertaAdmin.ViewHolder>{
    private final List<Alerta> mValues;
    public Alerta usermod;
    private final ListaAlertasAdmin.OnListFragmentInteractionListener mListener;
    private final Context context;

    public CardAlertaAdmin(Context context, List<Alerta> items, ListaAlertasAdmin.OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
        this.context = context;
    }
    @Override
    public CardAlertaAdmin.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_card_alerta_admin, parent, false);
        return new CardAlertaAdmin.ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(final CardAlertaAdmin.ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        holder.direccion_alerta.setText(mValues.get(position).getDirection());
        //holder.ubicacion_alerta.setText(mValues.get(position).getLatitude());
        //holder.longitud_alerta.setText(mValues.get(position).getLongitude());
        holder.hora_alerta.setText(mValues.get(position).getTime());


        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vista) {

                Intent intent = new Intent(context, MapsActivity.class);
                intent.putExtra("latitude", mValues.get(position).getLatitude());
                intent.putExtra("longitude", mValues.get(position).getLongitude());
                intent.putExtra("url", mValues.get(position).getUrl());
                context.startActivity(intent);
                //}
            }
        });

    }


    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView direccion_alerta;
        //public final TextView ubicacion_alerta;
        //public final TextView longitud_alerta;
        public final TextView hora_alerta;
        public Alerta mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            direccion_alerta = view.findViewById(R.id.tv_alert_direccion);
            //ubicacion_alerta = view.findViewById(R.id.tv_alert_ubicacion);
            //longitud_alerta = view.findViewById(R.id.tv_alert_longitud);
            hora_alerta = view.findViewById(R.id.tv_alert_hora);
        }

    }
}