<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0019)http://www.dfmcsoft.com/ -->

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
<META http-equiv=Content-Type content="text/html; charset=GBK"/>
<link rel="stylesheet" type="text/css" href="css/public.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/public.js"></script>
<script type="text/javascript">
$(document).ready(function() { 
	$("img.headLogo").hide(); 
	var $source = $("img.headLogo").attr("src"); 
	$('#headL').css({ 
	'backgroundImage': 'url(' + $source +')', 
	'backgroundRepeat': 'no-repeat', 
	'backgroundPosition': 'top center' 
	}); 
	}); 
function exit(){
	window.open('out', '_top');
}
</script>
</head>
<body>
<%-- <%-- <div class="top">
<div style="height:160px;width: 100%;margin-left:0;background-image:url(<%=basePath %>resources/img/top.png) ;z-index: 100;float:left;">
<div style="height:14px;"></div>
<div class="admin_logo "  style="z-index: 1;"></div>
<div class="logo_title1">
<span class="logo_title_sp" >欢迎登陆，你好</span>
<span class="logo_title_col" ><%=request.getSession().getAttribute("name")%></span>
<div class="top-menu1">
<div id="nav" style="width:600px; height:25px;list-style:none; float: left; margin-right: 440px;margin-top: 20px;color: #000000;">
</div>
<div class="clear"></div> 
</div>
</div>
</div>
</div> --%>
				<!-- 头部 -->
	<div class="head" style="background-image:url(<%=basePath %>resources/img/top.png);">
		
		<div class="headR">
			<p class="p1">
				欢迎，${lu.username}
			</p>
			<p class="p2">
				<a href="#" class="resetPWD">重置密码</a>&nbsp;&nbsp;<a
					href="javascript:exit()" class="goOut">退出</a>
			</p>
		</div>
	</div>

	<div class="closeOut">
		<div class="coDiv">
			<p class="p1">
				<span>X</span>
			</p>
			<p class="p2">确定退出当前用户？</p>
			<P class="p3">
				<a class="ok yes" href="#">确定</a><a class="ok no" href="#">取消</a>
			</p>
		</div>
	</div>
</body>
<script type="text/javascript">
// 广告弹出框
/* $(".goOut").click(function(){
    $(".closeOut").show();
  });
  $(".p1").click(function(){
    $(".closeOut").hide();
  });
  $(".no").click(function(){
    $(".closeOut").hide();
  }); */
// 广告弹出框 end

function del(){
    var input=document.getElementsByName("check[]");
    for(var i=input.length-1; i>=0;i--){
       if(input[i].checked==true){
           //获取td节点
           var td=input[i].parentNode;
          //获取tr节点
          var tr=td.parentNode;
          //获取table
          var table=tr.parentNode;
          //移除子节点
          table.removeChild(tr);
        }
    }     
}
</script>
</html>
