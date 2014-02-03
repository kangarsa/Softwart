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
        <h1>Menu Comentario</h1>
        <hr>
        <a href="agregarInicioComentario">Agregar Comentario</a><br>
        <a href="listarInicioComentario">Listar Comentarios</a><br>
        <hr>
        <hr>
        <h1>Menu Usuario</h1>
        <hr>
        <a href="agregarInicioUsuario">Agregar Usuario</a><br>
        <a href="listarInicioUsuario">Listar Usuarios</a><br>
        <h1>Menu Publicacion</h1>
        <hr>
        <a href="agregarInicioPublicacion">Agregar Publicacion</a><br>
        <a href="listarInicioPublicacion">Listar Publicaciones</a><br>
        <s:include value="footer.jsp" />
    </body>
</html>
