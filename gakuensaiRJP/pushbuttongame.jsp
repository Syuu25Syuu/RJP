<%@ page pageEncoding="Windows-31J"
 contentType="text/html;charset=UTF-8"
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
			<input type="button" value="ボタン" name="p_btn" id="button">
		</form>
		
		<span id="counter"></span>
		<br>
		<span id="display"></span>
		<br>
		<span id="rankingpage"></span>
		<a href="index" id="modoru">戻る</a>
		
<dialog  style="position: absolute; width: 50%; height: 500px; top: 10px; text-align:center " id="dialog">
           <h4 class="modal-title text-center text-primary myFontClass" id="myModalLabel">連打ゲームの説明</h4>
  <p>名前を入力してゲームをするボタンを押す。</p>
           <p>ボタンを連打する。</p>
           <p><form id="nameform" action=""><input type="text" id="name" name="name" value="" placeholder="名前を入力してください。"></p>
           <p><button id ="close" type="button" class="btn btn-primary btn-lg myFont1" data-dismiss="modai"><span class="glyphicon glyphicon-repeat" aria-hidden="true"></span> ゲームをする</button></p>
</dialog>

	</body>
</html>
