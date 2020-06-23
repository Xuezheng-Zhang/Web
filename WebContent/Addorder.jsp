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
		<title>购买</title>
	</head>
	<link  rel="stylesheet" href="default.css" id="changelink" />
	
	
	<body>
		
	<%   
		String email =(String)session.getAttribute("email");
        //String email="asasas";
	try {  
        	request.setCharacterEncoding("utf-8");
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	String url = "jdbc:mysql://localhost:3306/runoob?useSSL=false&serverTimezone=Hongkong&characterEncoding=UTF-8&autoReconnect=true";
            String username="root" ;
        	String password="123456";
            Connection conn = DriverManager.getConnection(url, username, password);  //连接状态  //连接状态
            
            String gname=request.getParameter("gname");
            String seller=request.getParameter("seller");
            String num=request.getParameter("num");
            String price=request.getParameter("price");
            String links=request.getParameter("links");
            //email="asassa";
            
            
            if(conn != null){             
            	 Statement stmt1 = null;  
                   //INSERT INTO table_name (列1, 列2,...) VALUES (值1, 值2,....)
                 String sql1 = "INSERT INTO ordered (物品名称,物品数量,物品单价,买家,卖家) VALUES ('"+gname+"',"+num+","+price+",'"+email+"','"+seller+"');"; //插值语句
                 stmt1 = conn.createStatement();//加入购物车表
                 stmt1.executeUpdate(sql1); 
                 //out.print("<script LANGUAGE='javascript'>alert('加入成功');</script>");
                 conn.close();
                 %>
               	<jsp:forward page="checkorder.jsp"></jsp:forward><%//调回购物主页
            }
            else{  
                out.print("连接失败！");  
            }  
        }catch (Exception e) {        
            out.print("数据库连接异常！");  
        }  
	%>
	</body>
	
</html>