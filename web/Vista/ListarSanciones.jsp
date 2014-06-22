<%-- 
    Document   : ListarSanciones
    Created on : 16/02/2014, 17:50:33
    Author     : agustin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<s:set var="varPag" value="%{'sancion'}" />
<html>
    <head>
        <s:include value="head.jsp" />
    </head>
    <body>
        <s:include value="nav.jsp" />
        <h1>Lista de Sanciones</h1>
        <hr>
        <s:form action="listarSanciones" method="post">
            <s:submit value="Listar"/>
        </s:form>
        <table border="1" width="100%">
                <tr>
                    <td>ID</td>
                    <td>MOTIVO</td>
                    <td>PUNTOS</td>
                    <td>EDITAR</td>
                    <td>BORRAR</td>
                </tr>
            <s:iterator value="%{listaSanciones}">
                <tr>
                    <td><s:property value="idSancion"/></td>
                    <td><s:property value="motivo"/></td>
                    <td><s:property value="puntos"/></td>
                    <td><a href="<s:url value="http://www.google.com"  />"><img src="images/tema_1/edit.gif" alt="editar"></a></td>
                    <td><a href="<s:url value="http://www.google.com"  />"><img src="images/tema_1/delete.gif" alt="editar"></a></td>
                </tr>
            </s:iterator>
        </table>

        <s:include value="footer.jsp" />
    </body>
</html>
