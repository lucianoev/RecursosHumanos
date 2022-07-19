/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucianovazquez.gestionrecursoshumanos.dao;

import com.lucianovazquez.gestionrecursoshumanos.entity.Empleado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo 3
 */
public class EmpleadoDAO {

    private String mensaje = "";
    private Empleado empleado;

    private static final String INSERT_QUERY = "INSERT INTO empleado (id_empleado,id_reparticion,id_funcionario,nombre,apellido,dni,domicilio,telefono,email,estadoEmpleado,turno,disponibleLicencia,disponiblePermiso)"
            + "VALUES (id_empleado=LAST_INSERT_ID(id_empleado+1),?,?,?,?,?,?,?,?,?,?,?,?)";

    public String insert(Empleado empleado) throws ClassNotFoundException {
        try {
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
            preparedStatement.setInt(12, empleado.getDisponiblePermiso());
            preparedStatement.execute();
            mensaje = "Creado Correctamente";

        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            mensaje = " No se puedo crear" + ex.getMessage();
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return mensaje;

    }

    public Empleado buscarEmpleadoDni(String dni) {
        empleado = new Empleado();
        String sql = "SELECT * FROM empleado WHERE dni = ?";
        try {
            PreparedStatement pst = ConexionDAO.getConnection().prepareStatement(sql);
            pst.setString(1, dni);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
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
        } catch (Exception e) {
            System.out.println("ERROR AL BUSCAR EMPLEADO POR DNI: " + e.getMessage());
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("NOMBRE EMPLEADO:" + empleado.getNombre());
        return empleado;
    }

    public Empleado buscarEmpleadoId(int id) {
        empleado = new Empleado();
        String sql = "SELECT * FROM empleado WHERE id_empleado = ?";
        try {
            PreparedStatement pst = ConexionDAO.getConnection().prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                empleado.setId_empleado(rs.getInt(1));
                empleado.setId_reparticion(rs.getInt(2));
                empleado.setId_funcionario(rs.getInt(3));
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
        } catch (Exception e) {
            System.out.println("ERROR AL BUSCAR EMPLEADO POR ID: " + e.getMessage());
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return empleado;
    }

    public void listarEmpleadosDni(JTable tabla, int dni) {

        DefaultTableModel model;
        String[] columnas = {"N° Legajo", "Nombre", "Apellido", "D.N.I.", "Repartición", "Superior Jerarquico", "Turno"};
        model = new DefaultTableModel(null, columnas);
        String sql = "SELECT id_empleado, nombre, apellido, dni, nombreReparticion, nombreFuncionario, turno FROM empleado INNER JOIN reparticion ON empleado.id_reparticion = reparticion.id_reparticion INNER JOIN funcionario ON empleado.id_funcionario = funcionario.id_funcionario WHERE dni=?";
        String[] filas = new String[8];

        System.out.println("CARGA TABLA EMPLEADO POR DNI");

        ResultSet rs = null;

        try {
            PreparedStatement pst = ConexionDAO.getConnection().prepareStatement(sql);

            pst.setInt(1, dni);

            rs = pst.executeQuery();
            while (rs.next()) {
                for (int i = 0; i < 7; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);

        } catch (Exception e) {
            System.out.println("ERROR AL CARGAR TABLA EMPLEADO POR DNI" + e.getMessage());
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void listarEmpleadosId(JTable tabla, Integer id) {
        DefaultTableModel model;
        String[] columnas = {"N° Legajo", "Nombre", "Apellido", "D.N.I.", "Repartición", "Superior Jerarquico", "Turno"};
        model = new DefaultTableModel(null, columnas);
        String sql = "SELECT id_empleado, nombre, apellido, dni, nombreReparticion, nombreFuncionario, turno FROM empleado INNER JOIN reparticion ON empleado.id_reparticion = reparticion.id_reparticion INNER JOIN funcionario ON empleado.id_funcionario = funcionario.id_funcionario WHERE id_empleado=?";
        String[] filas = new String[8];

        System.out.println("CARGA TABLA EMPLEADO POR id");

        ResultSet rs = null;

        try {
            PreparedStatement pst = ConexionDAO.getConnection().prepareStatement(sql);

            pst.setInt(1, id);

            rs = pst.executeQuery();
            while (rs.next()) {
                for (int i = 0; i < 7; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);

        } catch (Exception e) {
            System.out.println("ERROR AL CARGAR TABLA EMPLEADO POR id" + e.getMessage());
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void listarEmpleadosApellido(JTable tabla, String apellido) {
        DefaultTableModel model;
        String[] columnas = {"N° Legajo", "Nombre", "Apellido", "D.N.I.", "Repartición", "Superior Jerarquico", "Turno"};
        model = new DefaultTableModel(null, columnas);
        String sql = "SELECT id_empleado, nombre, apellido, dni, nombreReparticion, nombreFuncionario, turno FROM empleado INNER JOIN reparticion ON empleado.id_reparticion = reparticion.id_reparticion INNER JOIN funcionario ON empleado.id_funcionario = funcionario.id_funcionario WHERE apellido=?";
        String[] filas = new String[8];

        System.out.println("CARGA TABLA EMPLEADO POR APELLIDO");

        ResultSet rs = null;

        try {
            PreparedStatement pst = ConexionDAO.getConnection().prepareStatement(sql);

            pst.setString(1, apellido);

            rs = pst.executeQuery();
            while (rs.next()) {
                for (int i = 0; i < 7; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);

        } catch (Exception e) {
            System.out.println("ERROR AL CARGAR TABLA EMPLEADO POR APELLIDO" + e.getMessage());
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public int obtenerProximoIdEmpleado() {
        int proximoId = 0;
        String sql = "SELECT MAX(id_empleado)+1 FROM empleado";

        try {
            Statement st = ConexionDAO.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                proximoId = rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println("ERROR AL RECUPERAR PROXIMO ID " + e.getMessage());
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return proximoId;
    }

    public void update(Empleado empleado) throws ClassNotFoundException {
        String sql = "UPDATE empleado SET id_funcionario = ?, id_reparticion = ?, nombre = ?, apellido = ?, dni = ?, domicilio = ?, email = ?, turno = ?, telefono = ?, estadoEmpleado = ?, disponiblePermiso = ?, disponibleLicencia = ? WHERE id_empleado = ?";
        try {
            PreparedStatement preparedStatement = ConexionDAO.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, empleado.getId_funcionario());
            preparedStatement.setInt(2, empleado.getId_reparticion());
            preparedStatement.setString(3, empleado.getNombre());
            preparedStatement.setString(4, empleado.getApellido());
            preparedStatement.setString(5, empleado.getDni());
            preparedStatement.setString(6, empleado.getDomicilio());
            preparedStatement.setString(7, empleado.getEmail());
            preparedStatement.setString(8, empleado.getTurno());
            preparedStatement.setString(9, empleado.getTelefono());
            preparedStatement.setString(10, empleado.getEstadoEmpleado());
            preparedStatement.setInt(11, empleado.getDisponiblePermiso());
            preparedStatement.setInt(12, empleado.getDisponibleLicencia());
            preparedStatement.setInt(13, empleado.getId_empleado());

            preparedStatement.execute();
            mensaje = "Empleado Modificado Correctamente";
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            mensaje = "No se pudo actualizar info de empleado" + ex.getMessage();
        } finally {
            try {
                ConexionDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
