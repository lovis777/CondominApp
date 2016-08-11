package com.condominio.proy.condominapp.activity.activitys;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.condominio.proy.condominapp.activity.adapter.Adapterporteria;
import com.condominio.proy.condominapp.activity.dao.porteriaDAO;
import com.condominio.proy.condominapp.activity.objetos.porteriaO;

/**
 * Created by lazar on 9/08/2016.
 */
public class Lista_visita extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        porteriaO vo = (porteriaO)l.getAdapter().getItem(position);
        Toast.makeText(getBaseContext(), vo.getId().toString(), Toast.LENGTH_SHORT).show();
        startActivity(new Intent("EditaVisita").putExtra("codigo", vo.getId()));

    }

    @Override
    public void onResume(){
        super.onResume();
        porteriaDAO dao = new porteriaDAO(getBaseContext());
        setListAdapter(new Adapterporteria(getBaseContext(),dao.getAll()));
    }
}
