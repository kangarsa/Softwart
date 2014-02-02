<%-- 
    Document   : ListarPublicaciones
    Created on : 02/02/2014, 16:27:45
    Author     : agustin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<s:set var="varPag" value="%{'publicacion'}" />
<html>
    <head>
        <s:include value="head.jsp" />
    </head>
    <body>
        <s:include value="nav.jsp" />
        <h1>Lista de Publicaciones</h1>
        <hr>
        <s:form action="listarPublicaciones" method="post">
            <s:submit value="Listar"/>
        </s:form>
        <table border="1" width="100%">
                <tr>
                    <td>ID</td>
                    <td>TITULO</td>
                    <td>DESCRIPCION</td>
                    <td>CONTENIDO</td>
                </tr>
            <s:iterator value="%{listaPublicaciones}">
                <tr>
                    <td><s:property value="idPublicacion"/></td>
                    <td><s:property value="titulo"/></td>
                    <td><s:property value="descripcion"/></td>
                    <td><s:property value="contenido"/></td>
                </tr>
            </s:iterator>
        </table>

    </body>
</html>
