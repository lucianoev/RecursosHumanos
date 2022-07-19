/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucianovazquez.gestionrecursoshumanos.dao;

import com.lucianovazquez.gestionrecursoshumanos.entity.Funcionario;
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
public class FuncionarioDAO {
    
    Funcionario funcionario;
    
    public Funcionario buscarFuncionario(int id){
       funcionario = new Funcionario();
        String sql = "SELECT * FROM funcionario WHERE id_funcionario = ?";
        try{
            PreparedStatement pst = ConexionDAO.getConnection().prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                funcionario.setId_funcionario(rs.getInt(1));
                funcionario.setId_reparticion(rs.getInt(2));
                funcionario.setNombreFuncionario(rs.getString(3));
        }
    }catch (Exception e) {
            System.out.println("ERROR AL BUSCAR REPARTICION: " + e.getMessage());
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    return funcionario;
    }

    public int recuperarIdReparticion(int idFun) {
         int idReparticion = 0;
        String sql = "SELECT id_reparticion FROM funcionario WHERE id_funcionario = ?";
        try{
            PreparedStatement pst = ConexionDAO.getConnection().prepareStatement(sql);
            pst.setInt(1, idFun);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                idReparticion = rs.getInt(1);
                System.out.println("ID REPARTICION:"+idReparticion);
                
        }
    }catch (Exception e) {
            System.out.println("ERROR AL BUSCAR ID_REPARTICION DEL FUNCIONARIO: " + e.getMessage());
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return idReparticion;
    }
    
}
