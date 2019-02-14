package com.example.scott.practica2mapsshpref;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText etEditar;
    private EditText etEdad;
    private Button btnSalvar;
    private TextView tvMostrar;

    public static String mensaje;
    public static String edad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etEditar = (EditText) findViewById(R.id.etEditar);
        etEdad = (EditText) findViewById(R.id.etEditar);
        btnSalvar = (Button) findViewById(R.id.btnSalva);
        tvMostrar = (TextView) findViewById(R.id.tvMuestra);

        mensaje = String.valueOf(etEditar.getText());
        edad = String.valueOf(etEdad.getText());

        SharedPreferences preferencias = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencias.edit();
        editor.putString("nombre", mensaje);
        editor.putString("edad", edad);
        editor.commit();

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences preferencias = getPreferences(MODE_PRIVATE);

                String nombrePref = preferencias.getString("nombre",null);
                String edadPref = preferencias.getString("edad", null);

                tvMostrar.setText("Nombre : " + nombrePref + "\n" + "edad : " + edadPref);

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
