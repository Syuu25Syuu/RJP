package scoretaker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ScoreSortTaker {
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
}
