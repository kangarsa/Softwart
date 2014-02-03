<%-- 
    Document   : ListarComentarios
    Created on : 24/01/2014, 17:06:18
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
        <h1>Lista de comentarios</h1>
        <hr>
        <s:include value="footer.jsp" />
    </body>
</html>
