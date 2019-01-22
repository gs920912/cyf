<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%-- <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   --%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<META http-equiv=Content-Type content="text/html; charset=gb2312" />
<script type="text/javascript">
	var tag = false;
	function systemStart() {
		createCode();
		if ('${msg}' != "") {
			alert('${msg}');

		}
	}
	function createCode() {
		code = new Array();
		var codeLength = 4;//验证码的长度
		var checkCode = document.getElementById("checkCode");
		checkCode.value = "";
		var selectChar = new Array(2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C', 'D',
				'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R',
				'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
		for (var i = 0; i < codeLength; i++) {
			var charIndex = Math.floor(Math.random() * 32);
			code += selectChar[charIndex];
		}
		if (code.length != codeLength) {
			createCode();
		}
		checkCode.value = code;
	}
	function checkLogin() {
		//if(true) return true;
		var checkCode = document.getElementById("input1").value.toUpperCase();
		if (code == checkCode) {
			return true;
		} else {
			alert("验证码错误！");
			createCode();
			return false;
		}
	}
	function loginSub() {
		var user = document.getElementById("user_txt").value;
		var pswd = document.getElementById("pswd_txt").value;
		if (user == '') {
			alert("请输入用户名！");
			tag = false;
			return false;
		} else if (pswd == '') {
			alert("请输入密码！");
			tag = false;
			return false;

		} else if (checkLogin()) {
			alert("登录成功")
			frm.submit();
			return true;
			/* if(user=="admin"&&pswd=="123"){
				tag = true;
				frm.submit();
			}else{
				tag = false;
				
			} */
			/* var testStr=document.getElementById("pswd_txt").value;
			var resultStr=testStr.replace("\r\n","");
			
			// 			alert("222"+document.getElementById("pswd_txt").value.replace(/[\r\n]/g,"")+"111");
				document.getElementById("pswd_txt").value = hex_md5(resultStr);
				frm.submit(); */

		}else{
			alert("登录失败");
			return false;
		}

	}

	function loginCommit() {
		return tag;
	}
	function qxSub() {
		return true;
	}
	function clearBtn_click() {

		document.getElementById("user_txt").value = '';
		document.getElementById("pswd_txt").value = '';
		document.getElementById("input1").value = '';
		createCode();
	}

	function enterIn(evt) {
		var evt = evt ? evt : (window.event ? window.event : null);//兼容IE和FF
		if (evt.keyCode == 13) {
			//	loginSub();
		}
	}
</script>

</head>
<style type="text/css" media="screen">
/* /*<![CDATA[*/
.code {
	background-image: url(111.png);
	font-family: Arial, 宋体;
	font-style: italic;
	color: #ffffff;
	border: 0;
	padding: 2px 3px;
	letter-spacing: 3px;
	font-weight: bolder;
}

.unchanged {
	border: 0;
	background: blue;
}
/*]]>*/
*
/
</style>
<body onload="systemStart();" onkeydown="enterIn(event)"
	style="background-color: #074381;">
	<div>
		<div style="height: 100px;"></div>
		<!-- <c:url var="loginFrm" value="loginSystem"></c:url> -->
		<%-- <form:form id="frm" action=" ${loginFrm } " method="post" onsubmit="return loginCommit()"> --%>
		<form id="frm" action="loginSystem" method="post" onsubmit="return loginCommit()">
			<div
				style="background-image: url(resources/img/login.png); background-repeat: no-repeat; height: 600px;; width: 1000px; margin-left: 150px;">
				<table>
					<tr>
						<td>
							<div style="margin-top: 415px; margin-left: 710px;">
								<div>
									<input type="text" id="user_txt" name="username">
								</div>
								<div style="margin-top: 15px;">
									<input type="password" id="pswd_txt" name="password">
								</div>

								<div style="margin-top: 20px; margin-left: 2px;">
									<input id="input1" type="text"
										style="float: left; width: 76px;" /> <input type="button"
										class="code" id="checkCode"
										style="width: 76px; border-style: none; border-width: 0px; margin-left: 4px; background: #074381; cursor: pointer;"
										onclick="createCode()" />
								</div>
							</div>
							<div style="margin-top: 5px; margin-left: 670px;">
								<input type="image" src="resources/img/login-up.png"
									onmousemove="this.src='resources/img/login-over.png'"
									onmouseout="this.src='resources/img/login-up.png'"
									onclick="loginSub();" /> <input type="image"
									src="resources/img/qx-up.png"
									onmousemove="this.src='resources/img/qx-over.png'"
									onmouseout="this.src='resources/img/qx-up.png'"
									onclick="clearBtn_click();" />
							</div>
						</td>
					</tr>
				</table>

			</div>
		</form>

	</div>
</body>
</html>
