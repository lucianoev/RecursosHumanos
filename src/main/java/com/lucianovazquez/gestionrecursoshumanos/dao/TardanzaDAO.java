/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucianovazquez.gestionrecursoshumanos.dao;

import com.lucianovazquez.gestionrecursoshumanos.entity.Tardanza;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JTable;
import java.time.*;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo 3
 */
public class TardanzaDAO  {
    private String mensaje = "";
    
    private static final String INSERT_QUERY = "INSERT INTO tardanza (id_tardanza, id_empleado, diaTardanza, tiempoTardanza, observacionTardanza)"
            + "VALUES (id_tardanza=LAST_INSERT_ID(id_tardanza+1),?,?,?,?)";
    
    public String insert (Tardanza tardanza) throws ClassNotFoundException{
    try{
        PreparedStatement ps = ConexionDAO.getConnection().prepareStatement(INSERT_QUERY);
       
        ps.setInt(1, tardanza.getId_empleado());
        ps.setString(2, tardanza.getDiaTardanza());
        ps.setString(3, tardanza.getTiempoTardanza());
        ps.setString(4, tardanza.getObservacionTardanza());
        ps.execute();
        mensaje = "Tardanza cargada correctamente";
    }catch(SQLException ex) {
        mensaje = "No se pudo cargar tardanza" + ex.getMessage();
            Logger.getLogger(InasistenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        
    } finally {
            try {
                ConexionDAO.closeConnection();
                System.out.println("tconexion close tardanzaDAO");
            } catch (SQLException ex) {
                Logger.getLogger(TardanzaDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("tconexion close error en tardanzaDAO");
            }
    
        }
    return mensaje;
    }
    
    

    public void listarTardanza(JTable tabla, LocalDate dia) {
        
        DefaultTableModel model;
        String[] columnas = {"N°","Nombre","Apellido","D.N.I.","Repartición","Tiempo","Turno"};
        model = new DefaultTableModel(null,columnas);
        String sql = "SELECT row_number() OVER (ORDER BY tiempoTardanza) AS id_tardanza, nombre, apellido, dni, nombreReparticion, tiempoTardanza, turno FROM tardanza INNER JOIN empleado ON tardanza.id_empleado = empleado.id_empleado INNER JOIN reparticion ON empleado.id_reparticion = reparticion.id_reparticion WHERE diaTardanza=?";
        String [] filas = new String [7];
        
        System.out.println("CARGA TABLA TARDANZA");
        
        ResultSet rs = null;
        
        
        try {
            PreparedStatement pst = ConexionDAO.getConnection().prepareStatement(sql);
            System.out.println("Dia tabla tardanza:"+dia.toString());
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
            System.out.println("ERROR AL CARGAR TABLA TARDANZA" + e.getMessage());
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(TardanzaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    
    
}
