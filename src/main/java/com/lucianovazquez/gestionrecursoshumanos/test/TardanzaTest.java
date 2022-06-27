/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucianovazquez.gestionrecursoshumanos.test;

import com.lucianovazquez.gestionrecursoshumanos.bo.TardanzaBO;
import com.lucianovazquez.gestionrecursoshumanos.entity.Tardanza;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author Lenovo 3
 */
public class TardanzaTest {

TardanzaBO tarbo = new TardanzaBO();
Tardanza tar = new Tardanza();
String mensaje = "";
//LocalDate dia = LocalDate.parse("2022-05-22");
    
    public void insertar() throws ClassNotFoundException, SQLException {
    
    
    tar.setId_tardanza(3);
    tar.setId_empleado(4);
    tar.setDiaTardanza("2022-06-26");
    tar.setTiempoTardanza("12:07:21");
    tar.setObservacionTardanza("En espera de información");
    
    
    mensaje = tarbo.insert(tar);
    System.out.println("tardanza test mensaje:" + mensaje);
    }
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        TardanzaTest test = new TardanzaTest();
        test.insertar();
        
    }
    
}
