<%-- 
    Document   : menu
    Created on : 02/02/2014, 17:55:23
    Author     : banquete
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div id="container">
    <div class="header">
      <div class="infoGeneral_temas"></div>
      <div class="marca">
           <a class="marca_podcast" title="Softwart"></a>
      </div>
    </div>
    <div class="nav">
    <ul id="menu_principal">
        <li <s:if test="%{#varPag == 'menu'}">id="itemMarcado"</s:if> >
            <a href="<s:url value="/" />">Backend</a>
        </li> 
        <li <s:if test="%{#varPag == 'usuario'}">id="itemMarcado"</s:if> >
            <a href="<s:url action="listarInicioUsuario"/>">Usuarios</a>
        </li>
        <li <s:if test="%{#varPag == 'evento'}">id="itemMarcado"</s:if> >
            <a href="<s:url action="listarInicioEvento"/>">Eventos</a>
        </li>
        <li <s:if test="%{#varPag == 'comentario'}">id="itemMarcado"</s:if> >
            <a href="<s:url action="listarInicioComentario"/>">Comentarios</a>
        </li>
        <li <s:if test="%{#varPag == 'publicacion'}">id="itemMarcado"</s:if> >
            <a href="<s:url action="listarInicioPublicacion"/>">Publicaciones</a>
        </li>
        <li <s:if test="%{#varPag == 'sancion'}">id="itemMarcado"</s:if> >
            <a href="<s:url action="listarInicioSancion"/>">Sanciones</a>
        </li>
        <li <s:if test="%{#varPag == 'sistema'}">id="itemMarcado"</s:if> >
            <a href="<s:url action="listarInicioSistema"/>">Sistema</a>
        </li>
        <li <s:if test="%{#varPag == 'tag'}">id="itemMarcado"</s:if> >
            <a href="<s:url action="listarInicioTag"/>">Tags</a>
        </li>
        <li <s:if test="%{#varPag == 'voto'}">id="itemMarcado"</s:if> >
            <a href="<s:url action="listarInicioVoto"/>">Votos</a>
        </li>
        <li>
            <a href="<s:url action="index"/>">Ir al Frontend</a>
        </li>
        <s:if test="%{#session.usuario != null}">
        <li>
            <a href="<s:url action="logout"/>">Logout</a>
        </li> 
        </s:if>

    </ul>

  </div>