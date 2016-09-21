<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layouts/basic.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
    <title></title>
    <script type="text/javascript" src="${ctx}/Js/jquery.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $('#button1').click(function () {
//                alert("Text: " + $("#classId").val());//是val() 不是value()
                alert("attr："+ $("#button1").attr("href"));//符号是否正确
            });
        })
    </script>
</head>
<body>
<%--    <input type="hidden" id="classId" value="1"/>
    <button id="button1" href="aa.htm">删除</button>--%>

    <%--button和href区别:发送链接(button有click函数,a有href) --%>
    <button href="a.htm">提交</button> <%--因没有click函数，所以不发送链接-%>
    <a href="a.htm">提交</a> <%--发送链接--%>
</body>
</body>
</html>
