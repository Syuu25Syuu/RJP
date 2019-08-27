//カウンタの初期値を設定
var cnt = 0;
var st = false;
//
var interval_id;
//タイムカウンタースタートのチェック
var start_click = false;
//タイムセット
var time = 10000;
//残り秒数
var sec = 0;



//タイムカウントスタートする関数 count_start
function count_start(){
	if(start_click === false){
		interval_id = setInterval(count_down , 10);
		start_click = true;
	}
}


//タイムカウントダウンする関数 count_down
function count_down(){
	if(time === 1){
		//document.getElementById("display").innerHTML ="残り00:00";
	}else{
		time--;
		
		sen = time % 100000;
		
		var str = String(sen);
		str =  str.slice(1,2);
		
		var str2 = String(sen);
		str2 = str2.slice(-2);
		if(str2.length < 2){
			str2 = str2 + "0"
		}
		if(str2.length < 1){
			str2 = str2 + "00"
		}
		
		document.getElementById("display").innerHTML ="残り0"+str+":"+str2;
	}
}



//カウントアップする関数 countUp
function countUp(){
	//スタート前なら
	if(!st){
		//スタートのフラグをオン
		st=true;
		count_start();
		setTimeout("end()",10010);
		cnt++;
	    
		//カウンタの値を HTML 内の counter に表示
		document.getElementById("counter").innerHTML=cnt;
	}else{
		//カウンタに 1 を加算
		cnt++;
	    
		//カウンタの値を HTML 内の counter に表示
		document.getElementById("counter").innerHTML=cnt;
	}
}

var name;
	  


//変更点2019/08/17------------------------------------------------------------------------------

function end(){
	var count = 2;
	var countdown = function(){
		console.log(count--);
		var id = setTimeout(countdown, 1000);
		document.getElementById("button").style.display="none";
		document.getElementById("counter").style.display="none";
		document.getElementById("display").style.display="none";
		document.getElementById("modoru").style.display="none";
		if(count==0){
			location.href = "http://localhost:8080/minigames/pushbuttongameservlet?cnt="+cnt+"&name="+name;
		}
		else{
			document.getElementById("rankingpage").innerHTML="ランキング画面に飛びます";
		}
	}//countdownの終わり
	countdown();

	time=10000;
	clearInterval(interval_id);
	start_click = false;
	st=false;
	document.getElementById("counter").innerHTML=cnt;
	document.getElementById("display").innerHTML ="残り10:00";
}
//------------------------------------------------------------------------------------------------------

//ページロード時に実行
window.onload = function(){
		document.getElementById("button").style.display="none";
		document.getElementById("counter").style.display="none";
		document.getElementById("display").style.display="none";
		document.getElementById("modoru").style.display="none";
	//--------------------ダイアログ-------------------------
	var dialog = document.querySelector('dialog');
	
	dialog.show();

	var btn_close = document.getElementById("close");


	btn_close.addEventListener('click', function() {
	  
	  name=document.getElementById('name').value;
	  if(name==""){
		name="名無しの権兵衛";
	}
	console.log(name);
	//&が入力されたときに変換するよう"縺昴ｏ縺"は特に理由はないです
	name=name.replace(/&/g,"縺昴ｏ縺");
	  
	  dialog.close();
	  
	  document.getElementById("button").style.display="block";
	  document.getElementById("counter").style.display="block";
	  document.getElementById("display").style.display="block";
	  document.getElementById("modoru").style.display="block";
	}, false);
	//----------------------------------------------------------



    //カウンタの値を HTML 内の counter に表示
    document.getElementById("counter").innerHTML=cnt;
    
    document.getElementById("display").innerHTML ="残り10:00";
    
    //「p_btn」クリック時に関数 countUp を実行
    document.form1.p_btn.onclick=countUp;
};


