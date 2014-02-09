<%-- 
    Document   : login
    Created on : 27/01/2014, 17:47:46
    Author     : banquete
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<s:set var="varPag" value="%{'menu'}" />
<html>
    <head>
        <s:include value="head.jsp" />
    </head>
    <body>
        <s:include value="nav.jsp" />
        <h3>Bienvenido, por favor ingrese sus datos.</h3>
        <s:actionmessage />
        <s:fielderror>
            <s:param>usuarioInexistente</s:param>
        </s:fielderror>
        <s:form action="login" method="post">
            <s:textfield name="mail" label="E-mail"></s:textfield>
            <s:textfield name="clave" label="Clave" type="password"></s:textfield>
            <s:hidden name="from" value="login" />
            <s:submit value="Ingresar"></s:submit>
        </s:form>
        <s:include value="footer.jsp" />
    </body>
</html>
