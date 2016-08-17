package com.condominio.proy.condominapp.activity.activitys;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.condominio.proy.condominapp.activity.adapter.AdapterReserva;
import com.condominio.proy.condominapp.activity.dao.reservaDAO;
import com.condominio.proy.condominapp.activity.objetos.reservaO;

/**
 * Created by lazar on 9/08/2016.
 */
public class ListaReserva extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id){
        reservaO vo = (reservaO)l.getAdapter().getItem(position);
        Toast.makeText(getBaseContext(), vo.getId().toString(),Toast.LENGTH_SHORT).show();
        startActivity(new Intent("EditaReserva").putExtra("codigo", vo.getId()));
    }

    @Override
    public void onResume() {
        super.onResume();
        reservaDAO dao = new reservaDAO(getBaseContext());
        setListAdapter(new AdapterReserva(getBaseContext(), dao.getAll()));
    }

}
