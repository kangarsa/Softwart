<%-- 
    Document   : AgregarComentario
    Created on : 24/01/2014, 17:06:01
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
        <h1>Crear Comentario</h1>
        <hr>
        <s:form action="agregarComentario" method="post">
            <s:textfield label="Titulo" name="comentario.titulo" size="20" maxlength="30"/>
            <s:textfield label="Contenido" name="comentario.contenido" size="40" maxlength="255"/>  
            <s:submit value="Comentar"/>
        </s:form>
        <hr>
        <s:label value="%{msg}"/>
        <s:include value="footer.jsp" />
    </body>
</html>
