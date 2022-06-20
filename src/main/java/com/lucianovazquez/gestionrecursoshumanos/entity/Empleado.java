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
    private String turno;
    private int disponibleLicencia;
    private int dsponiblePermiso;

    public Empleado() {
    }
    
    
    public Empleado(int id_empleado, int id_funcionario, int id_reparticion, String turno, int disponibleLicencia, int dsponiblePermiso, int id_persona, int dni, String nombre, String domicilio, String telefono, String email) {
        
        this.id_empleado = id_empleado;
        this.id_funcionario = id_funcionario;
        this.id_reparticion = id_reparticion;
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
