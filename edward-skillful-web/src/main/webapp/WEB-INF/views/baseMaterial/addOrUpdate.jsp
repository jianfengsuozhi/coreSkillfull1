<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layouts/basic.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${ctx}/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/Css/style.css" />
    <script type="text/javascript" src="${ctx}/Js/jquery2.js"></script>
    <script type="text/javascript" src="${ctx}/Js/jquery2.sorted.js"></script>
    <script type="text/javascript" src="${ctx}/Js/bootstrap.js"></script>
    <script type="text/javascript" src="${ctx}/Js/ckform.js"></script>
    <script type="text/javascript" src="${ctx}/Js/common.js"></script>
    <script type="text/javascript" src="${ctx}/Js/jquerypicture.js"></script>

    <style type="text/css">
        body {font-size: 20px;
            padding-bottom: 40px;
            background-color:#e9e7ef;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }

    </style>

    <script type="text/javascript" src="${ctx}/Js/jquery.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            $('#button1').click(function(){
               $.ajax({
                   cache:true,
                   type:"POST",
                   url:$("#form1").attr("action"),
                   dataType:"json",
                   data:$("#form1").serialize(),
                   async:false,
                   success:function (data) {
                       if(data.status==0){
                           window.location.href = $("#class").attr("data-list");
                       }else{
                           alert(data.msg);
                       }
                   }
               });

            });

        });
    </script>
</head>
<body>
<input type="hidden" id="class" data-list="${ctx}/baseMaterial/list.htm"/>
<form action="${ctx}/baseMaterial/save.htm" method="post" class="definewidth m20" enctype="multipart/form-data" id="form1">
    <table class="table table-bordered table-hover m10" style="margin-left:10px;margin-top:3px;">
        <tr>
            <input type="hidden" name="materialId" value="${baseMaterial.materialId}" />
            <td class="tableleft">序号</td>
            <td><input type="text" name="orderNo" value="${baseMaterial.orderNo}"/></td>
        </tr>
        <tr>
            <td class="tableleft">物资编码</td>
            <td><input type="text" name="materialCode" value="${baseMaterial.materialCode}"/></td>
        </tr>
        <tr>
            <td class="tableleft">物质名称</td>
            <td><input type="text" name="materialName" value="${baseMaterial.materialName}"/></td>
        </tr>
        <tr>
            <td class="tableleft">物资规格</td>
            <td><input type="text" name="materialSpec" value="${baseMaterial.materialSpec}"/></td>
        </tr>
        <tr>
            <td class="tableleft">助记码</td>
            <td><input type="text" name="mnemonicCode" value="${baseMaterial.mnemonicCode}"/></td>
        </tr>
        <tr>
            <td class="tableleft">物资单位</td>
            <td><input type="text" name="materialUnit" value="${baseMaterial.materialUnit}"/></td>
        <tr>
            <td class="tableleft">物资分类名称</td>
            <td>
                <select name="classCode">
                    <option value="" selected="selected">全部</option>
                    <c:forEach var="item" items="${materialClasses}">
                        <option value="${item.code}" <c:if test="${baseMaterial.classCode == item.code}">selected="selected"</c:if> >${item.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td class="tableleft"></td>
            <td>
                <button style="margin-left:5px;" class="btn btn-primary" type="button" id="button1">保存</button> &nbsp;&nbsp;
                <a href="${ctx}/baseMaterial/list.htm">返回</a>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
