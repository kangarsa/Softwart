/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import model.dao.UsuarioDAO;
import model.dao.UsuarioDAOImpl;
import model.entities.Usuario;

/**
 *
 * @author agustin
 */
public class UsuarioController implements ModelDriven<Usuario>{
    Usuario usuario = new Usuario();
    ArrayList<Usuario> listaUsuarios= new ArrayList();
    UsuarioDAO usuarioDAO;
    String msg="";
    
    public Usuario getModel() {
        return usuario;
    }
    
    
    
    public UsuarioController(){
        usuarioDAO=new UsuarioDAOImpl();
    }
    
    public String agregarInicio(){
        return "exito";
    }
    
    public String listarInicio(){
        return "exito";
    }
    
    public String agregar(){
        if(usuarioDAO.agregar(usuario))
            msg="Se agrego un usuario nuevo";
        else
            msg="Ocurrio un error al agregar usuario";
        return "fin";
    }
    
    public String listar(){
        listaUsuarios=usuarioDAO.listar();
        return "fin";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public String getMsg() {
        return msg;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
