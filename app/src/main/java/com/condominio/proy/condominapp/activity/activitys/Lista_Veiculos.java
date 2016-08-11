package com.condominio.proy.condominapp.activity.activitys;

import android.app.ListActivity;
import android.os.Bundle;

import com.condominio.proy.condominapp.activity.adapter.AdapterVeiculo;
import com.condominio.proy.condominapp.activity.dao.veiculoDAO;

/**
 * Created by lazar on 9/08/2016.
 */
public class Lista_Veiculos extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onResume(){
        super.onResume();
        veiculoDAO dao = new veiculoDAO(getBaseContext());
        setListAdapter(new AdapterVeiculo(getBaseContext(),dao.getAll()));
    }

}
