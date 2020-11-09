package com.example.sqlitedb_2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;

public class Activity2 extends AppCompatActivity {
    ListView lista;
    Button btnDel;
    DatabaseAdapter DBadapter;
    ArrayList<String> elementos;
    ArrayAdapter<String> adaptador;
    Cursor resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        btnDel = findViewById(R.id.btnEliminar);
        lista = findViewById(R.id.lista);


        DBadapter = new DatabaseAdapter(Activity2.this);

        cargarElementos(DBadapter);


        lista.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;
            }
        });

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }




    public void cargarElementos(DatabaseAdapter DBadapter){
        elementos = new ArrayList();
        resultado = DBadapter.mostrarClientes();
        StringBuilder cadena;

        elementos.add("NOMBRE\t\tEDAD\t\tDINERO");
        while (resultado.moveToNext()) {
            cadena = new StringBuilder();
            cadena.append(resultado.getString(1));
            cadena.append("\t\t"+resultado.getString(2));
            cadena.append("\t\t"+resultado.getDouble(3));
            elementos.add(cadena.toString());
        }

        /*adaptador =new ArrayAdapter<String>(
                this,android.R.layout.simple_list_item_1,elementos);
        lista.setAdapter(adaptador);*/
        SimpleCursorAdapter adaptadorLista = new SimpleCursorAdapter(
                Activity2.this,
                R.layout.fila,
                resultado,
                new String[]{"nombre","edad","dinero"},
                new int[]{R.id.txt1,R.id.txt2,R.id.txt3}
                );
        lista.setAdapter(adaptadorLista);

    }
}
