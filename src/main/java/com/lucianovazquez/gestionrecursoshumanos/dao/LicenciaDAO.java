/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucianovazquez.gestionrecursoshumanos.dao;

import com.lucianovazquez.gestionrecursoshumanos.entity.Licencia;
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
public class LicenciaDAO {
    
    private boolean control;

    public void listarLicencia(JTable tabla, int id_empleado, String tipo) {
         DefaultTableModel model;
        String[] columnas = {"N°", "Desde", "Hasta", "Tipo", "Estado"};
        model = new DefaultTableModel(null, columnas);
        String sql = "SELECT row_number() OVER (ORDER BY diaInicio) AS id, diaInicio, diaFin, tipoLicencia, estadoLicencia FROM licencia WHERE id_empleado=? AND tipoLicencia=?";
        String[] filas = new String[6];

        System.out.println("CARGA TABLA LICENCIA");

        ResultSet rs = null;

        try {
            PreparedStatement pst = ConexionDAO.getConnection().prepareStatement(sql);
            
            pst.setInt(1, id_empleado);
            pst.setString(2, tipo);

            rs = pst.executeQuery();
            while (rs.next()) {
                for (int i = 0; i < 5; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);

        } catch (Exception e) {
            System.out.println("ERROR AL CARGAR TABLA LICENCIA" + e.getMessage());
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(LicenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void insert(Licencia licencia) throws ClassNotFoundException {
        
       String sql = "INSERT INTO licencia (id_licencia,id_empleado,id_medico,tipoLicencia,diaInicio,diaFin,estadoLicencia,observacionLicencia)"
            + "VALUES (id_licencia=LAST_INSERT_ID(id_licencia+1),?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = ConexionDAO.getConnection().prepareStatement(sql);
            
            preparedStatement.setInt(1, licencia.getId_empleado());
            preparedStatement.setInt(2, licencia.getId_medico());
            preparedStatement.setString(3, licencia.getTipoLicencia());
            preparedStatement.setString(4, licencia.getDiaInicio());
            preparedStatement.setString(5, licencia.getDiaFin());
            preparedStatement.setString(6, licencia.getEstadoLicencia());
            preparedStatement.setString(7, licencia.getObservacionLicencia());
            
            preparedStatement.execute();
           
        } catch (SQLException ex) {
            Logger.getLogger(LicenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(LicenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    public boolean controlLicenciaAbierta(LocalDate jdateInicio, LocalDate jdateFin, int id_empleado) {
       String sql = "SELECT * FROM licencia WHERE id_empleado = ? AND ? BETWEEN diaInicio AND diaFin OR ? BETWEEN diaInicio AND diaFin;";
       try {
            PreparedStatement pst = ConexionDAO.getConnection().prepareStatement(sql);
            pst.setInt(1, id_empleado);
            pst.setString(2, jdateInicio.toString());
            pst.setString(3, jdateFin.toString());

            ResultSet rs = pst.executeQuery();

            control = rs.next();

        } catch (Exception e) {
            System.out.println("ERROR AL CONTROLAR FECHA DE LICENCIA: " + e.getMessage());
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(LicenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return control;
    }
    
}
