<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/10/25
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--格式化工具 jstl中提供--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
>
    <title>我的商城 | 控制面板</title>
    <jsp:include page="../include/header.jsp" />

</head>
<body class="hold-transition skin-blue sidebar-mini">
    <div class="wrapper">
        <jsp:include page="../include/nav.jsp" />

        <jsp:include page="../include/menu.jsp" />

        <%--content-wrapper 主页面容器--%>
        <div class="content-wrapper">
            <section class="content-header">
                <h1>
                    控制面板
                    <%--<small>Control panel</small>--%>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                    <li class="active">控制面板</li>
                </ol>
            </section>

            <!-- Main content 页面主要内容布局-->
            <section class="content">

            </section>
        </div>
        <!-- /.content-wrapper 底部版权信息-->

    <jsp:include page="../include/copyrigth.jsp" />

    </div>
</body>

    <jsp:include page="../include/footer.jsp" />

</html>

