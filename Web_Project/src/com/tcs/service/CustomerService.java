package com.tcs.service;

import org.apache.log4j.Logger;

import com.tcs.DAO.CustomerDAO;
import com.tcs.bean.Customer;
import com.tcs.bean.RoomStatus;
import com.tcs.controller.CustomerController;

public class CustomerService {

	  Logger log = Logger.getLogger(CustomerService.class);

	public int registerCustomer(Customer customer) 
	{
		CustomerDAO customerDAO=new CustomerDAO();
		int number=customerDAO.registerCustomer(customer);
		return number;
	}
	public String getCustomerId(Customer customer)
	{
		CustomerDAO customerDAO=new CustomerDAO();
		return customerDAO.getCustomerId(customer);
	}
		public String bookRoom(RoomStatus roomStatus)
	{
		CustomerDAO customerDAO=new CustomerDAO();
		return customerDAO.bookRoom(roomStatus);
	}
	public boolean cancelRoom(String bookingId)
	{
		CustomerDAO customerDAO=new CustomerDAO();
		return customerDAO.cancelRoom(bookingId);
	}
}
