/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucianovazquez.gestionrecursoshumanos.dao;

import com.lucianovazquez.gestionrecursoshumanos.entity.Empleado;
import com.lucianovazquez.gestionrecursoshumanos.entity.Medico;
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
public class MedicoDAO {
    Medico medico;

    public Medico obtenerMedicoTurno(String turno) {
        medico = new Medico();
        String sql = "SELECT * FROM medico WHERE turnoMedico = ?";
        try {
            PreparedStatement pst = ConexionDAO.getConnection().prepareStatement(sql);
            pst.setString(1, turno);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                medico.setId_medico(rs.getInt(1));
                medico.setNombre(rs.getString(2));
                medico.setTurnoMedico(rs.getString(3));
                
            }
        } catch (Exception e) {
            System.out.println("ERROR AL BUSCAR MEDICO POR TURNO: " + e.getMessage());
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return medico;
    }

    public void listarLicenciasPorMedico(JTable tabla, int id_usuario, String estado) {
      DefaultTableModel model;
        String[] columnas = {"N°","ID Lic.", "Nombre", "Apellido","DNI", "Repartición", "Desde", "Hasta"};
        model = new DefaultTableModel(null, columnas);
        String sql = "SELECT row_number() OVER (ORDER BY diaInicio) AS id, id_licencia, nombre, apellido, dni, nombreReparticion, diaInicio, diaFin FROM licencia INNER JOIN empleado ON licencia.id_empleado = empleado.id_empleado INNER JOIN reparticion ON empleado.id_reparticion = reparticion.id_reparticion WHERE id_medico = ? AND estadoLicencia = ? AND tipoLicencia = 'Médica'";
        String[] filas = new String[9];

        System.out.println("CARGA TABLA EMPLEADO POR DNI");

        ResultSet rs = null;

        try {
            PreparedStatement pst = ConexionDAO.getConnection().prepareStatement(sql);

            pst.setInt(1, id_usuario);
            pst.setString(2, estado);

            rs = pst.executeQuery();
            while (rs.next()) {
                for (int i = 0; i < 8; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);

        } catch (Exception e) {
            System.out.println("ERROR AL CARGAR TABLA LICENCIAS POR MEDICO" + e.getMessage());
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
    
}
