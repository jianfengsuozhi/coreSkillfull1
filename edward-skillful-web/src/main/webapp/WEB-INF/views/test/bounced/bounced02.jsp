<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layouts/basic.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <script type="text/javascript">
        /*点击按钮常用的6中提示框和操作*/

    </script>
</head>
<body>
    <%--按钮提示框--%>
    <input type="button" id="btn1" onclick="return confirm('yes/no');" value="删除1"/>
    <input type="button" id="btn2" onclick="javaScript:alert('你确定要删除么?');" value="删除2"/>

    <%--点击后跳到响应的链接: 提交--%>
    <input type="button" value="提交" onclick="javaScript:window.location.href='http://www.baidu.com';"/>
    <%--刷新当前页--%>
    <input type="button" value="刷新当前页" onclick="javaScript:window.location.reload()">

    <%--返回 == 后退--%>
    <input type="button" value="返回" onclick="javascript:history.go(-1);"/>
</body>
</body>
</html>
