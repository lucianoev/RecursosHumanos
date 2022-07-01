/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucianovazquez.gestionrecursoshumanos.bo;

import com.lucianovazquez.gestionrecursoshumanos.dao.ConexionDAO;
import com.lucianovazquez.gestionrecursoshumanos.dao.EmpleadoDAO;
import com.lucianovazquez.gestionrecursoshumanos.entity.Empleado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public Empleado buscarEmpleadoDni(String dni) {
       empleado = new Empleado();
       String sql = "SELECT * FROM empleado WHERE dni = ?";
       try{
           PreparedStatement pst = ConexionDAO.getConnection().prepareStatement(sql);
           pst.setString(1, dni);
           ResultSet rs = pst.executeQuery();
           if (rs.next()){
               empleado.setId_empleado(rs.getInt(1));
               empleado.setId_funcionario(rs.getInt(2));
               empleado.setId_reparticion(rs.getInt(3));
               empleado.setNombre(rs.getString(4));
               empleado.setApellido(rs.getString(5));
               empleado.setDni(rs.getString(6));
               empleado.setDomicilio(rs.getString(7));
               empleado.setTelefono(rs.getString(8));
               empleado.setEmail(rs.getString(9));
               empleado.setEstadoEmpleado(rs.getString(10));
               empleado.setTurno(rs.getString(11));
               empleado.setDisponibleLicencia(rs.getInt(12));
               empleado.setDisponiblePermiso(rs.getInt(13));
           }
       } catch (Exception e){
           System.out.println("ERROR AL BUSCAR EMPLEADO POR DNI: " + e.getMessage());
       } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       return empleado;
    }
   
}
