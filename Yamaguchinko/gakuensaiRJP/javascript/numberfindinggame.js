

var mode;					// ストップウォッチのモード	RUN/STOP
var startTime;				// スタートした時刻
var nowTime;				// ストップした時刻
var addTime;				// 経過時間（ストップウォッチ再開時に加算する）
var millisec;					// 1000分の1秒
var sec100;					// 100分の1秒
var sec;						// 秒
var min;						// 分
var hour;					// 時
var gmt;						// タイムゾーンのオフセット値
							//	例）GMT+0900 なら 標準時より9時間後をさしているので-9する
var timerId;					// タイマー

/*
 * ストップウォッチのリセット
 */
function resetStopWatch(){
	addTime = 0;
	millisec = sec100 = sec = min = hour = 0;
	gmt = new Date().getTimezoneOffset() / 60;	// 戻り値は分のため60で割る
	document.getElementById("time").innerHTML = "00:00:00";
}
		
/*
 * ボタン処理
 */
function start(){
			timerId = setTimeout(runStopWatch, 10);
			// スタート時刻を設定（ストップウォッチが進んでいれば加算）
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
 * 時間表示
 */
function drawTime(strTime){
	var strTime = "";
	var strSec100, strSec, strMin, strHour;

	// 数値を文字に変換及び2桁表示設定
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
	// 表示形式を設定
	strTime = strMin + ":" + strSec + ":" + strSec100;
	document.getElementById("time").innerHTML = strTime;
	return strTime;
}

/*
 * 時間計測
 */
function runStopWatch(){
	// スタートからの差分をとる
	nowTime = new Date().getTime();
	diff = new Date(nowTime - startTime);
	// ミリ秒、100分の1秒、秒、分を設定
	millisec = diff.getMilliseconds();
	sec100 = Math.floor(millisec / 10);
	sec = diff.getSeconds();
	min = diff.getMinutes();
	hour = diff.getHours() + gmt;	// タイムゾーンのオフセットを考慮する

	drawTime();			// 時間表示
	timerId = setTimeout(runStopWatch, 10);
}

/*
 * 実行時の処理
 */
window.onload = function(){
	resetStopWatch();
}
