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
        <h1>Lista de Comentarios</h1>
        <hr>
        <s:form action="listarComentarios" method="post">
            <s:submit value="Listar"/>
        </s:form>
        <table border="1" width="100%">
                <tr>
                    <td>ID</td>
                    <td>TITULO</td>
                    <td>DESCRIPCION</td>
                    <td>EDITAR</td>
                    <td>BORRAR</td>
                </tr>
            <s:iterator value="%{listaComentarios}">
                <tr>
                    <td><s:property value="idComentario"/></td>
                    <td><s:property value="titulo"/></td>
                    <td><s:property value="contenido"/></td>
                    <td><a href="<s:url action="editarComentario" > <s:param name="idComentario"><s:property value="idComentario"/></s:param></s:url>"><img src="images/tema_1/edit.gif" alt="editar"></a></td>
                    <td><a href="<s:url action="eliminarComentario" > <s:param name="idComentario"><s:property value="idComentario"/></s:param></s:url>"><img src="images/tema_1/delete.gif" alt="editar"></a></td>
                </tr>
            </s:iterator>
        </table>

        <s:include value="footer.jsp" />
    </body>
</html>
