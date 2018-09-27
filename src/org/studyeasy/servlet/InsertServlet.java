package org.studyeasy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertServlet extends HttpServlet {
    Connection con;
    Statement st;
    PreparedStatement ps;
    String user,pass; 

 @Override 
 protected void doPost(HttpServletRequest request, 
 HttpServletResponse response) throws ServletException, IOException {
 response.setContentType("text/html;charset=UTF-8");

  try (PrintWriter out=response.getWriter()){
    user=request.getParameter("username");
    pass=request.getParameter("password");
    Class.forName("com.mysql.jdbc.Driver");
    con=DriverManager.getConnection
  ("jdbc:mysql://localhost/mydatabase","root","rohini2722");

    ps = con.prepareStatement("insert into Login values(?,?)");
    ps.setString(1, user);
    ps.setString(2,pass);

    String query = null;
	ps.executeUpdate(query);

    System.out.println("Data Inserted Successfully");

 }
 catch(Exception e){
 e.printStackTrace();
  }
 }
}



