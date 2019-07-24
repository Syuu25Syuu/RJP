<%@ page pageEncoding="Windows-31J"
 contentType="text/html;charset=Windows-31J"
%>

<%--JSTL 1.1.2 core タグライブラリ--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>連打ランキング</title>
		<script src="javascript/pushbuttongame.js"></script>
	</head>

	<body>
		<h1>ランキング</h1>
		
		<table border="1">
			<tr><td>1</td><td>${name[0]}</td><td>${score[0]}</td></tr>
			<tr><td>2</td><td>${name[1]}</td><td>${score[1]}</td></tr>
			<tr><td>3</td><td>${name[2]}</td><td>${score[2]}</td></tr>
		</table>
		<br>
		<table border="1">
			<th>最新記録</th>
			<tr><td>${name[3]}</td><td>${score[3]}</td></tr>
		</table>
		
	</body>
</html>
