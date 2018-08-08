package com.felpmtz.semanados;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText InNombre, InTelefono, InEmail, Desc;
    Button buttonFecha;
    EditText editTextFecha;
    private int dia,mes,anio;
    private Button siguiente;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InNombre = (EditText) findViewById(R.id.InNombre);
        buttonFecha = (Button) findViewById(R.id.buttonFecha);
        editTextFecha = (EditText) findViewById(R.id.editTextFecha);
        InTelefono = (EditText) findViewById(R.id.InTelefono);
        InEmail = (EditText) findViewById(R.id.InEmail);
        Desc = (EditText) findViewById(R.id.Desc);
        buttonFecha.setOnClickListener(this);
        siguiente = (Button) findViewById(R.id.Bsiguiente);


        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent siguiente = new Intent(MainActivity.this, Detalles.class);
               startActivity(siguiente);

                if(!InNombre.getText().toString().trim().isEmpty() && !editTextFecha.getText().toString().trim().isEmpty() &&
                        !InTelefono.getText().toString().trim().isEmpty() && !InEmail.getText().toString().trim().isEmpty() &&
                        !Desc.getText().toString().trim().isEmpty()){

                    Intent intent = new Intent(getBaseContext(), Detalles.class);
                    intent.putExtra(getResources().getString(R.string.INombre), InNombre.getText().toString().trim());
                    intent.putExtra(getResources().getString(R.string.IFecha), editTextFecha.getText().toString().trim());
                    intent.putExtra(getResources().getString(R.string.ITelefono), InTelefono.getText().toString().trim());
                    intent.putExtra(getResources().getString(R.string.IEmail), InEmail.getText().toString().trim());
                    intent.putExtra(getResources().getString(R.string.IDescripcion), Desc.getText().toString().trim());
                    startActivity(intent);
                    finish();
                }

            }
        });

        Intent intent = getIntent();

        if (null != intent) {
            try{
                InNombre.setText(intent.getStringExtra(getResources().getString(R.string.INombre)));
                editTextFecha.setText(intent.getStringExtra(getResources().getString(R.string.IFecha)));
                InTelefono.setText(intent.getStringExtra(getResources().getString(R.string.ITelefono)));
                InEmail.setText(intent.getStringExtra(getResources().getString(R.string.IEmail)));
                Desc.setText(intent.getStringExtra(getResources().getString(R.string.IDescripcion)));
            }catch (Exception e){
            }

    }


    }


    @Override
    public void onClick(View view) {
        if(view == buttonFecha){
            final Calendar Cal = Calendar.getInstance();

            dia  = Cal.get(Calendar.DAY_OF_MONTH);
            mes  = Cal.get(Calendar.MONTH);
            anio = Cal.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {

                    editTextFecha.setText(dayOfMonth+" / "+(monthOfYear+1)+" / "+year);
                }
            }
                    ,dia,mes,anio);
            datePickerDialog.show();

        }

    }
}
