/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import model.dao.PublicacionDAO;
import model.dao.PublicacionDAOImpl;
import model.entities.Comentario;
import model.entities.Publicacion;
import model.entities.Usuario;

/**
 *
 * @author agustin
 */
public class PublicacionController implements ModelDriven<Publicacion>{
    Publicacion publicacion = new Publicacion();
    ArrayList<Publicacion> listaPublicacion= new ArrayList();
    ArrayList<Comentario> listaDeComentarios= new ArrayList();
    PublicacionDAO publicacionDAO;
    String msg="";
    
    /**
     *
     * @return
     */
    @Override
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
        
        Map<String, Object> sessionAttributes = ActionContext.getContext().getSession();
        
        Usuario usuarioPublicador = (Usuario) sessionAttributes.get("usuario");
        
        publicacion.setUsuarioByUsuarioPublicador(usuarioPublicador);
        usuarioPublicador.getPublicacionsForUsuarioPublicador().add(publicacion);
        
        System.out.println("QUE PASOOOOO" + publicacion.getUsuarioByUsuarioPublicador());
        
        if(publicacionDAO.agregar(publicacion))
            msg="Se agrego una publicacion nueva";
        else
            msg="Ocurrio un error al agregar publicacion";
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
    
    public String listarComentarios(Publicacion publicacion){
        listaDeComentarios = (ArrayList<Comentario>) publicacionDAO.listarComentarios(publicacion);
        return "fin";
    }
    
    public String publicacionDeUsuario(Usuario usuario){
        listaPublicacion = publicacionDAO.publicacionesDeUsuario(usuario);
        return "fin";
    }
    
}