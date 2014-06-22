<%-- 
    Document   : AgregarEvento
    Created on : 09/02/2014, 21:58:18
    Author     : agustin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<s:set var="varPag" value="%{'usuario'}" />
<html>
    <head>
        <s:include value="head.jsp" />
    </head>
    <body>
        <s:include value="nav.jsp" />
        <h1>Crear Evento</h1>
        <hr>
        <s:form action="agregarEvento" method="post">
            <s:textfield label="Titulo" name="evento.titulo" size="20" maxlength="30"/>
            <s:textfield label="Descripcion" name="evento.descripcion" size="40" maxlength="255"/>
            <s:textfield label="Contenido" name="evento.contenido" size="40" maxlength="30"/>
            <s:submit value="Agregar"/>
        </s:form>
        <hr>
        <s:label value="%{msg}"/>
        <s:include value="footer.jsp" />
    </body>
</html>
