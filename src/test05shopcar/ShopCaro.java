package test05shopcar;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;


public class ShopCaro {
	
	//��ѯShopCar�������ݲ�����list����
	public ArrayList<ShopCar> getALL(String email){
		ArrayList<ShopCar> list = new ArrayList<ShopCar>(); //list
		
		try {
			Connection conn = null;
			Statement stmt =null; 
			ResultSet rs = null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/runoob?useSSL=false&serverTimezone=Hongkong&characterEncoding=UTF-8&autoReconnect=true";
			conn=DriverManager.getConnection(url,"root","123456");
			
			if(conn != null) {
				stmt = conn.createStatement();
				String sql = "SELECT * FROM shopcar WHERE buyer='"+email+"';"; //��ѯ���ݿ�
				rs = stmt.executeQuery(sql);
				//д��list
				while(rs.next()) {
					ShopCar shopcar = new ShopCar();
					shopcar.setGoods_id(rs.getInt("goods_id"));
					shopcar.setGoods_name(rs.getString("goods_name"));
					shopcar.setGoods_num(rs.getInt("goods_num"));
					shopcar.setPrice(rs.getDouble("price"));
					shopcar.setBuyer(rs.getString("buyer"));
					shopcar.setSeller(rs.getString("seller"));
					list.add(shopcar);
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
	
	//ɾ�����ﳵ����Ʒ
	public int deleteGoods(int goods_id) {
		int flag=0;
		String sql = "DELETE FROM shopcar WHERE goods_id='"+goods_id+"';";
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
	
}
