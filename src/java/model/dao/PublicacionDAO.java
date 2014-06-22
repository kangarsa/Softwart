/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao;

import java.util.List;
import model.entities.Publicacion;
import model.entities.Usuario;

/**
 *
 * @author agustin
 */
public interface PublicacionDAO {
    public boolean agregar(Publicacion publicacion);
    public List<Publicacion> listar();
    public void eliminar(Publicacion publicacion);
    public boolean editar(Publicacion publicacion);
    public boolean eliminarComentarios(Publicacion publicacion);
    public List listarComentarios(Publicacion publicacion);
    public List listarTags(Publicacion publicacion);
    public List<Publicacion> publicacionesDeUsuario(Usuario usuario);
    public Publicacion getPublicacionById(Integer idPublicacion);
    
}
