package requiredscoretaker;

import java.util.ArrayList;

import scoretaker.ScoreTaker;

//必要なデータだけを取得しサーブレットに送るクラス
public class PushbuttonRequiredScoreTaker{
	public static ArrayList takeRequiredScore(String path){
		//必要なデータ(ランキング上位者と最新の記録のデータ)を入れるリスト
		ArrayList<ArrayList> requireddata=new ArrayList<ArrayList>();
		//抽出したデータ
		ArrayList<String> sortnames=new ArrayList<String>();
		ArrayList<Integer> sortscores=new ArrayList<Integer>();
		
		//データを取得するクラスのインスタス化
		ScoreTaker st=new ScoreTaker();
		
		//ランキング上位者のデータの読み込み
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
		
		//最新の記録の取得
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