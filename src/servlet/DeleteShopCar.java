package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test05shopcar.ShopCar;
import test05shopcar.ShopCaro;


@WebServlet("/servlet/DeleteShopCar")
public class DeleteShopCar extends HttpServlet{
	
	private String action;
	private ShopCaro shopcaro = new ShopCaro();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(request.getParameter("action")!=null) {
			this.action = request.getParameter("action");
			if(action.equals("deleteshopcar")) {
				if(DeleteShopCar1(request,response)) {
					request.getRequestDispatcher("../success.jsp").forward(request, response);
				}else {
					request.getRequestDispatcher("../failed.jsp").forward(request, response);}
			}
		}
	}
	
	public boolean DeleteShopCar1(HttpServletRequest request, HttpServletResponse response) {
		String goods_id  = request.getParameter("goods_id");
		if(shopcaro.deleteGoods(Integer.parseInt(goods_id))>0) {//goods_id强制转换为int
			return true;
		}else {
			return false;
		}
	}
}