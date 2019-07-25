package requiredscoretaker;

import java.util.ArrayList;

import scoretaker.ScoreTaker;

//�K�v�ȃf�[�^�������擾���T�[�u���b�g�ɑ���N���X
public class PushbuttonRequiredScoreTaker{
	public static ArrayList takeRequiredScore(String path){
		//�K�v�ȃf�[�^(�����L���O��ʎ҂ƍŐV�̋L�^�̃f�[�^)�����郊�X�g
		ArrayList<ArrayList> requireddata=new ArrayList<ArrayList>();
		//���o�����f�[�^
		ArrayList<String> sortnames=new ArrayList<String>();
		ArrayList<Integer> sortscores=new ArrayList<Integer>();
		
		//�f�[�^���擾����N���X�̃C���X�^�X��
		ScoreTaker st=new ScoreTaker();
		
		//�����L���O��ʎ҂̃f�[�^�̓ǂݍ���
		ArrayList data=st.takeSortScore(path);
		ArrayList names2=(ArrayList)data.get(0);
		ArrayList scores2=(ArrayList)data.get(1);
		
		for(int i=1; 3>=i; i++){
			sortnames.add((String)names2.get(names2.size()-i));
		}
		
		for(int i=1; 3>=i; i++){
			sortscores.add((int)scores2.get(scores2.size()-i));
		}
		
		requireddata.add(sortnames);
		requireddata.add(sortscores);
		
		//�ŐV�̋L�^�̎擾
		data=st.takeScore(path);
		ArrayList names1=(ArrayList)data.get(0);
		ArrayList scores1=(ArrayList)data.get(1);
		
		String newestname=(String)names1.get(names1.size()-1);
		int newestscore=(int)scores1.get(scores1.size()-1);
		
		sortnames.add(newestname);
		sortscores.add(newestscore);
		
		return requireddata;
	}
}