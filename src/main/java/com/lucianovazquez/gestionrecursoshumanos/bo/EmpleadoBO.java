/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucianovazquez.gestionrecursoshumanos.bo;

import com.lucianovazquez.gestionrecursoshumanos.dao.ConexionDAO;
import com.lucianovazquez.gestionrecursoshumanos.dao.EmpleadoDAO;
import com.lucianovazquez.gestionrecursoshumanos.entity.Empleado;
import javax.swing.JTable;

/**
 *
 * @author Lenovo 3
 */
public class EmpleadoBO {

    private String mensaje = "";
    private EmpleadoDAO emp = new EmpleadoDAO();
    private Empleado empleado = new Empleado();

    public String insert(Empleado empleado) {
        try {
            mensaje = emp.insert(empleado);
        } catch (Exception e) {
            mensaje = mensaje + "" + e.getMessage();
        }
        return mensaje;
    }

    public Empleado buscarEmpleadoDni(String dni) {
        try {
            empleado = emp.buscarEmpleadoDni(dni);
        } catch (Exception e) {
            mensaje = mensaje + "" + e.getMessage();
        }
        return empleado;
    }

    public Empleado buscarEmpleadoId(int id) {
        try {
            empleado = emp.buscarEmpleadoId(id);
        } catch (Exception e) {
            mensaje = mensaje + "" + e.getMessage();
        }
        return empleado;
    }

    public void listarEmpleadosDni(JTable tabla, int dni) {
        try {
            emp.listarEmpleadosDni(tabla, dni);
        } catch (Exception e) {
            mensaje = mensaje + "" + e.getMessage();
        }

    }

    public void listarEmpleadosId(JTable tabla, Integer id) {
        try {
            emp.listarEmpleadosId(tabla, id);
        } catch (Exception e) {
            mensaje = mensaje + "" + e.getMessage();
        }
    }

}
