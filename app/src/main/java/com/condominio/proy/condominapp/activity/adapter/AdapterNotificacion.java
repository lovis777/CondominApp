package com.condominio.proy.condominapp.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.condominio.proy.condominapp.R;
import com.condominio.proy.condominapp.activity.objetos.notificacionO;

import java.util.List;

/**
 * Created by lazar on 9/08/2016.
 */
public class AdapterNotificacion extends BaseAdapter{
    private Context ctx;
    private List<notificacionO> lista;

    public AdapterNotificacion(Context ctx, List<notificacionO> lista){
        this.ctx=ctx;
        this.lista=lista;
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
        notificacionO vo = (notificacionO)getItem(position);

        LayoutInflater layout = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = layout.inflate(R.layout.lay_lista_notificaciones, null);

        TextView txvDataNot = (TextView)v.findViewById(R.id.txvDataNot);
        txvDataNot.setText("Data: "+vo.getData());
        TextView txvNotDescripcion = (TextView)v.findViewById(R.id.txvNotDescripcion);
        txvNotDescripcion.setText(vo.getDescripcion());
        return v;
    }
}
