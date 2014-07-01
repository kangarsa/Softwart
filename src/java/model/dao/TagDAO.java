/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao;

import java.util.List;
import model.entities.Tag;

/**
 *
 * @author agustin
 */
public interface TagDAO {
    public boolean agregar(Tag tag);
    public List<Tag> listar();
    public boolean editar(Tag tag);
    public void eliminar(Tag tag);
    public Tag getTagById(Integer idTag);
    public Tag buscarPorTexto(String textoTag);
}
