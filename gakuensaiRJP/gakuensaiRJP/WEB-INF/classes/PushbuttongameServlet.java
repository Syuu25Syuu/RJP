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
		//�����R�[�h
		request.setCharacterEncoding("Windows-31J");
		
		//URL�ő����Ă����l���󂯎��
		String cnt = request.getParameter("cnt");
		
		//�������݁[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[
		//�e�L�X�g�t�@�C���w��
		File file = new File("C:\\gakuensaiRJP\\pushbuttonranking.txt");
		//��������FileWriter����
		FileWriter filewriter = new FileWriter(file, true);
		//���O��������
		String name="���킾";
		filewriter.write(name+",");
		//�_����������
		filewriter.write(cnt+"\n");
		//FileWriter�N���[�Y
        filewriter.close();
		
		//�ǂݍ��݁[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[
		
		
		
		
		
		
		
		//JSP�]���[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[-�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[
		//�l�Z�b�g
		//request.setAttribute("aaa",aaa);
		//������JSP�w��
		//RequestDispatcher dispatcher=request.getRequestDispatcher("pushbuttonranking");
		//JSP�ɓ]��
		//dispatcher.forward(request,response);
	}
}

