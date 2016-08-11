package com.condominio.proy.condominapp.activity.objetos;

/**
 * Created by glerison on 05/08/2016.
 */
public class porteriaO {
    private Integer id;
    private String nombre;
    private String observacion;
    private String tipo;
    private String data;
    private String hora;
    private Integer acompanhantes;
    private int status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Integer getAcompanhantes() {
        return acompanhantes;
    }

    public void setAcompanhantes(Integer acompanhantes) {
        this.acompanhantes = acompanhantes;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
