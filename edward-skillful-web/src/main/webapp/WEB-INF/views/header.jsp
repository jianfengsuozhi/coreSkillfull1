<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layouts/basic.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${ctx }/css/public.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${ctx }/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx }/js/global.js"></script>
<script type="text/javascript" src="${ctx }/js/jquery.autoTextarea.js"></script>
 <script type="text/javascript" src="${ctx }/js/jquery.tab.js"></script>
<link rel="stylesheet" href="${ctx }/js/kindeditor/themes/default/default.css" />
<link rel="stylesheet" href="${ctx }/js/kindeditor/plugins/code/prettify.css" />
<title>ITFARM 后台管理</title>
</head>
<body>
<div id="dcHead">
 <div id="head">
  <div class="logo"><a href="index.html"><img src="${ctx }/images/dclogo.gif" alt="logo"></a></div>
  <div class="nav">
   <ul>
    <li class="M"><a href="JavaScript:void(0);" class="topAdd">新建</a>
     <div class="drop mTopad"><a href="product.php?rec=add">商品</a> <a href="article.php?rec=add">文章</a> <a href="nav.php?rec=add">自定义导航</a> <a href="show.html">首页幻灯</a> <a href="page.php?rec=add">单页面</a> <a href="manager.php?rec=add">管理员</a> <a href="link.html"></a> </div>
    </li>
    <li><a href="${systemConfig.webUrl}" target="_blank">查看站点</a></li>
    <li><a href="http://www.mycodes.net" target="_blank">帮助</a></li>
    <li class="noRight"><a href="${systemConfig.webUrl}">ITFARM</a></li>
   </ul>
   <ul class="navRight">
    <li class="M noLeft"><a href="JavaScript:void(0);">您好，${user.nickname }</a>
     <div class="drop mUser">
      <a href="manager.php?rec=edit&id=1">编辑我的个人资料</a>
      <a href="manager.php?rec=cloud_account">设置云账户</a>
     </div>
    </li>
    <li class="noRight"><a href="${ctx}/loginOut.do">退出</a></li>
   </ul>
  </div>
 </div>
</div>
<!-- dcHead 结束 --> <div id="dcLeft"><div id="menu">
 <ul class="top">
  <li><a href="${ctx}/admin/index.do"><i class="home"></i><em>管理首页</em></a></li>
 </ul>
 <ul>
  <li><a href="${ctx }/system/index.do"><i class="system"></i><em>系统设置</em></a></li>
  <li><a href="${ctx }/menu/list.do"><i class="nav"></i><em>自定义菜单栏</em></a></li>
  <li><a href="show.html"><i class="show"></i><em>首页幻灯广告</em></a></li>
 </ul>
  <ul>
  <li><a href="${ctx }/category/list.do"><i class="articleCat"></i><em>文章分类</em></a></li>
   <li><a href="${ctx }/article/articleList.do"><i class="article"></i><em>文章列表</em></a></li>
 </ul>
   <ul class="bot">
  <li><a href="${ctx }/admin/user/index.do"><i class="backup"></i><em>用户权限管理</em></a></li>
  <li><a href="${ctx }/log/list.do"><i class="managerLog"></i><em>操作记录</em></a></li>
 </ul>
</div></div>
</body>
</html>