package com.tcs.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.tcs.bean.Room;
import com.tcs.controller.CustomerController;
import com.tcs.dbutil.DBConnection;

public class RoomManagementDAO {
	  Logger log = Logger.getLogger(RoomManagementDAO.class);


	private Connection conn = null;
	private PreparedStatement ps5 = null;
	private PreparedStatement ps3 = null;
	private PreparedStatement ps6 = null;
	private PreparedStatement ps7 = null;
	private ResultSet rs = null;

	
	
	
	
//ADD Room method	
	
	
	
	
	
	public int addRoom(Room room) throws Exception {
		log.info("Now Inside  addRoom()  method of  RoomManagementDAO class");
		int roomNo = 0;
		try {

			conn = DBConnection.getConnection();
			
			ps6=conn.prepareStatement("select room_no from room where room_no=?");
			ps6.setInt(1, room.getRoomNo());
			rs = ps6.executeQuery();
			if(rs.next()){
				roomNo=1;
			}
			
			else{
			ps5 = conn
					.prepareStatement("insert into room values (?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?)");
			ps5.setInt(1, room.getRoomNo());
			ps5.setDouble(2, room.getTariff());
			ps5.setString(3, room.getADStatus());
			ps5.setInt(4, room.getCategoryId());
			ps5.setString(5, room.getStartDate());
			ps5.setString(6, room.getEndDate());
			ps5.setString(7, room.getImage());
			ps5.executeUpdate();

			conn.commit();

			ps3 = conn
					.prepareStatement("insert into speciality values(?,?)");
			ps3.setInt(1, room.getRoomNo());
			ps3.setString(2, room.getSpecality());
			ps3.executeUpdate();
			conn.commit();
			
			ps7 = conn
					.prepareStatement("insert into room_status(room_no,booking_status) values(?,?)");
			ps7.setInt(1, room.getRoomNo());
			ps7.setString(2, "Available");
			ps7.executeUpdate();
			conn.commit();
			
			
			roomNo= 0;
		   }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(conn);
		}

		return roomNo;

	}
	
	
	
	
//Display Rooms
	
	
	
	
	
	public ArrayList<Room> displayRooms() {
		log.info("Now Inside displayRooms()  method of  RoomManagementDAO class");
		ArrayList<Room> roomList = new ArrayList<Room>();

		try {
			conn = DBConnection.getConnection();
			ps6 = conn.prepareStatement("select room.room_no,room.tariff,room.ad_status,room.category_id,category.category_type,speciality.speciality from room ,category ,speciality  where room.room_no=speciality.room_no and room.category_id=category.category_id");
			rs = ps6.executeQuery();

			while (rs.next()) {
				Room room = new Room();
				room.setRoomNo(rs.getInt(1));
				room.setTariff(rs.getDouble(2));
				room.setADStatus(rs.getString(3));
				room.setCategoryId(rs.getInt(4));
				room.setSpecality(rs.getString(6));
				room.setCategory((rs.getString(5)));
				roomList.add(room);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(conn);
		}
		return roomList;
	}
	
	
	
	
	
//Mthod to Update a Room
	
	
	
	
	
	public ArrayList<Room> updateRoom(int roomNo) {
		log.info("Now Inside updateRoom()  method of  RoomManagementDAO class");
		ArrayList<Room> roomList = new ArrayList<Room>();

		try {
			conn = DBConnection.getConnection();
			ps6 = conn
					.prepareStatement("select room.room_no,room.tariff,room.ad_status,room.category_id,category.category_type,speciality.speciality from room ,category ,speciality  where room.room_no=speciality.room_no and room.category_id=category.category_id and room.room_no=?");
			ps6.setInt(1, roomNo);
			rs = ps6.executeQuery();

			while (rs.next()) {
				Room room = new Room();
				room.setRoomNo(rs.getInt(1));
				room.setTariff(rs.getDouble(2));
				room.setADStatus(rs.getString(3));
				room.setCategoryId(rs.getInt(4));
				room.setSpecality(rs.getString(6));
				room.setCategory(rs.getString(5));
				roomList.add(room);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(conn);
		}
		return roomList;

	}
	
	
	
	
	
//Update Room Details
	
	
	
	
	
	public int updateDetails(Room room) {
		log.info("Now Inside updateDetails()  method of  RoomManagementDAO class");
		int roomNo = 0;
		try {

			conn = DBConnection.getConnection();
			ps5 = conn
					.prepareStatement("update room set tariff=?,category_id=? where room_no=?");

			ps5.setDouble(1, room.getTariff());
			ps5.setInt(2, room.getCategoryId());
			ps5.setInt(3, room.getRoomNo());

			ps5.executeUpdate();

			conn.commit();
			
			ps3 = conn
					.prepareStatement("update peciality set speciality=? where room_no=?");
			
			ps3.setString(1, room.getSpecality());
			ps3.setInt(2, room.getRoomNo());

			ps3.executeUpdate();
			conn.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(conn);
		}

		return roomNo;

	}
	
	
	
	
//Display Deactivated Rooms
	
	
	
	
	
	public ArrayList<Room> displayDeactivatedRooms() {
		log.info("Now Inside displayDeactivatedRooms()  method of  RoomManagementDAO class");
		ArrayList<Room> roomList = new ArrayList<Room>();

		try {
			conn = DBConnection.getConnection();
			ps6 = conn
					.prepareStatement("select room.room_no,room.tariff,room.ad_status,room.category_id,category.category_type,speciality.speciality from room ,category ,speciality  where room.room_no=speciality.room_no and room.category_id=category.category_id and room.ad_status=?");
			ps6.setString(1, "Deactivated");
			rs = ps6.executeQuery();

			while (rs.next()) {
				Room room = new Room();
				room.setRoomNo(rs.getInt(1));
				room.setTariff(rs.getDouble(2));
				room.setADStatus(rs.getString(3));
				room.setCategoryId(rs.getInt(4));
				room.setSpecality(rs.getString(6));
				room.setCategory((rs.getString(5)));

				roomList.add(room);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(conn);
		}
		return roomList;
	}
	
	
	

	
//Method for activating a room 
	
	
	
	
	
	public int activateRoom(ArrayList<Integer> roomNo) {
		log.info("Now Inside activateRoom()  method of  RoomManagementDAO class");
		int value = 0;
		try {

			conn = DBConnection.getConnection();
			for (int no : roomNo) {

				ps5 = conn
						.prepareStatement("update room set ad_status=?,start_date=?,end_date=? where room_no=?");

				ps5.setString(1, "Activated");
				ps5.setString(2, "");
				ps5.setString(3, "");
				ps5.setInt(4, no);
				value = ps5.executeUpdate();

				conn.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(conn);
		}

		return value;

	}
	
	
	
	
//Method to display activated rooms 
	
	
	
	
	public ArrayList<Room> displayActivateRooms() {
		log.info("Now Inside displayActivateRooms()  method of  RoomManagementDAO class");
		ArrayList<Room> roomList = new ArrayList<Room>();

		try {
			conn = DBConnection.getConnection();
			ps6 = conn.prepareStatement("select room.room_no,room.tariff,room.ad_status,room.category_id,category.category_type,speciality.speciality from room ,category ,speciality  where room.room_no=speciality.room_no and room.category_id=category.category_id and room.ad_status=?");
			ps6.setString(1, "Activated");
			rs = ps6.executeQuery();

			while (rs.next()) {
				Room room = new Room();
				room.setRoomNo(rs.getInt(1));
				room.setTariff(rs.getDouble(2));
				room.setADStatus(rs.getString(3));
				room.setCategoryId(rs.getInt(4));
				room.setSpecality(rs.getString(6));
				room.setCategory((rs.getString(5)));
				roomList.add(room);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(conn);
		}
		return roomList;
	}
	
	
	
	
	
//Method to select a room to deactivate 
	
	
	
	
	
	public ArrayList<Room> deactivateRoom(int roomNo) {
		log.info("Now Inside deactivateRoom()  method of  RoomManagementDAO class");
		ArrayList<Room> roomList = new ArrayList<Room>();

		try {
			conn = DBConnection.getConnection();
			ps6 = conn
					.prepareStatement("select room_no,start_date,end_date from room where room_no=?");
			ps6.setInt(1, roomNo);
			rs = ps6.executeQuery();

			while (rs.next()) {
				Room room = new Room();
				room.setRoomNo(rs.getInt(1));
				room.setStartDate(rs.getString(2));
				room.setEndDate(rs.getString(3));
				roomList.add(room);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(conn);
		}
		return roomList;

		
	}
	
	
	
	
	
//Method to deactivate room details
	
	
	
	
	
	public int deactivateDetails(Room room) {
		log.info("Now Inside deactivateDetails()  method of  RoomManagementDAO class");
		int roomNo = 0;
		try {

			conn = DBConnection.getConnection();
			ps5 = conn
					.prepareStatement("update room set start_date=to_date(?,'dd/mm/yyyy'),end_date=to_date(?,'dd/mm/yyyy'),ad_status=? where room_no=?");

			ps5.setString(1, room.getStartDate());
			ps5.setString(2, room.getEndDate());
			ps5.setString(3, "Deactivated");
			ps5.setInt(4, room.getRoomNo());

			ps5.executeUpdate();

			conn.commit();
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(conn);
		}

		return roomNo;

	}

	

}
