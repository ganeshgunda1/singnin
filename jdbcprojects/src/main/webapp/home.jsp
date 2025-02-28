<%@page import="java.util.*"%>
<%@page import="java.io.*"%>

<%@page import="java.sql.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">*{
    padding: 0%;
    margin: 0%;
    box-sizing: border-box;
}
#ct{
position: relative;
    top: 10px;
     cursor: pointer;
}

#mainnav
{
   width: 100%;
   height: 5em;
  background-color: blue;
  display: flex;
    justify-content: space-around;
   position: fixed;
   z-index: 1000;
  
 
}
.d{
    height: 100%;
    background-color: blue;
    
     color: white;
     width: 18em;
     text-align: center;
     align-items: center;
     justify-content: center;
     align-content: center;
     transition: all 1s;
      cursor: pointer;
}
#s{
    height: 30px;
    width: 70%;
    border-radius: 10%;
    outline: none;
    border: none;
}
#product img{
  
    transition:all 2s;
       
}

#product:hover img,ct{
   position: relative;
    top: 5%;
    transform: scale(1.4);
}
#productcon{
     
     display: grid;
    grid-template-columns: repeat(3,1fr);
    gap:5px;
   
   position: relative;
       top: 100px;
    
       
}
#product{
    border: 2px,black,solid;
     height: 500px;
     width:80%;
        
       overflow: hidden;
        transition:all 2s;
}


#p{
    height:60% ;
    
    
}</style>
</head>
<body>
    <nav id="mainnav" >
        <img  src="./cs.css/532-5328945_menu-bar-icon-white-clipart-png-download-menu.png" alt="" id="m1" onclick="opn()">
        <div class="d"><form action=""><input type="search" id="s" name="s"> <input type="submit" value="search" id="ss"></form></div>
        <div class="d">contact</div>
        <div class="d">chart </div>
    </nav> 
    
    <hr>
    
  <%
    String url="jdbc:mysql://localhost:3306?user=root&password=12345";
    String sql="SELECT * FROM teje2.product;";
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con=DriverManager.getConnection(url);
    PreparedStatement ps=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
    ResultSet rs= ps.executeQuery();
    %>
    
    <div id="productcon">

<%
while(rs.next()){
	
String d=rs.getNString(2);
 //Blob blob= rs.getBlob(3);
// byte [] b=blob.getBytes(//1int)blob.length());
byte [] im=rs.getBytes(3);
//System.out.print(image);
String img=Base64.getEncoder().encodeToString(im);
 //response.setContentType("image/jpeg");
 //OutputStream os=response.getOutputStream();

 //os.write(image);
 //os.flush();
 //os.close();
%>
     
   
    <div id="product" align="center">
    
     <img src="data:image/jpeg;base64,<%=img%>" alt="coming" id="p">
     <br>
     <h1><%=d %></h1>
      <input type="submit" value="Addtochart" onclick="addproducttochart" id="ct" >
     </div>
    <%} %>
    </div>
</body>
</html>