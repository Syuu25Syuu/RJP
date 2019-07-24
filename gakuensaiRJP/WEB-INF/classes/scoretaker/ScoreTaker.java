package scoretaker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ScoreTaker {
	public static ArrayList scoreTake(String path) {
		/*
		ArrayList<ArrayList> data=ScoreReader.getScore(path);//�X�R�A�A���O�̃��X�g���i�[���郊�X�g
		ArrayList<String> name=data.get(0);//���O�̃��X�g���i�[���郊�X�g
		ArrayList<Integer> score=data.get(1);//�X�R�A�̃��X�g���i�[���郊�X�g

		for(int i=0; score.size()-1>i; i++) {//�����Ƀ\�[�g
			for(int j=score.size()-1; j>i; j--) {
				if(score.get(j-1)>score.get(j)) {
					int x=score.get(j-1);
					score.set(j-1, score.get(j));
					score.set(j,x);
					String y=name.get(j-1);
					name.set(j-1, name.get(j));
					name.set(j,y);
				}
			}
		}
		System.out.println(name);
		System.out.println(score);

		data=

	}
	*/

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

	    for(int i=0; score.size()-1>i; i++) {//�����Ƀ\�[�g
			for(int j=score.size()-1; j>i; j--) {
				if(score.get(j-1)>score.get(j)) {
					int x=score.get(j-1);
					score.set(j-1, score.get(j));
					score.set(j,x);
					String y=name.get(j-1);
					name.set(j-1, name.get(j));
					name.set(j,y);
				}
			}
		}

	    data.add(name);
	    data.add(score);

	    return data;
	}

}
