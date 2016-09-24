<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.io.PrintWriter,java.lang.Exception" %>
<%@ include file="/WEB-INF/layouts/basic.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><title>Exception!</title></head>
<body>
<% Exception ex = (Exception)request.getAttribute("ex"); %>
<H2>Exception: <%= ex.getMessage()%></H2><%--Exception: 其他异常--%>
<P/>
<% ex.printStackTrace(new java.io.PrintWriter(out)); %>
</body>
</html>

