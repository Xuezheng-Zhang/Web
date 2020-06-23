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
		<title>购物车</title>
		<style type="text/css">
* {
box-sizing: border-box;
}
body {
margin: 0;
padding: 0;
font: 16px/20px microsft yahei;
}
.wrap {
width: 100%;
height: 100%;
padding: 10% 0;
position: fixed;
opacity: 0.8;
background: linear-gradient(to bottom right,#000000, #656565);
background: -webkit-linear-gradient(to bottom right,#50a3a2,#53e3a6);
}
.container {
width: 60%;
margin: 0 auto;
	
}
        .container h1 {
text-align: center;
color: #FFFFFF;
font-weight: 500;
}
.container input {
width: 320px;
display: block;
height: 36px;
border: 0;
outline: 0;
padding: 6px 10px;
line-height: 24px;
margin: 32px auto;
-webkit-transition: all 0s ease-in 0.1ms;
-moz-transition: all 0s ease-in 0.1ms;
transition: all 0s ease-in 0.1ms;
}
.container input[type="text"] , .container input[type="password"]  {
background-color: #FFFFFF;
font-size: 16px;
color: #50a3a2;
}
.container input[type='submit'] {
font-size: 16px;
letter-spacing: 2px;
color: #666666;
background-color: #FFFFFF;
}
.container input:focus {
width: 400px;
}
.container input[type='submit']:hover {
cursor: pointer;
width: 400px;
}
.to_login{
color: #a7c4c9;
}
.text{
color: #e2dfe4;
}
.wrap ul {
position: absolute;
top: 0;
left: 0;
width: 100%;
height: 100%;
z-index: -20;
}
.wrap ul li {
list-style-type: none;
display: block;
position: absolute;
bottom: -120px;
width: 15px;
height: 15px;
z-index: -8;
border-radius: 50%;
background-color:rgba(255, 255, 255, 0.15);
animotion: square 25s infinite;
-webkit-animation: square 25s infinite;
}
.wrap ul li:nth-child(1) {
left: 0;
animation-duration: 10s;
-moz-animation-duration: 10s;
-o-animation-duration: 10s;
-webkit-animation-duration: 10s;
}
.wrap ul li:nth-child(2) {
width: 40px;
height: 40px;
left: 10%;
animation-duration: 15s;
-moz-animation-duration: 15s;
-o-animation-duration: 15s;
-webkit-animation-duration: 11s;
}
.wrap ul li:nth-child(3) {
left: 20%;
width: 25px;
height: 25px;
animation-duration: 12s;
-moz-animation-duration: 12s;
-o-animation-duration: 12s;
-webkit-animation-duration: 12s;
}
.wrap ul li:nth-child(4) {
width: 50px;
height: 50px;
left: 30%;
-webkit-animation-delay: 3s;
-moz-animation-delay: 3s;
-o-animation-delay: 3s;
animation-delay: 3s;
animation-duration: 12s;
-moz-animation-duration: 12s;
-o-animation-duration: 12s;
-webkit-animation-duration: 12s;
}
.wrap ul li:nth-child(5) {
width: 60px;
height: 60px;
left: 40%;
animation-duration: 10s;
-moz-animation-duration: 10s;
-o-animation-duration: 10s;
-webkit-animation-duration: 10s;
}
.wrap ul li:nth-child(6) {
width: 75px;
height: 75px;
left: 50%;
-webkit-animation-delay: 7s;
-moz-animation-delay: 7s;
-o-animation-delay: 7s;
animation-delay: 7s;
}
.wrap ul li:nth-child(7) {
left: 60%;
width: 30px;
height: 30px;
animation-duration: 8s;
-moz-animation-duration: 8s;
-o-animation-duration: 8s;
-webkit-animation-duration: 8s;
}
.wrap ul li:nth-child(8) {
width: 90px;
height: 90px;
left: 70%;
-webkit-animation-delay: 4s;
-moz-animation-delay: 4s;
-o-animation-delay: 4s;
animation-delay: 4s;
}
.wrap ul li:nth-child(9) {
width: 50px;
height: 50px;
left: 80%;
animation-duration: 20s;
-moz-animation-duration: 20s;
-o-animation-duration: 20s;
-webkit-animation-duration: 20s;
}
.wrap ul li:nth-child(10) {
width: 75px;
height: 75px;
left: 90%;
-webkit-animation-delay: 6s;
-moz-animation-delay: 6s;
-o-animation-delay: 6s;
animation-delay: 6s;
animation-duration: 30s;
-moz-animation-duration: 30s;
-o-animation-duration: 30s;
-webkit-animation-duration: 30s;
}
@keyframes square {
0% {
-webkit-transform: translateY(0);
transform: translateY(0)
}
100% {
bottom: 400px;
-webkit-transform: translateY(-500);
transform: translateY(-500)
}
}
@-webkit-keyframes square {
0% {
-webkit-transform: translateY(0);
transform: translateY(0)
}
100% {
bottom: 400px;
-webkit-transform: translateY(-500);
transform: translateY(-500)
}
}
	
	.s1{
		width: 300px;
		height: 200px;
		background-color:#000000;
		margin-top: 40px;
		float: left;
		box-shadow: red 0px 0px 10px;
		text-align:center;
		font-size: 28px;
		padding-top: 70px;
		cursor: pointer;
		
	}
	a:hover
	{
		color: red;
	}
	.s2{
		width: 300px;
		height: 200px;
		background-color:#000000;
		margin-left: 20px;
		margin-top: 40px;
		float: left;
		text-align:center;
		font-size: 28px;
		padding-top: 70px;
		box-shadow: red 0px 0px 10px;
		cursor: pointer;
	}
	.s3{
		width: 300px;
		height: 200px;
		background-color:#000000;
		margin-left: 20px;
		text-align:center;
		margin-top: 40px;
		font-size: 28px;
		padding-top: 70px;
		float: left;
		box-shadow: red 0px 0px 10px;
		cursor: pointer;
	}
	.hh{
		margin-bottom: 20px;
	}
	a
	{
		text-decoration: none;
		color: aliceblue;
	}
	</style>
	
		
	</head>
	<link  rel="stylesheet" href="default.css" id="changelink" />
	
	
	
	<body style="color:white">
	<div class="wrap" style="text-align: center">
	<%   
	String email =(String)session.getAttribute("email");
	//String email ="1131288763@qq.com";
        try {  
        	request.setCharacterEncoding("utf-8");
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	String url = "jdbc:mysql://localhost:3306/runoob?useSSL=false&serverTimezone=Hongkong&useUnicode=true&characterEncoding=UTF-8&autoReconnect=true";
        	String username="root" ;
        	String password="123456";
            Connection conn = DriverManager.getConnection(url, username, password);  //连接状态  //连接状态
            
            if(conn != null){             
            	 Statement stmt1 = null;  
                 ResultSet rs1 = null;  //SELECT * FROM [user] WHERE u_name LIKE '%三%'
                 String sql1 = "SELECT *FROM ordered WHERE 买家='"+email+"';";  //查询语句
                 stmt1 = conn.createStatement();  
                 rs1 = stmt1.executeQuery(sql1); //找到输出商品信息
        		 out.print("您购买的物品订单:");
            	 out.print("<br/>");
            	  while(rs1.next()){
            		 out.println("<table align='center'><tr>");
            		 out.println("<td>"+rs1.getInt("订单号")+"</td>");
            		 out.println("<td>"+rs1.getString("物品名称")+"</td>");
            		 out.println("<td>"+rs1.getInt("物品数量")+"</td>");
            		 out.println("<td>"+rs1.getDouble("物品单价")+"</td>");
            		 out.println("<td>"+rs1.getString("卖家")+"</td>");
            		 out.println("</tr></table>");
            		 out.print("<br/>");      
            	}//while循环结束
            	 rs1.close();
            	  
                 ResultSet rs2 = null;
                 sql1 = "SELECT *FROM ordered WHERE 卖家='"+email+"';";  //查询语句
                 stmt1 = conn.createStatement();  
                 rs2 = stmt1.executeQuery(sql1); //找到输出商品信息
        		 out.print("您出售的物品订单:");
            	 out.print("<br/>");
            	 while(rs2.next()){
            		 out.println("<table align='center'><tr> ");
            		 out.println("<td>"+rs2.getInt("订单号")+"</td>");
            		 out.println("<td>"+rs2.getString("物品名称")+"</td>");
            		 out.println("<td>"+rs2.getInt("物品数量")+"</td>");
            		 out.println("<td>"+rs2.getDouble("物品单价")+"</td>");
            		 out.println("<td>"+rs2.getString("买家")+"</td>");
            		 out.println("</tr></table>");
            		 out.print("<br/>");      
            	 }//while循环结束
            	
            	 rs2.close();
            	 
            	 conn.close(); 
 				
            }
            else{  
                out.print("连接失败！");  
            }  
        }catch (Exception e) {        
            out.print("数据库连接异常！");  
        }  
	%>
	</div>
	</body>
	<script type="text/javascript" src="la3.js"> </script>
</html>