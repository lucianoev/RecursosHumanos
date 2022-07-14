/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucianovazquez.gestionrecursoshumanos.bo;

import com.lucianovazquez.gestionrecursoshumanos.dao.LicenciaDAO;
import com.lucianovazquez.gestionrecursoshumanos.entity.Licencia;
import java.time.LocalDate;
import javax.swing.JTable;

/**
 *
 * @author Lenovo 3
 */
public class LicenciaBO {

    LicenciaDAO lic = new LicenciaDAO();

    public void listarLicencia(JTable jTable1, int id_empleado, String tipo) {
        lic.listarLicencia(jTable1, id_empleado, tipo);
    }

    public void insert(Licencia licencia) {
        try {
            lic.insert(licencia);
        } catch (Exception e) {
            System.out.println("ERROR INSERTAR SOLICITUD LICENCIA:" + e.getMessage());
        }

    }

    public boolean controlLicenciaAbierta(LocalDate jdateInicio, LocalDate jdateFin, int id_empleado) {
       boolean control = false;
       try{
          control = lic.controlLicenciaAbierta(jdateInicio,jdateFin,id_empleado);
       }catch(Exception e){
           System.out.println("Error control de licencia superpuesta:" + e.getMessage());
       }
       return control;
    }

}
