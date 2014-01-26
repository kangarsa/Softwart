package model.entities;
// Generated 23/01/2014 14:28:10 by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Publicacion generated by hbm2java
 */
public class Publicacion  implements java.io.Serializable {


     private Integer idPublicacion;
     private Usuario usuarioByUsuarioPublicador;
     private Usuario usuarioByModeradoPor;
     private String titulo;
     private String descripcion;
     private String contenido;
     private Date fechaSubida;
     private Boolean habilitada;
     private Date fechaBaja;
     private Boolean comentariosHabilitados;
     private Integer vistas;
     private Set tags = new HashSet(0);
     private Set comentarios = new HashSet(0);
     private Set sancions = new HashSet(0);
     private Set votos = new HashSet(0);
     private Set eventos = new HashSet(0);

    public Publicacion() {
    }

	
    public Publicacion(Usuario usuarioByUsuarioPublicador) {
        this.usuarioByUsuarioPublicador = usuarioByUsuarioPublicador;
    }
    public Publicacion(Usuario usuarioByUsuarioPublicador, Usuario usuarioByModeradoPor, String titulo, String descripcion, String contenido, Date fechaSubida, Boolean habilitada, Date fechaBaja, Boolean comentariosHabilitados, Integer vistas, Set tags, Set comentarios, Set sancions, Set votos, Set eventos) {
       this.usuarioByUsuarioPublicador = usuarioByUsuarioPublicador;
       this.usuarioByModeradoPor = usuarioByModeradoPor;
       this.titulo = titulo;
       this.descripcion = descripcion;
       this.contenido = contenido;
       this.fechaSubida = fechaSubida;
       this.habilitada = habilitada;
       this.fechaBaja = fechaBaja;
       this.comentariosHabilitados = comentariosHabilitados;
       this.vistas = vistas;
       this.tags = tags;
       this.comentarios = comentarios;
       this.sancions = sancions;
       this.votos = votos;
       this.eventos = eventos;
    }
   
    public Integer getIdPublicacion() {
        return this.idPublicacion;
    }
    
    public void setIdPublicacion(Integer idPublicacion) {
        this.idPublicacion = idPublicacion;
    }
    public Usuario getUsuarioByUsuarioPublicador() {
        return this.usuarioByUsuarioPublicador;
    }
    
    public void setUsuarioByUsuarioPublicador(Usuario usuarioByUsuarioPublicador) {
        this.usuarioByUsuarioPublicador = usuarioByUsuarioPublicador;
    }
    public Usuario getUsuarioByModeradoPor() {
        return this.usuarioByModeradoPor;
    }
    
    public void setUsuarioByModeradoPor(Usuario usuarioByModeradoPor) {
        this.usuarioByModeradoPor = usuarioByModeradoPor;
    }
    public String getTitulo() {
        return this.titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getContenido() {
        return this.contenido;
    }
    
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    public Date getFechaSubida() {
        return this.fechaSubida;
    }
    
    public void setFechaSubida(Date fechaSubida) {
        this.fechaSubida = fechaSubida;
    }
    public Boolean getHabilitada() {
        return this.habilitada;
    }
    
    public void setHabilitada(Boolean habilitada) {
        this.habilitada = habilitada;
    }
    public Date getFechaBaja() {
        return this.fechaBaja;
    }
    
    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }
    public Boolean getComentariosHabilitados() {
        return this.comentariosHabilitados;
    }
    
    public void setComentariosHabilitados(Boolean comentariosHabilitados) {
        this.comentariosHabilitados = comentariosHabilitados;
    }
    public Integer getVistas() {
        return this.vistas;
    }
    
    public void setVistas(Integer vistas) {
        this.vistas = vistas;
    }
    public Set getTags() {
        return this.tags;
    }
    
    public void setTags(Set tags) {
        this.tags = tags;
    }
    public Set getComentarios() {
        return this.comentarios;
    }
    
    public void setComentarios(Set comentarios) {
        this.comentarios = comentarios;
    }
    public Set getSancions() {
        return this.sancions;
    }
    
    public void setSancions(Set sancions) {
        this.sancions = sancions;
    }
    public Set getVotos() {
        return this.votos;
    }
    
    public void setVotos(Set votos) {
        this.votos = votos;
    }
    public Set getEventos() {
        return this.eventos;
    }
    
    public void setEventos(Set eventos) {
        this.eventos = eventos;
    }




}

