/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucianovazquez.gestionrecursoshumanos.bo;

import com.lucianovazquez.gestionrecursoshumanos.dao.ReporteDAO;
import javax.swing.JTable;

/**
 *
 * @author Lenovo 3
 */
public class ReporteBO {

    ReporteDAO rep = new ReporteDAO();

    public void listarAreasAñoActual(JTable jTable1) {
        try {
            rep.listarAreasAñoActual(jTable1);
        } catch (Exception e) {
            System.out.println("ERROR AL LISTAR REPORTE INASISTENCIA POR AREA");
        }
    }

    public void listarEmpleadosAñoActual(JTable jTable2) {
         try {
            rep.listarEmpleadosAñoActual(jTable2);
        } catch (Exception e) {
            System.out.println("ERROR AL LISTAR REPORTE INASISTENCIA POR empleado");
        }
    }

    public void listarEmpleadosMesActual(JTable jTable2) {
        try {
            rep.listarEmpleadosMesActual(jTable2);
        } catch (Exception e) {
            System.out.println("ERROR AL LISTAR REPORTE INASISTENCIA POR empleado");
        }}

    public void listarAreasMesActual(JTable jTable1) {
        try {
            rep.listarAreasMesActual(jTable1);
        } catch (Exception e) {
            System.out.println("ERROR AL LISTAR REPORTE INASISTENCIA POR AREA");
        }
    }

    public void listarEmpleadosSemanaActual(JTable jTable2) {
        try {
            rep.listarEmpleadosSemanaActual(jTable2);
        } catch (Exception e) {
            System.out.println("ERROR AL LISTAR REPORTE INASISTENCIA POR empleado");
        }
    }

    public void listarAreasSemanaActual(JTable jTable1) {
        try {
            rep.listarAreasSemanaActual(jTable1);
        } catch (Exception e) {
            System.out.println("ERROR AL LISTAR REPORTE INASISTENCIA POR AREA");
        }
    }
}
