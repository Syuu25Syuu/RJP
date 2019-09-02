<%@ page pageEncoding="SJIS"
 contentType="text/html;charset=SJIS"
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
			<tr><td>4</td><td>${name[3]}</td><td>${score[3]}</td></tr>
			<tr><td>5</td><td>${name[4]}</td><td>${score[4]}</td></tr>
			<tr><td>6</td><td>${name[5]}</td><td>${score[5]}</td></tr>
			<tr><td>7</td><td>${name[6]}</td><td>${score[6]}</td></tr>
			<tr><td>8</td><td>${name[7]}</td><td>${score[7]}</td></tr>
			<tr><td>9</td><td>${name[8]}</td><td>${score[8]}</td></tr>
			<tr><td>10</td><td>${name[9]}</td><td>${score[9]}</td></tr>
		</table>
		<br>
		<table border="1">
			<th>最新記録</th>
			<tr><td>${name[10]}</td><td>${score[10]}</td></tr>
		</table>
		<a href="index">TOP</a>
		<a href="pushbuttongame">もう一度遊ぶ</a>
	</body>
</html>
