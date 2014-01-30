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
import model.entities.Usuario;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author banquete
 */
public class LoginController extends ActionSupport implements SessionAware, ModelDriven<Usuario>{
    private final Usuario u = new Usuario();
    private Map<String, Object> sessionAttributes = ActionContext.getContext().getSession();
    private String siguiente;
    
    public String getSiguiente(){
        return siguiente;
    }

    @Override
    public String execute(){
        if("admin".equals(u.getMail()) && "admin".equals(u.getClave())){
            u.setNombre("admin admin");
            sessionAttributes.put("usuario", u);
            siguiente = (String) sessionAttributes.get("paginaSiguiente");
            return SUCCESS;
        }
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
