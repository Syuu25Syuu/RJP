package scoretaker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ScoreSortTaker {
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
}
