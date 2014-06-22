<%-- 
    Document   : backend
    Created on : 22/06/2014, 18:50:42
    Author     : agustin
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<s:set var="varPag" value="%{'comentario'}" />
<html>
    <head>
        <s:include value="head.jsp" />
    </head>
    <body>
        <s:include value="nav.jsp" />
        <h1>Bienvenido al Backend!</h1>
        <s:include value="footer.jsp" />
    </body>
</html>