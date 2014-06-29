<%-- 
    Document   : MostrarPublicacion
    Created on : 22/06/2014, 00:00:34
    Author     : agustin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<s:set var="varPag" value="%{'publicacion'}" />
<html>
    <head>
        <s:include value="head.jsp" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MOSTRAR PUBLICACION</title>
    </head>
    <body>
        <s:include value="nav.jsp" />
        <h1>MOSTRAR PUBLICACION</h1>
        <hr>

        <s:form action="modificarPublicacion" method="post">
            <s:textfield readonly="true" label="ID" name="idPublicacion" size="20" maxlength="30"/>
            <s:textfield readonly="true" label="Titulo" name="publicacion.titulo" size="20" maxlength="30"/>
            <s:textarea readonly="true" label="Descripcion" name="publicacion.descripcion" cols="60" rows="5"/>
            <s:textarea readonly="true" label="Contenido" name="publicacion.contenido" cols="60" rows="5"/>
        </s:form>
        <hr>
        <h1>Comentar</h1>
        <s:form action="agregarComentario" method="post">
            <s:property value="idPublicacion"/>
            <s:textfield  readonly="true" name="idPublicacion" ></s:textfield>
            <s:textfield label="Titulo" name="titulo" size="20" maxlength="30"/>
            <s:textfield label="Contenido" name="contenido" size="40" maxlength="255"/>  
            <s:submit value="Comentar"/>
        </s:form>
        <s:form action="listarComentariosDePublicacion" method="post">
            <s:textfield style="visibility: hidden;" readonly="true" name="idPublicacion" ></s:textfield>
            <s:textfield style="visibility: hidden;" readonly="true" name="publicacion.titulo" ></s:textfield>
            <s:textfield style="visibility: hidden;" readonly="true" name="publicacion.descripcion" ></s:textfield>
            <s:textfield style="visibility: hidden;" readonly="true" name="publicacion.contenido" ></s:textfield>
            <s:param name="idPublicacion"><s:property value="idPublicacion"/></s:param>
            <s:submit value="Ver Comentarios"/>
        </s:form>
        <hr>
        <table border="1" width="50%">
        <s:iterator value="%{listaComentarios}">
            <tr>
                <td>TITULO <br><s:property value="titulo"/><br></td>
            </tr>
            <tr>
                <td>CONTENIDO: <br><s:property value="contenido"/><br></td>
            </tr>
        </s:iterator>
        </table>
        <s:label value="%{msg}"/>
        <s:include value="footer.jsp" />
    </body>
</html>
