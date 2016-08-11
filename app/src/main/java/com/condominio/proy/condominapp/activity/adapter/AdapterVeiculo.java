package com.condominio.proy.condominapp.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.condominio.proy.condominapp.R;
import com.condominio.proy.condominapp.activity.objetos.veiculoO;

import java.util.List;


/**
 * Created by glerison on 14/07/2016.
 */
public class AdapterVeiculo extends BaseAdapter {

    private Context ctx;
    private List<veiculoO> lista;

    public AdapterVeiculo(Context ctx, List<veiculoO> lista) {
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
        veiculoO vo = (veiculoO) getItem(position);

        LayoutInflater layout = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = layout.inflate(R.layout.lay_lista__veiculos, null);

        TextView txvPlaca = (TextView) v.findViewById(R.id.txvPlacaVeiLis);
        txvPlaca.setText("Placa: " + vo.getPlaca());
        TextView txvModelo = (TextView) v.findViewById(R.id.txvModeloVeiLis);
        txvModelo.setText("Modelo: " + vo.getModelo());
        TextView txvCor = (TextView) v.findViewById(R.id.txvCorVeiLis);
        txvCor.setText("Cor: " + vo.getCor());

        return v;
    }
}
