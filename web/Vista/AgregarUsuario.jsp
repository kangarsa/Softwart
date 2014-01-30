<%-- 
    Document   : AgregarComentario
    Created on : 24/01/2014, 17:06:01
    Author     : agustin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Crear Usuario</h1>
        <hr>
        <s:form action="agregarUsuario" method="post">
            <s:textfield label="Nombre" name="usuario.nombre" size="20" maxlength="30"/>
            <s:textfield label="Apellido" name="usuario.apellido" size="40" maxlength="255"/>
            <s:textfield label="Mail" name="usuario.mail" size="40" maxlength="30"/>
            <s:textfield label="Clave" name="usuario.clave" size="40" maxlength="255"/>
            <s:submit value="Agregar"/>
        </s:form>
        <hr>
        <s:label value="%{msg}"/>
    </body>
</html>
