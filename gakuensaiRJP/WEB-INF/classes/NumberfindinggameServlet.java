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
		//�����R�[�h
		request.setCharacterEncoding("Windows-31J");
		//URL�ő����Ă����l���󂯎��
		String time = request.getParameter("time");
		String name = request.getParameter("name");
		//�������݁[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[
		//�e�L�X�g�t�@�C���w��
		File file = new File("C:/gakuensaiRJP/txt/numberfindingscore.txt");
		//��������FileWriter����
		FileWriter filewriter = new FileWriter(file, true);
		//���O��������
		filewriter.write(name+",");
		//�R�������󕶎��ɕϊ�
		time=time.replace(":","");
		//�_����������
		filewriter.write(time+"\n");
		//FileWriter�N���[�Y
        filewriter.close();
        //�ǂݍ��݁[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[
		//�\�[�g�O�̃f�[�^(�ŐV�̃f�[�^)�̓ǂݍ���
        /*ArrayList data=ScoreTaker.takeScore("C:/gakuensaiRJP/txt/pushbuttonscore.txt");
		ArrayList names1=(ArrayList)data.get(0);
		ArrayList scores1=(ArrayList)data.get(1);
		
		String newestname=(String)names1.get(names1.size()-1);
		int newestscore=(int)scores1.get(scores1.size()-1);
		
		//�\�[�g��̃f�[�^�̓ǂݍ���
		data=ScoreSortTaker.takeScore("C:/gakuensaiRJP/txt/pushbuttonscore.txt");
		ArrayList names2=(ArrayList)data.get(0);
		ArrayList scores2=(ArrayList)data.get(1);
		
		//���o�����f�[�^
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




		//JSP�]���[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[-�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[
		//�l�Z�b�g
		request.setAttribute("name",sortnames);
		request.setAttribute("score",sortscores);
		//������JSP�w��
		RequestDispatcher dispatcher=request.getRequestDispatcher("numberfindingranking");
		//JSP�ɓ]��
		dispatcher.forward(request,response);
		
	}
}
