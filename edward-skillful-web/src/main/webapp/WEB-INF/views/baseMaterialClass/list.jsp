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
                    contentType : "application/json",
                    url:$("#delete").attr("href"),
                    dataType:"json",
                    data:{classId:$("#classId").val()},
                    success:function(data){
                        if(data.status==0){
                           /* $.ajax({ 实现跳转功能
                                type:"get",
                                contentType : "application/json",
                                url:$("#list").attr("href"),
                                dataType:"json"

                            });*/
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
<form class="form-inline definewidth m20" action="${ctx}/baseMaterialClass/list.htm" method="get" id="list">
    <font color="#777777"><strong>视频名称：</strong></font>
    <input type="text" name="menuname" id="menuname"class="abc input-default" placeholder="" value="">&nbsp;&nbsp;
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp;
    <%--<button type="button"  id="addnew"><a href="${ctx}/add.htm">添加视频</a></button>--%>
    <a href="${ctx}/baseMaterialClass/toAdd.htm">添加视频</a>
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>序号</th>
        <th>分类名称</th>
        <th>分类编码</th>
        <th>创建时间</th>
        <th>操作</th>
    </tr>
    </thead>
    <c:forEach items="${pageList}" var="item">
        <tr>
            <td> <input type="hidden" value="${item.classId}" id="classId"/></td>
            <td>${item.orderNo}</td>
            <td>${item.className}</td>
            <td>${item.classCode}</td>
             <%--时间 时间格式转化:一种实现方式--%>
            <td><fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd"/></td>
            <%--带有 placeholder 文本的搜索字段 <input type="search" name="user_search" placeholder="Search W3School" />--%>
            <td><button href="${ctx}/baseMaterialClass/delete.htm" id="delete">删除</button></td>
        </tr>

    </c:forEach>

</table>
    <skillful:PageBar pageUrl="/baseMaterialClass/list.htm" pageAttrKey="page"/>

</body>
</html>
