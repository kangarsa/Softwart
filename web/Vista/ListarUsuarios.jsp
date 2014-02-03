<%-- 
    Document   : ListarComentarios
    Created on : 24/01/2014, 17:06:18
    Author     : agustin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<s:set var="varPag" value="%{'usuario'}" />
<html>
    <head>
        <s:include value="head.jsp" />
    </head>
    <body>
        <s:include value="nav.jsp" />
        <h1>Lista de Usuarios</h1>
        <hr>
        <s:form action="listarUsuarios" method="post">
            <s:submit value="Listar"/>
        </s:form>
        <table border="1" width="100%">
                <tr>
                    <td>ID</td>
                    <td>NOMBRE</td>
                    <td>APELLIDO</td>
                    <td>MAIL</td>
                    <td>DNI</td>
                </tr>
            <s:iterator value="%{listaUsuarios}">
                <tr>
                    <td><s:property value="idUsuario"/></td>
                    <td><s:property value="nombre"/></td>
                    <td><s:property value="apellido"/></td>
                    <td><s:property value="mail"/></td>
                    <td><s:property value="dni"/></td>
                </tr>
            </s:iterator>
        </table>

        <s:include value="footer.jsp" />
    </body>
</html>
