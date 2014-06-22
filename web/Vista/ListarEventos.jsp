<%-- 
    Document   : ListarEventos.jsp
    Created on : 09/02/2014, 19:18:43
    Author     : agustin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<s:set var="varPag" value="%{'evento'}" />
<html>
    <head>
        <s:include value="head.jsp" />
    </head>
    <body>
        <s:include value="nav.jsp" />
        <h1>Lista de Eventos</h1>
        <hr>
        <s:form action="listarEventos" method="post">
            <s:submit value="Listar"/>
        </s:form>
        <table border="1" width="100%">
                <tr>
                    <td>ID</td>
                    <td>TITULO</td>
                    <td>DESCRIPCION</td>
                    <td>CONTENIDO</td>
                    <td>EDITAR</td>
                    <td>BORRAR</td>   
                </tr>
            <s:iterator value="%{listaEventos}">
                <tr>
                    <td><s:property value="idEvento "/></td>
                    <td><s:property value="titulo"/></td>
                    <td><s:property value="descripcion"/></td>
                    <td><s:property value="contenido"/></td>
                    <td><a href="<s:url action="editarEvento" > <s:param name="idEvento"><s:property value="idEvento"/></s:param></s:url>"><img src="images/tema_1/edit.gif" alt="editar"></a></td>
                    <td><a href="<s:url action="eliminarEvento" > <s:param name="idEvento"><s:property value="idEvento"/></s:param></s:url>"><img src="images/tema_1/delete.gif" alt="editar"></a></td>
                </tr>
            </s:iterator>
        </table>

        <s:include value="footer.jsp" />
    </body>
</html>
