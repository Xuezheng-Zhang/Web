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
	
	//��ѯUser���е�������Ϣ���Ҵ���list����
	public ArrayList<User> getALL(){
		//Database database = new Database();
		//conn=database.getConn();
		//Connection conn = null;
		//Statement stmt = null;
		//ResultSet rs = null;
		ArrayList<User> list = new ArrayList<User>(); //list
		
		//�������ݿ�
		try {
			Connection conn = null;
			Statement stmt =null; 
			ResultSet rs = null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/RUNOOB?useSSL=false&serverTimezone=Hongkong&characterEncoding=UTF-8&autoReconnect=true";
			conn=DriverManager.getConnection(url,"root","123456");
			
			if(conn!=null) {
			stmt = conn.createStatement();
			String sql = "SELECT * FROM user;"; //��ѯ���ݿ�
			rs = stmt.executeQuery(sql);
			//д��list
			while(rs.next()) {
				User user = new User();
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				list.add(user); //��һ���û����뼯����
			}
	        stmt.close();
	        conn.close();
			}else {
				System.out.print("����ʧ�ܣ�"); 
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
		String sql = "DELETE FROM user WHERE email='"+email+"';";  //����emailɾ��ָ���û�
		PreparedStatement pstmt;
		try {
			Statement stmt =null;
			Connection conn = null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/RUNOOB?useSSL=false&serverTimezone=Hongkong&characterEncoding=UTF-8&autoReconnect=true";
			conn=DriverManager.getConnection(url,"root","123456");
			
			if(conn!=null) {
			System.out.println("���ݿ����ӳɹ���\n");
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			flag = pstmt.executeUpdate();
			
			//stmt = conn.createStatement();
			//stmt.executeUpdate(sql);
			//System.out.println("�ɹ��޸�");
			//flag=1;
			System.out.println("�ɹ��޸���"+flag+"��");
			pstmt.close();
			//stmt.close();
			conn.close();
			}else{
				System.out.print("����ʧ�ܣ�");  
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
		
		User user = new User(); //�����汻�ҵ����û�
		try 
		{
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/RUNOOB?useSSL=false&serverTimezone=Hongkong&characterEncoding=UTF-8&autoReconnect=true";
			conn=DriverManager.getConnection(url,"root","123456");
			if(conn!=null) {
			System.out.println("���ݿ����ӳɹ���\n");
			
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
				System.out.print("����ʧ�ܣ�"); 
			}
		}catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
	        e.printStackTrace();
	    }
		
        return user;
	}
	
}
