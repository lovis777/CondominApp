package com.condominio.proy.condominapp.activity.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.condominio.proy.condominapp.R;
import com.condominio.proy.condominapp.activity.adapter.AdapterReserva;
import com.condominio.proy.condominapp.activity.dao.reservaDAO;

/**
 * Created by lazar on 8/08/2016.
 */
public class Reserva_Principal extends ActionBarActivity {

    private TextView txvNuevaReserva;
    private ListView listViewRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_reserva__principal);

        txvNuevaReserva = (TextView) findViewById(R.id.txvNuevaReserva);
        listViewRes = (ListView) findViewById(R.id.listViewRes);

        reservaDAO dao = new reservaDAO(getBaseContext());
        listViewRes.setAdapter(new AdapterReserva(getBaseContext(), dao.getAll()));

        txvNuevaReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), ReservaNueva.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_reserva__principal, menu);
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
