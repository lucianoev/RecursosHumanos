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
public class Funcionario  {
    private int id_funcionario;
    private int id_reparticion;
    private String nombreFuncionario;

    public Funcionario(int id_funcionario, int id_reparticion, String nombreFuncionario) {
        this.id_funcionario = id_funcionario;
        this.id_reparticion = id_reparticion;
        this.nombreFuncionario = nombreFuncionario;
    }

    public Funcionario() {
  
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public int getId_reparticion() {
        return id_reparticion;
    }

    public void setId_reparticion(int id_reparticion) {
        this.id_reparticion = id_reparticion;
    }

    public String getNombreFuncionario() {
        return nombreFuncionario;
    }

    public void setNombreFuncionario(String nombreFuncionario) {
        this.nombreFuncionario = nombreFuncionario;
    }
   
    
}
