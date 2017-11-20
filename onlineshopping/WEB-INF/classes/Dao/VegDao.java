package Dao;
import bean.*;
import java.sql.*;
import java.lang.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

public class VegDao
{
	public void retrieveCategory(Vegi v)
	{
		int i=-1;
		final String driver="com.mysql.jdbc.Driver";
		final String DB_url="jdbc:mysql://localhost:3306/veginfo";
		final String user="root";
		final String pass="password";
		Connection con=null;
		StringBuilder sb=new StringBuilder("");
		String ret;
		try{
			Class.forName(driver);
			con=DriverManager.getConnection(DB_url,user,pass);
			Statement stmt=con.createStatement();
			String sql="select distinct category from veg";
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next())
			{
				String cat=rs.getString("category");
				sb.append(cat);
				sb.append("&");
			}
			ret=sb.toString();
			v.setCategory(ret);
			
		}
		catch(SQLException se)
		{
		
			se.printStackTrace();
		}
		catch(Exception e) {
		
         		//Handle errors for Class.forName
        		 e.printStackTrace();
     		 }
		//ret=sb.toString();
		//return ret;
	}
	
	public String retrieveItem(Vegi v)
	{
		int i=-1;
		final String driver="com.mysql.jdbc.Driver";
		final String DB_url="jdbc:mysql://localhost:3306/veginfo";
		final String user="root";
		final String pass="password";
		Connection con=null;
		StringBuilder sbit=new StringBuilder("");
		StringBuilder sbdesp=new StringBuilder("");
		StringBuilder sbprice=new StringBuilder("");
		String retit,retdesp,retprice="null";
		try{
			Class.forName(driver);
			con=DriverManager.getConnection(DB_url,user,pass);
			String cat=v.getCategory();
			Statement stmt=con.createStatement();
			String sql="select * from veg ";
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next())
			{
				String cate=rs.getString("category");
				if(cat.equals(cate))
				{
					String item=rs.getString("items");
					sbit.append(item);
					sbit.append("&");
					String desp=rs.getString("description");
					sbdesp.append(desp);
					sbdesp.append("&");
					int pr=rs.getInt("price");
					String price=String.valueOf(pr);
					sbprice.append(pr);
					sbprice.append("&");
					
				}
			}
			retit=sbit.toString();
			v.setItem(retit);
			retdesp=sbdesp.toString();
			v.setDescription(retdesp);
			retprice=sbprice.toString();
			//v.setItem(retprice);
			
		}
		catch(SQLException se)
		{
		
			se.printStackTrace();
		}
		catch(Exception e) {
		
         		//Handle errors for Class.forName
        		 e.printStackTrace();
     		 }
		retprice=sbprice.toString();
		return retprice;
	}
}
	