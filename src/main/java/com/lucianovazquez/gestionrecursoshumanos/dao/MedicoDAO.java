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
    
}
