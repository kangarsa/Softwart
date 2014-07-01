<%-- 
    Document   : login_form
    Created on : 29/06/2014, 19:20:00
    Author     : agustin
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<s:form action="login" method="post">
    <s:textfield name="mail" label="E-mail"></s:textfield>
    <s:textfield name="clave" label="Clave" type="password"></s:textfield>
    <s:hidden name="from" value="login" />
    <s:submit value="Ingresar"></s:submit>
</s:form>