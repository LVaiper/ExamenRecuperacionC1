package com.example.recuperaion;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Random;

public class Cotizacion_Activity extends AppCompatActivity {

    private TextView lblNombre;
    private TextView lblFolio;

    private TextView lblEngache;

    private TextView lblPagoM;

    private EditText txtDescripcion;
    private EditText txtValor;
    private EditText txtPorcentaje;

    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;

    private Button btnCalcular;
    private Button btnLimpiar;
    private Button btnRegresar;

    private cotizacion coti = new cotizacion(0,"", 0.0,0.0,0);
    DecimalFormat decimalFormat = new DecimalFormat("#.##");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cotizacion);

        iniciar();

        Intent intent=getIntent();
        String nombre=intent.getStringExtra("nombre");
        lblNombre.setText("Nombre Cliente: "+nombre.toString());

        int folio;
        int numero = (int)(Math.random()*10+1);

        lblFolio.setText("Folio:"+numero);


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(txtDescripcion.getText().toString().equals("") || txtValor.getText().toString().equals("") || txtPorcentaje.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(),"No deje campos vacios",Toast.LENGTH_SHORT).show();
                }
                else {
                    btnCotizar();

                }
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnLimpiar();
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnRegresar();
            }
        });




    }

    private void iniciar()
    {
        lblNombre=findViewById(R.id.lblNombre);
        lblFolio=findViewById(R.id.lblFolio);
        lblEngache=findViewById(R.id.lblPagoI);
        lblPagoM=findViewById(R.id.lblPagoM);

        txtDescripcion=findViewById(R.id.txtDescricion);
        txtPorcentaje=findViewById(R.id.txtPorcentaje);
        txtValor=findViewById(R.id.txtValorAuto);

        btnCalcular=findViewById(R.id.btnCotizar);
        btnLimpiar=findViewById(R.id.btnLimpiar);
        btnRegresar=findViewById(R.id.btnRegresar);


        rb1=findViewById(R.id.rb1);
        rb2=findViewById(R.id.rb2);
        rb3=findViewById(R.id.rb3);
        rb4=findViewById(R.id.rb4);



    }

    private void btnCotizar()
    {




        int meses=0;
        coti.setValorAuto(Double.parseDouble(txtValor.getText().toString()));
        coti.setPorEnganche(Double.parseDouble(txtPorcentaje.getText().toString()));
        if(rb1.isChecked())
        {
            meses=1;
        }
        else if(rb2.isChecked()){
            meses=2;
        }
        else if(rb3.isChecked())
        {
            meses=3;
        } else if (rb4.isChecked()) {
            meses=4;
        }

        coti.setPlazo(meses);

        double enganche=coti.calcularEnganche();

        lblEngache.setText("El Enganche es: "+decimalFormat.format(enganche));

        double pagom=coti.calcularPagoMensual();
        lblPagoM.setText("El Pago mensual es: "+decimalFormat.format(pagom));

    }


    private void btnLimpiar()
    {
        txtPorcentaje.setText("");
        txtValor.setText("");
        txtDescripcion.setText("");
        lblPagoM.setText("");
        lblEngache.setText("");
    }

    private void btnRegresar()
    {
        AlertDialog.Builder confirmar = new AlertDialog.Builder(this);

        confirmar.setTitle("Cotizacion");
        confirmar.setMessage("¿Desea Salir?");
        confirmar.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        confirmar.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // No hacer nada
            }
        });

        confirmar.show();
    }

}