package com.whiwol.miscontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declarando el ACtion Bar de Material Design
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        listaContactos = (RecyclerView) findViewById(R.id.rvContactos);


        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaContactos.setLayoutManager(llm);
        inicializarListaContactos();
        inicializarAdaptador();

        //Inicializar Adaptor


        /*
        ListView lstContactos = (ListView) findViewById(R.id.lstContactos);

        lstContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombresContacto));

        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Mandando Parametros o Datos a la Siguiente Pantalla
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.pnombre), contactos.get(position).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono), contactos.get(position).getTelefono());
                intent.putExtra(getResources().getString(R.string.pcorreo), contactos.get(position).getCorreo());
                startActivity(intent);
                finish();
            }
        });
        */
    }

    public void inicializarAdaptador(){
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos, this);
        listaContactos.setAdapter(adaptador);
    }

    public void inicializarListaContactos(){
        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto(R.drawable.father_96, "Mahonri Del Rincon", "4271038159", "developer@whiwol.com"));
        contactos.add(new Contacto(R.drawable.pregnant_96, "Patricia Rodriguez", "4621152407", "annelrom@hotmail.com"));
        contactos.add(new Contacto(R.drawable.stroller_96, "Annel Del Rincon Rodriguez", "4612218444", "developer@whiwol.com"));
        contactos.add(new Contacto(R.drawable.pokeball_96, "Elias Del Rincon Rodriguez", "4612218444", "developer@whiwol.com"));
        contactos.add(new Contacto(R.drawable.pokemon_96, "Duque Goku Lorenzo", "4612218444", "developer@whiwol.com"));
    }
}