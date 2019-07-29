import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;

import scoretaker.ScoreTaker;
import requiredscoretaker.NumberfindingRequiredScoreTaker;

public class NumberfindinggameServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		//文字コード
		request.setCharacterEncoding("Windows-31J");
		//URLで送られてきた値を受け取る
		String time = request.getParameter("time");
		String name = request.getParameter("name");
		//書き込みーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー
		//テキストファイル指定
		File file = new File("C:/gakuensaiRJP/txt/numberfindingscore.txt");
		//書き込みFileWriter生成
		FileWriter filewriter = new FileWriter(file, true);
		//名前書き込み
		filewriter.write(name+",");
		//コロンを空文字に変換
		time=time.replace(":","");
		//点数書き込み
		filewriter.write(time+"\n");
		//FileWriterクローズ
        filewriter.close();
        //読み込みーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー
		//ソート前のデータ(最新のデータ)の読み込み
        /*ArrayList data=ScoreTaker.takeScore("C:/gakuensaiRJP/txt/pushbuttonscore.txt");
		ArrayList names1=(ArrayList)data.get(0);
		ArrayList scores1=(ArrayList)data.get(1);
		
		String newestname=(String)names1.get(names1.size()-1);
		int newestscore=(int)scores1.get(scores1.size()-1);
		
		//ソート後のデータの読み込み
		data=ScoreSortTaker.takeScore("C:/gakuensaiRJP/txt/pushbuttonscore.txt");
		ArrayList names2=(ArrayList)data.get(0);
		ArrayList scores2=(ArrayList)data.get(1);
		
		//抽出したデータ
		ArrayList<String> sortnames=new ArrayList<String>();
		ArrayList<Integer> sortscores=new ArrayList<Integer>();
		
		for(int i=1; 3>=i; i++){
			sortnames.add((String)names2.get(names2.size()-i));
		}
		
		for(int i=1; 3>=i; i++){
			sortscores.add((int)scores2.get(scores2.size()-i));
		}
		
		sortnames.add(newestname);
		sortscores.add(newestscore);
		
		*/
		
		ArrayList data=NumberfindingRequiredScoreTaker.takeRequiredScore("C:/gakuensaiRJP/txt/numberfindingscore.txt");
		ArrayList sortnames=(ArrayList)data.get(0);
		ArrayList sortscores=(ArrayList)data.get(1);




		//JSP転送ーーーーーーーーーーーーーーーー-ーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー
		//値セット
		request.setAttribute("name",sortnames);
		request.setAttribute("score",sortscores);
		//送る先のJSP指定
		RequestDispatcher dispatcher=request.getRequestDispatcher("numberfindingranking");
		//JSPに転送
		dispatcher.forward(request,response);
		
	}
}
