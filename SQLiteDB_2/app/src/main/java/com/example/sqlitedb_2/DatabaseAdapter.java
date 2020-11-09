package com.example.sqlitedb_2;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;

public class DatabaseAdapter {

    SQLiteDatabase myDB;
    Database database;
    Context contexto;
    ContentValues valores;

    public DatabaseAdapter(Context contexto){
        this.contexto = contexto;
        database = new Database(this.contexto);
        myDB = database.getWritableDatabase();
    }

    public long insertar(String nombre, String edad, double dinero){
        valores = new ContentValues();
        valores.put("nombre", nombre);
        valores.put("edad", edad);
        valores.put("dinero", dinero);

        return myDB.insert("clientes",null,valores);
    }


    public Cursor mostrarClientes(){
        return myDB.rawQuery("select * from clientes",null);
    }

    public void eliminarCliente(View v) {
        String table = "clientes";
        String whereClause="";
        String[]whereArgs = new String[]{};
        myDB.delete(table,whereClause,whereArgs);
    }
}
