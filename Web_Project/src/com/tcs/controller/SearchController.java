package com.tcs.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.tcs.bean.Room;
import com.tcs.service.SearchService;

/**
 * Servlet implementation class searchController
 */
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  Logger log = Logger.getLogger(SearchController.class);

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
	String action=request.getParameter("action");
	if(action.equals("searchByCategory"))
	{
		String category=request.getParameter("room");
		String fd=request.getParameter("fdate");
		String td=request.getParameter("tdate");
		
		
		SearchService searchservice= new SearchService();
		ArrayList<Room> roomList=searchservice.searchByCategory(category,fd,td);
        request.setAttribute("roomList",roomList);
		request.setAttribute("fromdate",fd);
		request.setAttribute("todate",td);
		RequestDispatcher rd=request.getRequestDispatcher("/JSP/SearchResult.jsp");
		rd.forward(request,response);
		
		
	}
	if(action.equals("tariff"))
	{
		String t=request.getParameter("room");
		String fd=request.getParameter("fdate");
		String td=request.getParameter("tdate");
		int tariff=Integer.parseInt(t);
		SearchService searchservice= new SearchService();
		ArrayList<Room> roomList=searchservice.searchByTariff(tariff,fd,td);
		request.setAttribute("roomList", roomList);
		request.setAttribute("fromdate",fd);
		request.setAttribute("todate",td);
		RequestDispatcher rd=request.getRequestDispatcher("/JSP/SearchResult.jsp");
		rd.forward(request,response);
		
		
	}
	if(action.equals("viewAll"))
	{
		SearchService searchservice= new SearchService();
		
		String fd=request.getParameter("fdate");
		String td=request.getParameter("tdate");
		ArrayList<Room> roomList=searchservice.viewAll(fd,td);
		request.setAttribute("roomList", roomList);
		request.setAttribute("fromdate",fd);
		request.setAttribute("todate",td);
		RequestDispatcher rd=request.getRequestDispatcher("/JSP/SearchResult.jsp");
		rd.forward(request,response);
		
		}
	}

}
