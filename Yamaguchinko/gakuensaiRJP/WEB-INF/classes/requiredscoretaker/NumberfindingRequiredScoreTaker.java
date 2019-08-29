package requiredscoretaker;

import java.util.ArrayList;

import scoretaker.ScoreTaker;

//必要なデータだけを取得しサーブレットに送るクラス
public class NumberfindingRequiredScoreTaker{
	public static ArrayList takeRequiredScore(String path){
		//必要なデータ(ランキング上位者と最新の記録のデータ)を入れるリスト
		ArrayList<ArrayList> requireddata=new ArrayList<ArrayList>();
		//抽出したデータ
		ArrayList<String> requirednames=new ArrayList<String>();
		ArrayList<String> requiredscores=new ArrayList<String>();
		
		//データを取得するクラスのインスタス化
		ScoreTaker st=new ScoreTaker();
		
		//ランキング上位者のデータの読み込み
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
		
		//最新のデータの取得
		ArrayList newestall=st.takeScore(path);//最新のデータの全ての名前、スコアのリスト
		ArrayList newestnames=(ArrayList)newestall.get(0);//最新のデータの全ての名前のリスト
		ArrayList newestscores=(ArrayList)newestall.get(1);//最新のデータの全てのスコアのリスト
		
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