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
    
    private static final String INSERT_QUERY = "INSERT INTO empleado (id_empleado,id_funcionario,id_reparticion,turno,disponibleLicencia,disponiblePermiso)" + "VALUES (?,?,?,?,?,?)";

    public String insert (Empleado empleado) throws ClassNotFoundException{
    try{
        PreparedStatement preparedStatement = ConexionDAO.getConnection().prepareStatement(INSERT_QUERY);
        preparedStatement.setInt(1, empleado.getId_empleado());
        preparedStatement.setInt(2, empleado.getId_funcionario());
        preparedStatement.setInt(3, empleado.getId_reparticion());
        preparedStatement.setString(4, empleado.getTurno());
        preparedStatement.setInt(5, empleado.getDisponibleLicencia());
        preparedStatement.setInt(6, empleado.getDsponiblePermiso());
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
