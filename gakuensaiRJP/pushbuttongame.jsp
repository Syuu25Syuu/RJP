<%@ page pageEncoding="Windows-31J"
 contentType="text/html;charset=UTF-8"
%>

<%--JSTL 1.1.2 core �^�O���C�u����--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
	<title>�A�ŃQ�[��</title>
	<script src="javascript/pushbuttongame.js"></script>
	</head>

	<body>

		<h1>�A�ŗ�</h1>
		
		<form name="form1">
			<input type="button" value="�{�^��" name="p_btn" id="button">
		</form>
		
		<span id="counter"></span>
		<br>
		<span id="display"></span>
		<br>
		<span id="rankingpage"></span>
		<a href="index" id="modoru">�߂�</a>
		
<dialog  style="position: absolute; width: 50%; height: 500px; top: 10px; text-align:center " id="dialog">
           <h4 class="modal-title text-center text-primary myFontClass" id="myModalLabel">�A�ŃQ�[���̐���</h4>
  <p>���O����͂��ăQ�[��������{�^���������B</p>
           <p>�{�^����A�ł���B</p>
           <p><form id="nameform" action=""><input type="text" id="name" name="name" value="" placeholder="���O����͂��Ă��������B"></p>
           <p><button id ="close" type="button" class="btn btn-primary btn-lg myFont1" data-dismiss="modai"><span class="glyphicon glyphicon-repeat" aria-hidden="true"></span> �Q�[��������</button></p>
</dialog>

	</body>
</html>
