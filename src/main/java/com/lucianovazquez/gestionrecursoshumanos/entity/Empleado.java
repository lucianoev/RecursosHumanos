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
public class Empleado  {
    private int id_empleado;
    private int id_funcionario;
    private int id_reparticion;
    private String nombre;
    private String apellido;
    private String dni;
    private String domicilio;
    private String telefono;
    private String email;
    private String estadoEmpleado;
    private String turno;
    private int disponibleLicencia;
    private int dsponiblePermiso;

    public Empleado() {
    }

    public Empleado(int id_empleado, int id_funcionario, int id_reparticion, String nombre, String apellido, String dni, String domicilio, String telefono, String email, String estadoEmpleado, String turno, int disponibleLicencia, int dsponiblePermiso) {
        this.id_empleado = id_empleado;
        this.id_funcionario = id_funcionario;
        this.id_reparticion = id_reparticion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.email = email;
        this.estadoEmpleado = estadoEmpleado;
        this.turno = turno;
        this.disponibleLicencia = disponibleLicencia;
        this.dsponiblePermiso = dsponiblePermiso;
    }

    
    
    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public int getId_reparticion() {
        return id_reparticion;
    }

    public void setId_reparticion(int id_reparticion) {
        this.id_reparticion = id_reparticion;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstadoEmpleado() {
        return estadoEmpleado;
    }

    public void setEstadoEmpleado(String estadoEmpleado) {
        this.estadoEmpleado = estadoEmpleado;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getDisponibleLicencia() {
        return disponibleLicencia;
    }

    public void setDisponibleLicencia(int disponibleLicencia) {
        this.disponibleLicencia = disponibleLicencia;
    }

    public int getDsponiblePermiso() {
        return dsponiblePermiso;
    }

    public void setDsponiblePermiso(int dsponiblePermiso) {
        this.dsponiblePermiso = dsponiblePermiso;
    }
    
    
}
