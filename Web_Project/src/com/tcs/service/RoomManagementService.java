package com.tcs.service;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.tcs.bean.Room;
import com.tcs.controller.CustomerController;
import com.tcs.DAO.RoomManagementDAO;

public class RoomManagementService {
	  Logger log = Logger.getLogger(RoomManagementService.class);


	
//Method to add a room
	
	
	
		public int addRoom(Room room) throws Exception{
			RoomManagementDAO roomdao=new RoomManagementDAO();
			return roomdao.addRoom(room);
		}
	
		
//Method to display rooms
		
		
	
		public ArrayList<Room> displayRooms(){
			RoomManagementDAO roomdao=new RoomManagementDAO();
			ArrayList<Room> roomList=roomdao.displayRooms();
			return roomList;
		}

		
//Method to select a room to update 
		
		
		public ArrayList<Room> updateRoom(int roomNo) {
			RoomManagementDAO roomdao=new RoomManagementDAO();
			ArrayList<Room> roomList=roomdao.updateRoom(roomNo);
			return roomList;
		}

		
//Method to update a room details
		
		
		public int updateDetails(Room room) throws Exception{
			RoomManagementDAO roomdao=new RoomManagementDAO();
			return roomdao.updateDetails(room);
		}


//Method to display deactivated rooms		

		
		
		public ArrayList<Room> displayDeactivatedRooms() {
			RoomManagementDAO roomdao=new RoomManagementDAO();
			ArrayList<Room> roomList=roomdao.displayDeactivatedRooms();
			return roomList;
			
		}
		
		
//Method to activate a room

		
		
		public int activateRoom(ArrayList<Integer> roomNo) {
			RoomManagementDAO roomdao=new RoomManagementDAO();
			int value=roomdao.activateRoom(roomNo);
			return value;
			
		}
		
	
//Method to display activate rooms
		
		

		public ArrayList<Room> dispalyActivateRooms() {
			RoomManagementDAO roomdao=new RoomManagementDAO();
			ArrayList<Room> roomList=roomdao.displayActivateRooms();
			return roomList;
		}

		
//Method to select a room to deactivate 
		
		
		public ArrayList<Room> deactivateRoom(int roomNo) {
			RoomManagementDAO roomdao=new RoomManagementDAO();
			ArrayList<Room> roomList=roomdao.deactivateRoom(roomNo);
			return roomList;
		}

		
//Method to deactivate a selected room
		
		
		
		public int deactivateDetails(Room room) throws Exception {
			RoomManagementDAO roomdao=new RoomManagementDAO();
			return roomdao.deactivateDetails(room);
		}

		


}
