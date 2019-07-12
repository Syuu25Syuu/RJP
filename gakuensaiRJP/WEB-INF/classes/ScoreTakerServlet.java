package classes;

import scoretaker.ScoreSortTaker;
import scoretaker.ScoreTaker;

public class ScoreTakerServlet {
	public static void main(String[] args) {
		System.out.println(ScoreSortTaker.getScore("c:/TEST/test.txt"));
		System.out.println(ScoreTaker.scoreTake("c:/TEST/test.txt"));
	}
}
