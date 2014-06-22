<%-- 
    Document   : EditarTag.jsp
    Created on : 21/06/2014, 23:43:01
    Author     : agustin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<s:set var="varPag" value="%{'tag'}" />
<html>
    <head>
        <s:include value="head.jsp" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EDITAR TAG</title>
    </head>
    <body>
        <s:include value="nav.jsp" />
        <h1>EDITAR TAG</h1>
        <hr>

        <s:form action="modificarTag" method="post">
            <s:textfield readonly="true" label="ID" name="tag.idTag" size="20" maxlength="30"/>
            <s:textfield label="Texto" name="tag.texto" size="20" maxlength="30"/>
            <s:textfield label="Cantidad" name="tag.cantidad" size="40" maxlength="255"/>
            <s:submit value="Aceptar"/>
        </s:form>
        <hr>
        <s:label value="%{msg}"/>
        <s:include value="footer.jsp" />
    </body>
</html>