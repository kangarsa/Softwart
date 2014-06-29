/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao;

import java.util.List;
import model.entities.Comentario;
import model.entities.Publicacion;
import model.entities.Usuario;

/**
 *
 * @author agustin
 */
public interface ComentarioDAO {
    public List<Publicacion> publicacionesComentablesPara(Usuario u);
    public boolean agregar(Comentario comentario);
    public List<Comentario> listar();
    public boolean editar(Comentario comentario);
    public void eliminar(Comentario comentario);

    public List<Comentario> listarDePublicacion(Integer idPublicacion);

    public Comentario getComentarioById(Integer idComentario);
}
