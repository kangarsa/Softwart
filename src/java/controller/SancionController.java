/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import model.dao.SancionDAO;
import model.dao.SancionDAOImpl;
import model.entities.Sancion;

/**
 *
 * @author agustin
 */
public class SancionController implements ModelDriven<Sancion>{
    Sancion sancion = new Sancion();
    ArrayList<Sancion> listaSanciones= new ArrayList();
    SancionDAO sancionDAO;
    String msg="";
    
    public Sancion getModel() {
        return sancion;
    }
    
    public SancionController(){
        sancionDAO=new SancionDAOImpl();
    }
    
    public String agregarInicio(){
        return "exito";
    }
    
    public String listarInicio(){
        return "exito";
    }
    
    public String agregar(){
        if(sancionDAO.agregar(sancion))
            msg="Se agrego un comentario nuevo";
        else
            msg="Ocurrio un error al agragar comentario";
        return "fin";
    }
    
    public String listar(){
        listaSanciones=sancionDAO.listar();
        return "fin";
    }

    public Sancion getSancion() {
        return sancion;
    }

    public ArrayList<Sancion> getListaSancion() {
        return listaSanciones;
    }

    public String getMsg() {
        return msg;
    }

    public void setSancion (Sancion sancion) {
        this.sancion = sancion;
    }
    
}
