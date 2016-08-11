package com.condominio.proy.condominapp.activity.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.condominio.proy.condominapp.activity.objetos.porteriaO;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by lazar on 06/07/2016.
 */
public class porteriaDAO {

    private static String table_name = "porteria";
    private static Context ctx;
    private static String[] columns = {"id", "nombre", "tipo", "observacion", "data", "hora", "acompanhantes", "status"};

    public porteriaDAO(Context ctx) {
        this.ctx = ctx;
    }

    public boolean insert(porteriaO vo) {
        SQLiteDatabase db = new BD(ctx).getWritableDatabase();
        ContentValues ctv = new ContentValues();
        ctv.put("nombre", vo.getNombre());
        ctv.put("tipo", vo.getTipo());
        ctv.put("observacion", vo.getObservacion());
        ctv.put("data", vo.getData());
        ctv.put("hora", vo.getHora());
        ctv.put("acompanhantes", vo.getAcompanhantes());
        ctv.put("status", vo.getStatus());

        return (db.insert(table_name, null, ctv) > 0);

    }

    public boolean delete(porteriaO vo) {
        SQLiteDatabase db = new BD(ctx).getWritableDatabase();
        return (db.delete(table_name, "id=?", new String[]{vo.getId().toString()}) > 0);
    }

    public boolean update(porteriaO vo) {
        SQLiteDatabase db = new BD(ctx).getWritableDatabase();

        ContentValues ctv = new ContentValues();
        ctv.put("nome", vo.getNombre());
        ctv.put("tipo", vo.getTipo());
        ctv.put("observacao", vo.getObservacion());
        ctv.put("data", vo.getData());
        ctv.put("hora", vo.getHora());
        ctv.put("acompanhantes", vo.getAcompanhantes());
        ctv.put("status", vo.getStatus());

        return (db.update(table_name, ctv, "id=?", new String[]{vo.getId().toString()}) > 0);
    }

    public porteriaO getById(Integer ID) {
        SQLiteDatabase db = new BD(ctx).getWritableDatabase();

        Cursor rs = db.query(table_name, columns, "id=?", new String[]{ID.toString()}, null, null, null);

        porteriaO vo = null;

        if (rs.moveToFirst()) {
            vo = new porteriaO();
            vo.setId(rs.getInt(rs.getColumnIndex("id")));
            vo.setNombre(rs.getString(rs.getColumnIndex("nombre")));
            vo.setObservacion(rs.getString(rs.getColumnIndex("observacion")));
            vo.setData(rs.getString(rs.getColumnIndex("data")));
            vo.setHora(rs.getString(rs.getColumnIndex("hora")));
            vo.setAcompanhantes(rs.getInt(rs.getColumnIndex("acompanhantes")));
            vo.setTipo(rs.getString(rs.getColumnIndex("tipo")));
            vo.setStatus(rs.getInt(rs.getColumnIndex("status")));
        }
        return vo;
    }

    public List<porteriaO> getAll() {

        ArrayList<porteriaO> lista = new ArrayList<porteriaO>();
        try {
            SQLiteDatabase db = new BD(ctx).getWritableDatabase();

            Cursor rs = db.rawQuery("select * from porteria", null);
            if (rs != null && rs.getCount() != 0) {
                rs.moveToFirst();

                do {
                    porteriaO vo = new porteriaO();

                    vo.setId(Integer.parseInt(rs.getString(rs.getColumnIndex("id"))));
                    vo.setTipo(rs.getString(rs.getColumnIndex("tipo")));
                    vo.setNombre(rs.getString(rs.getColumnIndex("nombre")));
                    vo.setObservacion(rs.getString(rs.getColumnIndex("observacion")));
                    vo.setData(rs.getString(rs.getColumnIndex("data")));
                    vo.setHora(rs.getString(rs.getColumnIndex("hora")));
                    vo.setAcompanhantes(Integer.valueOf(rs.getString(rs.getColumnIndex("acompanhantes"))));
                    vo.setStatus(Integer.parseInt(rs.getString(rs.getColumnIndex("status"))));

                    lista.add(vo);
                } while (rs.moveToNext());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

}
