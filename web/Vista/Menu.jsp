<%-- 
    Document   : Menu
    Created on : 24/01/2014, 17:06:28
    Author     : agustin
    Edited by  : mateo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <s:include value="head.jsp" />
    </head>
    <body>
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
    </body>
</html>
