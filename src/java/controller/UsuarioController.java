/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import com.opensymphony.xwork2.ModelDriven;
import java.util.List;
import model.dao.UsuarioDAO;
import model.dao.UsuarioDaoHibernateJPA;
import model.entities.Usuario;

/**
 *
 * @author agustin
 */
public class UsuarioController implements ModelDriven<Usuario>{
    Usuario usuario = new Usuario();
    Integer idUsuario;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }
    List<Usuario> listaUsuarios;
    UsuarioDAO usuarioDAO;
    String msg="";
    
    @Override
    public Usuario getModel() {
        return usuario;
    }
    
    
    
    public UsuarioController(){
        usuarioDAO=new UsuarioDaoHibernateJPA();
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

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public String getMsg() {
        return msg;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String editar(){
        usuario = usuarioDAO.getUsuarioById(usuario.getIdUsuario());
        return "fin";
    }
    
    public String modificar(){
        usuarioDAO.editar(usuario);
        return "fin";
    }
    
    public String eliminar(){
        usuarioDAO.eliminar(usuario);
        return "fin";
    }
    
    
}
