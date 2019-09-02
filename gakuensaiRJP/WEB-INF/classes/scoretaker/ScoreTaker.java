package scoretaker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//テキストファイルからデータを取得するクラス
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
	        	//---------2019/08/29終わらなかったカンマの置き換え--------------------------
	        	if(line[0].contains("名無しの権")==true){
	        		System.out.println("jjjjj");
	        		line[0].replaceAll("名無しの権" , "siosiosiosiosio");
	        		System.out.println(line[0]);
	        		
	        	}
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
	
	//ソートせずに(最新のデータを取るときに使う)データを送るメソッド
	public ArrayList takeScore(String path){
		return getScore(path);
	}
	//ソートして(上位者のデータを取るときに使う)データを送るメソッド
	public ArrayList takeSortScore(String path){
		ArrayList<ArrayList> data=(ArrayList)getScore(path);//名前、スコアのデータのリスト
		ArrayList<String> name=(ArrayList)data.get(0);//名前のデータのリスト
		ArrayList<Integer> score=(ArrayList)data.get(1);//スコアのデータのリスト
		
		
		//昇順にソート
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
