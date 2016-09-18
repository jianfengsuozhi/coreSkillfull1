<%@ tag import="com.tc.itfarm.api.util.StringLengthUtil" %>
<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" import="java.util.Map,java.util.TreeMap"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="strValue" required="true" rtexprvalue="true"
  description="需要删减的内容"%>
<%@ attribute name="length" required="true" rtexprvalue="true"
  description="删减后的长度"%>
<%
	String strCut = StringLengthUtil.cutStr(strValue, Integer.parseInt(length));
	request.setAttribute("strCut", strCut);
%>
${strCut}