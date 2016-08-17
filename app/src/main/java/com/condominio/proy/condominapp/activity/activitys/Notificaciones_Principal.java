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
import com.condominio.proy.condominapp.activity.adapter.AdapterNotificacion;
import com.condominio.proy.condominapp.activity.dao.notificacionDAO;

/**
 * Created by lazar on 8/07/2016.
 */
public class Notificaciones_Principal extends ActionBarActivity {

    private TextView txvNuevaNotificacion;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_notificacion_principal);

        txvNuevaNotificacion = (TextView) findViewById(R.id.txvNuevaNotificacion);
        lv = (ListView) findViewById(R.id.listViewNot);
        notificacionDAO dao = new notificacionDAO(getBaseContext());
        lv.setAdapter(new AdapterNotificacion(getBaseContext(), dao.getAll()));
        txvNuevaNotificacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), NotificacionNueva.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; esto agrega elementos a la barra de acción si está presente.
        getMenuInflater().inflate(R.menu.menu_notificacion_principal, menu);
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
