<%@ page pageEncoding="Windows-31J"
 contentType="text/html;charset=Windows-31J"
%>

<%--JSTL 1.1.2 core �^�O���C�u����--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>�A�ŃQ�[��</title>
		<script src="javascript/pushbuttongame.js"></script>
		<link rel="shortcut icon" href="css/UNK.ico">
		<link href="css/pushbuttongamee.css" rel="stylesheet">
	</head>

	<body>
		<header class="header">
			<div class="headerTitle">
				<h1>�A�ŃQ�[��</h1>
			</div>
			<div class="headerBotton">
				<a href="index" class="btn-square-pop">���g���C</a>
				<a href="index" class="btn-square-pop">TOP</a>
			</div>
		</header>
			
		<div class="footer">
			<a href="" onclick="countUp(); return false;"><img src="images/image3.png" alt="" /></a>
			
			<span id="counter"></span>
			<br>
			<span id="display"></span>
			<br>
			<a href="index">�߂�</a>
		</div>
	</body>
</html>
