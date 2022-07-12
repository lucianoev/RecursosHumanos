/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucianovazquez.gestionrecursoshumanos.bo;

import com.lucianovazquez.gestionrecursoshumanos.dao.UsuarioDAO;
import com.lucianovazquez.gestionrecursoshumanos.entity.Usuario;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 *
 * @author Lenovo 3
 */
public class UsuarioBO {
    
    private String mensaje = "";
    private UsuarioDAO usu = new UsuarioDAO();
    Usuario recupusuario;
    Usuario usua = new Usuario();

    public Usuario loginUsuario(String nombreUsuario) {
        
        try {
            usua = usu.loginUsuario(nombreUsuario);
        } catch (Exception e) {
            mensaje = mensaje + "ERROR AL LOGUEARSE" + e.getMessage();
        }
        return usua;
    }

    /*public Usuario sesionUsuario() {
        recupusuario = usu.sesionUsuario();
        return recupusuario;
    }*/

    public void cambiarContraseña(String contraseñaActual, String contraseñaNueva, Usuario usuario) throws NoSuchAlgorithmException, NoSuchProviderException, ClassNotFoundException{
        usu.cambiarContraseña(contraseñaActual,contraseñaNueva,usuario);
    }

    public boolean validarContraseña(String contraseñaIngresada, String nombreUsuario) {
        boolean validacion=false;
        try{
        validacion = usu.validarContraseña(contraseñaIngresada, nombreUsuario);
        }catch(Exception e){
            mensaje = mensaje + "Error al validar contraseña"+e.getMessage();
        }
        return validacion;
    }
}
