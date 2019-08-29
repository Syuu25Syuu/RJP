<%@ page pageEncoding="Windows-31J"
 contentType="text/html;charset=Windows-31J"
%>

<%--JSTL 1.1.2 core �^�O���C�u����--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ja">
	<head>
		<meta charset="UTF-8" />
		<title>�A�ŃQ�[��</title>
		<script src="javascript/pushbuttongame.js"></script>
		<link rel="shortcut icon" href="css/UNK.ico">
		<link href="css/pushbuttongame.css" rel="stylesheet">
	</head>

	<body>
		<header class="header">
			<div class="headerTitle">
				<h1>�A�ŃQ�[��</h1>
			</div>
			<div class="headerBotton">
				<a href="index" class="btn-square-pop">���g���C</a>
				<a href="index" class="btn-square-pop">TOP</a>
			</div>
		</header>
			
		<div id="footer">
			
			<p><a href=""><img src="images/image3.png" alt="" /></a></p>

			<script src="javascript/alphapicker.js"></script>
			<script>
			window.addEventListener("load", function() {
				var footer = document.getElementById('footer'),
					a = footer.getElementsByTagName("a")[0], // a�v�f���擾
					img = a.getElementsByTagName("img")[0], // img�v�f���擾
					url = a.href, // �����NURL���擾
					alpha;
				
				try {
					/* Alphapicker��img�v�f��n���AAlphapicker�I�u�W�F�N�g���擾 */
					alpha = AlphaPicker(img);
				}
				catch(e) {
					/* �G���[���� */
					console.log(e.name + ":" + e.message);
					return;
				}
				
				/* a�v�f�̃C�x���g�𖳌��ɂ��܂� */
				a.className = "alphapicker";
				a.addEventListener("click", function(e) {
					e.preventDefault();
				}, false);
				
				/* Alphapicker�I�u�W�F�N�g�̃��\�b�h�Ń}�E�X�I�[�o�[�ƃ����N��ݒ肵�܂� */
				alpha.mousemove(function(e) {
					/* �C�x���g�I�u�W�F�N�g��alpha�v���p�e�B�ɁA�}�E�X���W�̃A���t�@�l�������Ă��܂� */
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
			<a href="index">�߂�</a>

		</div>
	</body>
</html>
