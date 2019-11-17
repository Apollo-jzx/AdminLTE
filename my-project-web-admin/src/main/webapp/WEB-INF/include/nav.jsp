<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/10/27
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<header class="main-header">
    <!-- Logo -->
    <a href="/main" class="logo">
        <!-- mini logo for sidebar mini 50x50 pixels -->

        <%--1111111111111111111111缩放效果样式11111111111111111111111111--%>
        <span class="logo-mini"><b>商城</b>我的</span>
        <!-- logo for regular state and mobile devices -->
        <span class="logo-lg"><b>我的</b>商城</span>
    </a>
    <!-- Header Navbar: style can be found in header.less 导航栏-->
    <nav class="navbar navbar-static-top">
        <!-- Sidebar toggle button-->
        <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
            <span class="sr-only">Toggle navigation</span>
        </a>
        <%--菜单--%>
        <div class="navbar-custom-menu">
            <%--菜单的无序列表--%>
            <ul class="nav navbar-nav">
                <!-- dropdown 下拉菜单 -->
                <li class="dropdown messages-menu">
                    <ul class="dropdown-menu">
                        <li>
                            <ul class="menu">
                                <li>
                                    <a href="#">
                                        <div class="pull-left">
                                            <img src="/static/assets/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                                        </div>
                                        <h4>
                                            Support Team
                                            <small><i class="fa fa-clock-o"></i> 5 mins</small>
                                        </h4>
                                        <p>Why not buy a new awesome theme?</p>
                                    </a>
                                </li>
                                <li class="footer">
                                    <a href="#">View all tasks</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                    <!-- User Account: style can be found in dropdown.less -->
                <li class="dropdown user user-menu">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <img src="/static/assets/img/user2-160x160.jpg" class="user-image" alt="User Image">
                        <%--工具类ConstantUtils中SESSION_USER = "user"，所以取到Session中的邮箱是${user.email}--%>
                        <span class="hidden-xs">${user.email}</span>
                    </a>
                    <ul class="dropdown-menu">
                        <!-- User image -->
                        <li class="user-header">
                            <img src="/static/assets/img/user2-160x160.jpg" class="img-circle" alt="User Image">

                            <p>
                                ${user.username} - Web Developer
                                <small>
                                    <fmt:formatDate value="${user.created}" type="both"/>
                                    <%--jstl中的格式化工具 年月日时分秒显示 在嘴上面的C标签下面引入--%>
                                    <%--<fmt:formatDate value="${user.updated}" pattern="yyyy-MM-dd HH:mm:ss"/>--%>
                                    <%--<fmt:formatDate value="${user.updated}" type="both"/>--%>
                                </small>
                            </p>
                        </li>
                        <!-- Menu Body -->
                        <li class="user-body">
                            <div class="row">
                                <div class="col-xs-4 text-center">
                                    <a href="#">Followers</a>
                                </div>
                                <div class="col-xs-4 text-center">
                                    <a href="#">Sales</a>
                                </div>
                                <div class="col-xs-4 text-center">
                                    <a href="#">Friends</a>
                                </div>
                            </div>
                            <!-- /.row -->
                        </li>
                        <!-- Menu Footer-->
                        <li class="user-footer">
                            <div class="pull-left">
                                <a href="#" class="btn btn-default btn-flat">个人信息</a>
                            </div>
                            <div class="pull-right">
                                <a href="/logout" class="btn btn-default btn-flat">注销</a>
                            </div>
                        </li>
                    </ul>
            </ul>
        </div>
    </nav>
</header>