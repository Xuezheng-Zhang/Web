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
		<link rel="stylesheet" href="css-1/物品展示.css">
		<title>搜索商品</title>
		<style type="text/css">
			a:link{color:black;}
			a:visited{color: black;}
			a:hover{color: darkgrey}
			a:active{color: red;}
		</style>
	</head>
	<body>
		
		<!------------ 导航1------------->
<div id="nav">
<!-- 1.1右侧导航 -->
<ul class="rightNav">
<li>
<a href="signin1.html">[登录]</a>
，
<a href="test.html">[注册，有惊喜]</a>
</li>
<li>
<b></b>
<a href="administrator.jsp">管理员</a>
</li>
<li>
<b></b>
<a href="shopcar.jsp">查看购物车</a>
</li>
<li>
<b></b>
<a href="#">联系客服</a>
</li>
</ul>
<!-- 1.2左侧导航 -->
<ol class="leftNav">
<li class="address">
<span>上海</span> <!-- 用于修改显示地区信息 -->
<!-- 左侧导航的三角标 -->
<u></u>
<!-- 地区下拉列表 -->
<ul class="select">
<li>北京</li>
<li>广州</li>
<li>深圳</li>
</ul>
</li>
<li>618购物节</li>
	<li>千万优惠等你来拿！</li>
</ol>
</div>

<!---------导航2------------->
	
	<ul class="nav">
	<li class="logo">LOGO</li>
	<li class="famaliy"><a href="Search.jsp"> 网站首页</a></li>
	<li class="a"><a href="person_page.html">小组介绍</a></li>
	<li class="a"><a href="Goodsreleasedln.html">物品发布</a></li>
	<li class="a"><a href="checkorder.jsp">查看订单</a></li> 
		<div class="gouwu">
		<img src="img/huanfu.png" alt="">
			<div class="g1"><a href="换肤.jsp">一键换肤</a></div>
		</div>
		
	</ul>
		<!-----------BANNER------------>
	<div class="banner">
	
		<div class="searchbar">
       		<form action="" method="post">
        <!--  <img src="../搜索.png" alt="" class="mg">-->
        <input type="text" id="search" value="Search Google or type a URL" 
        onfocus="if(value=='Search Google or type a URL')value=''"
        onblur="if(!value)value='Search Google or type a URL'" 
        name="keywords" >  <!--当鼠标点击搜索框时，灰色的文字‘Search Google or type a URL’会隐藏。当闲置状态时，提示文字恢复。js的if语句-->
        <button class="registe button" >搜索</button>
		 </form>
</div>

	<%   
        try {  
        	request.setCharacterEncoding("utf-8");
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	String url = "jdbc:mysql://localhost:3306/runoob?useSSL=false&serverTimezone=Hongkong&useUnicode=true&characterEncoding=UTF-8&autoReconnect=true";
        	String username="root" ;
        	String password="123456";
            Connection conn = DriverManager.getConnection(url, username, password);  //连接状态  //连接状态
            String keywords=request.getParameter("keywords");
            if(conn != null){             
            	 Statement stmt1 = null;  
                 ResultSet rs1 = null;  //SELECT * FROM [user] WHERE u_name LIKE '%三%'
                 String sql1 = "SELECT *FROM goods WHERE goods_name LIKE'%"+keywords+"%';";  //查询语句
                 stmt1 = conn.createStatement();  
                 rs1 = stmt1.executeQuery(sql1); //找到输出商品信息
                 
                 String []gwebset=new String[8];
                 String []gimg=new String[8];
                 
                 	gwebset[0]="dn.html";
            	 	gimg[0]="t1.jpg";
                	
            	 	gwebset[1]="ipad.html";
                	gimg[1]="ipad1.PNG";
                	
                	gwebset[2]="xiaomids.html";
                	gimg[2]="xiaomids.jpg";
                	
                	gwebset[3]="xiaomisj.html";
                	gimg[3]="xiaomisj.jpg";
                	
                	gwebset[4]="xiaomixyj.html";
            	 	gimg[4]="xiaomixyj.jpg";
                	
            	 	gwebset[5]="jn_eos.html";
                	gimg[5]="jn_eos.jpg";
                	
                	gwebset[6]="Search.jsp";
                	gimg[6]="mac1.jpg";
                	
                	gwebset[7]="Search.jsp";
                	gimg[7]="mate1.JPG";
                	Integer count=0;
        		 //out.print("查询结果:");
            	 //out.print("<br/>");
            	  
            	 while(rs1.next()){
            		//out.println(rs1.getString("goods_name")+"&nbsp&nbsp&nbsp " + rs1.getString("price") + "元&nbsp " +rs1.getString("shop_name"));
            		
            		gwebset[count]=rs1.getString("links");
            		gimg[count]=rs1.getString("image");
        			count++;
        			if(count>4)break;
            		   
            		
            		    
            		//out.print("<br/>");      
            	 }
            	 rs1.close();
 				 conn.close();
 				 
 					%>
 					<!------------show------------->
 					<br/><br/><br/>
 				<div class="show">
 				    <div class="nav2">
 					<ul class="daoh">
 						<li class="fenlei">产品分类</li>
 						<li>全部</li>
 						<li>huawei</li>
 						<li>苹果</li>
 						<li>小mi</li>
 						<li>honor</li>
 						<li>ipad</li>
 						<li>mac</li>
 						<li>联想</li>
 						</ul>
 					
 					</div>
 					<div class="bargan">
 					<% 
 					if(count>0)
 					{
 						for(int i=0;i<count;i++){ 
 							int tmp=i+1;
 							out.println("<div class=\"b"+tmp+"\">");
 							out.println("<a  href='"+gwebset[i]+"'><img  src='img/"+gimg[i]+"'></img></a>");
 							out.println("</div>");
 						}
 						for(int i=count;i<8;i++){ 
 							int tmp=i+1;
 							out.println("<div class=\"b"+tmp+"\">");
 							out.println("<a  href='Search.jsp'><img  src='img/white.jpg'></img></a>");
 							out.println("</div>");
 						}
 					}
 					else{
 						for(int i=0;i<8;i++){ 
 							int tmp=i+1;
 							out.println("<div class=\"b"+tmp+"\">");
 							out.println("<a  href='"+gwebset[i]+"'><img  src='img/"+gimg[i]+"'></img></a>");
 							out.println("</div>");
 						}
 					}
 					
 					
            }
            else{  
                out.print("连接失败！");  
            }  
        }catch (Exception e) {        
            out.print("数据库连接异常！");  
        }  
	%>
	
	</div>
	<div class="ad">
	<div class="wenzi">热销排行榜</div>
		<div class="huo">
		<img src="imge/麦克风.png" alt="">
		</div>
		
		<div class="frist"> 
			<div class="f1"><img src="第一 (1).png" alt=""></div>
			<div class="i1"><img src="images/IMG_1362(20200612-220203).JPG" alt=""> </div>
			
		
		</div>
	</div>
	</div>
	<!--------------root------------------>
	<div class="root">
	LOGO 引领5G时代！
	</div>
	</body>
	<script type="text/javascript" src="la3.js"> </script>
</html>