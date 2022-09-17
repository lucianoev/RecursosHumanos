/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucianovazquez.gestionrecursoshumanos.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo 3
 */
public class ReporteDAO {

    int c = 0;

    public void listarAreasAñoActual(JTable tabla) {
        DefaultTableModel model;
        String[] columnas = {"ID", "Repartición","Inasistencias totales"};
        model = new DefaultTableModel(null, columnas);
        String sql = "SELECT id_reparticion AS id, nombreReparticion,(SELECT COUNT(*) FROM inasistencia INNER JOIN empleado ON inasistencia.id_empleado=empleado.id_empleado INNER JOIN reparticion ON empleado.id_reparticion=reparticion.id_reparticion WHERE reparticion.id_reparticion=id AND YEAR(inasistencia.diaInasistencia)=YEAR(CURRENT_DATE())) AS total FROM reparticion ORDER BY total DESC";
        String[] filas = new String[3];

        ResultSet rs = null;

        try {
            PreparedStatement pst = ConexionDAO.getConnection().prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                for (int i = 0; i < 3; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }

            tabla.setModel(model);

        } catch (Exception e) {
            System.out.println("ERROR AL CARGAR TABLA reporte area año actual" + e.getMessage());
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ReporteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public void listarAreasMesActual(JTable tabla) {
        DefaultTableModel model;
        String[] columnas = {"ID", "Repartición","Inasistencias totales"};
        model = new DefaultTableModel(null, columnas);
        String sql = "SELECT id_reparticion AS id, nombreReparticion,(SELECT COUNT(*) FROM inasistencia INNER JOIN empleado ON inasistencia.id_empleado=empleado.id_empleado INNER JOIN reparticion ON empleado.id_reparticion=reparticion.id_reparticion WHERE reparticion.id_reparticion=id AND YEAR(inasistencia.diaInasistencia)=YEAR(CURRENT_DATE()) AND MONTH(inasistencia.diaInasistencia)=MONTH(CURRENT_DATE())) AS total FROM reparticion ORDER BY total DESC";
        String[] filas = new String[3];

        ResultSet rs = null;

        try {
            PreparedStatement pst = ConexionDAO.getConnection().prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                for (int i = 0; i < 3; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }

            tabla.setModel(model);

        } catch (Exception e) {
            System.out.println("ERROR AL CARGAR TABLA reporte area mes actual" + e.getMessage());
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ReporteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public void listarAreasSemanaActual(JTable tabla) {
        DefaultTableModel model;
        String[] columnas = {"ID", "Repartición","Inasistencias totales"};
        model = new DefaultTableModel(null, columnas);
        String sql = "SELECT id_reparticion AS id, nombreReparticion,(SELECT COUNT(*) FROM inasistencia INNER JOIN empleado ON inasistencia.id_empleado=empleado.id_empleado INNER JOIN reparticion ON empleado.id_reparticion=reparticion.id_reparticion WHERE reparticion.id_reparticion=id AND YEARWEEK(inasistencia.diaInasistencia)=YEARWEEK(CURRENT_DATE())) AS total FROM reparticion ORDER BY total DESC";
        String[] filas = new String[3];

        ResultSet rs = null;

        try {
            PreparedStatement pst = ConexionDAO.getConnection().prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                for (int i = 0; i < 3; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }

            tabla.setModel(model);

        } catch (Exception e) {
            System.out.println("ERROR AL CARGAR TABLA reporte area semana actual" + e.getMessage());
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ReporteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    

    public void listarEmpleadosAñoActual(JTable tabla) {
       DefaultTableModel model;
        String[] columnas = {"N° Legajo", "Apellido, Nombre","Repartición", "Inasistencias"};
        model = new DefaultTableModel(null, columnas);
        String sql = "SELECT id_empleado AS id, CONCAT(empleado.apellido,', ',empleado.nombre), nombreReparticion,(SELECT COUNT(*) FROM inasistencia INNER JOIN empleado ON inasistencia.id_empleado=empleado.id_empleado INNER JOIN reparticion ON empleado.id_reparticion=reparticion.id_reparticion WHERE empleado.id_empleado=id AND YEAR(inasistencia.diaInasistencia)=YEAR(CURRENT_DATE())) AS total FROM empleado INNER JOIN reparticion ON empleado.id_reparticion=reparticion.id_reparticion ORDER BY total DESC";
        String[] filas = new String[4];

        ResultSet rs = null;

        try {
            PreparedStatement pst = ConexionDAO.getConnection().prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                for (int i = 0; i < 4; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }

            tabla.setModel(model);

        } catch (Exception e) {
            System.out.println("ERROR AL CARGAR TABLA reporte inasistencias por empleado, año actual" + e.getMessage());
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ReporteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public void listarEmpleadosMesActual(JTable tabla) {
       DefaultTableModel model;
        String[] columnas = {"N° Legajo", "Apellido, Nombre","Repartición", "Inasistencias"};
        model = new DefaultTableModel(null, columnas);
        String sql = "SELECT id_empleado AS id, CONCAT(empleado.apellido,', ',empleado.nombre), nombreReparticion,(SELECT COUNT(*) FROM inasistencia INNER JOIN empleado ON inasistencia.id_empleado=empleado.id_empleado INNER JOIN reparticion ON empleado.id_reparticion=reparticion.id_reparticion WHERE empleado.id_empleado=id AND YEAR(inasistencia.diaInasistencia)=YEAR(CURRENT_DATE()) AND MONTH(inasistencia.diaInasistencia)=MONTH(CURRENT_DATE())) AS total FROM empleado INNER JOIN reparticion ON empleado.id_reparticion=reparticion.id_reparticion ORDER BY total DESC";
        String[] filas = new String[4];

        ResultSet rs = null;

        try {
            PreparedStatement pst = ConexionDAO.getConnection().prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                for (int i = 0; i < 4; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }

            tabla.setModel(model);

        } catch (Exception e) {
            System.out.println("ERROR AL CARGAR TABLA reporte inasistencias por empleado, mes actual" + e.getMessage());
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ReporteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
     public void listarEmpleadosSemanaActual(JTable tabla) {
       DefaultTableModel model;
        String[] columnas = {"N° Legajo", "Apellido, Nombre","Repartición", "Inasistencias"};
        model = new DefaultTableModel(null, columnas);
        String sql = "SELECT id_empleado AS id, CONCAT(empleado.apellido,', ',empleado.nombre), nombreReparticion,(SELECT COUNT(*) FROM inasistencia INNER JOIN empleado ON inasistencia.id_empleado=empleado.id_empleado INNER JOIN reparticion ON empleado.id_reparticion=reparticion.id_reparticion WHERE empleado.id_empleado=id AND YEARWEEK(inasistencia.diaInasistencia)=YEARWEEK(CURRENT_DATE())) AS total FROM empleado INNER JOIN reparticion ON empleado.id_reparticion=reparticion.id_reparticion ORDER BY total DESC";
        String[] filas = new String[4];

        ResultSet rs = null;

        try {
            PreparedStatement pst = ConexionDAO.getConnection().prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                for (int i = 0; i < 4; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }

            tabla.setModel(model);

        } catch (Exception e) {
            System.out.println("ERROR AL CARGAR TABLA reporte inasistencias por empleado, semana actual" + e.getMessage());
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ReporteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
