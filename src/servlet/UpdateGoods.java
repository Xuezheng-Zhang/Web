package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test03order.Orderedo;
import test04goods.Goods;
import test04goods.Goodso;

@WebServlet("/servlet/UpdateGoods")
public class UpdateGoods extends HttpServlet{
	private String action; //表示删除用户的动作
	private Goodso goodso=new Goodso();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//判断动作执行
		if(request.getParameter("action")!=null) {
			this.action = request.getParameter("action");
			if(action.equals("update")) {//获取到了删除操作
				if(updateGoods(request,response)) {
					//成功的话跳转到一个操作成功的页面
					request.getRequestDispatcher("../success.jsp").forward(request, response);
				}else {
					request.getRequestDispatcher("../failed.jsp").forward(request, response);}
			}
		}
	}
	//更新价格的方法
	private boolean updateGoods(HttpServletRequest request, HttpServletResponse response) {
		//request.getParameter("ID"); Integer.parseInt(req.getParameter("gender"));
		//Integer ID =(Integer)request.getAttribute("ID");
		Integer ID=Integer.parseInt(request.getParameter("ID"));
		Double zk=Double.parseDouble(request.getParameter("zhekou"));
		 //email="123456";
		System.out.print(ID);
		System.out.print(zk);
		if(goodso.update(ID,zk)>0) {//返回值大于0代表删除成功
			 return true;
		}else {
			 return false;
        }
	}

}