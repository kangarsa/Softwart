package model.entities;
// Generated 23/01/2014 14:28:10 by Hibernate Tools 3.6.0


import java.util.Date;

/**
 * Sancion generated by hbm2java
 */
public class Sancion  implements java.io.Serializable {


     private Integer idSancion;
     private Publicacion publicacion;
     private Comentario comentario;
     private String motivo;
     private Integer puntos;
     private Date fechaInicio;
     private Date fechaFinSancion;

    public Sancion() {
    }

    public Sancion(Publicacion publicacion, Comentario comentario, String motivo, Integer puntos, Date fechaInicio, Date fechaFinSancion) {
       this.publicacion = publicacion;
       this.comentario = comentario;
       this.motivo = motivo;
       this.puntos = puntos;
       this.fechaInicio = fechaInicio;
       this.fechaFinSancion = fechaFinSancion;
    }
   
    public Integer getIdSancion() {
        return this.idSancion;
    }
    
    public void setIdSancion(Integer idSancion) {
        this.idSancion = idSancion;
    }
    public Publicacion getPublicacion() {
        return this.publicacion;
    }
    
    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }
    public Comentario getComentario() {
        return this.comentario;
    }
    
    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }
    public String getMotivo() {
        return this.motivo;
    }
    
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    public Integer getPuntos() {
        return this.puntos;
    }
    
    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }
    public Date getFechaInicio() {
        return this.fechaInicio;
    }
    
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public Date getFechaFinSancion() {
        return this.fechaFinSancion;
    }
    
    public void setFechaFinSancion(Date fechaFinSancion) {
        this.fechaFinSancion = fechaFinSancion;
    }




}

