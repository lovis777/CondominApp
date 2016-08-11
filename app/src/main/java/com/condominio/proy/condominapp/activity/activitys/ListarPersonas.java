package com.condominio.proy.condominapp.activity.activitys;

import android.app.ListActivity;
import android.os.Bundle;

import com.condominio.proy.condominapp.activity.adapter.Adapterpersona;
import com.condominio.proy.condominapp.activity.dao.personaDAO;

/**
 * Created by lazar on 2/08/2016.
 */
public class ListarPersonas extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onResume(){
        super.onResume();
        personaDAO dao = new personaDAO(getBaseContext());
        setListAdapter(new Adapterpersona(getBaseContext(),dao.getAll()));
    }

}
