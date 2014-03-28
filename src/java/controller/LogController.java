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
import model.dao.UsuarioDaoHibernateJPA;
import model.entities.Usuario;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author banquete
 */
public class LogController extends ActionSupport implements SessionAware, ModelDriven<Usuario>{
    private final Usuario u = new Usuario();
    private final UsuarioDAO uDAO = new UsuarioDaoHibernateJPA();
    private Map<String, Object> sessionAttributes = ActionContext.getContext().getSession();
    private String siguiente;
    private String from;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
    
    public String getSiguiente(){
        return siguiente;
    }
    
    @Override
    public void validate(){
        if(getFrom() != null){
            if(u.getMail().isEmpty()){
                addFieldError("mail",getText("user.nullMail"));
            }
            if(u.getClave().isEmpty()){
                addFieldError("clave",getText("user.nullPass"));
            }
        }
    }
    
    @Override
    public String execute(){
        return SUCCESS;
    }

    public String login() {
        if(getFrom() != null){
            Usuario user = uDAO.getUsuario(u);
            if(user != null){
                sessionAttributes.put("usuario", user);
                siguiente = (String) sessionAttributes.get("paginaSiguiente");
                sessionAttributes.put("paginaSiguiente",null);
                return SUCCESS;
            }
            addFieldError("usuarioInexistente",getText("user.notExists"));
        }
        return INPUT;
    }
    
    public String logout() {
        sessionAttributes.put("usuario", null);
        addActionMessage(getText("user.thanks"));
        return SUCCESS;
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
