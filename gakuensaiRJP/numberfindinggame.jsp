<%@ page pageEncoding="Windows-31J"
 contentType="text/html;charset=Windows-31J"
%>

<%--JSTL 1.1.2 core タグライブラリ--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
	<title>ゲーム</title>
	<script src="javascript/numberfindinggame.js"></script>
	</head>

	<body>
		<h1>ストップウォッチ</h1>
	<form name="form1" id="form1">
	<p id="time">
	00:00:00
	</p>
	<button type="button" id="btnStart" onclick="start()">
	スタート
	</button>
	<button type="button" id="btnStart" onclick="stop()">
	ストップ
	</button>
	<button type="button" id="btnClear" onclick="resetStopWatch()">
	クリア
	</button>
	</form>
		<br>
		<a href="index">戻る</a>
	</body>
</html>
