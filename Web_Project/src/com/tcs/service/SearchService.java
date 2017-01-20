package com.tcs.service;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.tcs.DAO.SearchDAO;
import com.tcs.bean.Room;
import com.tcs.controller.CustomerController;


public class SearchService 
{
	  Logger log = Logger.getLogger(SearchService.class);

 public ArrayList<Room> searchByCategory(String category,String fd,String td)
 {
	 ArrayList<Room> roomList= new ArrayList<Room>();
	 SearchDAO searchDao=new SearchDAO();
	roomList=searchDao.searchByCategory(category,fd,td);
	 return roomList;
 }
 public ArrayList<Room> searchByTariff(int tariff,String fd,String td)
 {
	 ArrayList<Room> roomList= new ArrayList<Room>();
	 SearchDAO searchDao=new SearchDAO();
		roomList=searchDao.searchByTariff(tariff,fd,td);
		 return roomList;
	 }
 public ArrayList<Room> viewAll(String fd,String td)
 {
	 ArrayList<Room> roomList= new ArrayList<Room>();
	 SearchDAO searchDao=new SearchDAO();
		roomList=searchDao.viewAll(fd,td);
		 return roomList;
 }
 }

