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
    private int id_repartición;
    private String nombreFuncionario;

    public Funcionario(int id_funcionario, int id_repartición, String nombreFuncionario) {
        this.id_funcionario = id_funcionario;
        this.id_repartición = id_repartición;
        this.nombreFuncionario = nombreFuncionario;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public int getId_repartición() {
        return id_repartición;
    }

    public void setId_repartición(int id_repartición) {
        this.id_repartición = id_repartición;
    }

    public String getNombreFuncionario() {
        return nombreFuncionario;
    }

    public void setNombreFuncionario(String nombreFuncionario) {
        this.nombreFuncionario = nombreFuncionario;
    }
   
    
}
