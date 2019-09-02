import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;

//import scoretaker.ScoreSortTaker;
//import scoretaker.ScoreTaker;

import requiredscoretaker.PushbuttonRequiredScoreTaker;

public class PushbuttongameServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		//文字コード
		request.setCharacterEncoding("Windows-31J");
		//URLで送られてきた値を受け取る
		String cnt = request.getParameter("cnt");
		//書き込みーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー
		//テキストファイル指定
		File file = new File("C:/gakuensaiRJP/txt/pushbuttonscore.txt");
		//書き込みFileWriter生成
		FileWriter filewriter = new FileWriter(file, true);
		//名前書き込み
		String name=request.getParameter("name");
		//サニタイジング
		name = name.replace("昴ｏ", "&amp;");
		name = name.replace("<", "&lt;");
		name = name.replace(">", "&gt;");
		//------カンマの置き換え--------
		name = name.replace("," , "縺");
		filewriter.write(name+",");
		//点数書き込み
		filewriter.write(cnt+"\n");
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
		ArrayList data=PushbuttonRequiredScoreTaker.takeRequiredScore("C:/gakuensaiRJP/txt/pushbuttonscore.txt");
		ArrayList sortnames=(ArrayList)data.get(0);
		ArrayList sortscores=(ArrayList)data.get(1);


		//JSP転送ーーーーーーーーーーーーーーーー-ーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー
		//値セット
		request.setAttribute("name",sortnames);
		request.setAttribute("score",sortscores);
		//送る先のJSP指定
		RequestDispatcher dispatcher=request.getRequestDispatcher("pushbuttonranking");
		//JSPに転送
		dispatcher.forward(request,response);
	}
}
