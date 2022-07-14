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
public class Medico  {
    private int id_medico;
    private String nombre;
    private String turnoMedico;

    public Medico(int id_medico, String nombre, String turnoMedico) {
        this.id_medico = id_medico;
        this.nombre = nombre;
        this.turnoMedico = turnoMedico;
    }

    public Medico() {
    }

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTurnoMedico() {
        return turnoMedico;
    }

    public void setTurnoMedico(String turnoMedico) {
        this.turnoMedico = turnoMedico;
    }

    
    
}
