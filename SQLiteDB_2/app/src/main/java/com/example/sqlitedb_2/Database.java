package com.example.sqlitedb_2;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class Database extends SQLiteOpenHelper {

    Context contexto;

    public Database(Context context) {
        super(context,"DB-Cons", null, 2);
        this.contexto=context;

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            db.execSQL("CREATE TABLE clientes (_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "nombre VARCHAR, edad VARCHAR, dinero DOUBLE)");
        }catch(SQLException e){
            Toast.makeText(contexto,""+e,Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try{
            db.execSQL("DROP TABLE IF EXISTS clientes");

            onCreate(db);
        }catch(SQLException e){
            Toast.makeText(contexto,""+e,Toast.LENGTH_SHORT).show();
        }

    }
}
