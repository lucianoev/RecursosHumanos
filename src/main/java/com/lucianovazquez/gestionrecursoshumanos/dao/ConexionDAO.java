/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucianovazquez.gestionrecursoshumanos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Lenovo 3
 */
public class ConexionDAO {
    private Connection con;
    private static ConexionDAO repo;
    
    private ConexionDAO() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.con = DriverManager.getConnection("jdbc:mysql://localhost/gestionrrhh?serverTimezone=UTC", "Luciano2", "1234");
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (repo == null) {
            repo = new ConexionDAO();
        }
        return repo.con;
    }
    
    public static void closeConnection() throws SQLException {
        if (repo.con != null) {
            repo.con.close();
            repo = null;
        }
    
    }
}