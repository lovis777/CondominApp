package com.condominio.proy.condominapp.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.condominio.proy.condominapp.R;
import com.condominio.proy.condominapp.activity.objetos.reservaO;

import java.util.List;


/**
 * Created by glerison on 25/07/2016.
 */
public class AdapterReserva extends BaseAdapter {
    private Context ctx;
    private List<reservaO> lista;

    public AdapterReserva(Context ctx, List<reservaO> lista) {
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
    public View getView(int position, View convertView, ViewGroup parent) {
        reservaO vo = (reservaO) getItem(position);

        LayoutInflater layout = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = layout.inflate(R.layout.lay_lista_reserva, null);

        TextView txtNomeLisRes = (TextView) v.findViewById(R.id.txvNombreLisRes);
        txtNomeLisRes.setText("Nombre: " + vo.getId_persona());
        TextView txtLocalLisRes = (TextView) v.findViewById(R.id.txvLocalLisRes);
        txtLocalLisRes.setText("Local: " + vo.getLocal());
        TextView txtDataLisRes = (TextView) v.findViewById(R.id.txvDataLisRes);
        txtDataLisRes.setText("Data: " + vo.getData());

        return v;

    }
}
