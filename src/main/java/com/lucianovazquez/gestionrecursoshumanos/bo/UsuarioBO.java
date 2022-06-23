/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucianovazquez.gestionrecursoshumanos.bo;

import com.lucianovazquez.gestionrecursoshumanos.dao.UsuarioDAO;
import com.lucianovazquez.gestionrecursoshumanos.entity.Usuario;

/**
 *
 * @author Lenovo 3
 */
public class UsuarioBO {
    
    private String mensaje = "";
    private UsuarioDAO usu = new UsuarioDAO();
    Usuario recupusuario;
    Usuario usuario = new Usuario();

    public boolean loginUsuario(String usuario, String contraseña) {
        boolean login = false;
        try {
            login = usu.loginUsuario(usuario, contraseña);
        } catch (Exception e) {
            mensaje = mensaje + "ERROR AL LOGUEARSE" + e.getMessage();
        }
        return login;
    }

    public Usuario sesionUsuario() {
        recupusuario = usu.sesionUsuario();
        return recupusuario;
    }

}
