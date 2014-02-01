/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import com.opensymphony.xwork2.ActionContext;
import static com.opensymphony.xwork2.ActionContext.getContext;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import java.util.Map;
import model.dao.ComentarioDAO;
import model.dao.ComentarioDAOImpl;
import model.entities.Comentario;
import model.entities.Publicacion;
import model.entities.Usuario;

/**
 *
 * @author agustin
 */
public class ComentarioController implements ModelDriven<Comentario>{
    Comentario comentario = new Comentario();
    ArrayList<Comentario> listaComentarios= new ArrayList();
    ComentarioDAO comentarioDAO;
    Usuario u = (Usuario) ActionContext.getContext().getSession().get("usuario");
    String msg="";
    
    public Comentario getModel() {
        return comentario;
    }
    
    public ComentarioController(){
        comentarioDAO=new ComentarioDAOImpl();
    }
    
    public String agregarInicio(){
        return "exito";
    }
    
    public String listarInicio(){
        return "exito";
    }
    
    public String agregar(){
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

    public Comentario getComentario() {
        return comentario;
    }

    public ArrayList<Comentario> getListaComentarios() {
        return listaComentarios;
    }

    public String getMsg() {
        return msg;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }
    
    public ArrayList<Publicacion> getPublicacionesComentables() {
        ArrayList<Publicacion> listaPublicaciones = comentarioDAO.publicacionesComentablesPara(u);
        System.out.println(listaPublicaciones);
        return listaPublicaciones;
    }
    
}
