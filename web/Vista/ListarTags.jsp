<%-- 
    Document   : ListarTags
    Created on : 20/02/2014, 15:41:41
    Author     : agustin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<s:set var="varPag" value="%{'tag'}" />
<html>
    <head>
        <s:include value="head.jsp" />
    </head>
    <body>
        <s:include value="nav.jsp" />
        <h1>Lista de Tags</h1>
        <hr>
        <s:form action="listarTags" method="post">
            <s:submit value="Listar"/>
        </s:form>
        <table border="1" width="100%">
                <tr>
                    <td>ID</td>
                    <td>TEXTO</td>
                    <td>CANTIDAD</td>
                    <td>EDITAR</td>
                    <td>BORRAR</td>
                </tr>
            <s:iterator value="%{listaTags}">
                <tr>
                    <td><s:property value="idTag"/></td>
                    <td><s:property value="texto"/></td>
                    <td><s:property value="cantidad"/></td>
                    <td><a href="<s:url action="editarTag" > <s:param name="idTag"><s:property value="idTag"/></s:param></s:url>"><img src="images/tema_1/edit.gif" alt="editar"></a></td>
                    <td><a href="<s:url action="eliminarTag" > <s:param name="idTag"><s:property value="idTag"/></s:param></s:url>"><img src="images/tema_1/delete.gif" alt="borrar"></a></td>
                </tr>
            </s:iterator>
        </table>

        <s:include value="footer.jsp" />
    </body>
</html>

