/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package listener;

import java.util.Date;
import java.util.Map;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import model.dao.SistemaDAO;
import model.dao.SistemaDAOImpl;
import model.entities.Sistema;

/**
 *
 * @author banquete
 */
public class DbConfigContextListener implements ServletContextListener{
    
    private void setContextAttributes(ServletContextEvent sce, Sistema s) {
        sce.getServletContext().setAttribute("sistema", s);
        sce.getServletContext().setAttribute("sBanner", s.getBanner());
        sce.getServletContext().setAttribute("sDescripcionDelSitio", s.getDescripcionDelSitio());
        sce.getServletContext().setAttribute("sEstilo", s.getEstilo());
        sce.getServletContext().setAttribute("sFechaModificacion", s.getFechaModificacion());
        sce.getServletContext().setAttribute("sHablitado", s.getHablitado());
        sce.getServletContext().setAttribute("sModerarPublicaciones", s.getModerarPublicaciones());
        sce.getServletContext().setAttribute("sPuntosParaSancionar", s.getPuntosParaSancionar());
        sce.getServletContext().setAttribute("sTagsDelSitio", s.getTagsDelSitio());
        sce.getServletContext().setAttribute("sTiempoDeSancion", s.getTiempoDeSancion());
        sce.getServletContext().setAttribute("sTituloDelSitio", s.getTituloDelSitio());
        sce.getServletContext().setAttribute("sUrisSemanticas", s.getUrisSemanticas());
    }
 
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContextListener inicializado");
        SistemaDAO sDAO = new SistemaDAOImpl();
        Sistema s = sDAO.getSistema();
        if (s==null) {
            // Default Config
            s = new Sistema(
                    null, 
                    "Softwart", 
                    "Página multimedia para alumnos de la facultad.", 
                    "softwart, multimedia, unlp", 
                    "http://www.unlp.edu.ar/", 
                    "banner.jpg", 
                    "estilo1.css", 
                    false, 
                    true, 
                    20, 
                    3600, 
                    new Date()
            );
        }
        this.setContextAttributes(sce, s);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContextListener finalizando");
    }
}