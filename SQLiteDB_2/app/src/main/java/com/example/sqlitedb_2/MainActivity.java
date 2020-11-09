package com.example.sqlitedb_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etNombre, etEdad,etDinero;
    Button btnInsert, btnShow;
    DatabaseAdapter DBadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNombre = (EditText)findViewById(R.id.etNombre);
        etEdad = (EditText)findViewById(R.id.etEdad);
        etDinero = (EditText)findViewById(R.id.etDinero);
        btnInsert = findViewById(R.id.btnInsertar);
        btnShow = findViewById(R.id.btnMostrar);


        DBadapter = new DatabaseAdapter(MainActivity.this);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long n = DBadapter.insertar(
                        etNombre.getText().toString(),
                        etEdad.getText().toString(),
                        Double.parseDouble(etDinero.getText().toString()));
                Toast.makeText(getApplicationContext(),""+n,Toast.LENGTH_LONG).show();

                etNombre.setText("");etEdad.setText("");etDinero.setText("");
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Activity2.class);
                startActivity(i);
            }
        });

    }
}
