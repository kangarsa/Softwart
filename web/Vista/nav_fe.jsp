<%-- 
    Document   : nav_fe
    Created on : 22/06/2014, 14:35:43
    Author     : agustin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!-- Nav -->
<div id="message"><s:label value="%{msg}"/></div>
        <nav id="nav" class="skel-panels-fixed">
                <ul>
                        <li class="current_page_item"><a href="index">Inicio</a></li>
                    <s:if test="%{#session.usuario == null}">
                        <li><a href="#tologin" onclick="document.getElementById('loginBox').style.visibility='visible';">Login</a></li>
                    </s:if>
                    <s:else>
                        <li><a href="<s:url action="publicar"/>">Publicar</a></li>
                        <li><a href="<s:url action="irAlMenuBackend"/>">Backend</a></li>
                        <li><a href="<s:url action="logout"/>">Logout</a></li>
                    </s:else>
                            
                </ul>
            <div id="loginBox" ><s:include value="login_form.jsp" /></div>
        </nav>
        
<!-- /Nav -->
