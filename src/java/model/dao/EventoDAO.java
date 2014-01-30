/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao;

import java.util.ArrayList;
import model.entities.Evento;

/**
 *
 * @author agustin
 */
public interface EventoDAO {
    public boolean agregar(Evento evento);
    public ArrayList<Evento> listar();
}
