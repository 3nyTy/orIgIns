package com.tcs.DAO;

import java.sql.*;
import java.util.ArrayList;

import org.apache.log4j.Logger;

//import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;
import com.tcs.bean.Room;
import com.tcs.controller.CustomerController;
import com.tcs.dbutil.DBConnection;
public class SearchDAO
{
	  Logger log = Logger.getLogger(SearchDAO.class);

	private Connection connect=null;
	 private ResultSet rs1=null;
	 private ResultSet rs2=null;
	 private ResultSet rs3=null;

	 private PreparedStatement preparedStatement1=null;
	 private PreparedStatement preparedStatement2=null;
	 private PreparedStatement preparedStatement3=null;
	 
	 ArrayList<Room> roomList=new ArrayList<Room>();
	public ArrayList<Room> searchByCategory(String category,String fd,String td)
	
	{
		log.info("Now Inside searchByCategory()  method of  SearchDAO class");
		try
	{
		
	
		
			connect=DBConnection.getConnection();
			preparedStatement1=connect.prepareStatement("select room.room_no,room.tariff,category.category_type from room inner join category on (category.category_id=room.category_id) inner join room_status on (room.room_no=room_status.room_no) where (((room_status.booking_status='Booked') and ( (room_status.check_in_date>to_date(?,'dd/mm/yyyy') and room_status.check_in_date>to_date(?,'dd/mm/yyyy')) or (room_status.check_out_date<to_date(?,'dd/mm/yyyy') and room_status.check_out_date<to_date(?,'dd/mm/yyyy')))and (category.category_type=?)) or ((category.category_type=?)and(room_status.booking_status='Available')))");

			 preparedStatement1.setString(1,fd);
			 preparedStatement1.setString(2,td);
			 preparedStatement1.setString(3,fd);
			 preparedStatement1.setString(4,td);
			 preparedStatement1.setString(5,category);
			 preparedStatement1.setString(6,category);
			 
	         rs1=preparedStatement1.executeQuery();
	 while(rs1.next())
	{
		 Room room =new Room();
		int roomno=rs1.getInt("room_no");
		System.out.println(roomno);
		double tariff=rs1.getDouble("tariff");
		String category1=rs1.getString("category_type");
	   room.setRoomNo(roomno);
	   room.setTariff(tariff);
	   room.setCategory(category1);
	 
	roomList.add(room);
	   
	}
	
		
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	/*catch(ParseException p)
	{
		p.printStackTrace();
	} */
		return roomList;
	}
	public ArrayList<Room> searchByTariff(int tariff,String fd,String td)
	{  
		log.info("Now Inside searchByTariff()  method of  SearchDAO class");
		try
	{
		String query=null;
	
		
		if(tariff==1)
		{
			query="select room.room_no,room.tariff,category.category_type from room inner join category on (category.category_id=room.category_id) inner join room_status on (room.room_no=room_status.room_no) where ((room_status.booking_status='Booked') and ((room_status.check_in_date>to_date(?,'dd/mm/yyyy') and room_status.check_in_date>to_date(?,'dd/mm/yyyy')) or (room_status.check_out_date<to_date(?,'dd/mm/yyyy') and room_status.check_out_date<to_date(?,'dd/mm/yyyy')))and (room.tariff>=2500 and room.tariff<=3000)) or ((room.tariff>=2500 and room.tariff<=3000) and room_status.booking_status='Available')";
		}
		else if(tariff==2)
		{
			query="select room.room_no,room.tariff,category.category_type from room inner join category on (category.category_id=room.category_id) inner join room_status on (room.room_no=room_status.room_no) where ((room_status.booking_status='Booked') and ((room_status.check_in_date>to_date(?,'dd/mm/yyyy') and room_status.check_in_date>to_date(?,'dd/mm/yyyy')) or (room_status.check_out_date<to_date(?,'dd/mm/yyyy') and room_status.check_out_date<to_date(?,'dd/mm/yyyy')))and (room.tariff>=3000 and room.tariff<=4000)) or ((room.tariff>=3000 and room.tariff<=4000) and room_status.booking_status='Available')";			
		}
		else if(tariff==3)
		{
			query="select room.room_no,room.tariff,category.category_type from room inner join category on (category.category_id=room.category_id) inner join room_status on (room.room_no=room_status.room_no) where ((room_status.booking_status='Booked') and ((room_status.check_in_date>to_date(?,'dd/mm/yyyy') and room_status.check_in_date>to_date(?,'dd/mm/yyyy')) or (room_status.check_out_date<to_date(?,'dd/mm/yyyy') and room_status.check_out_date<to_date(?,'dd/mm/yyyy')))and (room.tariff>=4500 and room.tariff<=5500)) or ((room.tariff>=4500 and room.tariff<=5500) and room_status.booking_status='Available')";}
		else if(tariff==4)
		{
			query="select room.room_no,room.tariff,category.category_type from room inner join category on (category.category_id=room.category_id) inner join room_status on (room.room_no=room_status.room_no) where ((room_status.booking_status='Booked') and ((room_status.check_in_date>to_date(?,'dd/mm/yyyy') and room_status.check_in_date>to_date(?,'dd/mm/yyyy')) or (room_status.check_out_date<to_date(?,'dd/mm/yyyy') and room_status.check_out_date<to_date(?,'dd/mm/yyyy')))and (room.tariff>=6500 and room.tariff<=7000)) or ((room.tariff>=6500 and room.tariff<=7000) and room_status.booking_status='Available')";}
		else
			{
			query="select room.room_no,room.tariff,category.category_type from room inner join category on (category.category_id=room.category_id) inner join room_status on (room.room_no=room_status.room_no) where ((room_status.booking_status='Booked') and ((room_status.check_in_date>to_date(?,'dd/mm/yyyy') and room_status.check_in_date>to_date(?,'dd/mm/yyyy')) or (room_status.check_out_date<to_date(?,'dd/mm/yyyy') and room_status.check_out_date<to_date(?,'dd/mm/yyyy')))and (room.tariff>=10000 and room.tariff<=15000)) or ((room.tariff>=10000 and room.tariff<=15000) and room_status.booking_status='Available')";
			}
		
			connect=DBConnection.getConnection();
		
			preparedStatement2=connect.prepareStatement(query);
			preparedStatement2.setString(1,fd);
			preparedStatement2.setString(2,td);
			preparedStatement2.setString(3,fd);
			preparedStatement2.setString(4,td);
			
			int c=preparedStatement2.executeUpdate();
			
			rs2=preparedStatement2.executeQuery();
			while(rs2.next())
			{
				Room room =new Room();
				int roomno=rs2.getInt("room_no");
				double tariffs=rs2.getDouble("tariff");
				String category=rs2.getString("category_type");
			   room.setRoomNo(roomno);
			   room.setTariff(tariffs);
			   room.setCategory(category);
				roomList.add(room);
			
			
		}
	}

	catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}

return roomList;
}
	public ArrayList<Room> viewAll(String fd,String td)
	
	{
		log.info("Now Inside viewAll()  method of  SearchDAO class");
		try{
			connect=DBConnection.getConnection();
			preparedStatement3=connect.prepareStatement("select room.room_no,room.tariff,category.category_type from room inner join category on (category.category_id=room.category_id) inner join room_status on (room.room_no=room_status.room_no) where ((room_status.booking_status='Booked') and ((room_status.check_in_date>to_date(?,'dd/mm/yyyy') and room_status.check_in_date>to_date(?,'dd/mm/yyyy')) or (room_status.check_out_date<to_date(?,'dd/mm/yyyy') and room_status.check_out_date<to_date(?,'dd/mm/yyyy')))) or ( room_status.booking_status='Available')");
			preparedStatement3.setString(1,fd);
			preparedStatement3.setString(2,td);
			preparedStatement3.setString(3,fd);
			preparedStatement3.setString(4,td);
			rs3=preparedStatement3.executeQuery();
            connect.commit();
            while(rs3.next())
            	{Room room =new Room();
            	int roomno=rs3.getInt("room_no");
            	double tariff=rs3.getDouble("tariff");
            	String category=rs3.getString("category_type");
            	room.setRoomNo(roomno);
            	room.setTariff(tariff);
            	room.setCategory(category);
            	roomList.add(room);
            	
            }
		}
		 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				return roomList;	
	}
}
