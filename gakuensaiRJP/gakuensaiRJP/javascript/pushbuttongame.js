//�J�E���^�̏����l��ݒ�
var cnt = 0;
var st = false;
//
var interval_id;
//�^�C���J�E���^�[�X�^�[�g�̃`�F�b�N
var start_click = false;
//�^�C���Z�b�g
var time = 30;
//�c��b��
var sec = 0;



//�^�C���J�E���g�X�^�[�g����֐� count_start
function count_start(){
	if(start_click === false){
		interval_id = setInterval(count_down , 1000);
		start_click = true;
	}
}



//�^�C���J�E���g�_�E������֐� count_down
function count_down(){
	console.log(time);
	if(time === 0){
		//�������Ȃ�
	}else{
		time--;
		sen = Math.floor(time % 60);
		document.getElementById("display").innerHTML ="�c��"+sen;
	}
}


//�J�E���g�A�b�v����֐� countUp
function countUp(){
	//�X�^�[�g�O�Ȃ�
	if(!st){
		//�X�^�[�g�̃t���O���I��
		st=true;
		count_start();
		setTimeout("end()",30050);
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



function end(){
	console.log(time);
	var result = window.confirm("TIME UP! ���Ȃ��̓_����"+cnt+"�_�ł�\n�����L���O��ʂɔ��ł����H");
    
	if( result ) {
		location.href = "http://localhost:8080/mingames/pushbuttongameservlet?cnt="+cnt;	//+"&name="+name;
	}else{
		window.confirm("�́H\n�����L���O��ʂɔ��ł�����ˁH");
	}
	cnt=0;
	time=30;
	clearInterval(interval_id);
	start_click = false;
	st=false;
	document.getElementById("counter").innerHTML=cnt;
	document.getElementById("display").innerHTML ="�c��30";
}



//�y�[�W���[�h���Ɏ��s
window.onload = function(){
    //�J�E���^�̒l�� HTML ���� counter �ɕ\��
    document.getElementById("counter").innerHTML=cnt;
    
    document.getElementById("display").innerHTML ="�c��30";
    
    //�up_btn�v�N���b�N���Ɋ֐� countUp �����s
    document.form1.p_btn.onclick=countUp;
};



