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
import model.entities.Comentario;
import model.entities.Publicacion;

/**
 *
 * @author banquete
 */
public class WelcomeController implements ModelDriven<Publicacion> {    
    private Publicacion publicacion = new Publicacion();
    List<Publicacion> listaPublicacion= new ArrayList();
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
    }

    public String execute(){
        listaPublicacion=publicacionDAO.listar();
        listaComentario=publicacionDAO.listarComentarios(publicacion);
        System.out.println("EXECUTE LISTA COMENTARIO: " + listaComentario);
        content="ListarPublicaciones_fe.jsp";
        return "fin";
    }

    @Override
    public Publicacion getModel() {
        return publicacion;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        System.out.println("GETLISTAPUBLICACIONES: " + listaPublicacion);       
        Iterator <Publicacion> iterador = listaPublicacion.iterator();
        while(iterador.hasNext()){
            Publicacion p =  iterador.next();
            System.out.println("ESLAPUBLICACION: " + p.getTitulo());
            Iterator <Comentario> iterador2 = p.getComentarios().iterator();
            while(iterador2.hasNext()){
                System.out.println("COMENTARIOSPUBLICACION: " + iterador2.next().getTitulo());
            }
        }
        System.out.println("COMENTARIOSPUBLICACIONES: " + listaPublicacion);
        return listaPublicacion;
    }
    
    public List<Comentario> getListaComentarios(){
        return listaComentario;
    }
    
    /*public Integer getCantidadComentarios(){        
        this.cantidadComentarios = publicacionDAO.listarComentarios(publicacion).size();
        System.out.println("PUBLICACION: " + (publicacion.getIdPublicacion()));
        System.out.println("CANTIDAD COMENTARIOS:" + cantidadComentarios);
        
        return cantidadComentarios;
    }*/
 
}
