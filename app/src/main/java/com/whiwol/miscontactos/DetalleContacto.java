package com.whiwol.miscontactos;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class DetalleContacto extends AppCompatActivity {

    //Declarando los TextView Globales
    private TextView tvNombre;
    private TextView tvTelefono;
    private TextView tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        //Declarando el ACtion Bar de Material Design
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Mi Contacto Elegido");


        //Recibiendo los parametros enviados enviados en la pantalla anterior
        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString(getResources().getString(R.string.pnombre)); //nombre
        String telefono = parametros.getString(getResources().getString(R.string.ptelefono)); //telefono
        String correo = parametros.getString(getResources().getString(R.string.pcorreo)); //correo

        //Asignando el Texto de los parametros a cada etiqueta TextView
        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail = (TextView) findViewById(R.id.tvEmail);

        tvNombre.setText(nombre);
        tvTelefono.setText(telefono);
        tvEmail.setText(correo);

    }

    //Creando Metodo de Intent Implicito para hacer llamada
    public void llamar(View v) {
        String telefono = tvTelefono.getText().toString();

        //Ejecutando Intent Implicito (Toma Recursos Externos), mandando telefono como recurso accesible tipo Uri
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + telefono)));

    }

    //Creando Metodo de Intent Implicito para mandar Email
    public void mandarEmail(View v){
        String correo = tvEmail.getText().toString();
        Intent correoIntent = new Intent((Intent.ACTION_SEND));
        correoIntent.setData(Uri.parse("mailto:"));
        correoIntent.putExtra(Intent.EXTRA_EMAIL, correo);
        correoIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(correoIntent, "Email"));
    }

    //Creando Metodo para Regresar al Intent Anterior cuando se aprieta back, Pantalla Principal
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(DetalleContacto.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}