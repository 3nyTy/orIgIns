package com.tcs.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;


import com.tcs.bean.Customer;
import com.tcs.bean.RoomStatus;
import com.tcs.controller.CustomerController;
import com.tcs.dbutil.DBConnection;

public class CustomerDAO {
	Connection con=null;
	  Logger log = Logger.getLogger(CustomerDAO.class);

	public int registerCustomer(Customer customer) {
		log.info("Now Inside registerCustomer()  method of  CustomerDAO class");
	
		PreparedStatement ps1 = null;
		int number = 0;
		try {
			 con = DBConnection.getConnection();
			String registerCustomerQuery = "Insert into hoteluser (customer_id,username,password,customer_name,address,email_id,contact_no) values(customer_sequence.nextval,?,?,?,?,?,?)";
			ps1 = con.prepareStatement(registerCustomerQuery);
			ps1.setString(1, customer.getUserId());
			ps1.setString(2, customer.getPassword());
			ps1.setString(3, customer.getCustomerName());
			ps1.setString(4, customer.getAddress());
			ps1.setString(5, customer.getEmailId());
			ps1.setString(6, customer.getContactNo());
			number = ps1.executeUpdate();
		} catch (Exception e) {
								log.info("Exception Occurred while performing customer registration operation");
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(con);
		}
		return number;

	}

	public String getCustomerId(Customer customer) {
		log.info("Now Inside getCustomerId()  method of  CustomerDAO class");
		
		PreparedStatement ps1 = null;
		String customerId = null;
		ResultSet rs = null;
		try {
			 con = DBConnection.getConnection();
			String registerCustomerQuery = "select customer_id from hoteluser where username=? and password=?";
			ps1 = con.prepareStatement(registerCustomerQuery);
			ps1.setString(1, customer.getUserId());
			ps1.setString(2,customer.getPassword());
			rs = ps1.executeQuery();
			if (rs.next()) {
				customerId = rs.getString("customer_id");
			}
			else
				customerId=null;
		} catch (Exception e) {
			log.info("Exception Occurred while finding customer details");
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(con);
		}
		System.out.println(customerId);
		return customerId;


	}

	public String bookRoom(RoomStatus roomStatus) {
		log.info("Now Inside bookRoom()  method of  CustomerDAO class");
		Connection con =null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		//PreparedStatement ps3=null;
	ResultSet rs1 = null;
	ResultSet rs2 = null;
		//ResultSet rs3=null;
		String bookingId = null;
		//String result = null;
		try {
			
			 con = DBConnection.getConnection();
		
			String updateRoomStatusQuery = "update room_status set booking_Status='Booked',booking_id=bookingid_seq.nextval,check_in_date=to_date(?,'dd/mm/yyyy'),check_out_date=to_date(?,'dd/mm/yyyy'),customer_id=? where room_no=?";
			ps1 = con.prepareStatement(updateRoomStatusQuery);
			ps1.setString(1,roomStatus.getCheckIn());
			ps1.setString(2,roomStatus.getCheckOut());
			ps1.setString(3,roomStatus.getCustomerId());
			ps1.setInt(4,roomStatus.getRoomNo());
			rs1 = ps1.executeQuery();
			String selectRoomQuery="select bookingid_seq.currval as book_id from dual";
			ps2=con.prepareStatement(selectRoomQuery);
			rs2=ps2.executeQuery();
			if (rs2.next())
				bookingId = rs2.getString("book_id");
			else
				bookingId = null;

		} catch (Exception e) {
			log.info("Exception Occurred while Performing Booking Operation");
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(con);
		}

		return bookingId;

	}

	public boolean cancelRoom(String bookingId) {
		log.info("Now Inside cancelRoom()  method of  CustomerDAO class");
		
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		PreparedStatement ps3=null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		boolean result = false;
		java.sql.Date checkInDate = null;
		try {
			Connection con = DBConnection.getConnection();
			String DateQuery = "select check_in_date from room_status where booking_Id=?";
			ps1 = con.prepareStatement(DateQuery);
			ps1.setString(1, bookingId);
			rs1 = ps1.executeQuery();
		
			while (rs1.next()) {
				checkInDate = rs1.getDate("check_in_date");
			}
		
			java.util.Date checkInDateConverted = new java.util.Date(
					checkInDate.getTime());
			java.sql.Date sqlDate = new java.sql.Date(
					checkInDateConverted.getTime());
			java.util.Date date = new java.util.Date();
			java.sql.Date sqlDate1 = new java.sql.Date(date.getTime());
			String cancelRoomQuery = "update room_status set booking_status='Available' where (?-?)>=7 and booking_Id=?";
			ps2 = con.prepareStatement(cancelRoomQuery);
			ps2.setDate(1, sqlDate);
			ps2.setDate(2, sqlDate1);
			ps2.setString(3, bookingId);
			rs2 = ps2.executeQuery();
			if (rs2.next()) {
				result = true;
				String cancelQuery="update room_status set check_in_date='', check_out_date='' where booking_status='Available'";
				ps3=con.prepareStatement(cancelQuery);
				ps3.executeQuery();
			} 
			else
				result = false;
			

		} catch (Exception e) {
			log.info("Exception Occurred while Performing Cancellation Operation");
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(con);
		}
		return result;

	}

}
