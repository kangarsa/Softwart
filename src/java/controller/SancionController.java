/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import model.dao.SancionDAO;
import model.dao.SancionDAOImpl;
import model.entities.Publicacion;
import model.entities.Sancion;
import model.entities.Usuario;

/**
 *
 * @author agustin
 */
public class SancionController implements ModelDriven<Sancion>{
    Sancion sancion = new Sancion();
    ArrayList<Sancion> listaSanciones= new ArrayList();
    SancionDAO sancionDAO;
    Usuario u = (Usuario) ActionContext.getContext().getSession().get("usuario");
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
            msg="Se agrego una sancion nueva";
        else
            msg="Ocurrio un error al agregar sancion";
        return "fin";
    }
    
    public String listar(){
        listaSanciones=sancionDAO.listar();
        //NO SE MUESTRA Y NO SE PORQUE
        System.out.println("SANCIONES: " + listaSanciones);
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
    
    public ArrayList<Publicacion> getPublicacionesSancionables() {
        ArrayList<Publicacion> listaPublicaciones = sancionDAO.publicacionesSancionablesPara(u);
        System.out.println(listaPublicaciones);
        return listaPublicaciones;
    }
    
}
