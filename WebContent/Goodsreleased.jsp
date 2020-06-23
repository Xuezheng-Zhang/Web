<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>商品发布</title>
	</head>
	<link  rel="stylesheet" href="default.css" id="changelink" />
	
	
	<body>
		
	<%   
	
        try {  
        	request.setCharacterEncoding("utf-8");
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	String url = "jdbc:mysql://localhost:3306/runoob?useSSL=false&serverTimezone=Hongkong&characterEncoding=UTF-8&autoReconnect=true";
            String username="root" ;
        	String password="123456";
            Connection conn = DriverManager.getConnection(url, username, password);  //连接状态  //连接状态
            
            String name=request.getParameter("name");
            String seller=request.getParameter("seller");
            String image=request.getParameter("image");
            String price=request.getParameter("price");
            String links="nk.html";
            
            if(conn != null){             
            	 Statement stmt1 = null;  
                   //INSERT INTO table_name (列1, 列2,...) VALUES (值1, 值2,....)
                 String sql1 = "INSERT INTO goods (goods_name,price,shop_name,links,image) VALUES ('"+name+"',"+price+",'"+seller+"','"+links+"','"+image+"');"; //插值语句
                 stmt1 = conn.createStatement();
                 stmt1.executeUpdate(sql1); //查询邮箱是否已注册
                 out.print("<script LANGUAGE='javascript'>alert('发布成功！');</script>");
                 conn.close();
                 %>
              	<jsp:forward page="Search.jsp"></jsp:forward><%//调回购物主页
            }
            else{  
                out.print("连接失败！");  
            }  
        }catch (Exception e) {        
            out.print("数据库连接异常！");  
        }  
	%>
	</body>
	<script type="text/javascript" src="la3.js"> </script>
</html>