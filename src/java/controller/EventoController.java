/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.dao.EventoDAO;
import model.dao.EventoDaoHibernateJPA;
import model.entities.Evento;
import model.entities.Usuario;

/**
 *
 * @author agustin
 */
public class EventoController implements ModelDriven<Evento>{
    Evento evento = new Evento();
    List<Evento> listaEventos= new ArrayList();
    EventoDAO eventoDAO;
    String msg="";
    
    public Evento getModel() {
        return evento;
    }
    
    public EventoController(){
        eventoDAO=new EventoDaoHibernateJPA();
    }
    
    public String agregarInicio(){
        return "exito";
    }
    
    public String listarInicio(){
        return "exito";
    }
    
    public String listar(){
        listaEventos=eventoDAO.listar();
        return "fin";
    }
    
    public String agregar(){
        Map<String, Object> sessionAttributes = ActionContext.getContext().getSession();
        Usuario usuarioPublicador = (Usuario) sessionAttributes.get("usuario");
        evento.setEventoByUsuarioPublicador(usuarioPublicador);
        if(eventoDAO.agregar(evento))
            msg="Se agrego un evento nuevo";
        else
            msg="Ocurrio un error al agregar evento";
        return "fin";
  
    }

    public Evento getEvento() {
        return evento;
    }

    public List<Evento> getListaEventos() {
        return listaEventos;
    }

    public String getMsg() {
        return msg;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    
    public String editar(){
        evento = eventoDAO.getEventoById(evento.getIdEvento());
        return "fin";
    }
    
    public String modificar(){
        eventoDAO.editar(evento);
        return "fin";
    }
    
    public String eliminar(){
        eventoDAO.eliminar(evento);
        return "fin";
    }
    
}
