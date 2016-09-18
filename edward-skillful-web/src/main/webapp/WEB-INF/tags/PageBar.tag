<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" import="java.util.Map,java.util.TreeMap"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="pageUrl" required="true" rtexprvalue="true"
  description="分页页面对应的URl"%>
<%@ attribute name="pageAttrKey" required="true" rtexprvalue="true"
  description="Page对象在Request域中的键名称"%>
<c:set var="pageUrl" value="${pageUrl}" />
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%
    String separator = pageUrl.indexOf("?") > -1 ? "&" : "?";
    if (pageUrl.indexOf("?") > -1) {
        Map<String, String> hiddens = new TreeMap<String, String>();
        //获取？后面的参数字符串
        String[] urlAndParmas = pageUrl.split("\\?", 2);
        String parmas = urlAndParmas[1];
        //按照&截取每个key-value
        String[] nameAndValue = parmas.split("&");
        for (String s : nameAndValue) {
            String[] keyAndValue = s.split("=", 2);
            if (keyAndValue.length == 2) {
                hiddens.put(keyAndValue[0], keyAndValue[1]);
            }
        }
        if (hiddens.size() > 0) {
            jspContext.setAttribute("pageHiddens", hiddens);
        }
    }
    jspContext.setAttribute("pageResult", request.getAttribute(pageAttrKey));
    jspContext.setAttribute("pageUrl", pageUrl);
    jspContext.setAttribute("separator", separator);
%>
<div class="pager">
  <div class="scott2">
    <form action="${ctx}${pageUrl}" method="get" style="display: inline-block">
      <c:if test="${!empty pageHiddens}">
        <c:forEach items="${pageHiddens}" var="item">
          <input name="${item.key}" type="hidden" value="${item.value}" />
        </c:forEach>
      </c:if>
      <c:if test="${pageResult.pageIndex>1}"><a href="<c:url value="${pageUrl}"/>${separator}pageNo=1">首页</a></c:if>
      <c:if test="${pageResult.pageIndex==1}"><span class="disabled">首页</span></c:if>
      <c:if test="${pageResult.hasPreviousPage}"><a href="<c:url value="${pageUrl}"/>${separator}pageNo=${pageResult.pageIndex -1 }">上一页</a></c:if>
      <c:if test="${!pageResult.hasPreviousPage}"><span class="disabled">上一页</span></c:if>
      <c:forEach var="index" begin="${pageResult.lower}"
        end="${pageResult.higher}" step="1">
        <c:choose>
          <c:when test="${pageResult.pageIndex==index}">
            <span class="current">${index}</span>
          </c:when>
          <c:otherwise>
            <c:choose>
              <c:when test="${index==1}">
                <a href="<c:url value="${pageUrl}"/>${separator}pageNo=${index}">1</a>
              </c:when>
              <c:otherwise>
                <a href="<c:url value="${pageUrl}"/>${separator}pageNo=${index}">${index}</a>
              </c:otherwise>
            </c:choose>
          </c:otherwise>
        </c:choose>
      </c:forEach>
      <c:if test="${pageResult.hasNextPage}"><a href="<c:url value="${pageUrl}"/>${separator}pageNo=${pageResult.pageIndex +1 }">下一页</a></c:if>
      <c:if test="${!pageResult.hasNextPage}"><span class="disabled">下一页</span></c:if>
      <c:if test="${pageResult.pageIndex<pageResult.totalPages}"><a href="<c:url value="${pageUrl}"/>${separator}pageNo=${pageResult.totalPages}">末页</a></c:if>
      <c:if test="${pageResult.pageIndex==pageResult.totalPages || pageResult.totalPages<2}"><span class="disabled">尾页</span></c:if>
      <span>共${pageResult.totalRecords}条</span>
      <span>跳到：</span><input name="pageNo" id="pageNo" type="text" class="pageInput" /><span>页</span>
      <input id="totalPages" type="hidden" value="${pageResult.totalPages}" />
      <input type="submit" value="GO" class="go" />
    </form>
  </div>
</div>
<script>
function bindTitleEvent(){

  var el = document.getElementById("pageNo");
  var totalPages = document.getElementById("totalPages").value;

  if (!el) return;
  el.onblur = function(){
    if (eval(el.value) > eval(totalPages)) {
      el.value = totalPages;
    }
  }
}
bindTitleEvent();
</script>