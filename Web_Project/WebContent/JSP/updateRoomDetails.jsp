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
<script>history.forward();</script>

<!--TITLE OF PG-->
<title>Update Room Details</title>

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
response.sendRedirect("/JSP/Login.jsp");
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
<li><a href="<%=request.getContextPath() %>/JSP/Home.jsp">Home</a> </li>
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
 
 <div id="update_details_table">

<form name="updatedetails" onsubmit="return updateroomdetailsvalidate();" action="<%=request.getContextPath() %>/RoomManagementController" method="post" >
<center><h1>Update Room Details</h1></center>
<%
ArrayList<Room> roomList1=(ArrayList<Room>)request.getAttribute("roomList1");

if(roomList1.size()>0){
%>

<table border="1" cellpadding="10" style="border-collapse:collapse">

   <%for(Room r: roomList1){ %>
  
  <tr>
  <td>Room No</td>
  <td><input type="text" name="room" id="room" value=<%=r.getRoomNo()%> readonly ></td>
  <tr/>
  <tr>
  <td>Tariff</td>
  <td><input type="text" name="tariff" id="tariff" value=<%=r.getTariff()%> required></td>
  </tr>
  <tr>
   <tr>
        <td>Category</td>
        <td><select name="category" >
               <option value="select">--Select--</option>
               <option value="nona/cstandard">NON A/C Standard</option>
               <option value="a/cstandard">A/C Standard</option>
               <option value="nona/cdeluxe">NON A/C Deluxe</option>
               <option value="a/cdeluxe">A/C Deluxe</option>
               <option value="premium">Premium</option>
            </select>
        </td>
    </tr>
  <tr>
  <td>Speciality</td>
  <td><input type="text" name="speciality" id="speciality" value=<%=r.getSpecality()%>></td>
  </tr>
  <%} %>
<%} %>
</table>

<br/>
<center><input type="submit" name="submit" value="Update"/></center>
<input type="hidden" name="action" value="updatedetails"/>
</form>
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