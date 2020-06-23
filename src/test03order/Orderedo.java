package test03order;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class Orderedo {

	//查询Order表中的所有信息并且存在list表中
	public ArrayList<Ordered> getALL(){
		//Database database = new Database();
		//conn=database.getConn();
		//Connection conn = null;
		//Statement stmt = null;
		//ResultSet rs = null;
		ArrayList<Ordered> list = new ArrayList<Ordered>(); //list
		
		//连接数据库
		try {
			Connection conn = null;
			Statement stmt =null; 
			ResultSet rs = null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/runoob?useSSL=false&serverTimezone=Hongkong&characterEncoding=UTF-8&autoReconnect=true";
			conn=DriverManager.getConnection(url,"root","123456");
			
			if(conn!=null) {
			stmt = conn.createStatement();
			String sql = "SELECT * FROM ordered;"; //查询数据库
			rs = stmt.executeQuery(sql);
			//写入list
			while(rs.next()) {
				Ordered order = new Ordered();
				order.setGoods_name(rs.getString("物品名称"));
				order.setSeller(rs.getString("卖家"));
				order.setBuyer(rs.getString("买家"));
				order.setID(rs.getInt("订单号"));
				order.setNum(rs.getInt("物品数量"));
				order.setPrice(rs.getDouble("物品单价"));
				list.add(order); //把一名用户放入集合中
			}
	        stmt.close();
	        conn.close();
			}else {
				System.out.print("连接失败！"); 
			}
	        
		}catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
		
		return list;
	}
	
	public int delete(Integer ID){
		//Database database = new Database();
		//Connection conn = database.getConn();
		int flag=0;
		String sql = "DELETE FROM ordered WHERE 订单号="+ID+";";  //根据email删除指定用户
		PreparedStatement pstmt;
		try {
			Statement stmt =null;
			Connection conn = null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/runoob?useSSL=false&serverTimezone=Hongkong&characterEncoding=UTF-8&autoReconnect=true";
			conn=DriverManager.getConnection(url,"root","123456");
			
			if(conn!=null) {
			System.out.println("数据库连接成功！\n");
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			flag = pstmt.executeUpdate();
			
			//stmt = conn.createStatement();
			//stmt.executeUpdate(sql);
			//System.out.println("成功修改");
			//flag=1;
			System.out.println("成功修改了"+flag+"条");
			pstmt.close();
			//stmt.close();
			conn.close();
			}else{
				System.out.print("连接失败！");  
			}
		}catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
	        e.printStackTrace();
	    }
		return flag;
	}
	
	public Ordered getOrderByID(Integer ID) {	
		//Database database = new Database();
		
		Ordered order = new Ordered(); //用来存被找到的用户
		try 
		{
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/runoob?useSSL=false&serverTimezone=Hongkong&characterEncoding=UTF-8&autoReconnect=true";
			conn=DriverManager.getConnection(url,"root","123456");
			if(conn!=null) {
			System.out.println("数据库连接成功！\n");
			
			stmt = conn.createStatement();
			String sql = "SELETE *FROM ordered WHERE 订单号="+ID+";";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				order.setGoods_name(rs.getString("物品名称"));
				order.setSeller(rs.getString("卖家"));
				order.setBuyer(rs.getString("买家"));
				order.setID(rs.getInt("订单号"));
				order.setNum(rs.getInt("物品数量"));
				order.setPrice(rs.getDouble("物品单价"));
			}	
			
	        stmt.close();
	        conn.close();
			}else {
				System.out.print("连接失败！"); 
			}
		}catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
	        e.printStackTrace();
	    }
		
        return order;
	}
	
}
