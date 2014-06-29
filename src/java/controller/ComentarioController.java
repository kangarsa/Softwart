/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import java.util.List;
import model.dao.ComentarioDAO;
import model.dao.ComentarioDaoHibernateJPA;
import model.dao.PublicacionDAO;
import model.dao.PublicacionDaoHibernateJPA;
import model.entities.Comentario;
import model.entities.Publicacion;
import model.entities.Usuario;

/**
 *
 * @author agustin
 */
public class ComentarioController extends ActionSupport implements ModelDriven<Comentario> {
    Comentario comentario = new Comentario();
    List<Comentario> listaComentarios= new ArrayList();
    ComentarioDAO comentarioDAO;
    PublicacionDAO publicacionDAO;
    Usuario u = (Usuario) ActionContext.getContext().getSession().get("usuario");
    String msg="";
    List<Publicacion>  publicacionesComentables;
    private Publicacion publicacion = new Publicacion();
    private Integer idPublicacion;
    private String titulo;

    public ComentarioController(){
        comentarioDAO=new ComentarioDaoHibernateJPA();
        publicacionDAO=new PublicacionDaoHibernateJPA();
        listaComentarios= new ArrayList<Comentario>();
    }
    
    public ComentarioDAO getComentarioDAO() {
        return comentarioDAO;
    }

    public void setComentarioDAO(ComentarioDAO comentarioDAO) {
        this.comentarioDAO = comentarioDAO;
    }
    
    public PublicacionDAO getPublicacionDAO() {
        return publicacionDAO;
    }

    public void setPublicacionDAO(PublicacionDAO publicacionDAO) {
        this.publicacionDAO = publicacionDAO;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public Usuario getU() {
        return u;
    }

    public void setU(Usuario u) {
        this.u = u;
    }

    public Publicacion getPublicacion() {
        System.out.println("GETPUBLICACION: " + publicacion);
        return publicacion;
    }

    public void setPublicacion(Publicacion publication) {
        this.publicacion = publication;
    }

    public Integer getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(Integer idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    
    @Override
    public Comentario getModel() {
        return comentario;
    }
          
    public String agregarInicio(){
        this.publicacionesComentables = comentarioDAO.publicacionesComentablesPara(u);
        return "exito";
    }
    
    public String listarInicio(){
        return "exito";
    }
    
    public String agregar(){
        System.out.println("ID PUBLICACION COMENTADA: " + idPublicacion);
        publicacion = publicacionDAO.getPublicacionById(idPublicacion);
        publicacion.getComentarios().add(comentario);
        comentario.setPublicacion(publicacion);
        comentario.setUsuarioComentador(u);
        if(comentarioDAO.agregar(comentario))
            msg="Se agrego un comentario nuevo";
        else
            msg="Ocurrio un error al agregar comentario";
        return "fin";
    }
    
    public String listar(){
        listaComentarios=comentarioDAO.listar();
        return "fin";
    }

    public String listarDePublicacion(){
        System.out.println("ID PUBLICACION: " + idPublicacion);
       // listaComentarios=comentarioDAO.listarDePublicacion(idPublicacion);

        publicacion = publicacionDAO.getPublicacionById(idPublicacion);
        listaComentarios= publicacion.getComentarios();
        System.out.println("LISTA COMENTARIOS FE: " +  listaComentarios );
        System.out.println("PUBLICACION: " + publicacion.getTitulo());
        return "fin";
    }

    public Comentario getComentario() {
        return comentario;
    }

    public List<Comentario> getListaComentarios() {
        return listaComentarios;
    }

    public String getMsg() {
        return msg;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }
    
    public List<Publicacion> getPublicacionesComentables() {
        List<Publicacion> listaPublicaciones = comentarioDAO.publicacionesComentablesPara(u);
        System.out.println(listaPublicaciones);
        return listaPublicaciones;
    }
    
        public String editar(){
        comentario = comentarioDAO.getComentarioById(comentario.getIdComentario());
        return "fin";
    }
    
    public String modificar(){
        comentarioDAO.editar(comentario);
        return "fin";
    }
    
    public String eliminar(){
        comentarioDAO.eliminar(comentario);
        return "fin";
    }
    
    public String mostrar(){
        comentario = comentarioDAO.getComentarioById(comentario.getIdComentario());
        return "fin";
    }

}
