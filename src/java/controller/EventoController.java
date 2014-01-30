/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import model.dao.EventoDAO;
import model.dao.EventoDAOImpl;
import model.entities.Evento;

/**
 *
 * @author agustin
 */
public class EventoController implements ModelDriven<Evento>{
    Evento evento = new Evento();
    ArrayList<Evento> listaEventos= new ArrayList();
    EventoDAO eventoDAO;
    String msg="";
    
    public Evento getModel() {
        return evento;
    }
    
    public EventoController(){
        eventoDAO=new EventoDAOImpl();
    }
    
    public String agregarInicio(){
        return "exito";
    }
    
    public String listarInicio(){
        return "exito";
    }
    
    public String agregar(){
        if(eventoDAO.agregar(evento))
            msg="Se agrego un evento nuevo";
        else
            msg="Ocurrio un error al agregar evento";
        return "fin";
    }
    
    public String listar(){
        listaEventos = eventoDAO.listar();
        return "fin";
    }

    public Evento getEvento() {
        return evento;
    }

    public ArrayList<Evento> getListaEventos() {
        return listaEventos;
    }

    public String getMsg() {
        return msg;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    
}
