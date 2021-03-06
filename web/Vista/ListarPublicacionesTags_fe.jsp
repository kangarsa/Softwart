<%-- 
    Document   : listarpubli
    Created on : 22/06/2014, 16:07:23
    Author     : agustin
--%>

<%@taglib uri="/struts-tags" prefix="s"%>
<s:if test="%{listaPublicacionesTags.size() == 0}">
    <h2>Lo Sentimos, no existen publicaciones con ese tag.</h2>
</s:if>
<s:else>
    <s:iterator value="listaPublicacionesTags">
    <article class="is-page-content">
        <header>
            <h2><s:property value="titulo"/></h2>
            <span class="byline"><s:property value="descripcion"/></span>
            <ul class="meta">
                <li class="fa fa-clock-o"><s:date name="fechaSubida" format="dd/MM/yyyy" /></li>
                <li class="fa fa-comments"><a href="#"></a><s:property value="comentarios.size()"/></li>
            </ul>
        </header>

        <section>
            <span class="image image-full"><img src="images/pic05.jpg" alt="" /></span>
            <p><s:property value="contenido"/></p>
        </section>

        <section>
                <p>Tags: 
            <s:iterator value="tags">
                <s:property value="texto"/> 
            </s:iterator>
                </p>
        </section>

        <section>
            <s:iterator value="comentarios">
                <h3><s:property value="titulo"/></h3>
                <ul class="meta">
                    <li class="fa fa-clock-o"><s:date name="fechaSubida" format="dd/MM/yyyy" /></li>
                </ul>
                <p><s:property value="contenido"/></p>
                <span>De: <s:property value="usuarioComentador.nombre"/></span>
            </s:iterator>
        </section>
        <section>
            <s:if test="%{#session.usuario != null}">
                <s:form action="agregarComentarioFE" method="post">
                    <s:textfield label="Titulo" name="comentario.titulo" size="20" maxlength="30"/>
                    <s:textfield label="Contenido" name="comentario.contenido" size="40" maxlength="255"/>
                    <s:hidden value="%{idPublicacion}" name="idPublicacion" /> 
                    <s:submit value="Comentar"/>
                </s:form>
            </s:if>
            <s:else>
                <p>Para comentar ingresa <a href="<s:url action="login" ></s:url>">AQU�</a></p>
            </s:else>

        </section>

    </article>
    </s:iterator>
</s:else>