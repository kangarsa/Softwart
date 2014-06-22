<%-- 
    Document   : frontend
    Created on : 22/06/2014, 13:45:38
    Author     : agustin
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
        <%--
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
        
        --%>
        
                <s:include value="header_fe.jsp" />

                <s:include value="nav_fe.jsp" />
		
		<s:include value="main_fe.jsp" />

                <s:include value="footer_fe.jsp" />
    </body>
</html>
