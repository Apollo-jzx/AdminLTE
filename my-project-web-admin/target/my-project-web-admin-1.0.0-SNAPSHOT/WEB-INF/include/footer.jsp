<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/10/27
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--所有页面共有的模态框--%>
<div class="modal fade" id="modal-detail">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">查看详情</h4>
            </div>
            <div class="modal-body">
                <p id="modal-detail-body"></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">确定</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>

<!-- jQuery 3 -->
<script src="/static/assets/bower_components/jquery/dist/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="/static/assets/bower_components/jquery-ui/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<!-- Bootstrap 3.3.7 -->
<script src="/static/assets/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- Slimscroll -->
<script src="/static/assets/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="/static/assets/bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="/static/assets/js/adminlte.min.js"></script>
<%--jQuery.validate前端表单的验证--%>
<script src="/static/assets/plugins/jquery-validation/js/jquery.validate.min.js" ></script>
<%--添加自定义验证规则--%>
<script src="/static/assets/plugins/jquery-validation/js/additional-methods.min.js" ></script>
<%--引入中文 国际化--%>
<script src="/static/assets/plugins/jquery-validation/js/localization/messages_zh.min.js" ></script>

<%--app jQuery Vaildate表单验证的js--%>
<script src="/static/assets/app/validate.js" ></script>
<%--iCheck for checkbox--%>
<script src="/static/assets/plugins/iCheck/icheck.min.js" ></script>
<%--iCheck for checkbox app.js--%>
<script src="/static/assets/app/app.js" ></script>

<!-- DataTables -->
<script src="/static/assets/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="/static/assets/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>

<%--日期工具类--%>
<script src="/static/assets/app/datetime.js"></script>