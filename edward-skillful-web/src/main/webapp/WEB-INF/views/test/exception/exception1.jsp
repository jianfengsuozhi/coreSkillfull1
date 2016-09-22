<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layouts/basic.jsp" %>
<!DOCTYPE html>
<html>
<head>
   测试异常
</head>
<body>
    <h1>所有的演示例子</h1>
    <a href="${ctx}/test/exception/1">不合法参数</a>
    <a href="${ctx}/test/exception/2">业务异常</a>
    <a href="${ctx}/test/exception/3">其他异常</a>
    <a href="${ctx}/test/exception/4">未知异常</a>
</body>
</body>
</html>
