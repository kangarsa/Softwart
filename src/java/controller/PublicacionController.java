/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import model.dao.PublicacionDAO;
import model.dao.PublicacionDAOImpl;
import model.entities.Publicacion;

/**
 *
 * @author agustin
 */
public class PublicacionController implements ModelDriven<Publicacion>{
    Publicacion publicacion = new Publicacion();
    ArrayList<Publicacion> listaPublicacion= new ArrayList();
    PublicacionDAO publicacionDAO;
    String msg="";
    
    public Publicacion getModel() {
        return publicacion;
    }
    
    public PublicacionController(){
        publicacionDAO=new PublicacionDAOImpl();
    }
    
    public String agregarInicio(){
        return "exito";
    }
    
    public String listarInicio(){
        return "exito";
    }
    
    public String agregar(){
        if(publicacionDAO.agregar(publicacion))
            msg="Se agrego un publicacion nuevo";
        else
            msg="Ocurrio un error al agragar publicacion";
        return "fin";
    }
    
    public String listar(){
        listaPublicacion=publicacionDAO.listar();
        return "fin";
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public ArrayList<Publicacion> getListaPublicaciones() {
        return listaPublicacion;
    }

    public String getMsg() {
        return msg;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }
    
}