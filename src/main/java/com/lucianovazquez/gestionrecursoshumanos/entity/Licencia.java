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
public class Licencia {
    private int id_licencia;
    private int id_empleado;
    private int id_medico;
    private String tipoLicencia;
    private String diaInicio;
    private String diaFin;
    private String estadoLicencia;
    private String observacionLicencia;

    public Licencia(int id_licencia, int id_empleado, int id_medico, String tipoLicencia, String diaInicio, String diaFin, String estadoLicencia, String observacionLicencia) {
        this.id_licencia = id_licencia;
        this.id_empleado = id_empleado;
        this.id_medico = id_medico;
        this.tipoLicencia = tipoLicencia;
        this.diaInicio = diaInicio;
        this.diaFin = diaFin;
        this.estadoLicencia = estadoLicencia;
        this.observacionLicencia = observacionLicencia;
    }

    public Licencia() { 
    }

    public int getId_licencia() {
        return id_licencia;
    }

    public void setId_licencia(int id_licencia) {
        this.id_licencia = id_licencia;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }

    public String getTipoLicencia() {
        return tipoLicencia;
    }

    public void setTipoLicencia(String tipoLicencia) {
        this.tipoLicencia = tipoLicencia;
    }

    public String getDiaInicio() {
        return diaInicio;
    }

    public void setDiaInicio(String diaInicio) {
        this.diaInicio = diaInicio;
    }

    public String getDiaFin() {
        return diaFin;
    }

    public void setDiaFin(String diaFin) {
        this.diaFin = diaFin;
    }

    public String getEstadoLicencia() {
        return estadoLicencia;
    }

    public void setEstadoLicencia(String estadoLicencia) {
        this.estadoLicencia = estadoLicencia;
    }

    public String getObservacionLicencia() {
        return observacionLicencia;
    }

    public void setObservacionLicencia(String observacionLicencia) {
        this.observacionLicencia = observacionLicencia;
    }
   
}
