

var mode;					// �X�g�b�v�E�H�b�`�̃��[�h	RUN/STOP
var startTime;				// �X�^�[�g��������
var nowTime;				// �X�g�b�v��������
var addTime;				// �o�ߎ��ԁi�X�g�b�v�E�H�b�`�ĊJ���ɉ��Z����j
var millisec;					// 1000����1�b
var sec100;					// 100����1�b
var sec;						// �b
var min;						// ��
var hour;					// ��
var gmt;						// �^�C���]�[���̃I�t�Z�b�g�l
							//	��jGMT+0900 �Ȃ� �W�������9���Ԍ�������Ă���̂�-9����
var timerId;					// �^�C�}�[

/*
 * �X�g�b�v�E�H�b�`�̃��Z�b�g
 */
function resetStopWatch(){
	addTime = 0;
	millisec = sec100 = sec = min = hour = 0;
	gmt = new Date().getTimezoneOffset() / 60;	// �߂�l�͕��̂���60�Ŋ���
	document.getElementById("time").innerHTML = "00:00:00";
}
		
/*
 * �{�^������
 */
function start(){
			timerId = setTimeout(runStopWatch, 10);
			// �X�^�[�g������ݒ�i�X�g�b�v�E�H�b�`���i��ł���Ή��Z�j
			startTime = new Date().getTime();
			addTime = (hour*60*60*1000 + min*60*1000 + sec * 1000 + millisec);
			startTime -= addTime;
	
}

function stop(){
			clearTimeout(timerId);
			nowTime = new Date().getTime();
			drawTime();
			location.href = "http://localhost:8080/minigames/numberfindinggameservlet?time="+drawTime();
			
	
}

/*
 * ���ԕ\��
 */
function drawTime(strTime){
	var strTime = "";
	var strSec100, strSec, strMin, strHour;

	// ���l�𕶎��ɕϊ��y��2���\���ݒ�
	strSec100 = "" + sec100;
	if ( strSec100.length < 2){
		strSec100 = "0" + strSec100;
	}
	strSec = "" + sec;
	if ( strSec.length < 2){
		strSec = "0" + strSec;
	}
	strMin = "" + min;
	if ( strMin.length < 2){
		strMin = "0" + strMin;
	}
	// �\���`����ݒ�
	strTime = strMin + ":" + strSec + ":" + strSec100;
	document.getElementById("time").innerHTML = strTime;
	return strTime;
}

/*
 * ���Ԍv��
 */
function runStopWatch(){
	// �X�^�[�g����̍������Ƃ�
	nowTime = new Date().getTime();
	diff = new Date(nowTime - startTime);
	// �~���b�A100����1�b�A�b�A����ݒ�
	millisec = diff.getMilliseconds();
	sec100 = Math.floor(millisec / 10);
	sec = diff.getSeconds();
	min = diff.getMinutes();
	hour = diff.getHours() + gmt;	// �^�C���]�[���̃I�t�Z�b�g���l������

	drawTime();			// ���ԕ\��
	timerId = setTimeout(runStopWatch, 10);
}

/*
 * ���s���̏���
 */
window.onload = function(){
	resetStopWatch();
}
