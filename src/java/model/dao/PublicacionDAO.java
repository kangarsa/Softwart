/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao;

import java.util.ArrayList;
import model.entities.Publicacion;

/**
 *
 * @author agustin
 */
public interface PublicacionDAO {
    public boolean agregar(Publicacion publicacion);
    public ArrayList<Publicacion> listar();
    
}
