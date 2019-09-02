$(function(){
   var SIZE = 4, // 出現する数字の数を指定する
      BTN_NUMBER = SIZE*SIZE;
      $board = $("#board"), // ランダムな数字を入れるところ
      $timeCount = $("#timer"), // タイマーを表示するところ
      $missCount = $("#missCount"),//ミスした回数
      $finishScore = $("#finishScore"),//スコア
      currentNum = 1, // 今押さなければいけない数字を保存するもの
      startTime = undefined, // スタートを押したときの時間を保存するもの
      timerId = undefined, // ゲームのタイマー
      resultTime = 0, // ゲームの結果タイムを保存するもの
      missCount = 0;//ミスタッチをカウント
      
  //画像動かし用-------------------------------------------------
  var x = 0, y = 0, divx = 1, divy = 1, velx = 4, vely = 4;
  var windowWidth  = window.innerWidth;
  var windowHeight = window.innerHeight;
  var moveImgTimerId;
  var timing1 = 0;
  var timing2 = 0;
  var timing3 = 0;
  var timing4 = 0;
  var timing5 = 0;
  //-----------------------------------------------------------
  //ボード動かし用
  var bx = 0, by = 0, bdivx = 1, bdivy = 1, bvelx = 1, bvely = 3.5;
  var moveBoardTimerId;
  var timingB = 100;
  //-----------------------------------------------------------
  
    $('#rule').modal('show');
    $('img').imgLiquid();
    //初期設定の難易度を非活性にしておく
    $("#difficulty2").prop("disabled", true);

    $("#difficulty1").on("click", function() {
    	SIZE = 3;
    	BTN_NUMBER = SIZE * SIZE;
    	$("#difficulty1").prop("disabled", true);
    	$("#difficulty2").prop("disabled", false);
    	$("#difficulty3").prop("disabled", false);
    });
    $("#difficulty2").on("click", function() {
 		SIZE = 4;
    	BTN_NUMBER = SIZE * SIZE;
    	$("#difficulty1").prop("disabled", false);
    	$("#difficulty2").prop("disabled", true);
    	$("#difficulty3").prop("disabled", false);
    });
    $("#difficulty3").on("click", function() {
    	SIZE = 5;
    	BTN_NUMBER = SIZE * SIZE;
    	$("#difficulty1").prop("disabled", false);
    	$("#difficulty2").prop("disabled", false);
    	$("#difficulty3").prop("disabled", true);
    });

    $board.on("click", "#num", checkNum);

    function timingSet(){
    	timing1 = Math.floor(Math.random() * 1+1);
    	timing2 = Math.floor(Math.random() * 6+1);
    	timing3 = Math.floor(Math.random() * 11+1);
    	timing4 = Math.floor(Math.random() * 16+1);
    	timing5 = Math.floor(Math.random() * 21+1);
    }

    function initBoard() {
      var buttons = [];
      var button;

      //ボタンを生成
      for (var i = 0; i < BTN_NUMBER; i++) {
          buttons.push('<button id="num" class="btn btn-default">'+(i+1)+'</button>');
      }

      while(buttons.length){
         // ボタンにランダムな数字を配置
         button = buttons.splice(Math.floor(Math.random() * buttons.length),1);
         // ボタンの配置
         $board.append(button[0]);
         if(buttons.length % SIZE == 0){
            $board.append('</br>');
         }
      }
    }
    
	


var count = 4;
  var countdown = function(){
    console.log(count--);
    var id = setTimeout(countdown, 1000);
    if(count==0){
    	$timeCount.text("スタート");
    }else{
    	$timeCount.text(count);
    }
    if(count < 0){
      clearTimeout(id);
      timingSet();
        moveImg();
        $("#start").prop("disabled", true);//ゲーム中ははじめるボタンを非活性に
        $("#difficulty1").prop("disabled", true);
    	$("#difficulty2").prop("disabled", true);
    	$("#difficulty3").prop("disabled", true);
       $('#board').hide();
        $timeCount.text("00:00:00");
        $board.html("");
        currentNum = 1;
        clearTimeout(timerId);
        initBoard();
        start();
        $('#board').show();
    }
  }
  



    var dialog = document.querySelector('dialog');
    var btn_show = document.getElementById('show');
    var btn_close = document.getElementById('close');

    btn_show.addEventListener('click', function() {
      dialog.show();
    }, false);
    btn_close.addEventListener('click', function() {
      dialog.close();
      countdown();
    }, false);





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
			location.href = "http://localhost:8080/minigames/numberfindinggameservlet?time="+drawTime()+"&name="+name;
			
	
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
	$timeCount.text(strTime);
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

window.onload = function(){
      dialog.show();
      resetStopWatch();
}

				var count2 = 2;
                var countdown2 = function(){
				   console.log(count2--);
				   var id = setTimeout(countdown2, 1000);
				   if(count2==0){
				    $('#timer').hide();
				   	location.href = "http://localhost:8080/minigames/numberfindinggameservlet?time="+drawTime()+"&name="+names();
				   }else{
				   	$timeCount.text("ランキングページに飛びます");
				   	
				   }
                }



    function checkNum() {
       var num = $(this).text();

       if (num == currentNum) {
          soundCorrect();
           $(this).prop('disabled', true);
           $(this).html('<div class="img"><img src="../images/maru.jpg"/></div>');
           $(this).imgLiquid();
			moveSpeed(currentNum);
			
			
           if (currentNum == BTN_NUMBER) {
               clearTimeout(timerId);
               clearTimeout(moveImgTimerId);
               clearTimeout(moveBoardTimerId);
               $('#start').hide();
               $('#board').hide();
               //$('#timer').hide();
               $('#btnOtherGame').hide();
               $('#btnReplay').hide();
               $('#imgNum').hide()
               $('#show').hide();
               countdown2();
               
           }
           currentNum++;
      }else{
         missCount++;
         changeColorsuper();
         soundIncorrect();
      }
    }
    function changeColor(){
    	input = document.getElementById('board');
    	input.style.backgroundColor = 'transparent';
    	clearTimeout(color);
    }
    
    var color;
    var input;
    function changeColorsuper(){
    	input = document.getElementById('board');
    	input.style.backgroundColor = 'red';
    	color=setTimeout(changeColor,200);
    }

    function moveSpeed(num){
    	if(num==timing1 || num==timing2 || num==timing3 || num==timing4 || num==timing5){
    		velx=velx*2;
    		vely=vely*2;
    	}
    	if(num==timingB){
    		moveBoard();
    	}
    }
    function soundIncorrect(){
      //音声ファイルを巻き戻す(再生位置[秒]を0に設定する)
      document.getElementById("incorrect").currentTime = 0;
      $("#incorrect").get(0).play();
   }

   function soundCorrect(){
      //音声ファイルを巻き戻す(再生位置[秒]を0に設定する)
      //document.getElementById("correct").currentTime = 0;
     //$("#correct").get(0).play();
  }
     function soundFanfare(){
      //音声ファイルを巻き戻す(再生位置[秒]を0に設定する)
      document.getElementById("fanfare").currentTime = 0;
     $("#fanfare").get(0).play();
  }

  function moveImg(){
    $("#imgNum").css({left: x + 'px', top: y + 'px'});
	
    x = x + velx * divx;

    if((x + $("#imgNum").width() > windowWidth) || (x < 0)){
      divx = - divx;
      x = x + velx * divx;
      //console.log("a");
    }

    y = y + vely * divy;

    if((y + $("#imgNum").height() > windowHeight) || (y < 0)){
      divy = - divy;
      y = y + vely * divy;
      //console.log("b");
  }

  moveImgTimerId = setTimeout(moveImg, 10);
}

function moveBoard(){
    $("#board").css({left: bx + 'px', top: by + 'px'});
	
    bx = bx + bvelx * bdivx;

    if((bx > 50) || (bx < -50)){
      bdivx = - bdivx;
      bx = bx + bvelx * bdivx;
      //console.log("c");
    }

    by = by + bvely * bdivy;

    if((by > 50) || (by < -50)){
      bdivy = - bdivy;
      by = by + bvely * bdivy;
      //console.log("d");
  }

  moveBoardTimerId = setTimeout(moveBoard, 10);
}

    function sendResult(finishScore){
       switch(SIZE){
           case 3:
              var table='toucheasyranking';
           break;
           case 4:
              var table='touchnormalranking';
           break;
           case 5:
              var table='touchhardranking';
           break;
       }
       console.log(SIZE+table);
       $.ajax({
          url: 'http://172.19.253.32:8080/gakusaigametouchnumber/judge',
          type:'GET',
          dataType: 'json',
          data:{
             score: finishScore,
             table: table
          }
       })
       .done(function(data) {
		$('#rank>table>').remove();
		console.log(data[10].currentRank);
		console.log(data[11].currentScore);
	  $('#ranking2').append('<th class="text-center">順位</th><th class="text-center">スコア</th>');

	  // ランク用変数
	  var rank = 1;
	  for(var i = 0; i <= 9; i++){
		  if(data[10].currentRank == -1){
			  // ランク外ならば、直近のランクを「ランク外」に設定
			  data[10].currentRank = 'ランク外';
			  $('#ranking2').append("<tr class=\"text-center\"><td>"+rank+"位</td><td>"+parseFloat(data[i].score)/*.toFixed(2)*/+"</td></tr>");//小数点を表示しないように変更
		  }else if((data[10].currentRank+1) == rank){
			  console.log("ランクインしてるよー")
			  // ランクインしている場合
			  //$('#ranking2').append("<tr class=\"blinking text-center\"><td>"+(data[10].currentRank+1)+"位</td><td>"+parseFloat(data[11].currentScore)/*.toFixed(2)*/+"</td></tr>");
			  $('#ranking2').append("<tr class=\"text-center\"><td>"+(data[10].currentRank+1)+"位</td><td>"+parseFloat(data[11].currentScore)/*.toFixed(2)*/+"</td></tr>");
		  }else{
			  // 10位までを表示させる処理
			  console.log("その他ー")
			  $('#ranking2').append("<tr class=\"text-center\"><td>"+rank+"位</td><td>"+parseFloat(data[i].score)/*.toFixed(2)*/+"</td></tr>");
		  }
		  rank++;
		  console.log("らんくいんざるーぷ　"+rank);
	  }
	  // 最後に直近のランクとスコアを表示させる
	  $('#current').append('<th class="text-center">あなたの順位</th><th class="text-center">クリアタイム</th><th class="text-center">ミスした回数</th><th class="text-center">あなたのスコア</th>');//ミスとスコア追加
     if(data[10].currentRank == 'ランク外'){
        $('#current').append("<tr class=\"text-center\"><td>"+(data[10].currentRank)+"</td><td>"+resultTime+"</td><td>"+missCount+"</td><td>"+parseFloat(data[11].currentScore)+"</td></tr>");
     }else{
        $('#current').append("<tr class=\"text-center\"><td>"+(data[10].currentRank+1)+"</td><td>"+resultTime+"</td><td>"+missCount+"</td><td>"+parseFloat(data[11].currentScore)+"</td></tr>");
     }

          $('.modal-footer > button:first').on('click',function(){
             window.location.href = 'http://172.19.253.32:8080/gakusai/';
          });

          $('.modal-footer > button:last').on('click',function(){
             window.location.reload();
          });

          $('#ranking').modal({backdrop: false});
       })
       .fail(function(data) {
          console.log(data.currentScore);
          alert("ランキングの処理に失敗しました・・・(T_T)");
          window.location.reload();//追加部分
       });
    };
    //-------------------------------------------------------------------
     i = 0;
                        //配列を作成
    color = new Array("red","blue","green","yellow","purple");
    function change(){            //配列の値を背景色に
        i++;
        if(i >= color.length) {
            i = 0;
        }
        document.bgColor = color[i];
    }
    function tm(){                //タイマーをセット
        document.bgColor = color[i];
        tm = setInterval("change()",5000);
    }
    
});

function names(){
	//入力された名前関係
	var name=document.getElementById('name').value;
	if(name==""){
		name="名無しの権兵衛";
	}
	console.log(name);
	//&が入力されたときに変換するよう"縺昴ｏ縺"は特に理由はないです
	name=name.replace(/&/g,"縺昴ｏ縺");
	
	return name;
}