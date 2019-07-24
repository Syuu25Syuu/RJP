import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;

import scoretaker.ScoreSortTaker;
import scoretaker.ScoreTaker;

public class PushbuttongameServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		//�����R�[�h
		request.setCharacterEncoding("Windows-31J");
		//URL�ő����Ă����l���󂯎��
		String cnt = request.getParameter("cnt");
		//�������݁[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[
		//�e�L�X�g�t�@�C���w��
		File file = new File("pushbuttonscore.txt");
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
		//�\�[�g�O�̃f�[�^(�ŐV�̃f�[�^)�̓ǂݍ���
        ArrayList data=ScoreSortTaker.getScore("C:/gakuensaiRJP/txt/pushbuttonscore.txt");
		ArrayList names1=(ArrayList)data.get(0);
		ArrayList scores1=(ArrayList)data.get(1);
		
		String newestname=(String)names1.get(names1.size()-1);
		int newestscore=(int)scores1.get(scores1.size()-1);
		
		//�\�[�g��̃f�[�^�̓ǂݍ���
		data=ScoreTaker.scoreTake("C:/gakuensaiRJP/txt/pushbuttonscore.txt");
		ArrayList names2=(ArrayList)data.get(0);
		ArrayList scores2=(ArrayList)data.get(1);
		
		//���o�����f�[�^
		ArrayList<String> sortnames=new ArrayList<String>();
		ArrayList<Integer> sortscores=new ArrayList<Integer>();
		
		for(int i=0; 3>i; i++){
			sortnames.add((String)names2.get(i));
		}
		
		for(int i=0; 3>i; i++){
			sortscores.add((int)scores2.get(i));
		}
		
		sortnames.add(newestname);
		sortscores.add(newestscore);
		
		




		//JSP�]���[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[-�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[
		//�l�Z�b�g
		request.setAttribute("name",sortnames);
		request.setAttribute("score",sortscores);
		//������JSP�w��
		RequestDispatcher dispatcher=request.getRequestDispatcher("pushbuttonranking");
		//JSP�ɓ]��
		dispatcher.forward(request,response);
	}
}
