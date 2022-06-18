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
public class Medico extends Persona {
    private int id_medico;
    private String turnoMedico;

    public Medico(int id_medico, String turnoMedico, int id_persona, int dni, String nombre, String domicilio, String telefono, String email) {
        super(id_persona, dni, nombre, domicilio, telefono, email);
        this.id_medico = id_medico;
        this.turnoMedico = turnoMedico;
    }
    
}
