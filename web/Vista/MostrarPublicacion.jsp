<%-- 
    Document   : MostrarPublicacion
    Created on : 22/06/2014, 00:00:34
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
        <title>MOSTRAR PUBLICACION</title>
    </head>
    <body>
        <s:include value="nav.jsp" />
        <h1>MOSTRAR PUBLICACION</h1>
        <hr>

        <s:form action="modificarPublicacion" method="post">
            <s:textfield readonly="true" label="ID" name="publicacion.idPublicacion" size="20" maxlength="30"/>
            <s:textfield readonly="true" label="Titulo" name="publicacion.titulo" size="20" maxlength="30"/>
            <s:textarea readonly="true" label="Descripcion" name="publicacion.descripcion" cols="60" rows="5"/>
            <s:textarea readonly="true" label="Contenido" name="publicacion.contenido" cols="60" rows="5"/>
        </s:form>
        <hr>
        <s:label value="%{msg}"/>
        <s:include value="footer.jsp" />
    </body>
</html>
