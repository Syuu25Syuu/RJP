//package classes;

//import scoretaker.ScoreSortTaker;
import scoretaker.ScoreTaker;

import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		//˜A‘ÅƒQ[ƒ€
		ScoreTaker st=new ScoreTaker();
		System.out.println(st.takeScore("C:/gakuensaiRJP/txt/pushbuttonscore.txt"));
		System.out.println(st.takeSortScore("C:/gakuensaiRJP/txt/pushbuttonscore.txt"));
		
		//”š’T‚µƒQ[ƒ€
		System.out.println(st.takeSortScore("C:/gakuensaiRJP/txt/numberfindingscore.txt"));
		ArrayList all1=st.takeSortScore("C:/gakuensaiRJP/txt/numberfindingscore.txt");
		ArrayList name1=(ArrayList)all1.get(0);
		ArrayList score1=(ArrayList)all1.get(1);
		
		String m="";
		String s="";
		String ms="";
		
		for(int i=0; i<score1.size(); i++){
			String score=String.valueOf(score1.get(i));
			
			while(score.length()<6){
				score="0"+score;
			}
			
			m=score.substring(0,2);
			s=score.substring(2,4);
			ms=score.substring(4);
			System.out.println(name1.get(i)+" "+m+":"+s+":"+ms);
		}
	}
}
