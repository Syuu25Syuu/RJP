<%@ page pageEncoding="Windows-31J"
 contentType="text/html;charset=Windows-31J"
%>

<%--JSTL 1.1.2 core �^�O���C�u����--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>�A�Ń����L���O</title>
		<script src="javascript/pushbuttongame.js"></script>
	</head>

	<body>
		<h1>�����L���O</h1>
		
		<table border="1">
			<tr><td>1</td><td>${name[0]}</td><td>${score[0]}</td></tr>
			<tr><td>2</td><td>${name[1]}</td><td>${score[1]}</td></tr>
			<tr><td>3</td><td>${name[2]}</td><td>${score[2]}</td></tr>
		</table>
		<br>
		<table border="1">
			<th>�ŐV�L�^</th>
			<tr><td>${name[3]}</td><td>${score[3]}</td></tr>
		</table>
		
	</body>
</html>
