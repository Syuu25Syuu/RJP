<%@ page pageEncoding="Windows-31J"
 contentType="text/html;charset=Windows-31J"
%>

<%--JSTL 1.1.2 core タグライブラリ--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ja">
	<head>
		<meta charset="UTF-8" />
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
				<a href="index" class="btn-square-pop">リトライ</a>
				<a href="index" class="btn-square-pop">TOP</a>
			</div>
		</header>
			
		<div id="footer">
			
			<p><a href=""><img src="images/image3.png" alt="" /></a></p>

			<script src="javascript/alphapicker.js"></script>
			<script>
			window.addEventListener("load", function() {
				var footer = document.getElementById('footer'),
					a = footer.getElementsByTagName("a")[0], // a要素を取得
					img = a.getElementsByTagName("img")[0], // img要素を取得
					url = a.href, // リンクURLを取得
					alpha;
				
				try {
					/* Alphapickerにimg要素を渡し、Alphapickerオブジェクトを取得 */
					alpha = AlphaPicker(img);
				}
				catch(e) {
					/* エラー処理 */
					console.log(e.name + ":" + e.message);
					return;
				}
				
				/* a要素のイベントを無効にします */
				a.className = "alphapicker";
				a.addEventListener("click", function(e) {
					e.preventDefault();
				}, false);
				
				/* Alphapickerオブジェクトのメソッドでマウスオーバーとリンクを設定します */
				alpha.mousemove(function(e) {
					/* イベントオブジェクトのalphaプロパティに、マウス座標のアルファ値が入っています */
					if(e.alpha) {
						this.className = "hover";
					} else {
						this.className = "";
					}
				}).mouseout(function(e) {
					this.className = "";
				}).click(function(e) {
					if(e.alpha) {
						countUp;
					}
				});
			}, false);
			</script>
			
			<span id="counter"></span>
			<br>
			<span id="display"></span>
			<br>
			<a href="index">戻る</a>

		</div>
	</body>
</html>
