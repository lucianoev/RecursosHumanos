/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucianovazquez.gestionrecursoshumanos.dao;

import com.lucianovazquez.gestionrecursoshumanos.entity.Inasistencia;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author Lenovo 3
 */
public class InasistenciaDAO {
    private String mensaje = "";
    private Inasistencia inasistencia;
    
    private static final String INSERT_QUERY = "INSERT INTO inasistencia (id_inasistencia, id_empleado, diaInasistencia, tipo, observacionInasistencia)"
            + "VALUES (id_inasistencia=LAST_INSERT_ID(id_inasistencia+1),?,?,?,?)";
    
    public String insert (Inasistencia inasistencia) throws ClassNotFoundException{
    try{
        PreparedStatement ps = ConexionDAO.getConnection().prepareStatement(INSERT_QUERY);
        ps.setInt(1, inasistencia.getId_empleado());
        ps.setString(2, inasistencia.getDiaInasistencia());
        ps.setString(3, inasistencia.getTipo());
        ps.setString(4, inasistencia.getObservacionInasistencia());
        ps.execute();
        mensaje = "Inasistencia Guardada correctamente";
    }catch(SQLException ex) {
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
