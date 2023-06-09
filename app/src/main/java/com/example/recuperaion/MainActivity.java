package com.example.recuperaion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnIngresar;
    private EditText txtNombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciar();


        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnIngresar();
            }
        });





    }

    private void iniciar()
    {
        btnIngresar= findViewById(R.id.btnIniciar);
        txtNombre= findViewById(R.id.txtNombre);
    }
    private void btnIngresar()
    {


        if (txtNombre.getText().toString().equals(""))
        {

            Toast.makeText(getApplicationContext(),"Elcampo esta vacio",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Intent intent = new Intent(MainActivity.this,Cotizacion_Activity.class);
            String nombre="";
            nombre=txtNombre.getText().toString();
            intent.putExtra("nombre",nombre);
            startActivity(intent);
        }
    }
}