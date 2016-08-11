package com.condominio.proy.condominapp.activity.objetos;

/**
 * Created by lazar on 9/08/2016.
 */
public class notificacionO {
    private Integer _id;
    private Integer id_persona;
    private String descripcion;
    private String data;

    public notificacionO(){

    }


    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public Integer getId_persona() {
        return id_persona;
    }

    public void setId_persona(Integer id_persona) {
        this.id_persona = id_persona;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
