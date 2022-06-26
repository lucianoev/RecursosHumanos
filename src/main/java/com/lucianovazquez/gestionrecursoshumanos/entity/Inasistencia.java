/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucianovazquez.gestionrecursoshumanos.entity;

/**
 *
 * @author Lenovo 3
 */
public class Inasistencia {
    private int id_inasistencia;
    private int id_empleado;
    private String diaInasistencia;
    private String tipo;
    private String observacionInasistencia;

    public Inasistencia(int id_inasistencia, int id_empleado, String diaInasistencia, String tipo, String observacionInasistencia) {
        this.id_inasistencia = id_inasistencia;
        this.id_empleado = id_empleado;
        this.diaInasistencia = diaInasistencia;
        this.tipo = tipo;
        this.observacionInasistencia = observacionInasistencia;
    }

    public int getId_inasistencia() {
        return id_inasistencia;
    }

    public void setId_inasistencia(int id_inasistencia) {
        this.id_inasistencia = id_inasistencia;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getDiaInasistencia() {
        return diaInasistencia;
    }

    public void setDiaInasistencia(String diaInasistencia) {
        this.diaInasistencia = diaInasistencia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getObservacionInasistencia() {
        return observacionInasistencia;
    }

    public void setObservacionInasistencia(String observacionInasistencia) {
        this.observacionInasistencia = observacionInasistencia;
    }
    
}
