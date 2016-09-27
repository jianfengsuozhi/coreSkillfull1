<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layouts/basic.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <script type="text/javascript">
        /* javascript 消息框*/
        /*警告框*/
        function disp_alert() {
            alert("我是警告框！！");
        }
        /*带分行的警告框*/
        function disp_alertLine() {
            alert("带分行"+"\n"+"的警告框");
        }
        /*确认框*/
        function disp_confirm() {
            var r = confirm("你是魏德亮么？");
            if(r){
                alert("You press ok");
            }else {
                alert("You press cancel");
            }
        }
        /*提示框*/
        function disp_prompt() {
            var name = prompt("请输入你的名字","Tome");
            if(name != null && name != ""){
                document.write("你好！"+name+"过的怎么样？");
            }
        }

        /*浏览器的前进和后退按钮*/

    </script>
</head>
<body>
    <%--消息框--%>
    <input type="button" onclick="disp_alert()" value="警告框"/>
    <input type="button" onclick="disp_alertLine()" value="带分行警告框"/>
    <input type="button" onclick="disp_confirm()" value="确认框"/>
    <input type="button" onclick="disp_prompt()" value="提示框"/>

    <%--类似浏览器向前和向后功能--%>
    <input type="button" onclick="window.history.back();" value="向后"/>
    <input type="button" onclick="window.history.forward();" value="向前"/>

</body>
</body>
</html>
