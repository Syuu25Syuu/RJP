<%@ page pageEncoding="Windows-31J"
 contentType="text/html;charset=Windows-31J"
%>

<%--JSTL 1.1.2 core タグライブラリ--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
	<title>連打ゲーム</title>
	<script src="javascript/pushbuttongame.js"></script>
	</head>

	<body>
		<h1>連打力</h1>
		
		<form name="form1">
			<input type="button" value="ボタン" name="p_btn">
		</form>
		
		<span id="counter"></span>
		<br>
		<span id="display"></span>
	</body>
</html>
