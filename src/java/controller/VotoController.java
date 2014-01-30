/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import model.dao.VotoDAO;
import model.dao.VotoDAOImpl;
import model.entities.Voto;

/**
 *
 * @author agustin
 */
public class VotoController implements ModelDriven<Voto>{
    Voto voto = new Voto();
    ArrayList<Voto> listaVotos= new ArrayList();
    VotoDAO votoDAO;
    String msg="";
    
    @Override
    public Voto getModel() {
        return voto;
    }
    
    public VotoController(){
        votoDAO=new VotoDAOImpl();
    }
    
    public String agregarInicio(){
        return "exito";
    }
    
    public String listarInicio(){
        return "exito";
    }
    
    public String agregar(){
        if(votoDAO.agregar(voto))
            msg="Se agrego un voto nuevo";
        else
            msg="Ocurrio un error al agregar voto";
        return "fin";
    }
    
    public String listar(){
        listaVotos=votoDAO.listar();
        return "fin";
    }

    public Voto getVoto() {
        return voto;
    }

    public ArrayList<Voto> getListaVotos() {
        return listaVotos;
    }

    public String getMsg() {
        return msg;
    }

    public void setVoto(Voto voto) {
        this.voto = voto;
    }
    
    
}
