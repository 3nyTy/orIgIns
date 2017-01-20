<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    <%@ page import="java.sql.*,java.util.*,java.lang.*,com.tcs.bean.Room"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!--META TAGS-->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!--STYLE SHEETS-->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/CSS/home_style.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/CSS/adminHome_style.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/CustomerHome_Style.css" />

<!--SCRIPTS-->
<script>history.forward();</script>

<!--TITLE OF PG-->
<title>Available Rooms</title>
</head>
<body>

<!--HEADER-->
<!-- TOP GREEN STRIP-->
<div id="top_strip">

<!-- EXOTIC LOGO-->
<center>
<div id="logo">
<a href="<%=request.getContextPath() %>/JSP/Login.jsp"><img src="<%=request.getContextPath() %>/images/logo.jpg" /></a>
</div>
</center>
<%if(session.getAttribute("user")!=null){ 
String name=session.getAttribute("user").toString();%>
<div id="user">

WELCOME <%=name %>
<br/>
<a href="<%=request.getContextPath() %>/JSP/Logout.jsp">Logout</a>
</div>
<%} %>

<%if(session.getAttribute("CustomerName")!=null){ 
String user=session.getAttribute("CustomerName").toString();%>
<div id="user">

WELCOME <%=user %>
<br/>
<a href="<%=request.getContextPath() %>/JSP/Logout.jsp">Logout</a>
</div>
<%} %>



<div id="strip">
</div>

<!--TOP MENU-->
<div id="top_menu" >
<ul id="menu" style="list-style:none;">
<%if(session.getAttribute("user")!=null||session.getAttribute("CustomerName")!=null){%><li><a href="<%=request.getContextPath() %>/JSP/Home.jsp">Home</a> </li><%}else{%>
<li><a href="<%=request.getContextPath() %>/JSP/Login.jsp">Home</a> </li><%} %> 
<li><a href="<%=request.getContextPath() %>/JSP/Aboutus.jsp">About Us</a> </li>
<li><a href="<%=request.getContextPath() %>/JSP/Contactus.jsp">Contact Us</a> </li>
</ul>
</div>
</div>

<!-- DROP MENU-->
<div class="drop-menu">
<span class="plus">Search Rooms</span>
<ul  style="list-style:none;" class="sub-menu">


<li><a href="<%=request.getContextPath() %>/JSP/searchByCategory.jsp" >&nbsp;View by Category</a> </li>
<li><a href="<%=request.getContextPath() %>/JSP/searchByTariff.jsp" >&nbsp;&nbsp;View by Tariff</a> </li>
<li><a href="<%=request.getContextPath() %>/JSP/SearchViewAll.jsp">&nbsp;&nbsp;View all rooms</a> </li>
</ul>
</div>


<!--MIDDLE STRIP-->
<div id="middle_strip">

<div id="view_rooms_table">
<center><h1 style="font-size:20px"> View Rooms</h1></center>

<%
ArrayList<Room> roomList=(ArrayList<Room>)request.getAttribute("roomList");
String fromdate=request.getAttribute("fromdate").toString();
String todate=request.getAttribute("todate").toString();%>
<%;

if(roomList.size()>0)
{
	%>
	<table  border="1" style="border-collapse:collapse">
<tr>
<td>Room Number</td>
<td>Tariff</td>
<td>Category</td>
<td>Available from</td>
<td>Available to</td></tr>
<%

for(Room room:roomList)
{
    %>
    <% int roomNo=room.getRoomNo(); %>
   <tr><td> <%=room.getRoomNo()%></td>
    <td> <%=room.getTariff()%></td>
    <td><%=room.getCategory() %></td>
    <td><%=fromdate %></td>
    <td><%=todate %></td>
    
     
 <%if(session.getAttribute("CustomerName")!=null){%>  <td><a href="<%=request.getContextPath() %>/JSP/RoomBooking.jsp?roomNo=<%=roomNo %>,<%=fromdate%>,<%=todate%>">Book Now</a></td><%} %>
   
   </tr>

<% 
}
%>


</table>
<%
}
else
{
%>
No Rooms Found
<%} %>
<br/>
<center>
<%if(session.getAttribute("CustomerName")==null){ %>
Please Register to Book Room <br/> 
To Register please click here <a href="<%=request.getContextPath() %>/JSP/Registration.jsp"><u>Register</u></a>
<%} %>
</center>
</div>

 	
</div>

<!--FOOTER-->
<div id="footer">
<div id="footer_content">
@2014 The Exotic Hotels company ltd. All rights Reserved.
contact us :9674839362 
</div>
</div>


</body>
</html>