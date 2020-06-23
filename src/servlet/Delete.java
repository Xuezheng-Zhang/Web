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
	
	private String action; //表示删除用户的动作
	private Usero usero = new Usero();//操作逻辑类的对象
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//判断动作执行
		if(request.getParameter("action")!=null) {
			this.action = request.getParameter("action");
			if(action.equals("delete")) {//获取到了删除操作
				if(deleteUser(request,response)) {
					//成功的话跳转到一个操作成功的页面
					request.getRequestDispatcher("../success.jsp").forward(request, response);
				}else {
					request.getRequestDispatcher("../failed.jsp").forward(request, response);}
			}
		}
	}
	//删除用户的方法
	private boolean deleteUser(HttpServletRequest request, HttpServletResponse response) {
		 String email = request.getParameter("email");
		 System.out.print("要被删的email是："+email+"");
		 if(usero.delete(email)>0) {//返回值大于0代表删除成功
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