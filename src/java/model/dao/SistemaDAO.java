/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao;

import java.util.ArrayList;
import java.util.Date;
import model.entities.Sistema;

/**
 *
 * @author agustin
 */
public interface SistemaDAO {
    public Sistema getSistema();
    public boolean agregar(Sistema sistema);
    public ArrayList<Sistema> listar();
    public boolean cambiarTitulo(String titulo);
    public boolean cambiarDescripcion(String descripcion);
    public boolean setTag(String tag);
    public boolean setUris(String uris);
    public boolean setBanner(String banner);
    public boolean setEstilo(String estilo);
    public boolean habilitarSitio();
    public boolean deshabilitarSitio();
    public boolean activarModerarPublicaciones();
    public boolean desactivarModerarPublicaciones();
    public boolean cambiarPuntosParaSancionar(Integer limitePuntos);
    public boolean cambiarTiempoDeSancion(Integer tiempo);
    /**
     * @return
     */
    public Date getFechaModificacion();
}
