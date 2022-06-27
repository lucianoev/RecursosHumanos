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
public class Tardanza {
    private int id_tardanza;
    private int id_empleado;
    private String diaTardanza;
    private String tiempoTardanza;
    private String observacionTardanza;

     public Tardanza() {
    }
     
    public Tardanza(int id_tardanza, int id_empleado, String diaTardanza, String tiempoTardanza, String observacionTardanza) {
        this.id_tardanza = id_tardanza;
        this.id_empleado = id_empleado;
        this.diaTardanza = diaTardanza;
        this.tiempoTardanza = tiempoTardanza;
        this.observacionTardanza = observacionTardanza;
    }



    public int getId_tardanza() {
        return id_tardanza;
    }

    public void setId_tardanza(int id_tardanza) {
        this.id_tardanza = id_tardanza;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getDiaTardanza() {
        return diaTardanza;
    }

    public void setDiaTardanza(String diaTardanza) {
        this.diaTardanza = diaTardanza;
    }

    public String getTiempoTardanza() {
        return tiempoTardanza;
    }

    public void setTiempoTardanza(String tiempoTardanza) {
        this.tiempoTardanza = tiempoTardanza;
    }

    public String getObservacionTardanza() {
        return observacionTardanza;
    }

    public void setObservacionTardanza(String observacionTardanza) {
        this.observacionTardanza = observacionTardanza;
    }
    
    
}
