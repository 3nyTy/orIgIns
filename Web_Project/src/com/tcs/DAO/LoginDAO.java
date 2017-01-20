package com.tcs.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.tcs.controller.CustomerController;
import com.tcs.dbutil.DBConnection;

public class LoginDAO {
	  Logger log = Logger.getLogger(LoginDAO.class);

	
	public String verifyLogin(String userId,String password)
	{
		log.info("Now Inside verifyLogin()  method of  LoginDAO class");
		Connection con=null;
		PreparedStatement ps1=null;
		PreparedStatement ps2=null;
		String pwd=null;
		String userName=null;
		ResultSet rs=null;
		ResultSet rs2=null;
		String result=null;
		try
		{
			 con=DBConnection.getConnection();
			String verifyLoginQuery="select * from hoteluser where username=? and password=?";
			
			ps1=con.prepareStatement(verifyLoginQuery);
			ps1.setString(1,userId);
			ps1.setString(2,password);
			rs=ps1.executeQuery();
			/*String verifyCustomer="select * from TJA10GD_CUSTOMER where username=? and password=?";

			ps2=con.prepareStatement(verifyCustomer);
			ps2.setString(1,userId);
			ps2.setString(2,password);
			rs2=ps2.executeQuery();*/
		
			while(rs.next())
			{
				
				if( "admin".equals(userId))
				{ 
					
					pwd=rs.getString("password");
					userName=rs.getString("username");
					result="admin";
		
				}
				else
				{
					pwd=rs.getString("password");
					userName=rs.getString("username");	
					result=rs.getString("customer_name");
				}
			
			}
			if(result == null)
				result="Login Failed";
		}
		catch(Exception e)
		{
		log.info("Exception Occurred while performing Log in operation");
		e.printStackTrace();
		}
		finally
		{
			DBConnection.closeConnection(con);
		}
		System.out.println("result is "+result);
			return result;
		}
		
		
	}


