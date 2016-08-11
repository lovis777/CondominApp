package com.condominio.proy.condominapp.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.condominio.proy.condominapp.R;
import com.condominio.proy.condominapp.activity.objetos.personaO;

import java.util.List;


/**
 * Created by glerison on 14/07/2016.
 */
public class Adapterpersona extends BaseAdapter {

    private Context ctx;
    private List<personaO> lista;

    public Adapterpersona(Context ctx, List<personaO> lista) {
        this.ctx = ctx;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        personaO vo = (personaO) getItem(position);

        LayoutInflater layout = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = layout.inflate(R.layout.lay_listar_pesonas, null);

        TextView txvNombre = (TextView) v.findViewById(R.id.txvNombrePersLista);
        txvNombre.setText("Nombre: " + vo.getNombre());
        TextView txvBloco = (TextView) v.findViewById(R.id.txvBlocoPersLista);
        txvBloco.setText("Bloque: " + vo.getBloco_ap());

        return v;
    }
}
