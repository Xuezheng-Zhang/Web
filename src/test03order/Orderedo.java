package test03order;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class Orderedo {

	//��ѯOrder���е�������Ϣ���Ҵ���list����
	public ArrayList<Ordered> getALL(){
		//Database database = new Database();
		//conn=database.getConn();
		//Connection conn = null;
		//Statement stmt = null;
		//ResultSet rs = null;
		ArrayList<Ordered> list = new ArrayList<Ordered>(); //list
		
		//�������ݿ�
		try {
			Connection conn = null;
			Statement stmt =null; 
			ResultSet rs = null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/runoob?useSSL=false&serverTimezone=Hongkong&characterEncoding=UTF-8&autoReconnect=true";
			conn=DriverManager.getConnection(url,"root","123456");
			
			if(conn!=null) {
			stmt = conn.createStatement();
			String sql = "SELECT * FROM ordered;"; //��ѯ���ݿ�
			rs = stmt.executeQuery(sql);
			//д��list
			while(rs.next()) {
				Ordered order = new Ordered();
				order.setGoods_name(rs.getString("��Ʒ����"));
				order.setSeller(rs.getString("����"));
				order.setBuyer(rs.getString("���"));
				order.setID(rs.getInt("������"));
				order.setNum(rs.getInt("��Ʒ����"));
				order.setPrice(rs.getDouble("��Ʒ����"));
				list.add(order); //��һ���û����뼯����
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
	
	public int delete(Integer ID){
		//Database database = new Database();
		//Connection conn = database.getConn();
		int flag=0;
		String sql = "DELETE FROM ordered WHERE ������="+ID+";";  //����emailɾ��ָ���û�
		PreparedStatement pstmt;
		try {
			Statement stmt =null;
			Connection conn = null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/runoob?useSSL=false&serverTimezone=Hongkong&characterEncoding=UTF-8&autoReconnect=true";
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
	
	public Ordered getOrderByID(Integer ID) {	
		//Database database = new Database();
		
		Ordered order = new Ordered(); //�����汻�ҵ����û�
		try 
		{
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/runoob?useSSL=false&serverTimezone=Hongkong&characterEncoding=UTF-8&autoReconnect=true";
			conn=DriverManager.getConnection(url,"root","123456");
			if(conn!=null) {
			System.out.println("���ݿ����ӳɹ���\n");
			
			stmt = conn.createStatement();
			String sql = "SELETE *FROM ordered WHERE ������="+ID+";";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				order.setGoods_name(rs.getString("��Ʒ����"));
				order.setSeller(rs.getString("����"));
				order.setBuyer(rs.getString("���"));
				order.setID(rs.getInt("������"));
				order.setNum(rs.getInt("��Ʒ����"));
				order.setPrice(rs.getDouble("��Ʒ����"));
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
		
        return order;
	}
	
}
