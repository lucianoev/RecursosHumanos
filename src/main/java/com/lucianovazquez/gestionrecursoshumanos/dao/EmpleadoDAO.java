/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucianovazquez.gestionrecursoshumanos.dao;

import com.lucianovazquez.gestionrecursoshumanos.entity.Empleado;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo 3
 */
public class EmpleadoDAO {
    
    private String mensaje = "";
    private Empleado empleado;
    
    private static final String INSERT_QUERY = "INSERT INTO empleado (id_empleado,id_reparticion,id_funcionario,nombre,apellido,dni,domicilio,telefono,email,estadoEmpleado,turno,disponibleLicencia,disponiblePermiso)" 
            + "VALUES (id_empleado=LAST_INSERT_ID(id_empleado+1),?,?,?,?,?,?,?,?,?,?,?,?)";

    public String insert (Empleado empleado) throws ClassNotFoundException{
    try{
        PreparedStatement preparedStatement = ConexionDAO.getConnection().prepareStatement(INSERT_QUERY);
        preparedStatement.setInt(1, empleado.getId_reparticion());
        preparedStatement.setInt(2, empleado.getId_funcionario());
        preparedStatement.setString(3, empleado.getNombre());
        preparedStatement.setString(4, empleado.getApellido());
        preparedStatement.setString(5, empleado.getDni());
        preparedStatement.setString(6, empleado.getDomicilio());
        preparedStatement.setString(7, empleado.getTelefono());
        preparedStatement.setString(8, empleado.getEmail());
        preparedStatement.setString(9, empleado.getEstadoEmpleado());
        preparedStatement.setString(10, empleado.getTurno());
        preparedStatement.setInt(11, empleado.getDisponibleLicencia());
        preparedStatement.setInt(12, empleado.getDsponiblePermiso());
        preparedStatement.execute();
        mensaje = "Creado Correctamente";
                                                 
    }catch (SQLException ex){
        Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        mensaje = " No se puedo crear" + ex.getMessage();
    }finally{
        try{
            ConexionDAO.closeConnection();
            System.out.println("Error en la conexion finally close conec");
        }catch (SQLException ex){
             Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("Error en la conexion finally");
        }
    }
    return mensaje;
    
    }


}
