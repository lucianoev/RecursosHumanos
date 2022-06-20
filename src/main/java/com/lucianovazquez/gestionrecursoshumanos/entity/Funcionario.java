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

    public Funcionario(int id_funcionario, int id_repartición, int id_persona, int dni, String nombre, String domicilio, String telefono, String email) {
       
        this.id_funcionario = id_funcionario;
        this.id_repartición = id_repartición;
    }
    
}
