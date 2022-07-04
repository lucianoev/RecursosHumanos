/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucianovazquez.gestionrecursoshumanos.dao;

import com.lucianovazquez.gestionrecursoshumanos.entity.Inasistencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo 3
 */
public class InasistenciaDAO {

    private String mensaje = "";

    private static final String INSERT_QUERY = "INSERT INTO inasistencia (id_inasistencia, id_empleado, diaInasistencia, tipo, observacionInasistencia)"
            + "VALUES (id_inasistencia=LAST_INSERT_ID(id_inasistencia+1),?,?,?,?)";

    public String insert(Inasistencia inasistencia) throws ClassNotFoundException {
        try {
            PreparedStatement ps = ConexionDAO.getConnection().prepareStatement(INSERT_QUERY);
            ps.setInt(1, inasistencia.getId_empleado());
            ps.setString(2, inasistencia.getDiaInasistencia());
            ps.setString(3, inasistencia.getTipo());
            ps.setString(4, inasistencia.getObservacionInasistencia());
            ps.execute();
            mensaje = "Inasistencia Guardada correctamente";
        } catch (SQLException ex) {
            Logger.getLogger(InasistenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
            mensaje = "No se pudo guardar" + ex.getMessage();

        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(InasistenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return mensaje;
    }

    public void listarInasistencia(JTable tabla, LocalDate dia) {

        DefaultTableModel model;
        String[] columnas = {"N°", "Nombre", "Apellido", "D.N.I.", "Repartición", "Tipo", "Turno"};
        model = new DefaultTableModel(null, columnas);
        String sql = "SELECT row_number() OVER (ORDER BY tipo) AS id_inasistencia, nombre, apellido, dni, nombreReparticion, tipo, turno FROM inasistencia INNER JOIN empleado ON inasistencia.id_empleado = empleado.id_empleado INNER JOIN reparticion ON empleado.id_reparticion = reparticion.id_reparticion WHERE diaInasistencia=?";
        String[] filas = new String[7];

        System.out.println("CARGA TABLA INASISTENCIA");

        ResultSet rs = null;

        try {
            PreparedStatement pst = ConexionDAO.getConnection().prepareStatement(sql);
            System.out.println("Dia tabla inasistencia:" + dia.toString());
            pst.setString(1, dia.toString());

            rs = pst.executeQuery();
            while (rs.next()) {
                for (int i = 0; i < 6; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);

        } catch (Exception e) {
            System.out.println("ERROR AL CARGAR TABLA INASISTENCIA" + e.getMessage());
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(InasistenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void listaInasistenciaEmpleadoRango(JTable tabla, LocalDate jdateInicio, LocalDate jdateFin, int id_empleado) {
        DefaultTableModel model;
        String[] columnas = {"N°", "Día", "Tipo", "Observaciones"};
        model = new DefaultTableModel(null, columnas);
        String sql = "SELECT row_number() OVER (ORDER BY diaInasistencia) AS id, diaInasistencia, tipo, observacionInasistencia FROM inasistencia WHERE id_empleado=? AND diaInasistencia BETWEEN ? AND ?";
        String[] filas = new String[4];

        System.out.println("CARGA TABLA INASISTENCIA");

        ResultSet rs = null;

        try {
            PreparedStatement pst = ConexionDAO.getConnection().prepareStatement(sql);
            System.out.println("inasistencias entre:" + jdateInicio.toString() + " hasta" + jdateFin.toString());
            pst.setInt(1, id_empleado);
            pst.setString(2, jdateInicio.toString());
            pst.setString(3, jdateFin.toString());

            rs = pst.executeQuery();
            while (rs.next()) {
                for (int i = 0; i < 3; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);

        } catch (Exception e) {
            System.out.println("ERROR AL CARGAR TABLA INASISTENCIA" + e.getMessage());
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(InasistenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
