package test04goods;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class Goodso {

	//��ѯgoods���е�������Ϣ���Ҵ���list����
	public ArrayList<Goods> getALL(){
		//Database database = new Database();
		//conn=database.getConn();
		//Connection conn = null;
		//Statement stmt = null;
		//ResultSet rs = null;
		ArrayList<Goods> list = new ArrayList<Goods>(); //list
		
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
			String sql = "SELECT * FROM goods;"; //��ѯ���ݿ�
			rs = stmt.executeQuery(sql);
			//д��list
			while(rs.next()) {
				Goods goods = new Goods();
				goods.setGoods_name(rs.getString("goods_name"));
				goods.setSeller(rs.getString("shop_name"));
				goods.setLinks(rs.getString("links"));
				goods.setImage(rs.getString("image"));
				goods.setID(rs.getInt("goods_id"));
				goods.setPrice(rs.getDouble("price"));
				list.add(goods); //��һ���û����뼯����
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
		String sql = "DELETE FROM goods WHERE goods_id="+ID+";";  //����emailɾ��ָ���û�
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
	
	public int update(Integer ID,Double zk){
		//Database database = new Database();
		//Connection conn = database.getConn();
		int flag=0;//UPDATE goods SET price = price * zk WHERE goods_id = ID;
		String sql = "UPDATE goods SET price = price * "+zk+" WHERE goods_id = "+ID+";";  //����emailɾ��ָ���û�
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
	
	public Goods getGoodsByID(Integer ID) {	
		//Database database = new Database();
		
		Goods goods = new Goods(); //�����汻�ҵ����û�
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
			String sql = "SELETE *FROM goods WHERE goods_id="+ID+";";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				goods.setGoods_name(rs.getString("goods_name"));
				goods.setSeller(rs.getString("shop_name"));
				goods.setLinks(rs.getString("links"));
				goods.setImage(rs.getString("image"));
				goods.setID(rs.getInt("goods_id"));
				goods.setPrice(rs.getDouble("price"));
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
		
        return goods;
	}
	
}
