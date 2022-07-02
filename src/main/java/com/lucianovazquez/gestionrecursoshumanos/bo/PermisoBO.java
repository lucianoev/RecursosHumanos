/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucianovazquez.gestionrecursoshumanos.bo;

import com.lucianovazquez.gestionrecursoshumanos.dao.PermisoDAO;
import java.time.LocalDate;
import javax.swing.JTable;

/**
 *
 * @author Lenovo 3
 */
public class PermisoBO {
    PermisoDAO per = new PermisoDAO ();

    public void listarPermisosDia(JTable jTable3, LocalDate dia) {
        per.listarPermisosDia(jTable3,dia);
    }
    
}
