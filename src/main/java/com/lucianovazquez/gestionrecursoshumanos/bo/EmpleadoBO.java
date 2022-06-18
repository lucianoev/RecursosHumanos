/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucianovazquez.gestionrecursoshumanos.bo;

import com.lucianovazquez.gestionrecursoshumanos.dao.EmpleadoDAO;
import com.lucianovazquez.gestionrecursoshumanos.entity.Empleado;

/**
 *
 * @author Lenovo 3
 */
public class EmpleadoBO {
    
    private String mensaje = "";
    private EmpleadoDAO emp = new EmpleadoDAO();
    private Empleado empleado = new Empleado();
    
    public String insert (Empleado empleado){
        try{
            mensaje = emp.insert(empleado);
        }catch (Exception e){
            mensaje = mensaje + "" + e.getMessage();
        }
        return mensaje;
        }
   
}
