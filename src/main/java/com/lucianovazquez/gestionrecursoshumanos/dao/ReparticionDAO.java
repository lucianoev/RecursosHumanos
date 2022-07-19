/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucianovazquez.gestionrecursoshumanos.dao;

import com.lucianovazquez.gestionrecursoshumanos.entity.Reparticion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo 3
 */


public class ReparticionDAO {
    
    private String mensaje = "";
    Reparticion reparticion;
    
    public Reparticion buscarReparticion(int id){
       reparticion = new Reparticion();
        String sql = "SELECT * FROM reparticion WHERE id_reparticion = ?";
        try{
            PreparedStatement pst = ConexionDAO.getConnection().prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                reparticion.setId_reparticion(rs.getInt(1));
                reparticion.setId_funcionario(rs.getInt(2));
                reparticion.setNombreReparticion(rs.getString(3));
        }
    }catch (Exception e) {
            System.out.println("ERROR AL BUSCAR REPARTICION: " + e.getMessage());
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ReparticionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    return reparticion;
    }

    
    public int recuperarIdFuncionarioRep(int idRep) {
        int idFuncionario = 0;
        String sql = "SELECT id_funcionario FROM reparticion WHERE id_reparticion = ?";
        try{
            PreparedStatement pst = ConexionDAO.getConnection().prepareStatement(sql);
            pst.setInt(1, idRep);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                idFuncionario = rs.getInt(1);
                System.out.println("ID FUNCIONARIO:" + idFuncionario);
                
        }
    }catch (Exception e) {
            System.out.println("ERROR AL BUSCAR ID_FUNCIONARIO DE LA REPARTICION: " + e.getMessage());
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ReparticionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    return idFuncionario;
    }
    
    
    
    
}
