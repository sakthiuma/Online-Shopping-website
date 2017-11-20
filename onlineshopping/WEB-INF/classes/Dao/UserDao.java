package Dao;
import bean.*;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

public class UserDao
{
	public int addUser(User u)
	{
		int i=-1;
		final String driver="com.mysql.jdbc.Driver";
		final String DB_url="jdbc:mysql://localhost:3306/userinfo";
		final String user="root";
		final String pass="password";
		Connection con=null;
		String name=u.getName();
		String password=u.getPassword();
		
		
		
	try{
		Class.forName(driver);
		con=DriverManager.getConnection(DB_url,user,pass);
		PreparedStatement pst =(PreparedStatement) con.prepareStatement("insert into user(password,name) values(?,?);");
		pst.setString(1,password);  
		pst.setString(2,name);
		i=pst.executeUpdate();
		pst.close();
	}
	catch(SQLException se)
	{
		
		se.printStackTrace();
	}
	catch(Exception e) {
		
         //Handle errors for Class.forName
         e.printStackTrace();
      }
	return i;
}
	public int authenticate(User u)
	{int i=-1;
		final String driver="com.mysql.jdbc.Driver";
		final String DB_url="jdbc:mysql://localhost:3306/userinfo";
		final String user="root";
		final String pass="password";
		Connection con=null;
		Statement stmt=null;
		String name=u.getName();
		String password=u.getPassword();		
	try{
		Class.forName(driver);
		con=DriverManager.getConnection(DB_url,user,pass);
		stmt=con.createStatement();
		String sql="select * from user";
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next())
		{
			String uname=rs.getString("name");
			String upass=rs.getString("password");
			if(uname.equals(name))
			{
				if(upass.equals(password))
					i= 11;
				else
					i= 10;
				
			}
			else if(upass.equals(password))
			{
				if(uname.equals(name))
					i= 11;
				else
					i= 01;
			}
			else 
				i= 00;
		}
		
	}
	catch(SQLException se)
	{
		
		se.printStackTrace();
	}
	catch(Exception e) {
		
         //Handle errors for Class.forName
         e.printStackTrace();
      }
	return i;
}
			
}
