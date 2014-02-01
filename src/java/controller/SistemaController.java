/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import model.dao.SistemaDAO;
import model.dao.SistemaDAOImpl;
import model.entities.Sistema;

/**
 *
 * @author agustin
 */
public class SistemaController implements ModelDriven<Sistema>{
    Sistema sistema = new Sistema();
    ArrayList<Sistema> listaSistemas= new ArrayList();
    SistemaDAO sistemaDAO;
    String msg="";
    
    /**
     *
     * @return
     */
    @Override
    public Sistema getModel() {
        return sistema;
    }
    
    public SistemaController(){
        sistemaDAO=new SistemaDAOImpl();
    }
    
    public String agregarInicio(){
        return "exito";
    }
    
    public String listarInicio(){
        return "exito";
    }
    
    public String agregar(){
        if(sistemaDAO.agregar(sistema))
            msg="Se agrego un sistema nuevo";
        else
            msg="Ocurrio un error al agregar sistema";
        return "fin";
    }
    
    public String listar(){
        listaSistemas=sistemaDAO.listar();
        return "fin";
    }

    public Sistema getSistema() {
        return sistema;
    }

    public ArrayList<Sistema> getListaSistemas() {
        return listaSistemas;
    }

    public String getMsg() {
        return msg;
    }

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }
    
    public String cambiarTitulo(String titulo) {
        if(sistemaDAO.cambiarTitulo(titulo))
            msg="Se cambio el titulo del sistema";
        else
            msg="Ocurrio un error al cambiar el titulo del sistema";
        return "fin";
    }
    
    public String cambiarDescripcion(String descripcion) {
        if(sistemaDAO.cambiarDescripcion(descripcion))
            msg="Se cambio la descripcion del sistema";  
        else
            msg="Ocurrio un error al cambiar la descripcion del sistema";
        return "fin";
    }
    
    public String setTag(String tag) {
        if(sistemaDAO.setTag(tag))
            msg="Se cambio el tag del sistema";  
        else
            msg="Ocurrio un error al cambiar el tag del sistema";
        return "fin";
    }
    
    public String setUris(String uris) {
        if(sistemaDAO.setUris(uris))
            msg="Se cambio la uri del sistema";  
        else
            msg="Ocurrio un error al cambiar la uri del sistema";
        return "fin";
    }
    
    public String setBanner(String banner) {
        if(sistemaDAO.setBanner(banner) )
            msg="Se cambio el banner del sistema";  
        else
            msg="Ocurrio un error al cambiar el banner del sistema";
        return "fin";
    }
    
    public String setEstilo(String estilo) {
        if(sistemaDAO.setEstilo(estilo))
            msg="Se cambio el estilo del sistema";  
        else
            msg="Ocurrio un error al cambiar el estilo del sistema";
        return "fin";
    }
    
    
    public String habilitarSitio() {
        if(sistemaDAO.habilitarSitio())
            msg="Se habilito el sitio";  
        else
            msg="Ocurrio un al habilitar el sitio";
        return "fin";
    }
    
    
    public String deshabilitarSitio() {
        if(sistemaDAO.deshabilitarSitio())
            msg="Se deshabilito el sitio";  
        else
            msg="Ocurrio un al deshabilitar el sitio";
        return "fin";
    }
            
    public String activarModerarPublicaciones() {
        if(sistemaDAO.deshabilitarSitio())
            msg="Se activaron las moderaciones";  
        else
            msg="Ocurrio un al intentar activar las moderaciones";
        return "fin";
    }
    
    
    public String desactivarModerarPublicaciones() {
        if(sistemaDAO.deshabilitarSitio())
            msg="Se desactivaron las moderaciones";  
        else
            msg="Ocurrio un al intentar desactivar las moderaciones";
        return "fin";
    }
    
    public String cambiarPuntosParaSancionar(Integer limitePuntos) {
        if(sistemaDAO.deshabilitarSitio())
            msg="Se cambiaron los puntos para sancionar";  
        else
            msg="Ocurrio un error al intentar cambiar los puntos para sancionar";
        return "fin";
    }
    
    public String cambiarTiempoDeSancion(Integer tiempo) {
        if(sistemaDAO.deshabilitarSitio())
            msg="Se cambio el tiempo de sancion";  
        else
            msg="Ocurrio un al intentar cambiar el tiempo de sancion";
        return "fin";
    }
    
}
