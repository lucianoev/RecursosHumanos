/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucianovazquez.gestionrecursoshumanos.bo;

import com.lucianovazquez.gestionrecursoshumanos.dao.TardanzaDAO;
import com.lucianovazquez.gestionrecursoshumanos.entity.Tardanza;
import javax.swing.JTable;
import java.time.*;

/**
 *
 * @author Lenovo 3
 */
public class TardanzaBO {
    private String mensaje = "";
    private TardanzaDAO tar = new TardanzaDAO();
    
     public String insert (Tardanza tardanza){
    try{
        mensaje = tar.insert(tardanza);
    }catch (ClassNotFoundException e){
        mensaje = mensaje + "ERROR EN TARDANZABO" + e.getMessage() ;
    }
    return mensaje;
    }
    
    public void listarTardanza(JTable tabla, LocalDate dia) {
        tar.listarTardanza(tabla, dia);
    }
}
