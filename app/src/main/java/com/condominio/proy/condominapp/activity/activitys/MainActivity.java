package com.condominio.proy.condominapp.activity.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.condominio.proy.condominapp.R;

/**
 * Created by lazar on 8/07/2016.
 */
public class MainActivity extends ActionBarActivity {


    private TextView txvPorteria;
    private TextView txvReserva;
    private TextView txvRegistro;
    private TextView txvNotificaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txvRegistro = (TextView)findViewById(R.id.txvRegistro);
        txvNotificaciones = (TextView)findViewById(R.id.txvNotificaciones);
        txvPorteria = (TextView)findViewById(R.id.txvPorteria);
        txvReserva = (TextView)findViewById(R.id.txvReserva);

        txvPorteria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(),"Porteria", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),Porteria_Principal.class));
            }
        });
        txvReserva.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Toast.makeText(getApplicationContext(),"Reserva", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),Reserva_Principal.class));
            }
        });
        txvNotificaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(),"Notificaciones", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getBaseContext(), Notificaciones_Principal.class));

            }
        });
        txvRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(),"Registro", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), Registro_Principal.class));
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