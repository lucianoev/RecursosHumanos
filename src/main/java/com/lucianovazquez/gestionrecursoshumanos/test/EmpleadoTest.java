/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucianovazquez.gestionrecursoshumanos.test;

import com.lucianovazquez.gestionrecursoshumanos.bo.EmpleadoBO;
import com.lucianovazquez.gestionrecursoshumanos.entity.Empleado;
import java.sql.SQLException;

/**
 *
 * @author Lenovo 3
 */
public class EmpleadoTest {
EmpleadoBO empbo = new EmpleadoBO();
Empleado emp = new Empleado();
String mensaje = "";
    
    public void insertar() throws ClassNotFoundException, SQLException {
    
    emp.setId_empleado(1);
    emp.setId_funcionario(2);
    emp.setId_reparticion(3);
    /*
    emp.setDni(34067850);
    emp.setNombre("Juan");
    emp.setDomicilio("Rivadavia 336");
    emp.setTelefono("3834287951");
    emp.setEmail("juanperez@gmail.com");
    */
    
    emp.setTurno("mañana");
    emp.setDisponibleLicencia(30);
    emp.setDsponiblePermiso(5);
    
    mensaje = empbo.insert(emp);
    System.out.println("expediente test mensaje:" + mensaje);
    
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        EmpleadoTest test = new EmpleadoTest();
        test.insertar();
        // TODO code application logic here
    }
    
}