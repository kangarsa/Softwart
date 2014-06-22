<%-- 
    Document   : EditarPublicacion.jsp
    Created on : 21/06/2014, 20:29:52
    Author     : agustin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<s:set var="varPag" value="%{'publicacion'}" />
<html>
    <head>
        <s:include value="head.jsp" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EDITAR PUBLICACION</title>
    </head>
    <body>
        <s:include value="nav.jsp" />
        <h1>EDITAR PUBLICACION</h1>
        <hr>

        <s:form action="modificarPublicacion" method="post">
            <s:textfield readonly="true" label="ID" name="publicacion.idPublicacion" size="20" maxlength="30"/>
            <s:textfield label="Titulo" name="publicacion.titulo" size="20" maxlength="30"/>
            <s:textarea label="Descripcion" name="publicacion.descripcion" cols="60" rows="5"/>
            <s:textarea label="Contenido" name="publicacion.contenido" cols="60" rows="5"/>
            <s:submit value="Aceptar"/>
        </s:form>
        <hr>
        <s:label value="%{msg}"/>
        <s:include value="footer.jsp" />
    </body>
</html>
