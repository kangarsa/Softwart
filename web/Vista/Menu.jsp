<%-- 
    Document   : Menu
    Created on : 24/01/2014, 17:06:28
    Author     : agustin
    Edited by  : mateo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<s:set var="varPag" value="%{'menu'}" />
<html>
    <head>
        <s:include value="head.jsp" />
    </head>
    <body>
        <s:include value="nav.jsp" />
        <h1>MENU</h1>
        <h1>Menu Usuario</h1>
        <a href="agregarInicioUsuario">Agregar Usuario</a><br>
        <a href="listarInicioUsuario">Listar Usuarios</a><br>
        <h1>Menu Publicacion</h1>
        <a href="agregarInicioPublicacion">Agregar Publicacion</a><br>
        <a href="listarInicioPublicacion">Listar Publicaciones</a><br>
        <h1>Menu Evento</h1>
        <a href="agregarInicioEvento">Agregar Evento</a><br>
        <a href="listarInicioEvento">Listar Eventos</a><br>
        <h1>Menu Sancion</h1>
        <a href="agregarInicioSancion ">Agregar Sancion</a><br>
        <a href="listarInicioSancion">Listar Sanciones</a><br>
        <h1>Menu Tag</h1>
        <a href="agregarInicioTag ">Agregar Tag</a><br>
        <a href="listarInicioTag">Listar Tags</a><br>
        <s:include value="footer.jsp" />
        
    </body>
</html>
