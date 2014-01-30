/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interceptor;

import model.entities.Usuario;

/**
 *
 * @author banquete
 */

public interface UserAware {
    public void setUsuario(Usuario u);
}   

