/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucianovazquez.gestionrecursoshumanos.dao;

import com.lucianovazquez.gestionrecursoshumanos.entity.Usuario;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
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
    private String mensaje = "";

    public Usuario loginUsuario(String nombreUsuario) {
        

        String sql = "SELECT id_usuario, nombre, nombreUsuario, contraseña, salt, tipo FROM usuario WHERE nombreUsuario=?";
        try {
            PreparedStatement pst = ConexionDAO.getConnection().prepareStatement(sql);
            pst.setString(1, nombreUsuario);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                sesionUsuario.setId_usuario(rs.getInt(1));
                sesionUsuario.setNombre(rs.getString(2));
                sesionUsuario.setNombreUsuario(rs.getString(3));
                sesionUsuario.setContraseña(rs.getString(4));
                sesionUsuario.setSalt(rs.getString(5));
                sesionUsuario.setTipo(rs.getString(6));

            }

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return sesionUsuario;
    }

    

    private static String getSalt()
            throws NoSuchAlgorithmException, NoSuchProviderException {
        // Always use a SecureRandom generator
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");

        // Create array for salt
        byte[] salt = new byte[16];

        // Get a random salt
        sr.nextBytes(salt);

        // return salt
        return salt.toString();
    }

    private static final String UPDATE_QUERY = "UPDATE usuario SET contraseña=?, salt=? WHERE id_usuario=?";

    public void cambiarContraseña(String contraseñaActual, String contraseñaNueva, Usuario usuario) throws NoSuchAlgorithmException, NoSuchProviderException, ClassNotFoundException {

        String contraseñaHash = null;
        String salt = getSalt(); //guardar en base de datos para validar posteriormente

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt.getBytes());
            byte[] bytes = md.digest(contraseñaNueva.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
                        .substring(1));
            }
            contraseñaHash = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println("Contraseña HASH GENERADA:" + contraseñaHash);
        System.out.println("USUARIO QUE MODIFICA:" + usuario.getNombre());

        try {
            PreparedStatement ps = ConexionDAO.getConnection().prepareStatement(UPDATE_QUERY);
            ps.setString(1, contraseñaHash);
            ps.setString(2, salt);
            ps.setInt(3, usuario.getId_usuario());
            ps.execute();
            mensaje = "Contraseña Modificada correctamente";
        } catch (SQLException ex) {
            mensaje = "No se pudo modificar contraseña" + ex.getMessage();
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                ConexionDAO.closeConnection();
                System.out.println("cerrar conexion usuarioDAO");
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("tconexion close error en usuarioDAO");
            }

        }

    }

    public boolean validarContraseña(String contraseñaIngresada, String nombreUsuario) {
       boolean validacion = false;
        String sql = "SELECT * FROM usuario WHERE nombreUsuario=?";
        String contraseñaHash = null;

        try {
            PreparedStatement pst = ConexionDAO.getConnection().prepareStatement(sql);
            pst.setString(1, nombreUsuario);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                usuario.setId_usuario(rs.getInt(1));
                usuario.setNombre(rs.getString(2));
                usuario.setNombreUsuario(rs.getString(3));
                usuario.setContraseña(rs.getString(4));
                usuario.setSalt(rs.getString(5));
                usuario.setTipo(rs.getString(6));
            }

        } catch (Exception e) {
            System.out.println("ERROR AL BUSCAR usuario por nombre de usuario: " + e.getMessage());
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        System.out.println("CONTRASEÑA HASH ALMACENADA:"+usuario.getContraseña());
        
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(usuario.getSalt().getBytes());
            byte[] bytes = md.digest(contraseñaIngresada.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
                        .substring(1));
            }
            contraseñaHash = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println("CONTRASEÑA HASH GENERADA PARA VALIDACION:"+contraseñaHash);
        
        validacion = usuario.getContraseña().equals(contraseñaHash);
        
        System.out.println("BOLLEAN VALIDACIÓN"+validacion);

        return validacion;
    }
}
