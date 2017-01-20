package com.tcs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.tcs.bean.Customer;
import com.tcs.bean.RoomStatus;
import com.tcs.service.CustomerService;

/**
 * Servlet implementation class CustomerController
 */
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  Logger log = Logger.getLogger(CustomerController.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if ("Registration".equals(action)) {
			registration(request, response);

		} else if ("RoomBooking".equals(action)) {
			roomBook(request, response);

		}

		else if ("CancelBooking".equals(action)) {

			roomCancel(request, response);
		}

	}

	private void registration(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		log.info("Now Inside registration()  method of CustomerController class");
		String customerName = request.getParameter("name");
		String address = request.getParameter("address");
		String emailId = request.getParameter("email");
		String contactNo = request.getParameter("contactNo");
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		Customer customer = new Customer();
		customer.setCustomerName(customerName);
		customer.setAddress(address);
		customer.setEmailId(emailId);
		customer.setContactNo(contactNo);
		customer.setUserId(userId);
		customer.setPassword(password);
		if (password.equals(confirmPassword)) {
			CustomerService customerService = new CustomerService();
			int number = customerService.registerCustomer(customer);
			request.setAttribute("Number", number);
			request.setAttribute("Name", customerName);
			RequestDispatcher rd = request.getRequestDispatcher(
					"JSP/Welcome.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("Password", password);
			request.setAttribute("ConfirmPassword", confirmPassword);
			request.setAttribute("mismatch", "Sorry!..Passwords did not match");
			RequestDispatcher rd = request.getRequestDispatcher(
					"/JSP/Registration.jsp");
			rd.forward(request, response);
	
		}
	}

	private void roomCancel(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		log.info("Now Inside roomCancel()  method of CustomerController class");
		String bookingId = request.getParameter("bookingId");
		CustomerService customerService = new CustomerService();
		boolean result = customerService.cancelRoom(bookingId);
		request.setAttribute("Result", result);
		request.setAttribute("BookingId", bookingId);
		RequestDispatcher rd = request.getRequestDispatcher(
				"/JSP/CancellationResult.jsp");
		rd.forward(request, response);
	}

	private void roomBook(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		log.info("Now Inside roomBook()  method of  CustomerController class");
		String customerName = request.getParameter("name");
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		int roomNo=(Integer.parseInt(request.getParameter("roomNo")));
		Customer customer=new Customer();
		customer.setUserId(userName);
		customer.setPassword(password);
		CustomerService customerService = new CustomerService();
		String customerId = customerService.getCustomerId(customer);
		if(customerId==null)
		{
			String msg="You are not a registered customer.Please register to book a room";
			request.setAttribute("msg", msg);
			RequestDispatcher rd=request.getRequestDispatcher("/JSP/Login.jsp");
			rd.forward(request,response);
		}
		else if(customerId!=null)
		{
		request.setAttribute("customerId", customerId);
		String checkIn = request.getParameter("from");
		String checkOut = request.getParameter("to");
		RoomStatus roomStatus = new RoomStatus();
		roomStatus.setCheckOut(checkOut);
		roomStatus.setCheckIn(checkIn);
		roomStatus.setCustomerId(customerId);
		roomStatus.setRoomNo(roomNo);

		String result = customerService.bookRoom(roomStatus);
		request.setAttribute("BookingId", result);
		request.setAttribute("customerName", customerName);
		
		RequestDispatcher rd = request.getRequestDispatcher("/JSP/BookingResult.jsp");
		rd.forward(request, response);
	}
		}
}
