package com.condominio.proy.condominapp.activity.activitys;

import android.app.ListActivity;
import android.os.Bundle;

import com.condominio.proy.condominapp.activity.adapter.AdapterReserva;
import com.condominio.proy.condominapp.activity.dao.reservaDAO;

/**
 * Created by lazar on 9/08/2016.
 */
public class ListaReserva extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onResume() {
        super.onResume();
        reservaDAO dao = new reservaDAO(getBaseContext());
        setListAdapter(new AdapterReserva(getBaseContext(), dao.getAll()));
    }

}
