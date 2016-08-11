package com.condominio.proy.condominapp.activity.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.condominio.proy.condominapp.activity.objetos.personaO;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by glerison on 13/05/2015.
 */
public class personaDAO {

    private static String table_name = "persona";
    private static Context ctx;
    private static String[] columns = {"_id","nome","bloco_ap","sexo","status","veiculo"};

    public personaDAO(Context ctx) {
        this.ctx=ctx;
    }

    public boolean insert(personaO vo){
        SQLiteDatabase db = new BD(ctx).getWritableDatabase();
        ContentValues ctv = new ContentValues();
        ctv.put("nombre", vo.getNombre());
        ctv.put("bloco_ap", vo.getBloco_ap());
        ctv.put("sexo", vo.getSexo());
        ctv.put("status", vo.getStatus());
        ctv.put("veiculo", vo.getVeiculo());

        return (db.insert(table_name, null, ctv) > 0 );

    }

    public boolean delete(personaO vo){
        SQLiteDatabase db = new BD(ctx).getWritableDatabase();
        return (db.delete(table_name, "_id=?", new String[] {vo.get_id().toString()}) > 0);
    }

    public boolean update(personaO vo){
        SQLiteDatabase db = new BD(ctx).getWritableDatabase();

        ContentValues ctv = new ContentValues();
        ctv.put("nombre", vo.getNombre());
        ctv.put("bloco_ap", vo.getBloco_ap());
        ctv.put("sexo", vo.getSexo());
        ctv.put("status", vo.getStatus());
        ctv.put("veiculo", vo.getVeiculo());

        return (db.update(table_name, ctv, "_id=?", new String[] {vo.get_id().toString()}) > 0);
    }

    public personaO getById(Integer ID){
        SQLiteDatabase db = new BD(ctx).getWritableDatabase();

        Cursor rs = db.query(table_name, columns, "_id=?", new String[] {ID.toString()}, null, null, null);

        personaO vo = null;

        if(rs.moveToFirst()){
            vo = new personaO();
            vo.set_id(rs.getInt(rs.getColumnIndex("_id")));
            vo.setNombre(rs.getString(rs.getColumnIndex("nombre")));
            vo.setBloco_ap(rs.getString(rs.getColumnIndex("bloco_ap")));
            vo.setSexo(rs.getString(rs.getColumnIndex("sexo")));
            vo.setStatus(rs.getString(rs.getColumnIndex("status")));
            vo.setVeiculo(rs.getString(rs.getColumnIndex("veiculo")));

        }
        return vo;
    }

    public List<personaO> getAll(){

        ArrayList<personaO> lista = new ArrayList<personaO>();
        try {
            SQLiteDatabase db = new BD(ctx).getWritableDatabase();

            Cursor rs = db.rawQuery("select * from persona", null);
            if(rs != null && rs.getCount() != 0){
                rs.moveToFirst();

                do{
                    personaO vo = new personaO();

                    vo.set_id(rs.getInt(rs.getColumnIndex("_id")));
                    vo.setNombre(rs.getString(rs.getColumnIndex("nombre")));
                    vo.setBloco_ap(rs.getString(rs.getColumnIndex("bloco_ap")));
                    vo.setSexo(rs.getString(rs.getColumnIndex("sexo")));
                    vo.setStatus(rs.getString(rs.getColumnIndex("status")));
                    vo.setVeiculo(rs.getString(rs.getColumnIndex("veiculo")));

                    lista.add(vo);
                }while (rs.moveToNext());
            }


        }catch (Exception e){
            e.printStackTrace();
        }
        return lista;
    }

    public List<personaO> getNombre(){

        ArrayList<personaO> lista = new ArrayList<personaO>();
        try {
            SQLiteDatabase db = new BD(ctx).getWritableDatabase();

            Cursor rs = db.rawQuery("select nome from persona where veiculo = 'S'", null);
            if(rs != null && rs.getCount() != 0){
                rs.moveToFirst();

                do{
                    personaO vo = new personaO();
                    vo.setNombre(rs.getString(rs.getColumnIndex("nombre")));
                    lista.add(vo);
                }while (rs.moveToNext());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return lista;
    }

    public List<personaO> getNombreTodos(){

        ArrayList<personaO> lista = new ArrayList<personaO>();
        try {
            SQLiteDatabase db = new BD(ctx).getWritableDatabase();

            Cursor rs = db.rawQuery("select nombre from persona ", null);
            if(rs != null && rs.getCount() != 0){
                rs.moveToFirst();

                do{
                    personaO vo = new personaO();
                    vo.setNombre(rs.getString(rs.getColumnIndex("nombre")));
                    lista.add(vo);
                }while (rs.moveToNext());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return lista;
    }

    public int getidentificador(String nome){
        int retorno = 0;
        try {
            SQLiteDatabase db = new BD(ctx).getWritableDatabase();

            Cursor rs = db.rawQuery("select _id from persona where nombre ='"+nome+"'", null);
            if(rs != null && rs.getCount() != 0){
                rs.moveToFirst();

                do{
                    retorno = (rs.getInt(rs.getColumnIndex("_id")));
                }while (rs.moveToNext());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return retorno;
    }
}
