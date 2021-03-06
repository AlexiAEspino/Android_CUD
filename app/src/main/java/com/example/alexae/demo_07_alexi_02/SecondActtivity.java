package com.example.alexae.demo_07_alexi_02;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Alex.ae on 26/05/2017.
 */

public class SecondActtivity extends AppCompatActivity{

    Button btSecondRegistrar,btSecondEliminar;
    EditText etSecondNombre,etSecondApellido,etSecondDocumento,etSecondEdad;

    private  String cod;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        etSecondNombre= (EditText) findViewById(R.id.etSecondNombre);
        etSecondApellido= (EditText) findViewById(R.id.etSecondApellido);
        etSecondDocumento= (EditText) findViewById(R.id.etSecondDocumento);
        etSecondEdad= (EditText) findViewById(R.id.etSecondEdad);

        Intent intent= getIntent();

        cod = intent.getStringExtra("codigo");

        etSecondNombre.setText(intent.getStringExtra("nombre"));
        etSecondApellido.setText(intent.getStringExtra("apellido"));
        etSecondDocumento.setText(intent.getStringExtra("documento"));
        etSecondEdad.setText(intent.getStringExtra("edad"));

        btSecondRegistrar= (Button) findViewById(R.id.btSecondRegistrar);
      btSecondEliminar= (Button) findViewById(R.id.btSecondEliminar);

       btSecondRegistrar.setOnClickListener(btSecondAgregarOnCLickListener);
        btSecondEliminar.setOnClickListener(btSecondEliminarOnCLickListener);


        if(cod==null){

            btSecondRegistrar.setText("REGISTRAR");

        }else{
            btSecondRegistrar.setText("ACTUALIZAR");
        }
    }


    private  final View.OnClickListener btSecondEliminarOnCLickListener= new  View.OnClickListener(){


        @Override
        public void onClick(View v) {

            Intent intent = new Intent();
            intent.putExtra("nombre", etSecondNombre.getText().toString());
            intent.putExtra("apellido", etSecondApellido.getText().toString());
            intent.putExtra("documento", etSecondDocumento.getText().toString());
            intent.putExtra("edad", etSecondEdad.getText().toString());

            setResult(70, intent);
            finish();

        }
    };

    private final View.OnClickListener btSecondAgregarOnCLickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {

            if(cod == null) {
                //actualizar
                Intent intent = new Intent();

                intent.putExtra("nombre", etSecondNombre.getText().toString());
                intent.putExtra("apellido", etSecondApellido.getText().toString());
                intent.putExtra("documento", etSecondDocumento.getText().toString());
                intent.putExtra("edad", etSecondEdad.getText().toString());

                setResult(90, intent);
                finish();


            }else{
                //agregar

                Intent intent = new Intent();
                intent.putExtra("nombre", etSecondNombre.getText().toString());
                intent.putExtra("apellido", etSecondApellido.getText().toString());
                intent.putExtra("documento", etSecondDocumento.getText().toString());
                intent.putExtra("edad", etSecondEdad.getText().toString());

                setResult(80, intent);
                finish();

            }
        }
    };

}