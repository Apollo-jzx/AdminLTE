<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/10/27
  Time: 0:49
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
                控制面板
                <%--<small>Control panel</small>--%>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">用户信息</li>
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

                    <%--搜索部分--%>

                        <%--默认style为不显示，自定义一个class属性 在下面的搜索绑定事件 用class选择器选中触发事件--%>
                    <div class="box box-info box-info-search" style="display: none">
                        <div class="box-header">
                            <h3 class="box-title">搜索</h3>
                        </div>


                        <div class="box-body">
                            <div class="row form-horizontal">
                                <%--超小设备适应一行一个col-xs-12
                                中型设备适应一行三个col-sm-3--%>
                                <div class="col-xs-12 col-sm-3">
                                    <div class="form-group">
                                        <label for="username" class="col-sm-4 control-label" >名称：</label>
                                        <div class="col-sm-8">
                                            <input id="username" class="form-control" placeholder="搜索名称!"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-12 col-sm-3">
                                    <div class="form-group">
                                        <label for="email" class="col-sm-4 control-label" >邮箱：</label>
                                        <div class="col-sm-8">
                                            <input id="email" class="form-control" placeholder="搜索邮箱!"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-12 col-sm-3">
                                    <div class="form-group">
                                        <label for="phone" class="col-sm-4 control-label" >电话：</label>
                                        <div class="col-sm-8">
                                            <input id="phone" class="form-control" placeholder="搜索电话!"/>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="box-footer">
                            <button type="button" class="btn btn-info pull-right" onclick="search();">搜索</button>
                        </div>

                    </div>

                        <div class="box">
                            <div class="box-header">
                                <h3 class="box-title">用户信息</h3>
                            </div>

                            <div class="box-body">
                                <a href="/user/form" type="button" class="btn btn-sm btn-default"><i class="fa fa-plus"></i> 新增</a>&nbsp;&nbsp;&nbsp;
                                <button type="button" class="btn btn-sm btn-default" onclick="App.deleteMulti('/user/delete')"><i class="fa fa-trash-o"></i> 删除</button>&nbsp;&nbsp;&nbsp;
                                <a href="#" type="button" class="btn btn-sm btn-default"><i class="fa fa-download"></i> 导入</a>&nbsp;&nbsp;&nbsp;
                                <a href="#" type="button" class="btn btn-sm btn-default"><i class="fa fa-upload"></i> 导出</a>&nbsp;&nbsp;&nbsp;

                                <%--用class选择器选中属性，找到它的css样式中的display 如果为none则就让其显示，如果不为none就消失（点击之前默认none 所以点击就会显示）--%>
                                <button type="button" class="btn btn-sm btn-primary" onclick="$('.box-info-search').css('display') == 'none'?$('.box-info-search').show('fast'):$('.box-info-search').hide('fast')"><i class="fa fa-search"></i> 搜索</button>
                            </div>
                                <div class="box-body table-responsive ">
                                    <table id="dataTable" class="table table-hover">
                                        <thead>
                                        <tr>
                                            <th><input type="checkbox" class="minimal icheck_master"/></th>
                                            <th>ID</th>
                                            <th>用户名</th>
                                            <th>电话号码</th>
                                            <th>邮箱</th>
                                            <th>注册时间</th>
                                            <th>更新时间</th>
                                            <th>操作</th>
                                        </tr>
                                        </thead>
                                    </table>
                            </div>
                        </div>
                    </div>
        </section>
    </div>
    <!-- /.content-wrapper 底部版权信息-->

    <jsp:include page="../include/copyrigth.jsp" />


</div>
<jsp:include page="../include/footer.jsp" />

<!-- 自定义模态框 -->
<sys:modal/>

<script>
    var _dataTable;

    /*封装在app.js中的DataTables中需要传入两个数据 url和columns两个。*/
    $(function () {
        var _columns = [
                {
                    "data": function (row, type, val, meta) {
                        return '<input id="'+row.id+'" type="checkbox" class="minimal"/>';
                    }
                },
                {"data":"id"},
                {"data":"username"},
                {"data":"phone"},
                {"data":"email"},
                {
                    "data":
                        function (row, type, val, meta) {
                            return DateTime.format(row.created,"yyyy-MM-dd HH:mm:ss")

                        }
                },
                {
                    "data":
                        function (row, type, val, meta) {
                            return DateTime.format(row.updated,"yyyy-MM-dd HH:mm:ss")

                        }
                },

                {
                    "data": function (row, type, val, meta) {
                        var detailUrl = "/user/detail?id=" + row.id;
                        var deleteUrl = "/user/delete";
                        return ' <button type="button" class="btn btn-sm btn-default" onclick="App.showDetail(\''+detailUrl+'\');"><i class="fa fa-search"></i> 查看</button>&nbsp;&nbsp;&nbsp;' +
                            '<a href="/user/form?id='+row.id+'" type="button" class="btn btn-sm btn-primary"><i class="fa fa-edit"></i> 编辑</a>&nbsp;&nbsp;&nbsp;' +
                            '<button type="button" class="btn btn-sm btn-danger" onclick="App.deleteSingle(\''+deleteUrl+'\',\''+row.id+'\');"><i class="fa fa-trash"></i> 删除</button>'
                    }
                }


            ];
        _dataTable = App.initDataTables("/user/page",_columns)


    });

    //高级搜索
    function search() {
        var username = $("#username").val();
        var phone = $("#phone").val();
        var email = $("#email").val();

        var param = {
            "username": username,
            "phone": phone,
            "email": email
        };

        _dataTable.settings()[0].ajax.data = param;
        _dataTable.ajax.reload();
    }
</script>

</body>
</html>
