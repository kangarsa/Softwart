/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao;

import java.util.List;
import model.entities.Usuario;

/**
 *
 * @author agustin
 */
public interface UsuarioDAO {
    public boolean agregar(Usuario usuario);
    public List<Usuario> listar();
    public Usuario usuarioConMail(String mail);
    public Usuario getUsuario(Usuario u);
}
