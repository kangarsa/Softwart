
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.dao.PublicacionDAO;
import model.dao.PublicacionDaoHibernateJPA;
import model.dao.TagDAO;
import model.dao.TagDaoHibernateJPA;
import model.entities.Comentario;
import model.entities.Publicacion;
import model.entities.Tag;

/**
 *
 * @author banquete
 */
public class WelcomeController implements ModelDriven<Publicacion> {    
    private Publicacion publicacion = new Publicacion();
    List<Publicacion> listaPublicacion= new ArrayList();
    TagDAO tagDAO;
    String tag;
    PublicacionDAO publicacionDAO;
    Integer cantidadComentarios = 0;
    String content="";
    List<Comentario> listaComentario = new ArrayList();
    private Integer idPublicacion;

    public Integer getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(Integer idPublicacion) {
        this.idPublicacion = idPublicacion;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    String msg="";
 
    
    public WelcomeController(){
        publicacionDAO=new PublicacionDaoHibernateJPA();
        tagDAO=new TagDaoHibernateJPA();
    }

    public String execute(){
        listaPublicacion=publicacionDAO.listar();
        listaComentario=publicacionDAO.listarComentarios(publicacion);
        content="ListarPublicaciones_fe.jsp";
        return "fin";
    }
    
    public String publicar(){
        content="AgregarPublicacion_fe.jsp";
        return "fin";
    }

    @Override
    public Publicacion getModel() {
        return publicacion;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    
    public List<Comentario> getListaComentario() {
        return listaComentario;
    }

    public void setListaComentario(List<Comentario> listaComentario) {
        this.listaComentario = listaComentario;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }
    
    public List<Publicacion> getListaPublicaciones() {
        listaPublicacion=publicacionDAO.listar();
        return listaPublicacion;
    }
    
    public List<Publicacion> getListaPublicacionesTags() {
        return listaPublicacion;
    }
    
    public List<Comentario> getListaComentarios(){
        return listaComentario;
    }
    
    public String listarPorTag(){
        Tag t = tagDAO.buscarPorTexto(tag);
        List<Publicacion> laux= new ArrayList();
        listaPublicacion=publicacionDAO.listar();
        Iterator <Publicacion> iterador = listaPublicacion.iterator();
        while(iterador.hasNext()){
            Publicacion p = iterador.next();
            if(p.getTags().contains(t)){
                laux.add(p);
            }
        }
        listaPublicacion=laux;
        content="ListarPublicacionesTags_fe.jsp";
        return "fin";
    }   
 
}
