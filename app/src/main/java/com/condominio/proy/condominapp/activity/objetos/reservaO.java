package com.condominio.proy.condominapp.activity.objetos;

import java.util.Date;

/**
 * Created by lazar on 03/08/2016.
 */
public class reservaO {

    private Integer id;
    private String local;
    private Date data;
    private Integer id_persona;
    private Integer periodo;

    public reservaO(){}


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getId_persona() {
        return id_persona;
    }

    public void setId_persona(Integer id_persona) {
        this.id_persona = id_persona;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }
}
