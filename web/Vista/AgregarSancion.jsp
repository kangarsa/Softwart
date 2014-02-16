<%-- 
    Document   : AgregarSancion.jsp
    Created on : 16/02/2014, 17:39:11
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
        <h1>Sancionar</h1>
        <hr>
        <s:form action="agregarSancion" method="post">
            <s:textfield label="Motivo" name="sancion.motivo" size="20" maxlength="30"/>
            <s:textfield label="Puntos" name="sancion.puntos" size="40" maxlength="255"/>
            <s:select  
                        tooltip="Publicacion a Sancionar"  
                        label="Publicacion"  
                        list="publicacionesComentables" 
                        name="publicacion"
                        listKey="%{idPublicacion}" 
                        listValue="%{titulo}"  
                        emptyOption="true"  
                        headerKey="None"  
                        headerValue="None"/>  
            <s:submit value="Agregar"/>
        </s:form>
        <hr>
        <s:label value="%{msg}"/>
        <s:include value="footer.jsp" />
    </body>
</html>

