package com.ganesh.ecom;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/loging")
public class Log extends HttpServlet {
	 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user=req.getParameter("username");
		String possword=req.getParameter("password");
		String url="jdbc:mysql://localhost:3306?user=root&password=12345";
		String query="SELECT * FROM teje2.logd;";
		int n=0;
		int c=0;
		PrintWriter out=resp.getWriter();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url);
			PreparedStatement ps=con.prepareStatement(query);
		    ResultSet rs=ps.executeQuery();
		    while(rs.next()) {
		    	String user1=rs.getString(1);
		    	String pass=rs.getNString(2);
		    	if(user!="" &&possword!="")
		    	{
		    	if(user1.equals(user) && possword.equals(pass) )
		         	{
		    		n++;
		    		 RequestDispatcher ds=req.getRequestDispatcher("home.jsp");
		     		ds.include(req, resp);
		    	    }
		    	}
		    	else {
		    		c++;
		    	}
		    	}
		    
		    if(c>0)
		    {
		    	
		    	RequestDispatcher ds=req.getRequestDispatcher("index.html");
	    		ds.include(req, resp);
	    		 out.print("<br>");
				  out.print("<p style=\"color: red;\">Enter User data</p>");
		    }
		    if(n!=1&&c!=0) {
		   
		    RequestDispatcher ds=req.getRequestDispatcher("index.html");
    		ds.include(req, resp);
    		
    		 out.print("<br>");
			  out.print("<p style=\"color: red;\">invalid data</p>");
			
}	    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
