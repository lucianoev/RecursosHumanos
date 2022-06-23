/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucianovazquez.gestionrecursoshumanos.dao;

import com.lucianovazquez.gestionrecursoshumanos.entity.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo 3
 */
public class UsuarioDAO {
     Usuario sesionUsuario = new Usuario();
    Usuario usuario = new Usuario();

    public boolean loginUsuario(String nombreUsuario, String contraseña) {
        boolean login = false;
        String sql = "SELECT id_usuario, nombre, nombreUsuario, contraseña, tipo FROM usuario WHERE nombreUsuario=? and contraseña=?";
        try {
            PreparedStatement pst = ConexionDAO.getConnection().prepareStatement(sql);
            pst.setString(1, nombreUsuario);
            pst.setString(2, contraseña);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                login = true;
                sesionUsuario.setId_usuario(rs.getInt(1));
                sesionUsuario.setNombre(rs.getString(2));
                sesionUsuario.setNombreUsuario(rs.getString(3));
                sesionUsuario.setContraseña(rs.getString(4));
                sesionUsuario.setTipo(rs.getString(5));
                
            }

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                //Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return login;
    }

    public Usuario sesionUsuario() {
        return sesionUsuario;
    }
}
