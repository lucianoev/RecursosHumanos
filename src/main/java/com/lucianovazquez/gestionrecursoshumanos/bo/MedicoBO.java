/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucianovazquez.gestionrecursoshumanos.bo;

import com.lucianovazquez.gestionrecursoshumanos.dao.MedicoDAO;
import com.lucianovazquez.gestionrecursoshumanos.entity.Medico;

/**
 *
 * @author Lenovo 3
 */
public class MedicoBO {

    Medico medico = new Medico();
    MedicoDAO medDAO = new MedicoDAO();
    String mensaje = null;

    public Medico obtenerMedicoTurno(String turno) {
        try {
            medico = medDAO.obtenerMedicoTurno(turno);
        } catch (Exception e) {
            mensaje = mensaje + e.getMessage();
        }
        return medico;
    }

}
