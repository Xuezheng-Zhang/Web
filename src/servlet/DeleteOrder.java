package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test03order.Ordered;
import test03order.Orderedo;

@WebServlet("/servlet/DeleteOrder")
public class DeleteOrder extends HttpServlet{
	private String action; //��ʾɾ���û��Ķ���
	private Orderedo ordero=new Orderedo();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//�ж϶���ִ��
		if(request.getParameter("action")!=null) {
			this.action = request.getParameter("action");
			if(action.equals("delete")) {//��ȡ����ɾ������
				if(deleteOrder(request,response)) {
					//�ɹ��Ļ���ת��һ�������ɹ���ҳ��
					request.getRequestDispatcher("../success.jsp").forward(request, response);
				}else {
					request.getRequestDispatcher("../failed.jsp").forward(request, response);}
			}
		}
	}
	
	//ɾ���û��ķ���
		private boolean deleteOrder(HttpServletRequest request, HttpServletResponse response) {
			//request.getParameter("ID"); Integer.parseInt(req.getParameter("gender"));
			//Integer ID =(Integer)request.getAttribute("ID");
			Integer ID=Integer.parseInt(request.getParameter("ID"));
			 //email="123456";
			System.out.print(ID);
			 if(ordero.delete(ID)>0) {//����ֵ����0����ɾ���ɹ�
				 return true;
			 }else {
				 return false;
			 }
		}
}
