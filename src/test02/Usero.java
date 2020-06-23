package test02;

//import test02.Database;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class Usero {
	
	//查询User表中的所有信息并且存在list表中
	public ArrayList<User> getALL(){
		//Database database = new Database();
		//conn=database.getConn();
		//Connection conn = null;
		//Statement stmt = null;
		//ResultSet rs = null;
		ArrayList<User> list = new ArrayList<User>(); //list
		
		//连接数据库
		try {
			Connection conn = null;
			Statement stmt =null; 
			ResultSet rs = null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/RUNOOB?useSSL=false&serverTimezone=Hongkong&characterEncoding=UTF-8&autoReconnect=true";
			conn=DriverManager.getConnection(url,"root","123456");
			
			if(conn!=null) {
			stmt = conn.createStatement();
			String sql = "SELECT * FROM user;"; //查询数据库
			rs = stmt.executeQuery(sql);
			//写入list
			while(rs.next()) {
				User user = new User();
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				list.add(user); //把一名用户放入集合中
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


	public int delete(String email){
		//Database database = new Database();
		//Connection conn = database.getConn();
		int flag=0;
		String sql = "DELETE FROM user WHERE email='"+email+"';";  //根据email删除指定用户
		PreparedStatement pstmt;
		try {
			Statement stmt =null;
			Connection conn = null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/RUNOOB?useSSL=false&serverTimezone=Hongkong&characterEncoding=UTF-8&autoReconnect=true";
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
	
	public User getUserByEmail(String email) {	
		//Database database = new Database();
		
		User user = new User(); //用来存被找到的用户
		try 
		{
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/RUNOOB?useSSL=false&serverTimezone=Hongkong&characterEncoding=UTF-8&autoReconnect=true";
			conn=DriverManager.getConnection(url,"root","123456");
			if(conn!=null) {
			System.out.println("数据库连接成功！\n");
			
			stmt = conn.createStatement();
			String sql = "SELECT *FROM user WHERE email='"+email+"';";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
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
		
        return user;
	}
	
}
