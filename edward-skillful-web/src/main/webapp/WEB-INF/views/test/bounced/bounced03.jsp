<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layouts/basic.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <script type="text/javascript" src="${ctx}/Js/jquery2.js"></script>
    <style type="text/css">
        body {
            font-family: Arial, Helvetica, sans-serif;
            font-size: 12px;
            margin: 0;
        }
        #main {
            height: 1800px;
            padding-top: 90px;
            text-align: center;
        }
        #fullbg {
            background-color: Gray;
            left: 0px;
            opacity: 0.5;
            position: absolute;
            top: 0px;
            z-index: 3;
            filter: alpha(opacity=50); /* IE6 */
            -moz-opacity: 0.5; /* Mozilla */
            -khtml-opacity: 0.5; /* Safari */
        }
        #dialog {
            background-color: #FFF;
            border: 1px solid #888;
            display: none;
            height: 200px;
            left: 50%;
            margin: -100px 0 0 -100px;
            padding: 12px;
            position: fixed !important; /* 浮动对话框 */
            position: absolute;
            top: 50%;
            width: 200px;
            z-index: 5;
        }
        #dialog p {
            margin: 0 0 12px;
        }
        #dialog p.close {
            text-align: right;
        }
    </style>
    <script type="text/javascript">
        //显示灰色 jQuery 遮罩层
        function showBg() {
            var bh = $("body").height();
            var bw = $("body").width();
            $("#fullbg").css({
                height: bh,
                width: bw,
                display: "block"
            });
            $("#dialog").show();
        }
        //关闭灰色 jQuery 遮罩
        function closeBg() {
            $("#fullbg,#dialog").hide();
        }
    </script>


</head>
<body>
    <%--弹出框:一个页面div:覆盖 显示和隐藏--%>
    <div id="main">
        <a href="#" onclick="showBg();">点击这里看 jQuery 遮罩层效果.</a>
        <input type="text" value="完美世界"/>
    </div>
    <!-- jQuery 遮罩层 -->
    <div id="fullbg"></div>
    <!-- end jQuery 遮罩层 -->
    <!-- 对话框 -->
    <div id="dialog">
        <p class="close"><a href="#" onclick="closeBg();">关闭</a></p>
        <p>正在加载，请稍后...</p>
    </div>
    <!-- jQuery 遮罩层上方的对话框 -->
</body>
</html>
