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
                   dataType:"json",
                   data:$("#form1").serialize(),/* 要提交的表单,必须使用name属性*/
                   async:false,
                   success:function (data) {
                       if(data.status==0){
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
<input type="hidden" id="class" data-list="${ctx}/user/list.htm"/>
<form action="${ctx}/user/save.htm" method="post" class="definewidth m20" enctype="multipart/form-data" id="form1">
    <table class="table table-bordered table-hover m10" style="margin-left:10px;margin-top:3px;">
        <tr>
            <input type="hidden" name="userId" value="${user.userId}" />
            <td class="tableleft">用户名</td>
            <td><input type="text" name="userName" value="${user.userName}"/></td>
        </tr>
        <tr>
            <td class="tableleft">密码</td>
            <td><input type="text" name="password" value="${user.password}"/></td>
        </tr>
        <tr>
            <td class="tableleft">角色名称</td>
            <td>
                <select name="roleId">
                    <c:forEach items="${roles}" var="item">
                        <option value="${item.recordId}" <c:if test="${item.recordId==user.roleId}">selected="selected"</c:if> >${item.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>        
        <tr>
            <td class="tableleft">是否使用</td>
            <td>
                <input type="radio" name="enable" checked="checked" value="1"/>可以使用
                <input type="radio" name="enable"  value="-1" <c:if test="${user.enable == -1}">checked="checked"</c:if> />不可以使用
            </td>
        </tr>
        <tr>
            <td class="tableleft"></td>
            <td>
                <button style="margin-left:5px;" class="btn btn-primary" type="button" id="button1">保存</button> &nbsp;&nbsp;
                <a href="${ctx}/user/list.htm">返回</a>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
