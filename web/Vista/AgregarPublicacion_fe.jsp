<%-- 
    Document   : AgregarPublicacion_fe
    Created on : 02/02/2014, 16:27:34
    Author     : agustin
--%>


<%@taglib uri="/struts-tags" prefix="s"%>
<%--
        <h1>Crear Publicacion</h1>
        <hr>
        <s:form action="agregarPublicacion" method="post">
            <s:textfield label="Titulo" name="publicacion.titulo" size="50" maxlength="50"/>
            <s:textarea label="Descripcion" name="publicacion.descripcion" cols="60" rows="5"/>
            <s:textarea label="Contenido" name="publicacion.contenido" cols="60" rows="20"/>
            
            <s:submit value="Agregar"/>
        </s:form>
        <hr>
        <s:label value="%{msg}"/>
        <s:include value="footer.jsp" />
--%>

<div id="main-wrapper">
    <div id="main" class="container">
        <div class="row">
            <div class="9u skel-cell-important">
                <div class="content content-left">

                    <!-- Content -->
                    
                    <s:iterator value="%{listaPublicaciones}">
                    <article class="is-page-content">

                        <header>
                            <h2><s:property value="titulo"/></h2>
                            <span class="byline"><s:property value="descripcion"/></span>
                            <ul class="meta">
                                <li class="fa fa-clock-o">5 days ago</li>
                                <li class="fa fa-comments"><a href="#">1,024</a></li>
                            </ul>
                        </header>

                        <section>
                            <span class="image image-full"><img src="images/pic05.jpg" alt="" /></span>
                            <p><s:property value="contenido"/></p>
                        </section>

                        <section>
                            <h3>comentarios?</h3>
                            <p>texto</p>
                        </section>

                    </article>
                    </s:iterator>

                    <!-- /Content -->

                </div>
            </div>
            <div class="3u">
                <div class="sidebar">

                    <!-- Sidebar -->

                    <!-- Recent Posts -->
                    <section>
                        <h2 class="major"><span>Recent Posts</span></h2>
                        <ul class="style2">
                            <li>
                                <article class="is-post-summary">
                                    <h3><a href="#">Where are the graphics?</a></h3>
                                    <ul class="meta">
                                        <li class="fa fa-clock-o">6 hours ago</li>
                                        <li class="fa fa-comments"><a href="#">34</a></li>
                                    </ul>
                                </article>
                            </li>
                            <li>
                                <article class="is-post-summary">
                                    <h3><a href="#">What achievements are there</a></h3>
                                    <ul class="meta">
                                        <li class="fa fa-clock-o">9 hours ago</li>
                                        <li class="fa fa-comments"><a href="#">27</a></li>
                                    </ul>
                                </article>
                            </li>
                            <li>
                                <article class="is-post-summary">
                                    <h3><a href="#">Can I play w/a controller</a></h3>
                                    <ul class="meta">
                                        <li class="fa fa-clock-o">Yesterday</li>
                                        <li class="fa fa-comments"><a href="#">184</a></li>
                                    </ul>
                                </article>
                            </li>
                        </ul>
                        <a href="#" class="button button-alt">Browse Archives</a>
                    </section>
                    <!-- /Recent Posts -->

                    <!-- Something -->
                    <section>
                        <h2 class="major"><span>Ipsum Dolore</span></h2>
                        <a href="#" class="image image-full"><img src="images/pic03.jpg" alt="" /></a>
                        <p>
                            Donec sagittis massa et leo semper scele risque metus faucibus. Morbi congue mattis mi. 
                            Phasellus sed nisl vitae risus tristique volutpat. Cras rutrum sed commodo luctus blandit.
                        </p>
                        <a href="#" class="button button-alt">Learn more</a>
                    </section>
                    <!-- /something -->

                    <!-- Something -->
                    <section>
                        <h2 class="major"><span>Magna Feugiat</span></h2>
                        <p>
                            Rhoncus dui quis euismod. Maecenas lorem tellus, congue et condimentum ac, ullamcorper non sapien. 
                            Donec sagittis massa et leo semper scele risque metus faucibus. Morbi congue mattis mi. 
                            Phasellus sed nisl vitae risus tristique volutpat. Cras rutrum sed commodo luctus blandit.
                        </p>
                        <a href="#" class="button button-alt">Learn more</a>
                    </section>
                    <!-- /something -->

                    <!-- /Sidebar -->

                </div>
            </div>
        </div>
        <div class="row">
            <div class="12u">

                <!-- Features -->
                <section class="is-features">
                    <h2 class="major"><span>Valid Commands</span></h2>
                    <div>
                        <div class="row">
                            <div class="3u">

                                <!-- Feature -->
                                <section class="is-feature">
                                    <a href="#" class="image image-full"><img src="images/pic01.jpg" alt="" /></a>
                                    <h3><a href="#">Look Up</a></h3>
                                    <p>
                                        Phasellus quam turpis, feugiat sit amet ornare in, a hendrerit in 
                                        lectus dolore. Praesent semper mod quis eget sed etiam eu ante risus.
                                    </p>
                                </section>
                                <!-- /Feature -->

                            </div>
                            <div class="3u">

                                <!-- Feature -->
                                <section class="is-feature">
                                    <a href="#" class="image image-full"><img src="images/pic02.jpg" alt="" /></a>
                                    <h3><a href="#">Look Down</a></h3>
                                    <p>
                                        Phasellus quam turpis, feugiat sit amet ornare in, a hendrerit in 
                                        lectus dolore. Praesent semper mod quis eget sed etiam eu ante risus.
                                    </p>
                                </section>
                                <!-- /Feature -->

                            </div>
                            <div class="3u">

                                <!-- Feature -->
                                <section class="is-feature">
                                    <a href="#" class="image image-full"><img src="images/pic03.jpg" alt="" /></a>
                                    <h3><a href="#">Examine Room</a></h3>
                                    <p>
                                        Phasellus quam turpis, feugiat sit amet ornare in, a hendrerit in 
                                        lectus dolore. Praesent semper mod quis eget sed etiam eu ante risus.
                                    </p>
                                </section>
                                <!-- /Feature -->

                            </div>
                            <div class="3u">

                                <!-- Feature -->
                                <section class="is-feature">
                                    <a href="#" class="image image-full"><img src="images/pic04.jpg" alt="" /></a>
                                    <h3><a href="http://getlamp.com">Get Lamp</a></h3>
                                    <p>
                                        Phasellus quam turpis, feugiat sit amet ornare in, a hendrerit in 
                                        lectus dolore. Praesent semper mod quis eget sed etiam eu ante risus.
                                    </p>
                                </section>
                                <!-- /Feature -->

                            </div>
                        </div>
                    </div>
                </section>
                <!-- /Features -->

            </div>
        </div>
    </div>
</div>
<!-- /Main -->