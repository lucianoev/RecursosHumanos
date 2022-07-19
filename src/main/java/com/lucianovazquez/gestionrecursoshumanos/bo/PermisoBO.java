/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucianovazquez.gestionrecursoshumanos.bo;

import com.lucianovazquez.gestionrecursoshumanos.dao.PermisoDAO;
import com.lucianovazquez.gestionrecursoshumanos.entity.Permiso;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JTable;

/**
 *
 * @author Lenovo 3
 */
public class PermisoBO {

    PermisoDAO per = new PermisoDAO();
    boolean control = false;

    public void listarPermisosDia(JTable jTable3, LocalDate dia) {
        per.listarPermisosDia(jTable3, dia);
    }

    public void listarPermisoEmpleadoRango(JTable jTable1, LocalDate jdateInicio, LocalDate jdateFin, int id_empleado) {
        per.listarPermisoEmpleadoRango(jTable1, jdateInicio, jdateFin, id_empleado);
    }

    public boolean controlPermisoVigente(LocalTime tiempoInicio, LocalTime tiempoFin, int id_empleado) {
        try {
            control = per.controlPermisoVigente(tiempoInicio, tiempoFin, id_empleado);
        } catch (Exception e) {
            System.out.println("ERROR AL REALIZAR CONTROL DE PERMISO VIGENTE" + e.getMessage());
        }
        return control;
    }

    public void listarPermisoEmpleado(JTable jTable1, int id_empleado) {
        try {
            per.listarPermisoEmpleado(jTable1, id_empleado);
        } catch (Exception e) {
            System.out.println("ERROR AL LISTAR PERMISOS POR EMPLEADO");
        }

    }

    public void insert(Permiso permiso) {
        try {
            per.insert(permiso);
        } catch (Exception e) {
            System.out.println("ERROR AL INSERTAR NUEVO PERMISO DE EMPLEADO");
        }
     }

}
