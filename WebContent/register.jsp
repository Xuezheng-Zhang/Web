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
		<title>买家注册</title>
	</head>
	<link  rel="stylesheet" href="default.css" id="changelink" />
	
	
	<body>
		
	<%   
        try {  
        	request.setCharacterEncoding("utf-8");
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	String url = "jdbc:mysql://localhost:3306/runoob?useSSL=false&serverTimezone=Hongkong&characterEncoding=UTF-8&autoReconnect=true";
            String username="root" ;
        	String password_base="123456";
            Connection conn = DriverManager.getConnection(url, username, password_base);  //连接状态  //连接状态
            
            String name=request.getParameter("name");
            String email=request.getParameter("email");
            String passwords=request.getParameter("password");
            
            if(conn != null){             
            	 Statement stmt1 = null;  
                 ResultSet rs1 = null;  
                 String sql1 = "SELECT *FROM user where email='"+email+"';";  //查询语句
                 stmt1 = conn.createStatement();  
                 rs1 = stmt1.executeQuery(sql1); //查询邮箱是否已注册
                 if(rs1.next())//已经注册/转回注册界面
                 {
             		out.println("注册失败! 3秒后自动跳转...");
            		response.setHeader("refresh","2;URL=test.html");
                  	rs1.close();
                	 
                 }
                 else
                 {
                	 Statement stmt2 = null;  //数据库添加user
                	 String sql2 = "INSERT INTO user (name,email,password) VALUES ('"+name+"','"+email+"','"+passwords+"');";  //查询语句
                	 stmt2 = conn.createStatement();
                	 stmt2.executeUpdate(sql2); 
                	//out.print("<script LANGUAGE='javascript'>alert('注册成功！');</script>");
                 	session.setAttribute("email",email);
                 	session.setAttribute("password",passwords);
                 	System.out.println(passwords);
 					conn.close();
 					out.println("注册成功! 3秒后自动跳转...");
 					response.setHeader("refresh","2;URL=signin1.html");
                 }
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