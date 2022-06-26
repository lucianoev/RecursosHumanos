/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucianovazquez.gestionrecursoshumanos.bo;

import com.lucianovazquez.gestionrecursoshumanos.dao.TardanzaDAO;
import javax.swing.JTable;
import java.time.*;

/**
 *
 * @author Lenovo 3
 */
public class TardanzaBO {
    private TardanzaDAO tar;
    
    
    
    public void listarTardanza(JTable tabla, LocalDate dia) {
        tar.listarTardanza(tabla, dia);
    }
}
