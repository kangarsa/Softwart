<%-- 
    Document   : ListarComentariosDePublicacion
    Created on : 22/06/2014, 02:04:47
    Author     : agustin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        <table border="1" width="50%">
        <s:iterator value="%{listaComentarios}">
                <tr>
                    <td>TITULO: <s:property value="titulo"/></td>
                </tr>
                <tr>
                    <td>CONTENIDO: <s:property value="contenido"/></td>
                </tr>
            </s:iterator>
        </table>
    </body>
</html>
