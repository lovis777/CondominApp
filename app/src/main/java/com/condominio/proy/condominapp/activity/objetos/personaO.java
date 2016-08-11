package com.condominio.proy.condominapp.activity.objetos;

/**
 * Created by lazar on 03/08/2016.
 */
public class personaO {

    private Integer _id;
    private String nombre;
    private String bloco_ap;
    private String sexo;
    private String status;
    private String veiculo;

    public personaO(){

    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBloco_ap() {
        return bloco_ap;
    }

    public void setBloco_ap(String bloco_ap) {
        this.bloco_ap = bloco_ap;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }
}
