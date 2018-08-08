package com.felpmtz.semanados;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Detalles extends AppCompatActivity {

    private TextView VNombre, VFecha, VTelefono, VEmail, VDescripcion;
    Button beditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        VNombre = (TextView) findViewById(R.id.VNombre);
        VFecha = (TextView) findViewById(R.id.VFecha);
        VTelefono = (TextView) findViewById(R.id.VTelefono);
        VEmail = (TextView) findViewById(R.id.VEmail);
        VDescripcion = (TextView) findViewById(R.id.VDescripcion);
        beditar = (Button) findViewById(R.id.BEditar);

        final Intent intent = getIntent();
        if (null != intent) {
            VNombre.setText(intent.getStringExtra(getResources().getString(R.string.INombre)));
            VFecha.setText(intent.getStringExtra(getResources().getString(R.string.IFecha)));
            VTelefono.setText(intent.getStringExtra(getResources().getString(R.string.ITelefono)));
            VEmail.setText(intent.getStringExtra(getResources().getString(R.string.IEmail)));
            VDescripcion.setText(intent.getStringExtra(getResources().getString(R.string.IDescripcion)));

        }

       beditar.setOnClickListener(new View.OnClickListener() {
           @Override
          // public void onClick(View view) {
            //   Intent beditar = new Intent(Detalles.this, MainActivity.class);
              // startActivity(beditar);
           public void onClick(View v) {
               Intent intent_new = new Intent(getBaseContext(), MainActivity.class);
               intent_new.putExtra(getResources().getString(R.string.INombre), intent.getStringExtra(getResources().getString(R.string.INombre)));
               intent_new.putExtra(getResources().getString(R.string.IFecha), intent.getStringExtra(getResources().getString(R.string.IFecha)));
               intent_new.putExtra(getResources().getString(R.string.ITelefono), intent.getStringExtra(getResources().getString(R.string.ITelefono)));
               intent_new.putExtra(getResources().getString(R.string.IEmail), intent.getStringExtra(getResources().getString(R.string.IEmail)));
               intent_new.putExtra(getResources().getString(R.string.IDescripcion), intent.getStringExtra(getResources().getString(R.string.IDescripcion)));
               startActivity(intent_new );
               finish();
           }
       });
    }
}
