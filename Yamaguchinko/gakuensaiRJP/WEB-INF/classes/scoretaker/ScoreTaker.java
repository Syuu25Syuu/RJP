package scoretaker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ScoreTaker {
	//テキストファイルからデータを取ってくるメソッド
	public static ArrayList getScore(String path) {
		ArrayList<ArrayList> data = new ArrayList<ArrayList>();//スコア、名前のリストを格納するリスト
		ArrayList<Integer> score = new ArrayList<Integer>();//名前のリストを格納するリスト
		ArrayList<String> name = new ArrayList<String>();//スコアのリストを格納するリスト

	    StringBuilder builder = new StringBuilder();

	    try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
	    	String string = "";
	        string = reader.readLine();
	        while (string != null){
	        	//カンマ区切り
	        	String[] line = string.split(",");
	        	//name追加
				name.add(line[0]);
				//score追加
				score.add(Integer.parseInt(line[1]));
	        	//改行追加
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
	
	public ArrayList takeScore(String path){
		return getScore(path);
	}
	
	public ArrayList takeSortScore(String path){
		ArrayList data=getScore(path);
		ArrayList name=(ArrayList)data.get(0);
		ArrayList score=(ArrayList)data.get(1);
		
		
		
		for(int i=0; score.size()-1>i; i++) {//昇順にソート
			for(int j=score.size()-1; j>i; j--) {
				if((int)score.get(j-1)>(int)score.get(j)) {
					int x=(int)score.get(j-1);
					score.set(j-1, score.get(j));
					score.set(j,x);
					String y=(String)name.get(j-1);
					name.set(j-1, name.get(j));
					name.set(j,y);
				}
			}
		}
		
	    return data;
	}
}
