<%@ page pageEncoding="Windows-31J"
 contentType="text/html;charset=Windows-31J"
%>

<%--JSTL 1.1.2 core タグライブラリ--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>連打ゲーム</title>
		<script src="javascript/pushbuttongame.js"></script>
		<link rel="shortcut icon" href="css/UNK.ico">
		<link href="css/pushbuttongame.css" rel="stylesheet">
	</head>

	<body>
		<header class="header">
			<div class="headerTitle">
				<h1>連打ゲーム</h1>
			</div>
			<div class="headerBotton">
				<a href="http://localhost:8080/minigames/pushbuttongame.jsp" class="btn-square-pop">リトライ</a>
				<a href="index" class="btn-square-pop">TOP</a>
			</div>
		</header>
			
		<div id="footer">
			<div class="disBox">
				<span id="display"></span>
			</div>
						
			<div class="demo">
				<a href=""><img src="images/image3.png"  width="480" height="480" alt="90141919" /></a>
			</div>
			
			<script src="javascript/alphapicker.js"></script>
			<script>
			window.addEventListener("load", function() {
				var footer = document.getElementById('footer'),
					a = footer.getElementsByTagName("a")[0],
					img = a.getElementsByTagName("img")[0],
					alpha;
				
				try {
					alpha = AlphaPicker(img);
				}
				catch(e) {
					console.log(e.name + ":" + e.message);
					return;
				}
				a.className = "alphapicker";
				a.addEventListener("click", function(e) {
					e.preventDefault();
				}, false);
				alpha.mousemove(function(e) {
					if(e.alpha) {
						this.className = "hover";
					} else {
						this.className = "";
					}
				}).mouseout(function(e) {
					this.className = "";
				}).click(function(e) {
					if(e.alpha) {
						countUp();
					}
				});
			}, false);
			</script>
			
			<div class="cntBox">
				<span id="counter"></span>
			</div>
		</div>
	</body>
</html>
