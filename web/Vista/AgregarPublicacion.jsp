<%-- 
    Document   : AgregarPublicacion
    Created on : 02/02/2014, 16:27:34
    Author     : agustin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<s:set var="varPag" value="%{'publicacion'}" />
<html>
    <head>
        <s:include value="head.jsp" />
    </head>
    <body>
        <s:include value="nav.jsp" />
        <h1>Crear Publicacion</h1>
        <hr>
        <s:form action="agregarPublicacion" method="post">
            <s:textfield label="Titulo" name="publicacion.titulo" size="50" maxlength="50"/>
            <s:textarea label="Descripcion" name="publicacion.descripcion" cols="60" rows="5"/>
            <s:textarea label="Contenido" name="publicacion.contenido" cols="60" rows="20"/>
            <s:submit value="Agregar"/>
        </s:form>
        <hr>
        <s:label value="%{msg}"/>
        <s:include value="footer.jsp" />
    </body>
</html>
