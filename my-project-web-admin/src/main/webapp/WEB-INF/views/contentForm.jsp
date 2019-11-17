<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/11/3
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
<!DOCTYPE html>
<html>
<head>
    <title>我的商城 | 内容管理</title>
    <jsp:include page="../include/header.jsp" />
    <link rel="stylesheet" href="/static/assets/plugins/jquery-ztree/css/zTreeStyle/zTreeStyle.min.css" />
    <link rel="stylesheet" href="/static/assets/plugins/dropzone/dropzone.css" />
    <link rel="stylesheet" href="/static/assets/plugins/dropzone/min/basic.min.css" />
    <link rel="stylesheet" href="/static/assets/plugins/wangEditor/wangEditor.min.css" />

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
                <small></small>
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
                            <h3 class="box-title">${tbContent.id == null ? "新增":"编辑"}内容</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form:form id="inputForm" cssClass="form-horizontal" action="/content/save" method="post" modelAttribute="tbContent">
                            <form:hidden path="id" />
                            <div class="box-body">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">父级类目:</label>

                                    <div class="col-sm-10">
                                        <form:hidden id="categoryId" path="tbContentCategory.id" />
                                        <input id="categoryName" class="form-control required" placeholder="请选择" readonly="true" data-toggle="modal" data-target="#modal-default" value="${tbContent.tbContentCategory.name}" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="title" class="col-sm-2 control-label">标题:</label>

                                    <div class="col-sm-10">
                                        <form:input path="title" class="form-control required" placeholder="标题" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="subTitle" class="col-sm-2 control-label">子标题:</label>

                                    <div class="col-sm-10">
                                        <form:input path="subTitle" class="form-control required" placeholder="子标题" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="titleDesc" class="col-sm-2 control-label">标题描述:</label>

                                    <div class="col-sm-10">
                                        <form:input path="titleDesc" class="form-control required" placeholder="标题描述" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="url" class="col-sm-2 control-label">链接:</label>

                                    <div class="col-sm-10">
                                        <form:input path="url" class="form-control" placeholder="链接" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="url" class="col-sm-2 control-label">图片1:</label>

                                    <div class="col-sm-10">
                                        <form:input path="pic" class="form-control" placeholder="图片1" />
                                        <div id="dropz" class="dropzone"></div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="url" class="col-sm-2 control-label">图片2:</label>

                                    <div class="col-sm-10">
                                        <form:input path="pic2" class="form-control" placeholder="图片2" />
                                        <div id="dropz2" class="dropzone"></div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-2 control-label">详情:</label>

                                    <div class="col-sm-10">
                                        <form:hidden path="content" />
                                        <div id="editor">${tbContent.content}</div>
                                    </div>
                                </div>
                            </div>

                            <div class="box-footer">
                                <button type="button" class="btn btn-default" onclick="history.go(-1);">返回</button>
                                <button id="btnSubmit" type="submit" class="btn btn-info pull-right" >提交</button>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </section>
    </div>
    <!-- /.content-wrapper 底部版权信息-->

    <jsp:include page="../include/copyrigth.jsp" />

</div>


<jsp:include page="../include/footer.jsp" />
<script src="/static/assets/plugins/jquery-ztree/js/jquery.ztree.core-3.5.min.js"></script>
<script src="/static/assets/plugins/dropzone/min/dropzone.min.js"></script>
<script src="/static/assets/plugins/wangEditor/wangEditor.min.js"></script>
<sys:modal title="请选择创建目录" message="<ul id='myTree' class='ztree'></ul>"/>

<script>
    $(function () {
        App.initZTree("/content/category/tree/data", ["id"], function (nodes) {
            var node = nodes[0];
            $("#categoryId").val(node.id);
            $("#categoryName").val(node.name);
            $("#modal-default").modal("hide");
        });

        initWangEditor();
    });

    /**
     * 初始化富文本编辑器
     */
    function initWangEditor () {
        var E = window.wangEditor;
        var editor = new E('#editor');
        // 配置服务器端地址
        editor.customConfig.uploadImgServer = '/upload';
        editor.customConfig.uploadFileName = 'editorFiles';
        editor.create();

        $("#btnSubmit").bind("click", function() {
            var contentHtml = editor.txt.html();
            $("#content").val(contentHtml);
        });
    }

    App.initDropzone({
        id: "#dropz",
        url: "/upload",
        init: function () {
            this.on("success", function (file, data) {
                $("#pic").val(data.fileName);
            });
        }
    });

    App.initDropzone({
        id: "#dropz2",
        url: "/upload",
        init: function () {
            this.on("success", function (file, data) {
                $("#pic2").val(data.fileName);
            });
        }
    });

</script>
</body>
</html>

