package com.condominio.proy.condominapp.activity.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.condominio.proy.condominapp.activity.objetos.notificacionO;
import com.condominio.proy.condominapp.activity.objetos.personaO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lazar on 9/08/2016.
 */
public class notificacionDAO {

    private static String table_name = "notificacion";
    private static Context ctx;
    private static String[] columns = {"_id", "id_persona", "descripcion", "data_hora"};

    public notificacionDAO(Context ctx) {
        this.ctx = ctx;
    }

    public boolean insert(notificacionO vo) {
        SQLiteDatabase db = new BD(ctx).getWritableDatabase();
        ContentValues ctv = new ContentValues();
        ctv.put("descripcion", vo.getDescripcion());
        ctv.put("data_hora", vo.getData());
        ctv.put("id_persona", vo.getId_persona());

        return (db.insert(table_name, null, ctv) > 0);

    }

    public boolean delete(notificacionO vo) {
        SQLiteDatabase db = new BD(ctx).getWritableDatabase();
        return (db.delete(table_name, "_id=?", new String[]{vo.get_id().toString()}) > 0);
    }

    public boolean update(notificacionO vo) {
        SQLiteDatabase db = new BD(ctx).getWritableDatabase();

        ContentValues ctv = new ContentValues();
        ctv.put("descripcion", vo.getDescripcion());
        ctv.put("data", vo.getData());
        ctv.put("id_persona", vo.getId_persona());


        return (db.update(table_name, ctv, "_id=?", new String[]{vo.get_id().toString()}) > 0);
    }

    public notificacionO getById(Integer ID) {
        SQLiteDatabase db = new BD(ctx).getWritableDatabase();

        Cursor rs = db.query(table_name, columns, "_id=?", new String[]{ID.toString()}, null, null, null);

        notificacionO vo = null;

        if (rs.moveToFirst()) {
            vo = new notificacionO();
            vo.set_id(Integer.parseInt(rs.getString(rs.getColumnIndex("_id"))));
            vo.setData(rs.getString(rs.getColumnIndex("data_hora")));
            vo.setDescripcion(rs.getString(rs.getColumnIndex("descripcion")));
            vo.setId_persona(Integer.parseInt(rs.getString(rs.getColumnIndex("id_persona"))));
        }
        return vo;
    }

    public List<notificacionO> getAll() {

        ArrayList<notificacionO> lista = new ArrayList<notificacionO>();
        try {
            SQLiteDatabase db = new BD(ctx).getWritableDatabase();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy 23:59");
            String data_atual = formato.format(new Date().getTime());

            Cursor rs = db.rawQuery("select * from notificacion where data_hora <'" + data_atual + "'", null);
            if (rs != null && rs.getCount() != 0) {
                rs.moveToFirst();

                do {
                    notificacionO vo = new notificacionO();
                    vo.set_id(Integer.parseInt(rs.getString(rs.getColumnIndex("_id"))));
                    vo.setData(rs.getString(rs.getColumnIndex("data_hora")));
                    vo.setDescripcion(rs.getString(rs.getColumnIndex("descripcion")));
                    vo.setId_persona(Integer.parseInt(rs.getString(rs.getColumnIndex("id_persona"))));
                    lista.add(vo);
                } while (rs.moveToNext());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public int getidentificador(String nome) {
        int retorno = 0;
        try {
            SQLiteDatabase db = new BD(ctx).getWritableDatabase();

            Cursor rs = db.rawQuery("select _id from persona where nome =" + nome, null);
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

    public List<personaO> getNombreTodos() {

        ArrayList<personaO> lista = new ArrayList<personaO>();
        try {
            SQLiteDatabase db = new BD(ctx).getWritableDatabase();

            Cursor rs = db.rawQuery("select nombre from persona ", null);
            if (rs != null && rs.getCount() != 0) {
                rs.moveToFirst();

                do {
                    personaO vo = new personaO();
                    vo.setNombre(rs.getString(rs.getColumnIndex("nombre")));
                    lista.add(vo);
                } while (rs.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
