<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/10/27
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--格式化工具 jstl中提供--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--SpringMVC的表单标签库--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    >
    <title>我的商城 | 用户管理</title>
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
                <%--三元表达式，取出session中的id进行判断。如果有id则是用户编辑，没有则是用户新增--%>
                用户管理


                <%--<small>Control panel</small>--%>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">控制面板</li>
            </ol>
        </section>


        <!-- Main content 页面主要内容布局-->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${baseResult != null}">
                        <div class="alert alert-${baseResult.status ==200 ? "success":"danger"} alert-dismissable">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                            <h4><i class="icon fa fa-ban"></i> 提示!</h4>
                            ${baseResult.message}
                        </div>
                    </c:if>
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">${tbUser.id == null ? "新增用户":"编辑用户"}信息</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->

                        <%--modelAttribute与form:form一起才能将填写信息回显到表单上，modelAttribute和model跳转的类似。又因为当我们在用户
                        信息填写有误的时候后台判断不通过，则从新返回到原表单页面，所以在我们跳转到表单页面的时候可以将之前用户输入的有误信
                        息放在model里面随着跳转一起带到返回之后的表单页面，并将其对应取出显示到表单上--%>

                        <form:form id="inputForm" cssClass="form-horizontal" action="/user/save" method="post" modelAttribute="tbUser" >
                            <!--编辑所有的隐藏域 id-->
                            <form:hidden path="id" />
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="email" class="col-sm-2 control-label">邮箱：</label>

                                        <%--required="true"字段必填--%>
                                    <div class="col-sm-10">
                                        <form:input path="email" cssClass="form-control required email" placeholder="请输入您的邮箱！" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="password" class="col-sm-2 control-label">密码：</label>

                                    <div class="col-sm-10">
                                        <form:input path="password" cssClass="form-control required password" placeholder="请输入您的密码！" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="username" class="col-sm-2 control-label">名称：</label>

                                    <div class="col-sm-10">
                                        <form:input path="username" cssClass="form-control required" placeholder="请输入您的名称！" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="phone" class="col-sm-2 control-label">电话：</label>

                                    <div class="col-sm-10">
                                        <form:input path="phone" cssClass="form-control required mobile" placeholder="请输入您的电话！" />
                                    </div>
                                </div>
                            </div>

                            <!-- /.box-body -->
                            <div class="box-footer">
                                <button type="button" class="btn btn-default" onclick="history.go(-1);">返回</button>
                                <button type="submit" class="btn btn-info pull-right">确定</button>
                            </div>
                            <!-- /.box-footer -->
                        </form:form>
                    </div>
                </div>
            </div>
        </section>
    </div>
    <!-- /.content-wrapper 底部版权信息-->

    <jsp:include page="../include/copyrigth.jsp" />

</div>
</body>

<jsp:include page="../include/footer.jsp" />

</html>

