<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layouts/basic.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${ctx}/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/Css/style.css" />
    <script type="text/javascript" src="${ctx}/Js/jquery2.js"></script>
    <script type="text/javascript" src="${ctx}/Js/jquery2.sorted.js"></script>
    <script type="text/javascript" src="${ctx}/Js/bootstrap.js"></script>
    <script type="text/javascript" src="${ctx}/Js/ckform.js"></script>
    <script type="text/javascript" src="${ctx}/Js/common.js"></script>
    <script type="text/javascript" src="${ctx}/Js/jquerypicture.js"></script>

    <style type="text/css">
        body {font-size: 20px;
            padding-bottom: 40px;
            background-color:#e9e7ef;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }

    </style>

    <script type="text/javascript" src="${ctx}/Js/jquery.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            $('#button1').click(function(){
               $.ajax({
                   cache:true,
                   type:"POST",
                   url:$("#form1").attr("action"),
                   dataType:"json",//使返回数据是json,从而可以data.status fixfox出现html
                   data:$("#form1").serialize(),/* 要提交的表单,必须使用name属性*/
                   async:false,
                   success:function (data) {
                       if(data.status==0){
                           //{"status":0,"msg":"操作成功"} 获取值
                           window.location.href = $("#class").attr("data-list"); //刷新并加载url
                       }else{
                           alert(data.msg);
                       }
                   }
               });

            });

        });
    </script>
</head>
<body>
<input type="hidden" id="class" data-list="${ctx}/privilege/list.htm"/>
<form action="${ctx}/privilege/save.htm" method="post" class="definewidth m20" enctype="multipart/form-data" id="form1">
    <table class="table table-bordered table-hover m10" style="margin-left:10px;margin-top:3px;">
        <tr>
            <input type="hidden" name="classId" value="${privilege.classId}" />
            <td class="tableleft">序号</td>
            <td><input type="text" name="orderNo" value="${privilege.orderNo}"/></td>
        </tr>
        <tr>
            <td class="tableleft">类别名称</td>
            <td><input type="text" name="className" value="${privilege.className}"/></td>
        <tr>
            <td class="tableleft">类别编码</td>
            <td><input type="text" name="classCode" value="${privilege.classCode}"/></td>
        </tr>
        <tr>
            <td class="tableleft"></td>
            <td>
                <button style="margin-left:5px;" class="btn btn-primary" type="button" id="button1">保存</button> &nbsp;&nbsp;
                <a href="${ctx}/privilege/list.htm">返回</a>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
