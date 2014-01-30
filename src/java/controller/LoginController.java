/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.Map;
import model.dao.UsuarioDAO;
import model.dao.UsuarioDAOImpl;
import model.entities.Usuario;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author banquete
 */
public class LoginController extends ActionSupport implements SessionAware, ModelDriven<Usuario>{
    private final Usuario u = new Usuario();
    private final UsuarioDAO uDAO = new UsuarioDAOImpl();
    private Map<String, Object> sessionAttributes = ActionContext.getContext().getSession();
    private String siguiente;
    
    public String getSiguiente(){
        return siguiente;
    }
    
    @Override
    public void validate(){
    }

    @Override
    public String execute() {
        if(uDAO.getUsuario(u) != null){
            sessionAttributes.put("usuario", u);
            siguiente = (String) sessionAttributes.get("paginaSiguiente");
            return SUCCESS;
        }
        addFieldError("usuarioInexistente",getText("user.notExists"));
        return INPUT;
    }
 
    @Override
    public void setSession(Map<String, Object> sessionAttributes) {
        this.sessionAttributes = sessionAttributes;
    }
     
    @Override
    public Usuario getModel() {
        return u;
    }
}
