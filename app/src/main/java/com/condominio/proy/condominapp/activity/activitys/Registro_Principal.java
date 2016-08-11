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
 * Created by lazar on 28/07/2016.
 */
public class Registro_Principal extends ActionBarActivity {

    private TextView txvNuevaPersona;
    private TextView txvNuevoVeiculo;
    private TextView txvListaPersona;
    private TextView txvListaVeiculo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_registro_principal);

        txvNuevaPersona = (TextView) findViewById(R.id.txvNueva_Persona);
        txvNuevoVeiculo = (TextView) findViewById(R.id.txvNuevoVeiculo);
        txvListaPersona = (TextView) findViewById(R.id.txvListaPersona);
        txvListaVeiculo = (TextView) findViewById(R.id.txvListaVeiculo);

        txvNuevoVeiculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), RegistroVeiculo.class));
            }
        });
        txvNuevaPersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), RegistroPersona.class));
            }
        });
        txvListaVeiculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), Lista_Veiculos.class));
            }
        });
        txvListaPersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), ListarPersonas.class));
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registro_principal, menu);
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
