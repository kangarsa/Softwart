<%-- 
    Document   : EditarUsuario
    Created on : 19/06/2014, 14:25:24
    Author     : agustin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<s:set var="varPag" value="%{'usuario'}" />
<html>
    <head>
        <s:include value="head.jsp" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EDITAR USUARIO</title>
    </head>
    <body>
        <s:include value="nav.jsp" />
        <h1>EDITAR USUARIO</h1>
        <hr>

        <s:form action="modificarUsuario" method="post">
            <s:textfield readonly="true" label="ID" name="usuario.idUsuario" size="20" maxlength="30"/>
            <s:textfield label="Nombre" name="usuario.nombre" size="20" maxlength="30"/>
            <s:textfield label="Apellido" name="usuario.apellido" size="40" maxlength="255"/>
            <s:textfield label="Mail" name="usuario.mail" size="40" maxlength="30"/>
            <s:textfield label="Clave" name="usuario.clave" size="40" maxlength="255"/>
            <s:submit value="Aceptar"/>
        </s:form>
        <hr>
        <s:label value="%{msg}"/>
        <s:include value="footer.jsp" />
    </body>
</html>
