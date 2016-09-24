<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layouts/basic.jsp" %>
<!DOCTYPE html>
<html>
<head>
    测试cookie和session
</head>
<body>
    <a href="${ctx}/test/cookieSession/addCookie.htm">添加cookie</a>
    <a href="${ctx}/test/cookieSession/getCookie.htm">获取cookie</a>
    <a href="${ctx}/test/cookieSession/addSession.htm">添加Session</a>
    <a href="${ctx}/test/cookieSession/getSession.htm">获取Session</a>
</body>
</body>
</html>
