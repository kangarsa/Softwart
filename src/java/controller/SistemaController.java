/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import model.dao.SistemaDAO;
import model.dao.SistemaDAOImpl;
import model.entities.Sistema;

/**
 *
 * @author agustin
 */
public class SistemaController implements ModelDriven<Sistema>{
    Sistema sistema = new Sistema();
    ArrayList<Sistema> listaSistemas= new ArrayList();
    SistemaDAO sistemaDAO;
    String msg="";
    
    /**
     *
     * @return
     */
    @Override
    public Sistema getModel() {
        return sistema;
    }
    
    public SistemaController(){
        sistemaDAO=new SistemaDAOImpl();
    }
    
    public String agregarInicio(){
        return "exito";
    }
    
    public String listarInicio(){
        return "exito";
    }
    
    public String agregar(){
        if(sistemaDAO.agregar(sistema))
            msg="Se agrego un sistema nuevo";
        else
            msg="Ocurrio un error al agregar sistema";
        return "fin";
    }
    
    public String listar(){
        listaSistemas=sistemaDAO.listar();
        return "fin";
    }

    public Sistema getSistema() {
        return sistema;
    }

    public ArrayList<Sistema> getListaSistemas() {
        return listaSistemas;
    }

    public String getMsg() {
        return msg;
    }

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }
    
}
