<%-- 
    Document   : main_fe
    Created on : 22/06/2014, 14:37:54
    Author     : agustin
--%>

<%@taglib uri="/struts-tags" prefix="s"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Main -->
<div id="main-wrapper">
    <div id="main" class="container">
        <div class="row">
            <div class="9u skel-cell-important">
                <div class="content content-left">

                    <!-- Content -->
                    
                    <s:include value="%{content}" />

                    <!-- /Content -->

                </div>
            </div>
            <div class="3u">
                <div class="sidebar">

                    <!-- Sidebar -->

                    <!-- Tags Search -->
                    
                    <section>
                        <h2 class="major"><span>Buscar por Tags</span></h2>
                        <s:form action="buscarPorTagsFE" method="get">
                            <s:textfield label="Tag" name="tag" size="20" maxlength="30"/>
                            <s:submit value="Buscar"/>
                        </s:form>
                    </section>
                    
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