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
<title>图文管理系统</title>
 <script type="text/javascript">
 
 
 </script>
</head>
<frameset cols="*" frameborder="no" border="0" framespacing="0">
<frameset  rows="160px,*" framespacing = "0" frameborder="no" colspadding="0px" rowspandding="0px">
<frame name="top" src="top.jsp" noresize="noresize" scrolling="no" frameborder="no" />
<frameset cols="220px,*" framespacing = "0"  scrolling="no" frameborder="no"  >
<frame name="frame1" style="background:#252525" src="left.jsp" noresize="noresize" framespacing = "0"  frameborder="no" />
<frame id="frame2" name="frame2" src="rmain" frameborder="no"  />
</frameset>
</frameset> 
</frameset>
<noframes></noframes>

</html>