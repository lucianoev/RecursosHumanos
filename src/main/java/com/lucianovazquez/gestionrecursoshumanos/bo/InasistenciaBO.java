/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucianovazquez.gestionrecursoshumanos.bo;

import com.lucianovazquez.gestionrecursoshumanos.dao.InasistenciaDAO;
import com.lucianovazquez.gestionrecursoshumanos.entity.Inasistencia;
import javax.swing.JTable;
import java.time.*;
import java.util.TimerTask;

/**
 *
 * @author Lenovo 3
 */
public class InasistenciaBO {

    private String mensaje = "";
    private InasistenciaDAO ina = new InasistenciaDAO();
//    private InasistenciaBO inabo = new InasistenciaBO();

    public String insert(Inasistencia inasistencia) {
        try {
            mensaje = ina.insert(inasistencia);
        } catch (Exception e) {
            mensaje = mensaje + "" + e.getMessage();
        }
        return mensaje;
    }

    public void listarInasistencia(JTable tabla, LocalDate dia) {
        ina.listarInasistencia(tabla, dia);
    }

    
    public void run() {
        try {

        } catch (Exception e) {
        }
    }

    public void listarInasistenciaEmpleadoRango(JTable jTable1, LocalDate jdateInicio, LocalDate jdateFin, int id_empleado) {
        ina.listaInasistenciaEmpleadoRango(jTable1, jdateInicio, jdateFin, id_empleado);
    }

   

}
