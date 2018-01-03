package DAO;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*; 
import java.sql.*;
import java.util.*;
import Bean.user;

public class loginDao {

	public int authenticate(user u)
	{
		String name = u.getName();
		String roll = u.getRoll();
		String email = u.getEmail();
		String mobile = u.getMobile();



	final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	final String DB_URL="jdbc:mysql://localhost:3306/test";
 	final String USER="root";
	final String PASS="1";
	Connection conn=null;
	Statement stmt=null;
	
	try{
	Class.forName("com.mysql.jdbc.Driver");
	conn=DriverManager.getConnection(DB_URL,USER,PASS);
	stmt = conn.createStatement();
    PreparedStatement pst = conn.prepareStatement("insert into verify values(?,?,?,?)");    
	pst.setString(1,name);
	pst.setString(2,roll);
	pst.setString(3,mobile);
	pst.setString(4,email);
		
	 pst.execute();
		 //ResultSetMetaData rsmd=rs.getMetaData();
	    
	    }
	catch(SQLException se) {
         //Handle errors for JDBC
		se.printStackTrace();
		return 0;
      } catch(Exception e) {
         //Handle errors for Class.forName
         e.printStackTrace();
      } finally {
         //finally block used to close resources
         try {
            if(stmt!=null)
               stmt.close();
         } catch(SQLException se2) {
         } // nothing we can do
         try {
            if(conn!=null)
            conn.close();
         } catch(SQLException se) {
            se.printStackTrace();
         } //end finally try
       //end try
 




	}
	return 1;
}



}