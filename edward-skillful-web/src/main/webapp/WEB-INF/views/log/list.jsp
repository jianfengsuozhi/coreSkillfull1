<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/layouts/basic.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
<div id="dcWrap">
    <jsp:include page="../header.jsp"></jsp:include>
    <div id="dcMain">
        <!-- 当前位置 -->
        <div id="urHere">ITFARM 管理中心<b>></b><strong>操作记录</strong> </div>   <div id="manager" class="mainBox" style="height:auto!important;height:550px;min-height:550px;">
        <h3>操作记录</h3>
        <div class="filter">
            <form action="${ctx }/log/list.do" method="get">
                <select name="type">
                    <option value="">全部</option>
                    <option value="1" <c:if test="${type == 1}">selected="selected"</c:if>>系统登陆</option>
                    <option value="2" <c:if test="${type == 2}">selected="selected"</c:if>>新增</option>
                    <option value="3" <c:if test="${type == 3}">selected="selected"</c:if>>修改</option>
                    <option value="4" <c:if test="${type == 4}">selected="selected"</c:if>>删除</option>
                </select>
                <input name="submit" class="btnGray" type="submit" value="查询"/>
            </form>
        </div>
        <table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">
            <tr>
                <th width="50" align="center">编号</th>
                <th align="left">变更前内容</th>
                <th align="left">变更后内容</th>
                <th width="100" align="center">操作类型</th>
                <th width="100" align="center">操作者</th>
                <th width="150" align="left">操作时间</th>
            </tr>
            <c:forEach items="${list}" var="log" varStatus="vs">
            <tr>
                <td align="center">${vs.count}</td>
                <td align="left">${log.oldContent}</td>
                <td align="left">${log.newContent}</td>
                <td align="center">${log.type}</td>
                <td align="center">${log.username}</td>
                <td><fmt:formatDate value="${log.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            </tr>
            </c:forEach>
        </table>
        <itfarm:PageBar pageUrl="/log/list.do?type=${type }"
                        pageAttrKey="page"></itfarm:PageBar>
    </div>
    <div class="clear"></div>
    <jsp:include page="../footer.jsp"></jsp:include>
    <div class="clear"></div>
</div>
</body>
</html>
