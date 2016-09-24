<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layouts/basic.jsp" %>
<!DOCTYPE html>
<html>
<head>
    测试数据绑定
</head>
<body>
    <a href="${ctx}/test/data/nameP.htm?name='魏德亮'">name参数</a>
    <a href="${ctx}/test/data/test1.htm?id=123&name='魏德亮'">user参数</a>
</body>
</body>
</html>
