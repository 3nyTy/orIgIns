package com.tcs.service;

import org.apache.log4j.Logger;

import com.tcs.DAO.LoginDAO;
import com.tcs.controller.CustomerController;

public class LoginService {
	  Logger log = Logger.getLogger(LoginService.class);


	public String verifyLogin(String userId,String password) {
		
		LoginDAO loginDAO=new LoginDAO();
		return loginDAO.verifyLogin(userId,password);
		
	}
}
