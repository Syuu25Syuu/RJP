import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileWriter;


public class PushbuttongameServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException{
		//文字コード
		request.setCharacterEncoding("Windows-31J");
		
		//URLで送られてきた値を受け取る
		String cnt = request.getParameter("cnt");
		
		//書き込みーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー
		//テキストファイル指定
		File file = new File("C:\\gakuensaiRJP\\pushbuttonranking.txt");
		//書き込みFileWriter生成
		FileWriter filewriter = new FileWriter(file, true);
		//名前書き込み
		String name="そわだ";
		filewriter.write(name+",");
		//点数書き込み
		filewriter.write(cnt+"\n");
		//FileWriterクローズ
        filewriter.close();
		
		//読み込みーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー
		
		
		
		
		
		
		
		//JSP転送ーーーーーーーーーーーーーーーー-ーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー
		//値セット
		//request.setAttribute("aaa",aaa);
		//送る先のJSP指定
		//RequestDispatcher dispatcher=request.getRequestDispatcher("pushbuttonranking");
		//JSPに転送
		//dispatcher.forward(request,response);
	}
}

