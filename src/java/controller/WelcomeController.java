/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import java.util.List;
import model.dao.PublicacionDAO;
import model.dao.PublicacionDaoHibernateJPA;
import model.entities.Comentario;
import model.entities.Publicacion;

/**
 *
 * @author banquete
 */
public class WelcomeController extends ActionSupport implements ModelDriven<Publicacion> {    
    Publicacion publicacion = new Publicacion();
    List<Publicacion> listaPublicacion= new ArrayList();
    List<Comentario> listaDeComentarios= new ArrayList();
    PublicacionDAO publicacionDAO;
    String content="";

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
    
    @Override
    public String execute(){
        listaPublicacion=publicacionDAO.listar();
        System.out.println("E TARAO "+listaPublicacion);
        content="ListarPublicaciones_fe.jsp";
        return SUCCESS;
    }

    @Override
    public Publicacion getModel() {
        return publicacion;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }
    
    public List<Publicacion> getListaPublicaciones() {
        return listaPublicacion;
    }
 
}
