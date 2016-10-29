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
        /**
         * get/post区别：post更安全,get效率更高
         * 应用:
         *   参数: get http://localhost:8089/edward-skillful-web/test/ajax/ajax21.htm?name=%E9%AD%8F%E5%BE%B7%E4%BA%AE 放在url后面
         *         post http://localhost:8089/edward-skillful-web/test/ajax/ajax22.htm 其他地方
         *    实践: get(查询,删除),post(增，修改)
         *       限制 前提form提交 <input type="hidden" name="_method" value="set"/>
         *  {"status":0,"msg":"操作成功","data":{"id":"1234","name":null,"date":1474373891990}}
         *  加 {"status":0,"msg":"操作成功","data":{"id":1234,"name":null,"date":"2016-09-20 20:21:05"}}
         */
        $(document).ready(function(){
            $('#button1').click(function(){
                $.ajax({
                    type:"get",
                    contentType : "application/json",
                    url:"${ctx}/test/ajax/ajax21.htm",
                    dataType:"json",
                    data:{name:"魏德亮"}, //传参 {}
                    success:function(data){ //data 返回的对象如data==user对象 data.name==user.name
                        alert(data.msg); //{"status":0,"msg":"操作成功","data":{"name":"魏德亮"}}
                    },
                    error:function (error) { //异常
                        alert("错误");
                    }

                });
            });
            $('#button2').click(function(){
                $.ajax({
                    type:"post",
                    contentType : "application/json",
                    url:"${ctx}/test/ajax/ajax22.htm",
                    dataType:"json",
                    data:{name:"魏德亮"}, //传参 {}
                    success:function(data){ //data 返回的对象如data==user对象 data.name==user.name
                        alert(data.data.name); //{"status":0,"msg":"操作成功","data":{"name":"魏德亮"}}
                    },
                    error:function (error) {

                    }

                });
            });
            /**
             * 目的：带格式的时间
             * 原始: Date类型 Date Tue Sep 20 19:41:05 CST 2016 响应 {"name":null,"date":1474371665167(lomg类型时间戳)}
             *  加                                              响应 {"name":null,"date":"2016-09-20 19:50:15"}
             *
             * Long 原始 1234l              响应 {"id":1234,"name":null,"date":1474373592467}
             *  加                          响应 {"id":"1234","name":null,"date":1474373687850}
             */
            $('#button3').click(function(){
                $.ajax({
                    type:"get",
                    contentType : "application/json",
                    url:"${ctx}/test/ajax/ajax23.htm",
                    dataType:"json",
                    success:function(data){
                        alert("成功");
                    }
                });
            });
        });
    </script>
</head>
<body>
    <%--<button id="button1">点击get ajax事件</button>--%>
    <%--<button id="button2">post ajax事件</button>--%>
    <%--<button id="button3">点击get ajax事件</button>--%>
</body>
</body>
</html>
