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
		<meta charset="UTF-8">
		<title>买家登录</title>
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
            
            String email=request.getParameter("email");
            String passwords=request.getParameter("password");
            if(conn != null){             
            	 Statement stmt = null;  
                 ResultSet rs = null;  
                 String sql = "SELECT *FROM user where email='"+email+"'and password='"+passwords+"';";  //查询语句
                 stmt = conn.createStatement();  
                 rs = stmt.executeQuery(sql); 
                 if(rs.next())
                 {
                 	out.print("<script LANGUAGE='javascript'>alert('登陆成功！');</script>");
                	session.setAttribute("email",email);
                	session.setAttribute("passwords",passwords);
                	System.out.println(passwords);
                	rs.close();
					conn.close();
					%>
                	<jsp:forward page="Search.jsp"></jsp:forward>
					<%
				}
                 else
                 {
                	out.println("密码错误! 3秒后请重新输入...");
         			response.setHeader("refresh","2;URL=signin1.html");
                 	rs.close();
                 	conn.close();
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
	<script type="text/javascript" src="la3.js"> </script>
</html>