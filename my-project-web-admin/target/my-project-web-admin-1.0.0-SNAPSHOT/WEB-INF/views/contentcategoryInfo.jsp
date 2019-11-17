<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/11/2
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--格式化工具 jstl中提供--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
<!DOCTYPE html>
<html>
<head>

    <title>我的商城 | 内容管理</title>
    <jsp:include page="../include/header.jsp" />
    <link rel="stylesheet" href="/static/assets/plugins/treeTable/themes/vsStyle/treeTable.min.css" />

</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="../include/nav.jsp" />

    <jsp:include page="../include/menu.jsp" />

    <%--content-wrapper 主页面容器--%>
    <div class="content-wrapper">
        <section class="content-header">
            <h1>
                内容管理
                <%--<small>Control panel</small>--%>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">控制面板</li>
            </ol>
        </section>

        <!-- Main content 页面主要内容布局-->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${baseResult != null}">
                        <div class="alert alert-${baseResult.status == 200 ? "success":"danger"} alert-dismissable">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                ${baseResult.message}
                        </div>
                    </c:if>


                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">分类列表</h3>
                        </div>

                        <div class="box-body">
                            <a href="/content/category/form" type="button" class="btn btn-sm btn-default"><i class="fa fa-plus"></i> 新增</a>&nbsp;&nbsp;&nbsp;
                            <a href="#" type="button" class="btn btn-sm btn-default"><i class="fa fa-download"></i> 导入</a>&nbsp;&nbsp;&nbsp;
                            <a href="#" type="button" class="btn btn-sm btn-default"><i class="fa fa-upload"></i> 导出</a>&nbsp;&nbsp;&nbsp;
                        </div>

                        <!-- /.box-header -->
                        <div class="box-body table-responsive">
                            <table id="treeTable" class="table table-hover">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>名称</th>
                                    <th>排序</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${tbContentCategories}" var="tbContentCategory">
                                    <tr id="${tbContentCategory.id}" pId="${tbContentCategory.parent.id}">
                                        <td>${tbContentCategory.id}</td>
                                        <td>${tbContentCategory.name}</td>
                                        <td>${tbContentCategory.sortOrder}</td>
                                        <td>
                                            <a href="/content/category/form?id=${tbContentCategory.id}" type="button" class="btn btn-sm btn-primary"><i class="fa fa-edit"></i> 编辑</a>&nbsp;&nbsp;&nbsp;
                                            <button type="button" class="btn btn-sm btn-danger" onclick="App.deleteSingle('/content/category/delete', '${tbContentCategory.id}', '警告：该删除操作会将包括选中类目在内的全部子类目及属于类目的内容一并删除，请谨慎操作！您还确定继续吗？')"><i class="fa fa-trash-o"></i> 删除</button>&nbsp;&nbsp;&nbsp;
                                            <a href="/content/category/form?parent.id=${tbContentCategory.id}&parent.name=${tbContentCategory.name}" type="button" class="btn btn-sm btn-default"><i class="fa fa-plus"></i> 添加下级菜单</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                </div>
        </section>
    </div>
    <!-- /.content-wrapper 底部版权信息-->

    <jsp:include page="../include/copyrigth.jsp" />


</div>
<jsp:include page="../include/footer.jsp" />
<script src="/static/assets/plugins/treeTable/jquery.treeTable.min.js" ></script>


<!-- 自定义模态框 -->
<sys:modal/>

<script>
    $(function () {
        $("#treeTable").treeTable({
            column: 1,
            expandLevel: 2
        });
    });
</script>

</body>
</html>
