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
    <a href="${ctx}/test/exception/1.htm">不合法参数</a>
    <a href="${ctx}/test/exception/2.htm">业务异常</a>
    <a href="${ctx}/test/exception/3.htm">其他异常</a>
    <a href="${ctx}/test/exception/4.htm">未知异常</a>
</body>
</body>
</html>
