<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="itfarm" tagdir="/WEB-INF/tags" %>
<%@ page isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%-- 从Servlet名之后的路径  --%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<%-- 全路径(含schema，主机名，端口，Servlet名)
--%>
<%
//获取项目的路径 如：http://www.his.com:8080/tccloud_his_web/
{
  String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
    boolean _idx = basePath.endsWith("/");
    if(_idx){
      basePath = basePath.substring(0,basePath.length()-1);
    }
  request.setAttribute("basePath",basePath);
}
%>
<%--主机加端口--%>
<c:set var="host" value="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}/"/>
<%--basePath --%>
<c:set var="base" value="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}" />
<%--静态文件目录 --%>
<c:set var="path" value="${base}" />
<%--项目路径 --%>
<c:set var="staticPath" value="${base}" />
<html>
<head>
</head>
