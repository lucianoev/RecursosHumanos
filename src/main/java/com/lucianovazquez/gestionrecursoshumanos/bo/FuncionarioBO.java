/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucianovazquez.gestionrecursoshumanos.bo;

import com.lucianovazquez.gestionrecursoshumanos.dao.FuncionarioDAO;
import com.lucianovazquez.gestionrecursoshumanos.entity.Funcionario;

/**
 *
 * @author Lenovo 3
 */
public class FuncionarioBO {
     private FuncionarioDAO fun = new FuncionarioDAO();
    private Funcionario reparticion = new Funcionario();

    public Funcionario buscarFuncionario(int id) {
        reparticion = fun.buscarFuncionario(id);
        return reparticion;
    }
}
