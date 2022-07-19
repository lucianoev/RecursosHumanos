/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucianovazquez.gestionrecursoshumanos.dao;

import com.lucianovazquez.gestionrecursoshumanos.entity.Permiso;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo 3
 */
public class PermisoDAO {
    boolean control = false;

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

    public boolean controlPermisoVigente(LocalTime tiempoInicio, LocalTime tiempoFin, int id_empleado) {
        String sql = "SELECT * FROM permiso WHERE id_empleado = ? AND (? BETWEEN horaInicio AND horaFin OR ? BETWEEN horaInicio AND horaFin) AND diaPermiso = ?;";
       try {
            PreparedStatement pst = ConexionDAO.getConnection().prepareStatement(sql);
            pst.setInt(1, id_empleado);
            pst.setString(2, tiempoInicio.toString());
            pst.setString(3, tiempoFin.toString());
            pst.setString(4, LocalDate.now().toString());

            ResultSet rs = pst.executeQuery();

            control = rs.next();
            System.out.println("RESULTADO CONTROL PERMISO:"+control+"DIA de control"+LocalDate.now());

        } catch (Exception e) {
            System.out.println("ERROR AL CONTROLAR PERMISO VIGENTE DAO: " + e.getMessage());
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(PermisoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return control;
    }

    public void listarPermisoEmpleado(JTable tabla, int id_empleado) {
     DefaultTableModel model;
        String[] columnas = {"N°", "Día", "Desde", "Hasta", "Estado"};
        model = new DefaultTableModel(null, columnas);
        String sql = "SELECT row_number() OVER (ORDER BY diaPermiso) AS id, diaPermiso ,horaInicio, horaFin, estadoPermiso FROM permiso WHERE id_empleado=?";
        String[] filas = new String[6];

        System.out.println("CARGA TABLA PERMISOS DE EMPLEADO");

        ResultSet rs = null;

        try {
            PreparedStatement pst = ConexionDAO.getConnection().prepareStatement(sql);
            
            pst.setInt(1, id_empleado);
            

            rs = pst.executeQuery();
            while (rs.next()) {
                for (int i = 0; i < 5; i++) {
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

    public void insert(Permiso permiso) throws ClassNotFoundException {
    
       String sql = "INSERT INTO permiso (id_permiso,id_empleado,id_funcionario,horaInicio,horaFin,diaPermiso,estadoPermiso,observacionPermiso)"
            + "VALUES (id_permiso=LAST_INSERT_ID(id_permiso+1),?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = ConexionDAO.getConnection().prepareStatement(sql);
            
            preparedStatement.setInt(1, permiso.getId_empleado());
            preparedStatement.setInt(2, permiso.getId_funcionario());
            preparedStatement.setString(3, permiso.getHoraInicio());
            preparedStatement.setString(4, permiso.getHoraFin());
            preparedStatement.setString(5, permiso.getDiaPermiso());
            preparedStatement.setString(6, permiso.getEstadoPermiso());
            preparedStatement.setString(7, permiso.getObservacionPermiso());
            
            preparedStatement.execute();
           
        } catch (SQLException ex) {
            Logger.getLogger(PermisoDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(PermisoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}