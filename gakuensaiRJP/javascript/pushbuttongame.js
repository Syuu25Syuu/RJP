//�J�E���^�̏����l��ݒ�
var cnt = 0;
var st = false;
//
var interval_id;
//�^�C���J�E���^�[�X�^�[�g�̃`�F�b�N
var start_click = false;
//�^�C���Z�b�g
var time = 10000;
//�c��b��
var sec = 0;



//�^�C���J�E���g�X�^�[�g����֐� count_start
function count_start(){
	if(start_click === false){
		interval_id = setInterval(count_down , 10);
		start_click = true;
	}
}


//�^�C���J�E���g�_�E������֐� count_down
function count_down(){
	if(time === 1){
		//document.getElementById("display").innerHTML ="�c��00:00";
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
		
		document.getElementById("display").innerHTML ="�c��0"+str+":"+str2;
	}
}



//�J�E���g�A�b�v����֐� countUp
function countUp(){
	//�X�^�[�g�O�Ȃ�
	if(!st){
		//�X�^�[�g�̃t���O���I��
		st=true;
		count_start();
		setTimeout("end()",10010);
		cnt++;
	    
		//�J�E���^�̒l�� HTML ���� counter �ɕ\��
		document.getElementById("counter").innerHTML=cnt;
	}else{
		//�J�E���^�� 1 �����Z
		cnt++;
	    
		//�J�E���^�̒l�� HTML ���� counter �ɕ\��
		document.getElementById("counter").innerHTML=cnt;
	}
}

var name;
	  


//�ύX�_2019/08/17------------------------------------------------------------------------------

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
			document.getElementById("rankingpage").innerHTML="�����L���O��ʂɔ�т܂�";
		}
	}//countdown�̏I���
	countdown();

	time=10000;
	clearInterval(interval_id);
	start_click = false;
	st=false;
	document.getElementById("counter").innerHTML=cnt;
	document.getElementById("display").innerHTML ="�c��10:00";
}
//------------------------------------------------------------------------------------------------------

//�y�[�W���[�h���Ɏ��s
window.onload = function(){
		document.getElementById("button").style.display="none";
		document.getElementById("counter").style.display="none";
		document.getElementById("display").style.display="none";
		document.getElementById("modoru").style.display="none";
	//--------------------�_�C�A���O-------------------------
	var dialog = document.querySelector('dialog');
	
	dialog.show();

	var btn_close = document.getElementById("close");


	btn_close.addEventListener('click', function() {
	  
	  name=document.getElementById('name').value;
	  if(name==""){
		name="�������̌����q";
	}
	console.log(name);
	//&�����͂��ꂽ�Ƃ��ɕϊ�����悤"そわ�"�͓��ɗ��R�͂Ȃ��ł�
	name=name.replace(/&/g,"そわ�");
	  
	  dialog.close();
	  
	  document.getElementById("button").style.display="block";
	  document.getElementById("counter").style.display="block";
	  document.getElementById("display").style.display="block";
	  document.getElementById("modoru").style.display="block";
	}, false);
	//----------------------------------------------------------



    //�J�E���^�̒l�� HTML ���� counter �ɕ\��
    document.getElementById("counter").innerHTML=cnt;
    
    document.getElementById("display").innerHTML ="�c��10:00";
    
    //�up_btn�v�N���b�N���Ɋ֐� countUp �����s
    document.form1.p_btn.onclick=countUp;
};


