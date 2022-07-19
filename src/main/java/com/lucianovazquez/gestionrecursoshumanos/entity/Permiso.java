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
public class Permiso {
    private int id_permiso;
    private int id_empleado;
    private int id_funcionario;
    private String horaInicio;
    private String horaFin;
    private String diaPermiso;
    private String estadoPermiso;
    private String observacionPermiso;

    public Permiso(int id_permiso, int id_empleado, int id_funcionario, String horaInicio, String horaFin, String diaPermiso, String estadoPermiso, String observacionPermiso) {
        this.id_permiso = id_permiso;
        this.id_empleado = id_empleado;
        this.id_funcionario = id_funcionario;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.diaPermiso = diaPermiso;
        this.estadoPermiso = estadoPermiso;
        this.observacionPermiso = observacionPermiso;
    }

    public Permiso() {
    }

    public int getId_permiso() {
        return id_permiso;
    }

    public void setId_permiso(int id_permiso) {
        this.id_permiso = id_permiso;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public String getDiaPermiso() {
        return diaPermiso;
    }

    public void setDiaPermiso(String diaPermiso) {
        this.diaPermiso = diaPermiso;
    }

    public String getEstadoPermiso() {
        return estadoPermiso;
    }

    public void setEstadoPermiso(String estadoPermiso) {
        this.estadoPermiso = estadoPermiso;
    }

    public String getObservacionPermiso() {
        return observacionPermiso;
    }

    public void setObservacionPermiso(String observacionPermiso) {
        this.observacionPermiso = observacionPermiso;
    }
    
    
}
