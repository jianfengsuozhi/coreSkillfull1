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
</head>
<body>
<input type="hidden" id="class" data-list="${ctx}/baseMaterialClass/list.htm"/>
<form action="${ctx}/baseMaterial/save.htm" method="post" class="definewidth m20" enctype="multipart/form-data" id="form1">
    <table class="table table-bordered table-hover m10" style="margin-left:10px;margin-top:3px;">
        <tr>
            <td class="tableleft">序号</td>
            <td><span>${baseMaterial.orderNo}</span></td>
        </tr>
        <tr>
            <td class="tableleft">物资编码</td>
            <td><span>${baseMaterial.materialCode}</span></td>
        </tr>
        <tr>
            <td class="tableleft">物资名称</td>
            <td><span>${baseMaterial.materialName}</span></td>
        </tr>
        <tr>
            <td class="tableleft">物资规格</td>
            <td><span>${baseMaterial.materialSpec}</span></td>
        </tr>
        <tr>
            <td class="tableleft">助记码</td>
            <td><span>${baseMaterial.mnemonicCode}</span></td>
        </tr>
        <tr>
            <td class="tableleft">物资单位</td>
            <td><span>${baseMaterial.materialUnit}</span></td>
        </tr>
        <tr>
            <td class="tableleft">物资分类名称</td>
            <td><span>${baseMaterial.className}</span></td>
        </tr>
        <tr>
            <td class="tableleft">状态</td>
            <td><span>${baseMaterial.status}</span></td>
        </tr>
        <tr>
            <td class="tableleft">创建时间</td>
            <td><span><fmt:formatDate value="${baseMaterial.createTime}" pattern="yyyy-MM-dd"/></span></td>
        </tr>
        <tr>
            <td class="tableleft">修改时间</td>
            <td><span><fmt:formatDate value="${baseMaterial.modifyTime}" pattern="yyyy-MM-dd"/></span></td>
        </tr>
        <tr>
            <td class="tableleft"></td>
            <td>
                <a href="${ctx}/baseMaterial/list.htm">返回</a>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
