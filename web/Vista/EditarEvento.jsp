<%-- 
    Document   : EditarEvento
    Created on : 20/06/2014, 16:37:36
    Author     : agustin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<s:set var="varPag" value="%{'evento'}" />
<html>
    <head>
        <s:include value="head.jsp" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EDITAR EVENTO</title>
    </head>
    <body>
        <s:include value="nav.jsp" />
        <h1>EDITAR EVENTO</h1>
        <hr>

        <s:form action="modificarEvento" method="post">
            <s:textfield readonly="true" label="ID" name="evento.idEvento" size="20" maxlength="30"/>
            <s:textfield label="Titulo" name="evento.titulo" size="20" maxlength="30"/>
            <s:textfield label="Descripcion" name="evento.descripcion" size="40" maxlength="255"/>
            <s:textfield label="Contenido" name="evento.contenido" size="40" maxlength="30"/>
            <s:submit value="Aceptar"/>
        </s:form>
        <hr>
        <s:label value="%{msg}"/>
        <s:include value="footer.jsp" />
    </body>
</html>

