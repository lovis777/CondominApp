package com.condominio.proy.condominapp.activity.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lazar on 9/08/2016.
 */
public class BD extends SQLiteOpenHelper {

    private static String dbName = "condominio.db";
    private static String sqlporteria = "CREATE TABLE IF NOT EXISTS[porteria] ([id] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,[tipo] VARCHAR(20) NOT NULL,[nombre] VARCHAR(100),[observacion] VARCHAR(100),[data] VARCHAR(20),[hora] VARCHAR(10),[acompanhantes] INTEGER, [status] INTEGER);";
    private static String sqlpersona = "CREATE TABLE IF NOT EXISTS[persona] ([_id] INTEGER PRIMARY KEY AUTOINCREMENT, [nombre] VARCHAR(50), [bloco_ap] VARCHAR(20), [sexo] CHAR(1), [status] CHAR(1), [veiculo] CHAR(1));";
    private static String sqlveiculo = "CREATE TABLE IF NOT EXISTS[veiculo] ([_id] INTEGER PRIMARY KEY AUTOINCREMENT, [tipo] VARCHAR(10), [marca] VARCHAR(20), [modelo] VARCHAR(20), [color] VARCHAR(20), [placa] VARCHAR(10), [id_propietario] INTEGER CONSTRAINT [fk_propietario] REFERENCES [personaO]([_id]));";
    private static String sqlnotificacion = "CREATE TABLE IF NOT EXISTS[notificacion] ([_id] INTEGER PRIMARY KEY AUTOINCREMENT, [id_persona] INTEGER CONSTRAINT [fk_persona] REFERENCES [personaO]([_id]), [descripcion] VARCHAR(50), [data_hora] DATE);";
    private static String sqlreserva = "CREATE TABLE IF NOT EXISTS[reservas] ([id] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,[local] VARCHAR(20),[data] DATE,[id_persona] INTEGER CONSTRAINT [fk_persona_reserva] REFERENCES [persona]([_id]),[periodo] INTEGER);";
    private static int version = 1;

    public BD(Context ctx) {
        super(ctx, dbName, null, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(sqlporteria);
        db.execSQL(sqlpersona);
        db.execSQL(sqlnotificacion);
        db.execSQL(sqlveiculo);
        db.execSQL(sqlreserva);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
