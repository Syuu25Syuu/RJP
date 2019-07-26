package requiredscoretaker;

import java.util.ArrayList;

import scoretaker.ScoreTaker;

//�K�v�ȃf�[�^�������擾���T�[�u���b�g�ɑ���N���X
public class NumberfindingRequiredScoreTaker{
	public static ArrayList takeRequiredScore(String path){
		//�K�v�ȃf�[�^(�����L���O��ʎ҂ƍŐV�̋L�^�̃f�[�^)�����郊�X�g
		ArrayList<ArrayList> requireddata=new ArrayList<ArrayList>();
		//���o�����f�[�^
		ArrayList<String> requirednames=new ArrayList<String>();
		ArrayList<String> requiredscores=new ArrayList<String>();
		
		//�f�[�^���擾����N���X�̃C���X�^�X��
		ScoreTaker st=new ScoreTaker();
		
		//�����L���O��ʎ҂̃f�[�^�̓ǂݍ���
		ArrayList all=st.takeSortScore(path);
		ArrayList names=(ArrayList)all.get(0);
		ArrayList scores=(ArrayList)all.get(1);
		
		for(int i=0; i<3; i++){
			requirednames.add((String)names.get(i));
		}
		
		String m="";
		String s="";
		String ms="";
		
		for(int i=0; i<3; i++){
			String score=String.valueOf((int)scores.get(i));
			
			while(score.length()<6){
				score="0"+score;
			}
			
			m=score.substring(0,2);
			s=score.substring(2,4);
			ms=score.substring(4);
			
			requiredscores.add(m+":"+s+":"+ms);
		}
		
		//�ŐV�̃f�[�^�̎擾
		ArrayList newestall=st.takeScore(path);//�ŐV�̃f�[�^�̑S�Ă̖��O�A�X�R�A�̃��X�g
		ArrayList newestnames=(ArrayList)newestall.get(0);//�ŐV�̃f�[�^�̑S�Ă̖��O�̃��X�g
		ArrayList newestscores=(ArrayList)newestall.get(1);//�ŐV�̃f�[�^�̑S�ẴX�R�A�̃��X�g
		
		String newestscore=String.valueOf((int)newestscores.get(newestscores.size()-1));
		while(newestscore.length()<6){
				newestscore="0"+newestscore;
		}
		
		m=newestscore.substring(0,2);
		s=newestscore.substring(2,4);
		ms=newestscore.substring(4);
		
		requirednames.add((String)newestnames.get(newestnames.size()-1));
		requiredscores.add(m+":"+s+":"+ms);
		
		requireddata.add(requirednames);
		requireddata.add(requiredscores);
		
		return requireddata;
	}
}