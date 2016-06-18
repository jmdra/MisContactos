package com.whiwol.miscontactos;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Jmdra on 14/06/2016.
 */
public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder> {

    //2.- Declarando la coleccion de los contactos
    ArrayList<Contacto> contactos;
    Activity activity;

    //6.- Generando metodo constructor
    public ContactoAdaptador(ArrayList<Contacto> contactos, Activity activity){
        this.contactos = contactos;
        this.activity = activity;
    }

    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //4.- Esto infla o le da vida a nuestro layout cardview, Infla el layout y lo pasa al viewholder
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto, parent, false);
        return  new ContactoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ContactoViewHolder contactoViewHolder, int position) {
        //5.- Aqui vamos a pasar la lista de Contactos
        final Contacto contacto = contactos.get(position);
        contactoViewHolder.imgFoto.setImageResource(contacto.getFoto());
        contactoViewHolder.tvNombreCV.setText(contacto.getNombre());
        contactoViewHolder.tvTelefonoCV.setText(contacto.getTelefono());

        //Haciendo Clickeables cada elemento
        contactoViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, contacto.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, DetalleContacto.class);
                intent.putExtra("nombre", contacto.getNombre());
                intent.putExtra("telefono", contacto.getTelefono());
                intent.putExtra("correo", contacto.getCorreo());
                activity.startActivity(intent);
            }
        });

        //Haciendo Click en el boton Like
        contactoViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste Like a " + contacto.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override //3.- EL numero total de contactos
    public int getItemCount() { //Cantidad de Elementos que contiene mi lista
        return contactos.size();
    }

    //1.- Clase Inner Estatica de ViewHolder
    public static class ContactoViewHolder extends RecyclerView.ViewHolder{

        //Se declaran todos los views declarados dentro del cardview aqui es donde se adaptan
        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvTelefonoCV;
        private ImageButton btnLike;


        public ContactoViewHolder(View itemView) {
            super(itemView);
            //Se asocia el ImageView y se hace el casting
            imgFoto         = (ImageView)   itemView.findViewById(R.id.imgFoto);
            tvNombreCV      = (TextView)    itemView.findViewById(R.id.tvNombreCV);
            tvTelefonoCV    = (TextView)    itemView.findViewById(R.id.tvTelefonoCV);
            btnLike         = (ImageButton) itemView.findViewById(R.id.btnLike);
        }
    }

}
