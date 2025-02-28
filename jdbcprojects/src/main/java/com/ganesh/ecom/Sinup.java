package com.ganesh.ecom;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/sinup")
public class Sinup extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user=req.getParameter("username");
		String possword=req.getParameter("password");
		String url="jdbc:mysql://localhost:3306?user=root&password=12345";
		String query="INSERT INTO teje2.logd (username,possword) VALUES (?, ?);";
		System.out.println("hhh");
		PrintWriter out=resp.getWriter();
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url);
				PreparedStatement ps=con.prepareStatement(query);
				   ps.setString(1, user );
				  ps.setString(2, possword);
				  int res=  ps.executeUpdate();
				 
				  if(res==1)
				  {
					  RequestDispatcher d=req.getRequestDispatcher("index.html");
					  d.include(req, resp);
					  out.print("<br>");
					  out.print("<p style=\"color: green;\">sin up succsfull</p>");
					// TODO Auto-generated catch block
				  }
				  
			} catch (Exception e) {
				  RequestDispatcher d=req.getRequestDispatcher("sinup.html");
				  d.include(req, resp);
				  out.print("<br>");;
				  out.print("<p style=\"color: red;\">user name already exsicte give anthe name</p>");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
}
