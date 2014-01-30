/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import model.dao.TagDAO;
import model.dao.TagDAOImpl;
import model.entities.Tag;

/**
 *
 * @author agustin
 */
public class TagController implements ModelDriven<Tag>{
    Tag tag = new Tag();
    ArrayList<Tag> listaTags= new ArrayList();
    TagDAO tagDAO;
    String msg="";
    
    @Override
    public Tag getModel() {
        return tag;
    }
    
    public TagController(){
        tagDAO=new TagDAOImpl();
    }
    
    public String agregarInicio(){
        return "exito";
    }
    
    public String listarInicio(){
        return "exito";
    }
    
    public String agregar(){
        if(tagDAO.agregar(tag))
            msg="Se agrego un tag nuevo";
        else
            msg="Ocurrio un error al agregar tag";
        return "fin";
    }
    
    public String listar(){
        listaTags=tagDAO.listar();
        return "fin";
    }

    public Tag getTag() {
        return tag;
    }

    public ArrayList<Tag> getListaTags() {
        return listaTags;
    }

    public String getMsg() {
        return msg;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
    
    
}
