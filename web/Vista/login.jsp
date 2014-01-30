<%-- 
    Document   : login
    Created on : 27/01/2014, 17:47:46
    Author     : banquete
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body bgColor="lightBlue">
        <h3>Bienvenido, por favor ingresa tus datos.</h3>
        <s:form action="login" method="post">
            <s:textfield name="mail" label="E-mail"></s:textfield>
            <s:textfield name="clave" label="Clave" type="password"></s:textfield>
            <s:submit value="Ingresar"></s:submit>
        </s:form>
    </body>
</html>



