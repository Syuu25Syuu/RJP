package scoretaker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//�e�L�X�g�t�@�C������f�[�^���擾����N���X
public class ScoreTaker {
	//�e�L�X�g�t�@�C������f�[�^������Ă��郁�\�b�h
	public static ArrayList getScore(String path) {
		ArrayList<ArrayList> data = new ArrayList<ArrayList>();//�X�R�A�A���O�̃��X�g���i�[���郊�X�g
		ArrayList<Integer> score = new ArrayList<Integer>();//���O�̃��X�g���i�[���郊�X�g
		ArrayList<String> name = new ArrayList<String>();//�X�R�A�̃��X�g���i�[���郊�X�g

	    StringBuilder builder = new StringBuilder();

	    try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
	    	String string = "";
	        string = reader.readLine();
	        while (string != null){
	        	//�J���}��؂�
	        	String[] line = string.split(",");
	        	//---------2019/08/29�I���Ȃ������J���}�̒u������--------------------------
	        	if(line[0].contains("�������̌�")==true){
	        		System.out.println("jjjjj");
	        		line[0].replaceAll("�������̌�" , "siosiosiosiosio");
	        		System.out.println(line[0]);
	        		
	        	}
	        	//name�ǉ�
				name.add(line[0]);
				//score�ǉ�
				score.add(Integer.parseInt(line[1]));
	        	//���s�ǉ�
	            builder.append(string + System.getProperty("line.separator"));
	            string = reader.readLine();
	        }
	    }catch(IOException e){
	    	e.printStackTrace();
	    }

	    data.add(name);
	    data.add(score);

	    return data;
	}
	
	//�\�[�g������(�ŐV�̃f�[�^�����Ƃ��Ɏg��)�f�[�^�𑗂郁�\�b�h
	public ArrayList takeScore(String path){
		return getScore(path);
	}
	//�\�[�g����(��ʎ҂̃f�[�^�����Ƃ��Ɏg��)�f�[�^�𑗂郁�\�b�h
	public ArrayList takeSortScore(String path){
		ArrayList<ArrayList> data=(ArrayList)getScore(path);//���O�A�X�R�A�̃f�[�^�̃��X�g
		ArrayList<String> name=(ArrayList)data.get(0);//���O�̃f�[�^�̃��X�g
		ArrayList<Integer> score=(ArrayList)data.get(1);//�X�R�A�̃f�[�^�̃��X�g
		
		
		//�����Ƀ\�[�g
		for(int i=0; score.size()-1>i; i++) {
			for(int j=score.size()-1; j>i; j--) {
				if((int)score.get(j-1)>(int)score.get(j)) {
					int x=(int)score.get(j-1);
					score.set(j-1, (int)score.get(j));
					score.set(j,x);
					String y=(String)name.get(j-1);
					name.set(j-1, (String)name.get(j));
					name.set(j,y);
				}
			}
		}
		
	    return data;
	}
}
