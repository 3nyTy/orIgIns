package com.tcs.controller;

import java.io.File;
import java.io.IOException;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import org.apache.log4j.Logger;

//import oracle.sql.DATE;

import com.tcs.bean.Room;
import com.tcs.service.RoomManagementService;

/**
 * Servlet implementation class customerController
 */
public class RoomManagementController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  Logger log = Logger.getLogger(RoomManagementController.class);
	  
	  private static final int MAX_MEMORY_SIZE = 1024 * 1024 * 2;
		private static final int MAX_REQUEST_SIZE = 1024 * 1024;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RoomManagementController() {
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// ADD room method
		
				boolean isMultipart = ServletFileUpload.isMultipartContent(request);

				boolean addRoom = false;
				Room room = new Room();
				HashMap<String, String> roommap = new HashMap<String, String>();
				
				
				if (isMultipart) {
					// return;

					ServletContext context = getServletContext();
					DiskFileItemFactory factory = new DiskFileItemFactory();
					factory.setSizeThreshold(MAX_MEMORY_SIZE);
					factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
					String uploadFolder = "D:/workspace/";

					ServletFileUpload upload = new ServletFileUpload(factory);

					upload.setSizeMax(MAX_REQUEST_SIZE);
					String fileName = "photo.jpg";

					try {
						List items = upload.parseRequest(request);
						Iterator iter = items.iterator();
						int i = 1;
						String speciality = "";
						while (iter.hasNext()) {
							FileItem item = (FileItem) iter.next();

							if (!item.isFormField()) {
								fileName = new File(item.getName()).getName();
								String filePath = uploadFolder + File.separator
										+ fileName;
								File uploadedFile = new File(filePath);
								item.write(uploadedFile);
								room.setImage(fileName);
							} else {
								if (i <= 9) {
									String name = item.getFieldName();
									String value = item.getString();
									
									if(name.equals("speciality")){
										speciality=speciality+value+",";
										room.setSpecality(speciality);	
									}
									else{
									    roommap.put(name, value);
									}
									i++;
									addRoom = true;
								}

							}
						}

					} catch (FileUploadException ex) {
						throw new ServletException(ex);
					} catch (Exception ex) {
						throw new ServletException(ex);
					}

				}

				
				String action = request.getParameter("action");

				RoomManagementService roomService = new RoomManagementService();
				int roomNo;
				
				

				if (addRoom == true) {
					for(String s:roommap.keySet()){
						if(s.equals("roomno")){
							room.setRoomNo(Integer.parseInt(roommap.get(s)));
						}
						if(s.equals("category")){
							room.setCategory(roommap.get(s));
							if (roommap.get(s).equals("a/cstandard")) {
								room.setCategoryId(02);

							} else if (roommap.get(s).equals("nona/cstandard")) {
								room.setCategoryId(01);

							} else if (roommap.get(s).equals("a/cdeluxe")) {
								room.setCategoryId(04);

							} else if (roommap.get(s).equals("nona/cdeluxe")) {
								room.setCategoryId(03);

							} else if (roommap.get(s).equals("premium")) {
								room.setCategoryId(05);

							}
						}
						if(s.equals("tariff")){
							room.setTariff(Double.parseDouble(roommap.get(s)));				
						}
						if(s.equals("adstatus")){
							room.setADStatus(roommap.get(s));
						}
						
						if(s.equals("startdate")){
							if (room.getADStatus() == "Activated") {
								room.setStartDate("");
							}
							else{
								room.setStartDate(roommap.get(s));
							}
							
						}
						if(s.equals("enddate")){
							if (room.getADStatus() == "Deactivated") {
								room.setEndDate("");
							}
							else{
								room.setEndDate(roommap.get(s));
							}
						}
						
									
					}
					
					
									
					
					
					try {
						
						roomNo = roomService.addRoom(room);
						request.setAttribute("roomNo", roomNo);
						if(roomNo==0){
							String message="Room is registered succesfully";
							request.setAttribute("message",message );
							RequestDispatcher rd = request.getRequestDispatcher("/JSP/addRoom.jsp");
							rd.forward(request, response);
						
				  		}
						else{
							String message="RoomNo already exists Please enter another number";
							request.setAttribute("message",message );
							RequestDispatcher rd = request.getRequestDispatcher("/JSP/addRoom.jsp");
							rd.forward(request, response);
						
						}

					} catch (Exception e) {

						e.printStackTrace();
					}
					

				}
		
		
		
		
		
		// Variable used to capture action of different JSP pages

		
		String name = request.getParameter("name");

		if (name == null) {
			name = "no";
		}

		String state = request.getParameter("state");

		if (state == null) {
			state = "no";
		}

		String status = request.getParameter("status");

		if (status == null) {
			status = "no";
		}

				

		 if (name.equals("update")) {

			displayUpdateRooms(request, response);

		}

		// Displaying all the rooms to select a particular room for updating
		// details

		if ("updateroom".equals(action)) {

			roomUpdateDetails(request, response);

		}

		else if ("updatedetails".equals(action)) {

			roomUpdateSuccess(request, response);

		}

		// Activating rooms which are deactivated

		if (state.equals("activate")) {

			displayRoomsDeactivated(request, response);

		}

		if ("activateroom".equals(action)) {

			roomActivation(request, response);

		}

		// Deactivating rooms which are Activated

		if (status.equals("deactivate")) {

			displayRoomsActivated(request, response);

		}

		if ("deactivateroom".equals(action)) {

			roomDeactivateDetails(request, response);

		}

		else if ("deactivatedetails".equals(action)) {

			roomDeactivateSuccess(request, response);

		}

	}

	private void roomDeactivateSuccess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		log.info("Now Inside roomDeactivateSuccess()  method of  RoomManagementController class");
		Room room = new Room();
		room.setRoomNo(Integer.parseInt(request.getParameter("room")));
		room.setStartDate(request.getParameter("startdate"));
		room.setEndDate(request.getParameter("enddate"));
		RoomManagementService roomService2 = new RoomManagementService();
		int roomNo2;
		try {
			roomNo2 = roomService2.deactivateDetails(room);
			request.setAttribute("roomNo2", roomNo2);

		} catch (Exception e) {

			e.printStackTrace();
		}
		
		String message7="Room is deactivated succesfully";
		request.setAttribute("message7",message7 );
		RequestDispatcher rd2 = request.getRequestDispatcher("/JSP/adminHome.jsp");
		rd2.forward(request, response);
		
	}

	private void roomDeactivateDetails(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		log.info("Now Inside roomDeactivateDetails()  method of  RoomManagementController class");
		int roomNo = Integer.parseInt(request.getParameter("roomstates"));
		RoomManagementService roomService1 = new RoomManagementService();
		ArrayList<Room> roomList4 = roomService1.deactivateRoom(roomNo);
		request.setAttribute("roomList4", roomList4);

		RequestDispatcher rd1 = request
				.getRequestDispatcher("/JSP/deactivateRoomDetails.jsp");
		rd1.forward(request, response);
	}

	private void displayRoomsActivated(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		log.info("Now Inside displayRoomsActivated()  method of  RoomManagementController class");
		RoomManagementService roomService = new RoomManagementService();
		ArrayList<Room> roomList3 = roomService.dispalyActivateRooms();
		request.setAttribute("roomList3", roomList3);
		RequestDispatcher rd = request
				.getRequestDispatcher("/JSP/deactivateRoom.jsp");
		rd.forward(request, response);
	}

	private void roomActivation(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		log.info("Now Inside roomActivation()  method of  RoomManagementController class");
		ArrayList<Integer> roomNo = new ArrayList<Integer>();
		String[] values = request.getParameterValues("roomstate");
		for (String s : values) {
			int no = Integer.parseInt(s);
			roomNo.add(no);
		}

		RoomManagementService roomService1 = new RoomManagementService();
		int value = roomService1.activateRoom(roomNo);
		String message1="Rooms are activated";
		request.setAttribute("message1",message1 );
		RequestDispatcher rd1 = request.getRequestDispatcher("/JSP/adminHome.jsp");
		rd1.forward(request, response);
		
	}

	private void displayRoomsDeactivated(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RoomManagementService roomService = new RoomManagementService();
		ArrayList<Room> roomList2 = roomService.displayDeactivatedRooms();
		request.setAttribute("roomList2", roomList2);
		RequestDispatcher rd = request.getRequestDispatcher("/JSP/activateRoom.jsp");
		rd.forward(request, response);
	}

	private void roomUpdateSuccess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		log.info("Now Inside roomUpdateSuccess()  method of  RoomManagementController class");
		Room room = new Room();
		room.setRoomNo(Integer.parseInt(request.getParameter("room")));
		room.setCategory(request.getParameter("category"));
		room.setTariff(Double.parseDouble(request.getParameter("tariff")));
		room.setSpecality(request.getParameter("speciality"));

		room.setADStatus(request.getParameter("adstatus"));

		if (request.getParameter("category").equals("a/c standard")) {
			room.setCategoryId(02);

		} else if (request.getParameter("category").equals("nona/cstandard")) {
			room.setCategoryId(01);

		} else if (request.getParameter("category").equals("a/cdeluxe")) {
			room.setCategoryId(04);

		} else if (request.getParameter("category").equals("nona/cdeluxe")) {
			room.setCategoryId(03);

		} else if (request.getParameter("category").equals("premium")) {
			room.setCategoryId(05);

		}
		RoomManagementService roomService2 = new RoomManagementService();
		int roomNo1;
		try {
			roomNo1 = roomService2.updateDetails(room);
			request.setAttribute("roomNo1", roomNo1);

		} catch (Exception e) {

			e.printStackTrace();
		}
		
		String message3="Room details are  updated succesfully";
		request.setAttribute("message3",message3 );
		RequestDispatcher rd2 = request.getRequestDispatcher("/JSP/adminHome.jsp");
		rd2.forward(request, response);
		
	}

	private void roomUpdateDetails(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		log.info("Now Inside roomUpdateDetails()  method of  RoomManagementController class");
		int roomNo = Integer.parseInt(request.getParameter("room"));
		RoomManagementService roomService1 = new RoomManagementService();
		ArrayList<Room> roomList1 = roomService1.updateRoom(roomNo);
		request.setAttribute("roomList1", roomList1);

		RequestDispatcher rd1 = request
				.getRequestDispatcher("/JSP/updateRoomDetails.jsp");
		rd1.forward(request, response);
	}

	private void displayUpdateRooms(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		log.info("Now Inside displatUpdateRooms()  method of  RoomManagementController class");
		RoomManagementService roomService = new RoomManagementService();
		ArrayList<Room> roomList = roomService.displayRooms();
		request.setAttribute("roomList", roomList);
		RequestDispatcher rd = request.getRequestDispatcher("/JSP/updateRoom.jsp");
		rd.forward(request, response);
	}

	
}
