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
public class Reparticion {
    private int id_reparticion;
    private int id_funcionario;
    private String nombreReparticion;

    public Reparticion(int id_reparticion, int id_funcionario, String nombreReparticion) {
        this.id_reparticion = id_reparticion;
        this.id_funcionario = id_funcionario;
        this.nombreReparticion = nombreReparticion;
    }

    public Reparticion() {
    }

    public int getId_reparticion() {
        return id_reparticion;
    }

    public void setId_reparticion(int id_reparticion) {
        this.id_reparticion = id_reparticion;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public String getNombreReparticion() {
        return nombreReparticion;
    }

    public void setNombreReparticion(String nombreReparticion) {
        this.nombreReparticion = nombreReparticion;
    }
    
    
}
