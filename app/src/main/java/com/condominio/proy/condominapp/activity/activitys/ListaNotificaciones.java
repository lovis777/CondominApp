package com.condominio.proy.condominapp.activity.activitys;

import android.app.ListActivity;
import android.os.Bundle;

import com.condominio.proy.condominapp.activity.adapter.AdapterNotificacion;
import com.condominio.proy.condominapp.activity.dao.notificacionDAO;

/**
 * Created by lazar on 9/08/2016.
 */
public class ListaNotificaciones extends ListActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.lay_lista_notificacoes);
    }

    @Override
    public void onResume() {
        super.onResume();
        notificacionDAO dao = new notificacionDAO(getBaseContext());
        setListAdapter(new AdapterNotificacion(getBaseContext(), dao.getAll()));
    }
}
