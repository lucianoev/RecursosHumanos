/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucianovazquez.gestionrecursoshumanos.bo;

import com.lucianovazquez.gestionrecursoshumanos.dao.ReparticionDAO;
import com.lucianovazquez.gestionrecursoshumanos.entity.Reparticion;

/**
 *
 * @author Lenovo 3
 */
public class ReparticionBO {

    private ReparticionDAO rep = new ReparticionDAO();
    private Reparticion reparticion = new Reparticion();
    int idFun;

    public Reparticion buscarReparticion(int id) {
        try {
            reparticion = rep.buscarReparticion(id);
        } catch (Exception e) {
            System.out.println("Error al Recuperar Nombre de Repartición:" + e.getMessage());
        }
        return reparticion;
    }

    public int recuperarIdFuncionarioRep(int idRep) {
        try {
            idFun = rep.recuperarIdFuncionarioRep(idRep);
        } catch (Exception e) {
            System.out.println("Error al recuperar ID Funcionario con ID Repartición: " + e.getMessage());
        }
        return idFun;
    }

}
