<%@ page pageEncoding="Windows-31J"
 contentType="text/html;charset=Windows-31J"
%>

<%--JSTL 1.1.2 core �^�O���C�u����--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
	<title>�Q�[��</title>
	<script src="javascript/numberfindinggame.js"></script>
	</head>

	<body>
		<h1>�X�g�b�v�E�H�b�`</h1>
	<form name="form1" id="form1">
	<p id="time">
	00:00:00
	</p>
	<button type="button" id="btnStart" onclick="start()">
	�X�^�[�g
	</button>
	<button type="button" id="btnStart" onclick="stop()">
	�X�g�b�v
	</button>
	<button type="button" id="btnClear" onclick="resetStopWatch()">
	�N���A
	</button>
	</form>
		<br>
		<a href="index">�߂�</a>
	</body>
</html>
