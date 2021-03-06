<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layouts/basic.jsp" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CSS3动态背景登录框代码</title>

    <link rel="stylesheet" type="text/css" href="${ctx}/Css/styles.css">

</head>
<body>
<div class="wrapper">
    <div style="color: red">${error}</div>
    <div style="color: green">${logout}</div>

    <div class="container">
        <h1>MOOC 后台管理</h1>
        <form class="form" method="post" action="${ctx}/j_spring_security_check">
            <input type="text"  name="username">
            <input type="password"  name="password"><br>
            <button type="submit" id="login-button"><strong>登陆</strong></button>
        </form>
    </div>

    <ul class="bg-bubbles">
        <li></li>
        <li></li>
    </ul>

</div>
</body>
</html>
