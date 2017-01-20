<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.ArrayList,com.tcs.bean.Room;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!--META TAGS-->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!--STYLE SHEETS-->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/CSS/home_style.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/CSS/adminPage_style.css" />

<!--SCRIPTS-->
<script type="text/javascript" src="<%=request.getContextPath() %>/JS/adminValidation.js"> </script>
<script>
history.forward(); </script>

<!--TITLE OF PG-->
<title>Activate Room </title>
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

<%if(session.getAttribute("user")==null){
response.sendRedirect("Login.jsp");
} %>

<%
String name=session.getAttribute("user").toString();
%> 
<div id="user">
WELCOME <%=name %>
<br/>
<a href="<%=request.getContextPath() %>/JSP/Logout.jsp">Logout</a>
</div>

<div id="strip">
</div>

<!--TOP MENU-->
<div id="top_menu" >
<ul id="menu" style="list-style:none;">
<li><a href="<%=request.getContextPath() %>/JSP/Login.jsp">Home</a> </li>
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

 <div id="admin_navigation_table">
	<table border="1" cellpadding="25" style="border-collapse:collapse">
	   <tr>
	      <td><a href="<%=request.getContextPath() %>/JSP/adminHome.jsp">Admin Home</a></td>
	   </tr>
	   <tr>
	      <td><a href="<%=request.getContextPath() %>/JSP/addRoom.jsp">Add New Room</a></td>
	   </tr>
	   <tr>
	      <td><a href="<%=request.getContextPath() %>/RoomManagementController?name=update">Update Room Details </a></td>
	   </tr>
	   <tr>
	      <td><a href="<%=request.getContextPath() %>/RoomManagementController?state=activate">Activate Room</a></td>
	   </tr>
	   <tr>
	      <td><a href="<%=request.getContextPath() %>/RoomManagementController?status=deactivate">Deactivate Room</a></td>
	   </tr>
	</table>
 </div>
 
 <div id="display_deactivated_rooms">
 <center><h3>Deactivated Rooms</h3></center>
<form name="activateRoom" onsubmit="return activateroomvalidate();" action="RoomManagementController" method="post" >

<%
ArrayList<Room> roomList2=(ArrayList<Room>)request.getAttribute("roomList2");
if(roomList2.size()==0){%>
<center>No room are available for activation</center>
<%}
if(roomList2.size()>0){
%>

<table border="1" cellpadding="10" style="border-collapse:collapse">

  <tr style="bgcolor:grey">
  <th>Select</th>
  <th>Room No</th>
  <th>Tariff</th>
  <th>A/D Status</th>
  <th>Category</th>
  <th>Speciality</th>
  
  
  </tr>
  <%for(Room r: roomList2){ %>
 <%int x=r.getRoomNo(); %>
  <tr>
  <td><input type="checkbox" name="roomstate"  value=<%=x %>></td>
  <td><%=r.getRoomNo() %></td>
  <td><%=r.getTariff() %></td>
  <td><%=r.getADStatus() %></td>
  <td><%=r.getCategory() %></td>
  <td><%=r.getSpecality() %></td>
  
  
  </tr>
  <%} %>




</table>
<br/>
<center><input type="submit" name="submit" value="Activate"/></center>
<%} %>
<input type="hidden" name="action" value="activateroom"/>
</form>
</div>
 	
</div>

<!--FOOTER-->
<div id="footer">
@2014 The Exotic Hotels company ltd. All rights Reserved.
contact us :9674839362 
</div>




</body>
</html>