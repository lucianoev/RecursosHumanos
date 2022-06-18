/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucianovazquez.gestionrecursoshumanos.entity;

/**
 *
 * @author Lenovo 3
 */
public class Usuario extends Persona {
    private int id_usuario;
    private String nombreUsuario;
    private String contraseña;
    private String tipo;

    public Usuario(int id_usuario, String logUsuario, String contraseña, String tipo, int id_persona, int dni, String nombre, String domicilio, String telefono, String email) {
        super(id_persona, dni, nombre, domicilio, telefono, email);
        this.id_usuario = id_usuario;
        this.nombreUsuario = logUsuario;
        this.contraseña = contraseña;
        this.tipo = tipo;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getLogUsuario() {
        return nombreUsuario;
    }

    public void setLogUsuario(String logUsuario) {
        this.nombreUsuario = logUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
