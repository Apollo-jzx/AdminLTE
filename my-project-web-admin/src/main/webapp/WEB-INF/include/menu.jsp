<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/10/27
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <div class="user-panel">
            <div class="pull-left image">
                <img src="/static/assets/img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>Admin:${user.username}</p>
                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>
        <!-- search form 搜索表单-->
        <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
                <input type="text" name="q" class="form-control" placeholder="Search...">
                <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
            </div>
        </form>
        <!-- /.search form -->
        <!-- sidebar menu: : style can be found in sidebar.less 树形菜单-->
        <ul class="sidebar-menu" data-widget="tree">
            <li class="header">主要导航</li>
            <li class="active treeview">
                <a href="#">
                    <i class="fa fa-home"></i> <span>业务逻辑</span>
                    <span class="pull-right-container">
                             <i class="fa fa-angle-left pull-right"></i>
                            </span>
                </a>
                <ul class="treeview-menu">
                    <li ><a href="/user/list"><i class="fa fa-user-plus"></i> 用户信息</a></li>
                    <li><a href="/user/form"><i class="fa fa-user"></i> 用户管理</a></li>
                </ul>
            </li>

            <li class="active treeview">
                <a href="#">
                    <i class="fa fa-book"></i> <span>内容管理</span>
                    <span class="pull-right-container">
                             <i class="fa fa-angle-left pull-right"></i>
                            </span>
                </a>
                <ul class="treeview-menu">
                    <li ><a href="/content/category/list"><i class="fa fa-user-plus"></i> 内容分类</a></li>
                    <li><a href="/content/list"><i class="fa fa-user"></i> 内容列表</a></li>
                </ul>
            </li>
        </ul>
    </section>
</aside>