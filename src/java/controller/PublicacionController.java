/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.dao.PublicacionDAO;
import model.dao.PublicacionDaoHibernateJPA;
import model.dao.TagDAO;
import model.dao.TagDaoHibernateJPA;
import model.entities.Comentario;
import model.entities.Publicacion;
import model.entities.Tag;
import model.entities.Usuario;

/**
 *
 * @author agustin
 */
public class PublicacionController implements ModelDriven<Publicacion>{
    Publicacion publicacion = new Publicacion();
    List<Publicacion> listaPublicacion= new ArrayList();
    List<Comentario> listaDeComentarios= new ArrayList();
    PublicacionDAO publicacionDAO;
    TagDAO tagDAO;
    String tag;
    String[] tags;
    List<Tag> listaDeTags= new ArrayList<Tag>();
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
        publicacionDAO=new PublicacionDaoHibernateJPA();
        tagDAO=new TagDaoHibernateJPA();
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
        publicacion.setUsuarioPublicador(usuarioPublicador);
        tag = tag.replaceAll(",", " ").replaceAll("( )+", " ");
        tags = tag.split(" ");
        for (String tag1 : tags) {
            Tag t = tagDAO.buscarPorTexto(tag1);
            if(t==null){
                t = new Tag(tag1);
                tagDAO.agregar(t);
            }
            publicacion.getTags().add(t);
            
        }
        if(publicacionDAO.agregar(publicacion))
            msg="Se agrego una publicacion nueva";
        else
            msg="Ocurrio un error al agregar publicacion";
        return "fin";
    }
    
    public String listarPorTag(){
        listaPublicacion.addAll(tagDAO.buscarPorTexto(tag).getPublicacions());
        return "fin";
    }   
    
    
    public String listar(){
        listaPublicacion=publicacionDAO.listar();
        return "fin";
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public List<Publicacion> getListaPublicaciones() {
        return listaPublicacion;
    }

    public String getMsg() {
        return msg;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }
    
    public String listarComentarios(Publicacion publicacion){
        listaDeComentarios = (List<Comentario>) publicacionDAO.listarComentarios(publicacion);
        return "fin";
    }
    
    public String publicacionDeUsuario(Usuario usuario){
        listaPublicacion = publicacionDAO.publicacionesDeUsuario(usuario);
        return "fin";
    }
    
    public String editar(){
        publicacion = publicacionDAO.getPublicacionById(publicacion.getIdPublicacion());
        return "fin";
    }
    
    public String modificar(){
        publicacionDAO.editar(publicacion);
        return "fin";
    }
    
    public String eliminar(){
        publicacionDAO.eliminar(publicacion);
        return "fin";
    }
    
    public String mostrar(){
        publicacion = publicacionDAO.getPublicacionById(publicacion.getIdPublicacion());
        return "fin";
    }
    
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    
}