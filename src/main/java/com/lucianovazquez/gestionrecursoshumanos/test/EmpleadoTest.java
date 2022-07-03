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
    
    
    emp.setId_funcionario(3);
    emp.setId_reparticion(3);
    
    emp.setDni("34231432");
    emp.setNombre("Juliana");
    emp.setApellido("Vazquez");
    emp.setDomicilio("Maipu 2314");
    emp.setTelefono("3834283213");
    emp.setEmail("e23a@mail.com");
    
    emp.setEstadoEmpleado("Licencia");
    emp.setTurno("Tarde");
    emp.setDisponibleLicencia(15);
    emp.setDisponiblePermiso(1);
    
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
