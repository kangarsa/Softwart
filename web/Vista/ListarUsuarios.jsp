<%-- 
    Document   : ListarComentarios
    Created on : 24/01/2014, 17:06:18
    Author     : agustin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
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
            <s:iterator value="%(listaUsuarios)">
                <tr>
                    <td><s:property value="idUsuario"></s:property></td>
                    <td><s:property value="nombre"></s:property></td>
                    <td><s:property value="apellido"></s:property></td>
                    <td><s:property value="mail"></s:property></td>
                    <td><s:property value="dni"></s:property></td>
                </tr>
            </s:iterator>
        </table>

    </body>
</html>
