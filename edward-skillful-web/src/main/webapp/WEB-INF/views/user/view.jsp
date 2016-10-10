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
</head>
<body>
<input type="hidden" id="class" data-list="${ctx}/user/list.htm"/>
<form action="${ctx}/user/save.htm" method="post" class="definewidth m20" enctype="multipart/form-data" id="form1">
    <table class="table table-bordered table-hover m10" style="margin-left:10px;margin-top:3px;">
        <tr>
            <td class="tableleft">用户名</td>
            <td><span>${user.userName}</span></td>
        </tr>
        <tr>
            <td class="tableleft">密码</td>
            <td><span>${user.password}</span></td>
        </tr>
        <tr>
            <td class="tableleft">角色名称</td>
            <td><span>${user.roleName}</span></td>
        </tr>
        <tr>
            <td class="tableleft">是否使用</td>
            <td><span>
                    <c:choose>
                        <c:when test="${user.enable == 1}">可以使用</c:when>
                        <c:otherwise>不可以使用</c:otherwise>
                    </c:choose>
            </span></td>
        </tr>
        <tr>
            <td class="tableleft">创建时间</td>
            <td><span><fmt:formatDate value="${user.createTime}" pattern="yyyy-MM-dd"/> </span></td>
        </tr>
        <tr>
            <td class="tableleft"></td>
            <td>
                <a href="${ctx}/user/list.htm">返回</a>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
