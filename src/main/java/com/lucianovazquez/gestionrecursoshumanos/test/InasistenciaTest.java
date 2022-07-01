/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucianovazquez.gestionrecursoshumanos.test;

import com.lucianovazquez.gestionrecursoshumanos.bo.InasistenciaBO;
import com.lucianovazquez.gestionrecursoshumanos.entity.Inasistencia;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author Lenovo 3
 */
public class InasistenciaTest {

InasistenciaBO inabo = new InasistenciaBO();
Inasistencia ina = new Inasistencia();
String mensaje = "";

    
    public void insertar() throws ClassNotFoundException, SQLException {
    
    
    ina.setId_inasistencia(3);
    ina.setId_empleado(4);
    ina.setDiaInasistencia("2022-06-30");
    ina.setTipo("justificada");
    ina.setObservacionInasistencia("Varias ");
    
    
    mensaje = inabo.insert(ina);
    System.out.println("tardanza test mensaje:" + mensaje);
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        InasistenciaTest test = new InasistenciaTest();
        test.insertar();
    }
    
}
