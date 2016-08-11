package com.condominio.proy.condominapp.activity.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.condominio.proy.condominapp.activity.objetos.personaO;
import com.condominio.proy.condominapp.activity.objetos.reservaO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by glerison on 23/07/2016.
 */
public class reservaDAO {

    private static String table_name = "reservas";
    private static Context ctx;
    private static String[] columns = {"id", "local", "data", "id_persona", "periodo"};

    public reservaDAO(Context ctx) {
        this.ctx = ctx;
    }

    public boolean insert(reservaO vo) {
        SQLiteDatabase db = new BD(ctx).getWritableDatabase();
        ContentValues ctv = new ContentValues();
        ctv.put("local", vo.getLocal());
        ctv.put("data", vo.getData().toString());
        ctv.put("id_persona", vo.getId_persona());
        ctv.put("periodo", vo.getPeriodo());

        return (db.insert(table_name, null, ctv) > 0);

    }

    public boolean delete(reservaO vo) {
        SQLiteDatabase db = new BD(ctx).getWritableDatabase();
        return (db.delete(table_name, "id=?", new String[]{vo.getId().toString()}) > 0);
    }

    public boolean update(reservaO vo) {
        SQLiteDatabase db = new BD(ctx).getWritableDatabase();

        ContentValues ctv = new ContentValues();
        ctv.put("local", vo.getLocal());
        ctv.put("data", Date.parse(vo.getData().toString()));
        ctv.put("id_pessoa", vo.getId_persona());
        ctv.put("periodo", vo.getPeriodo());


        return (db.update(table_name, ctv, "id=?", new String[]{vo.getId().toString()}) > 0);
    }

    public reservaO getById(Integer ID) {
        SQLiteDatabase db = new BD(ctx).getWritableDatabase();

        Cursor rs = db.query(table_name, columns, "id=?", new String[]{ID.toString()}, null, null, null);

        reservaO vo = null;
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        if (rs.moveToFirst()) {
            vo = new reservaO();
            try {
                Date data = f.parse(rs.getString(rs.getColumnIndex("data")));

                vo.setId(Integer.parseInt(rs.getString(rs.getColumnIndex("id"))));
                vo.setData(data);
                vo.setId_persona(Integer.parseInt(rs.getString(rs.getColumnIndex("id_persona"))));
                vo.setLocal((rs.getString(rs.getColumnIndex("local"))));
                vo.setPeriodo(Integer.parseInt(rs.getString(rs.getColumnIndex("periodo"))));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return vo;
    }

    public List<reservaO> getAll() {
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<reservaO> lista = new ArrayList<reservaO>();
        try {
            SQLiteDatabase db = new BD(ctx).getWritableDatabase();
            String data_atual = f.format(new Date().getTime());
            Cursor rs = db.rawQuery("select * from reservas where data >='" + data_atual + "'", null);
            if (rs != null && rs.getCount() != 0) {
                rs.moveToFirst();

                do {
                    reservaO vo = new reservaO();
                    try {
                        Date data = f.parse(rs.getString(rs.getColumnIndex("data")));

                        vo.setId(Integer.parseInt(rs.getString(rs.getColumnIndex("id"))));
                        vo.setData(data);
                        vo.setId_persona(Integer.parseInt(rs.getString(rs.getColumnIndex("id_persona"))));
                        vo.setLocal((rs.getString(rs.getColumnIndex("local"))));
                        vo.setPeriodo(Integer.parseInt(rs.getString(rs.getColumnIndex("periodo"))));
                        lista.add(vo);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                } while (rs.moveToNext());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
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
