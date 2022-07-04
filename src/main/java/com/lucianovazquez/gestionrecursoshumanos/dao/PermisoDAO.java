/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucianovazquez.gestionrecursoshumanos.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo 3
 */
public class PermisoDAO {

    public void listarPermisosDia(JTable tabla, LocalDate dia) {
        
   
    DefaultTableModel model;
        String[] columnas = {"N°","Nombre","Apellido","D.N.I.","Horario Inicio","Horario Fin","Estado"};
        model = new DefaultTableModel(null,columnas);
        String sql = "SELECT row_number() OVER (ORDER BY horaInicio) AS id, nombre, apellido, dni, horaInicio, horaFin, estadoPermiso FROM permiso INNER JOIN empleado ON permiso.id_empleado = empleado.id_empleado WHERE diaPermiso=?";
        String [] filas = new String [8];
        
        System.out.println("CARGA TABLA PERMISOS");
        
        ResultSet rs = null;
        
        try {
            PreparedStatement pst = ConexionDAO.getConnection().prepareStatement(sql);
            System.out.println("Dia tabla permiso:"+dia.toString());
            pst.setString(1, dia.toString());

            rs = pst.executeQuery();
            while (rs.next()) {
                for (int i = 0; i < 7; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);

        } catch (Exception e) {
            System.out.println("ERROR AL CARGAR TABLA PERMISOS" + e.getMessage());
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(PermisoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void listarPermisoEmpleadoRango(JTable tabla, LocalDate jdateInicio, LocalDate jdateFin, int id_empleado) {
        DefaultTableModel model;
        String[] columnas = {"N°", "Día", "Horario Salida","Horario Regreso", "Estado"};
        model = new DefaultTableModel(null, columnas);
        String sql = "SELECT row_number() OVER (ORDER BY diaPermiso) AS id, diaPermiso, horaInicio, horaFin, estadoPermiso FROM permiso WHERE id_empleado=? AND diaPermiso BETWEEN ? AND ?";
        String[] filas = new String[5];

        System.out.println("CARGA TABLA PERMISOS");

        ResultSet rs = null;

        try {
            PreparedStatement pst = ConexionDAO.getConnection().prepareStatement(sql);
            System.out.println("inasistencias entre:" + jdateInicio.toString() + " hasta" + jdateFin.toString());
            pst.setInt(1, id_empleado);
            pst.setString(2, jdateInicio.toString());
            pst.setString(3, jdateFin.toString());

            rs = pst.executeQuery();
            while (rs.next()) {
                for (int i = 0; i < 4; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);

        } catch (Exception e) {
            System.out.println("ERROR AL CARGAR TABLA PERMISOS" + e.getMessage());
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(PermisoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}