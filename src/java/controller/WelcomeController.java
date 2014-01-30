/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import interceptor.UserAware;
import model.entities.Usuario;

/**
 *
 * @author banquete
 */
public class WelcomeController extends ActionSupport implements UserAware, ModelDriven<Usuario> {
 
    private Usuario u;
 
    @Override
    public String execute(){
        return SUCCESS;
    }
     
    @Override
    public void setUsuario(Usuario u) {
        this.u=u;
    }
     
    public Usuario getUsuario(Usuario u){
        return this.u;
    }
 
    @Override
    public Usuario getModel() {
        return this.u;
    }
 
}
