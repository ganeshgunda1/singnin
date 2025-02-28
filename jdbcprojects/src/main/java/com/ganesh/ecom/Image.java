package com.ganesh.ecom;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/images")
public class Image extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
		String url="jdbc:mysql://localhost:3306?user=root&password=12345";
		String query="SELECT * from teje2.product where id=?;";
		int n=Integer.parseInt(req.getParameter("id"));
		PrintWriter out=resp.getWriter();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url);
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, n);
		    ResultSet rs=ps.executeQuery();
		    
		   if(rs.next()) {
		    	byte [] image=rs.getBytes(3);
		    	 resp.setContentType("image/jpeg");
		    	 OutputStream os=resp.getOutputStream();

		    	 os.write(image);
		    	 os.flush();
		    	 os.close();
		    }
		}
		catch (Exception e) {
			
		}
	}

}
