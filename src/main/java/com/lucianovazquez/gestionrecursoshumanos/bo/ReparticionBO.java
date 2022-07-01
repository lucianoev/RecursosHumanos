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

    public Reparticion buscarReparticion(int id) {
        reparticion = rep.buscarReparticion(id);
        return reparticion;
    }
    
}
