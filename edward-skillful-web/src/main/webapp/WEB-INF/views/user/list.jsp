<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layouts/basic.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
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

    <style type="text/css">
        body {font-size: 20px;
            font-size: 20px;
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
            $('#delete').click(function(){
                $.ajax({
                    type:"get",
                    contentType : "application/json", //发送给服务器的内容编码方式 firefox出现json
                    url:$("#delete").attr("href"),
                    dataType:"json", //fixfox出现html
                    data:{userId:$("#userId").val()},
                    success:function(data){
                        if(data.status==0){
                           refreshCurrentPage();
                        }else{
                            alert(data.msg);
                        }
                    }
                });
            });
            //刷新当前页面
            function refreshCurrentPage()
            {
                window.location.reload();
            }
        });
    </script>
</head>
<body >
<form class="form-inline definewidth m20" action="${ctx}/user/list.htm" method="get" id="list">
    <sec:authorize access="hasRole('7')">
        <a href="${ctx}/user/toSave.htm">添加</a>
    </sec:authorize>
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>用户名</th>
        <th>密码</th>
        <th>角色名称</th>
        <th>是否使用</th>
        <th>创建时间</th>
        <th>操作</th>
    </tr>
    </thead>
    <c:forEach items="${list}" var="item">
        <tr>
            <td>
                <input type="hidden" value="${item.userId}" id="userId"/>
                ${item.userName}
            </td>
            <td>${item.password}</td>
            <td>${item.roleName}</td>
            <td>
                <c:choose>
                    <c:when test="${item.enable == 1}">可以使用</c:when>
                    <c:otherwise>不可以使用</c:otherwise>
                </c:choose>
            </td>
            <td><fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd"/></td>
            <td>
                <sec:authorize access="hasRole('9')">
                    <button href="${ctx}/user/delete.htm" id="delete">删除</button>
                </sec:authorize>
                <sec:authorize access="hasRole('8')">
                    <a href="${ctx}/user/toSave.htm?userId=${item.userId}">修改</a>
                </sec:authorize>

                <a href="${ctx}/user/view.htm?userId=${item.userId}">查看</a>
            </td>
        </tr>

    </c:forEach>

</table>
    <skillful:PageBar pageUrl="/user/list.htm" pageAttrKey="page"/>
</body>
</html>
