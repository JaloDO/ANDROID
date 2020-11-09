package com.example.tamago;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //declaro variables necesarias
    SharedPreferences myPreferences;
    SharedPreferences.Editor myEditor;
    ImageButton imagen;
    TextView marcador;
    Button boton;
    ImageButton info;
    int toquesRestantes;
    int[]listaImagenes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //conjugo la lista de imagenes
        listaImagenes= new int[]{
                R.mipmap.a1,
                R.mipmap.a2,
                R.mipmap.a3,
                R.mipmap.a4,
                R.mipmap.a5
        };



        //inicio variables de interfaz
        imagen = findViewById(R.id.imagen);
        marcador = findViewById(R.id.marcador);
        boton=findViewById(R.id.guardar);
        info=findViewById(R.id.information);

        //inicio variables de programa
        myPreferences=PreferenceManager.getDefaultSharedPreferences(this);
        myEditor = myPreferences.edit();

        //variables principales de la app
        toquesRestantes=myPreferences.getInt("toques",1000000);
        marcador.setText(String.valueOf(toquesRestantes));

        //evento click de imageButton
        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toquesRestantes--;
                marcador.setText(String.valueOf(toquesRestantes));
                final int imgSelect = listaImagenes[new Random().nextInt(listaImagenes.length)];
                findViewById(R.id.imagen).setBackgroundResource(imgSelect);
            }
        });
        //evento click de boton guardar
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myEditor.putInt("toques",toquesRestantes);
                Toast.makeText(getApplicationContext(),"TOQUES GUARDADOS", Toast.LENGTH_SHORT);
            }
        });

        //evento click en boton de info
        /*HAY QUE SEGUIR TRABAJANDO EN ESTO
        info.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String cad="\tTamago Remastered\nVersion: Beta_1.0.0\nAlejandro DO\n\tAPI 29 Android 10";
                Toast.makeText(getApplicationContext(),cad,Toast.LENGTH_LONG);
                AlertDialog.Builder builder=new AlertDialog.Builder(getApplicationContext());
                builder.setMessage(cad).setTitle("INFORMACIÓN");
                AlertDialog dialog=builder.create();
                dialog.show();
            }
        });*/
    }
}
