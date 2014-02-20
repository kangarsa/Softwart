<%-- 
    Document   : AgregarTag
    Created on : 20/02/2014, 15:33:15
    Author     : agustin
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<s:set var="varPag" value="%{'tag'}" />
<html>
    <head>
        <s:include value="head.jsp" />
    </head>
    <body>
        <s:include value="nav.jsp" />
        <h1>Crear Tag</h1>
        <hr>
        <s:form action="agregarTag" method="post">
            <s:textfield label="Text" name="tag.texto" size="20" maxlength="30"/>
            <s:textfield label="Cantidad" name="tag.cantidad" size="40" maxlength="255"/>
            <s:submit value="Agregar"/>
        </s:form>
        <hr>
        <s:label value="%{msg}"/>
        <s:include value="footer.jsp" />
    </body>
</html>
