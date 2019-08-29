<%@ page pageEncoding="Windows-31J"
 contentType="text/html;charset=Windows-31J"
%>

<%--JSTL 1.1.2 core タグライブラリ--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="utf-8">
		<title>ランキング-連打ゲーム</title>
		<script src="javascript/pushbuttongame.js"></script>
		<link rel="shortcut icon" href="css/UNK.ico">
		<link href="css/pushbuttonranking.css" rel="stylesheet">
	</head>

	<body>
		<header class="header">
			<div class="headerTitle">
				<h1>ランキング-連打ゲーム</h1>
			</div>
			<div class="headerBotton">
				<a href="http://localhost:8080/minigames/pushbuttongame.jsp" class="btn-square-pop">リトライ</a>
				<a href="index" class="btn-square-pop">TOP</a>
			</div>
		</header>
		
		<div class="footer">
			<div class="ranking">
				<table>
						<tr>
							<td class="icon gold">${name[0]}さん</td>
							<td>${score[0]}回</td>
						</tr>
						
						<tr>
							<td class="icon silver">${name[1]}さん</td>
							<td>${score[1]}回</td>
						</tr>
						
						<tr>
							<td class="icon bronze">${name[2]}さん</td>
							<td>${score[3]}回</td>
						</tr>
				</table>
			</div>
		</div>
	</body>
</html>
