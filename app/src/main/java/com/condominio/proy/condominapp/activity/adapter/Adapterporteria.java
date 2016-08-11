package com.condominio.proy.condominapp.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.condominio.proy.condominapp.R;
import com.condominio.proy.condominapp.activity.objetos.porteriaO;

import java.util.List;


/**
 * Created by lazar on 12/08/2016.
 */
public class Adapterporteria extends BaseAdapter {
    private Context ctx;
    private List<porteriaO> lista;

    public Adapterporteria(Context ctx, List<porteriaO> lista) {
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
        porteriaO vo = (porteriaO) getItem(position);

        LayoutInflater layout = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = layout.inflate(R.layout.lay_porteria_lista, null);

        TextView txtData = (TextView) v.findViewById(R.id.textViewId);
        txtData.setText("Fecha: " + vo.getData());
        TextView txtNome = (TextView) v.findViewById(R.id.textViewNombre);
        txtNome.setText("Visitante: " + vo.getNombre());

        return v;
    }
}
