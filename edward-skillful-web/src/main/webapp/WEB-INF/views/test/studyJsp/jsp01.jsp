<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layouts/basic.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="${ctx}/Js/jquery.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            $("#select").change(function(){
                $("#select1").append("<option >课程</option>");
            });
        });
    </script>
</head>
<body>
    <h1 id="h1"></h1>
    <select id="select">
        <option >课程</option>
        <option>奖学金</option>
        <option></option>
    </select>
    <select id="select1"></select>
</body>
</body>
</html>
