package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test02.User;
import test02.Usero;


@WebServlet("/servlet/Delete")
public class Delete extends HttpServlet{
	
	private String action; //��ʾɾ���û��Ķ���
	private Usero usero = new Usero();//�����߼���Ķ���
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//�ж϶���ִ��
		if(request.getParameter("action")!=null) {
			this.action = request.getParameter("action");
			if(action.equals("delete")) {//��ȡ����ɾ������
				if(deleteUser(request,response)) {
					//�ɹ��Ļ���ת��һ�������ɹ���ҳ��
					request.getRequestDispatcher("../success.jsp").forward(request, response);
				}else {
					request.getRequestDispatcher("../failed.jsp").forward(request, response);}
			}
		}
	}
	//ɾ���û��ķ���
	private boolean deleteUser(HttpServletRequest request, HttpServletResponse response) {
		 String email = request.getParameter("email");
		 System.out.print("Ҫ��ɾ��email�ǣ�"+email+"");
		 if(usero.delete(email)>0) {//����ֵ����0����ɾ���ɹ�
			 return true;
		 }else {
			 return false;
		 }
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}