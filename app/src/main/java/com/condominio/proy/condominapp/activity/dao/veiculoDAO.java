package com.condominio.proy.condominapp.activity.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.condominio.proy.condominapp.activity.objetos.veiculoO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lazar on 14/07/2016.
 */
public class veiculoDAO {

    private static String table_name = "veiculo";
    private static Context ctx;
    private static String[] columns = {"_id", "id_propietario", "tipo", "marca", "modelo", "cor", "placa"};

    public veiculoDAO(Context ctx) {
        this.ctx = ctx;
    }


    public boolean insert(veiculoO vo) {
        SQLiteDatabase db = new BD(ctx).getWritableDatabase();
        ContentValues ctv = new ContentValues();
        ctv.put("id_propietario", vo.getId_propietario());
        ctv.put("cor", vo.getCor());
        ctv.put("marca", vo.getMarca());
        ctv.put("modelo", vo.getModelo());
        ctv.put("placa", vo.getPlaca());
        ctv.put("tipo", vo.getTipo());

        return (db.insert(table_name, null, ctv) > 0);

    }

    public boolean delete(veiculoO vo) {
        SQLiteDatabase db = new BD(ctx).getWritableDatabase();
        return (db.delete(table_name, "_id=?", new String[]{vo.get_id().toString()}) > 0);
    }

    public boolean update(veiculoO vo) {
        SQLiteDatabase db = new BD(ctx).getWritableDatabase();

        ContentValues ctv = new ContentValues();
        ctv.put("id_proprietario", vo.getId_propietario());
        ctv.put("cor", vo.getCor());
        ctv.put("marca", vo.getMarca());
        ctv.put("modelo", vo.getModelo());
        ctv.put("veiculo", vo.getPlaca());
        ctv.put("tipo", vo.getTipo());

        return (db.update(table_name, ctv, "_id=?", new String[]{vo.get_id().toString()}) > 0);
    }

    public veiculoO getById(Integer ID) {
        SQLiteDatabase db = new BD(ctx).getWritableDatabase();

        Cursor rs = db.query(table_name, columns, "_id=?", new String[]{ID.toString()}, null, null, null);

        veiculoO vo = null;

        if (rs.moveToFirst()) {
            vo = new veiculoO();
            vo.set_id(rs.getInt(rs.getColumnIndex("_id")));
            vo.setId_propietario(rs.getInt(rs.getColumnIndex("id_propietario")));
            vo.setCor(rs.getString(rs.getColumnIndex("cor")));
            vo.setMarca(rs.getString(rs.getColumnIndex("marca")));
            vo.setModelo(rs.getString(rs.getColumnIndex("modelo")));
            vo.setTipo(rs.getString(rs.getColumnIndex("tipo")));
            vo.setPlaca(rs.getString(rs.getColumnIndex("placa")));

        }
        return vo;
    }

    public List<veiculoO> getAll() {

        ArrayList<veiculoO> lista = new ArrayList<veiculoO>();
        try {
            SQLiteDatabase db = new BD(ctx).getWritableDatabase();

            Cursor rs = db.rawQuery("select * from veiculo", null);
            if (rs != null && rs.getCount() != 0) {
                rs.moveToFirst();

                do {
                    veiculoO vo = new veiculoO();

                    vo.set_id(rs.getInt(rs.getColumnIndex("_id")));
                    vo.setId_propietario(rs.getInt(rs.getColumnIndex("id_propietario")));
                    vo.setCor(rs.getString(rs.getColumnIndex("cor")));
                    vo.setMarca(rs.getString(rs.getColumnIndex("marca")));
                    vo.setModelo(rs.getString(rs.getColumnIndex("modelo")));
                    vo.setTipo(rs.getString(rs.getColumnIndex("tipo")));
                    vo.setPlaca(rs.getString(rs.getColumnIndex("placa")));

                    lista.add(vo);
                } while (rs.moveToNext());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public int getidentificador(String nombre) {
        int retorno = 0;
        try {
            SQLiteDatabase db = new BD(ctx).getWritableDatabase();

            Cursor rs = db.rawQuery("select _id from persona where nombre =" + nombre, null);
            if (rs != null && rs.getCount() != 0) {
                rs.moveToFirst();

                do {
                    retorno = (rs.getInt(rs.getColumnIndex("_id")));
                } while (rs.moveToNext());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return retorno;
    }

}
