package com.tcs.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.tcs.service.LoginService;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  Logger log = Logger.getLogger(LoginController.class);

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
		if("login".equals(action))
		{
			loginPage(request,response);
		}
		else if ("logout".equals(action)) {
			logoutPage(request,response);
			
		}
		
	}
	public void loginPage(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		log.info("Now Inside loginPage()  method of  LoginController class");
		response.setContentType("text/html");
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		LoginService loginService=new LoginService();
		String result=loginService.verifyLogin(userId,password);
		if("admin".equals(result))
		{
			HttpSession session=request.getSession(true);
			session.setAttribute("user", result);
			
		
			RequestDispatcher rd=request.getRequestDispatcher("/JSP/adminHome.jsp");
			rd.forward(request, response);
		}
		else if("Login Failed".equals(result))
		{
			
			String fail="login failed!!!Please enter valid credentials";
			request.setAttribute("fail", fail);
				
			RequestDispatcher rd=request.getRequestDispatcher("/JSP/Login.jsp");
			rd.forward(request, response);
			
			
		}
		else
		{
			HttpSession session=request.getSession(true);
			session.setAttribute("CustomerName", result);
			
			RequestDispatcher rd=request.getRequestDispatcher("/JSP/customerHome.jsp");
			rd.forward(request, response);
			
			
		}
		
	}
	
	public void logoutPage(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
		
		log.info("Now Inside logout()  method of  LoginController class");
		HttpSession session=request.getSession(false);
	
		session.invalidate();
     	response.sendRedirect("/JSP/Login.jsp");
	}

}
