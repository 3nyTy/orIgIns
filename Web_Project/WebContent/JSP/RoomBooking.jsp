<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!--META TAGS-->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!--STYLE SHEETS-->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/CSS/home_style.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/CSS/CustomerPage_Style.css" />

<!--SCRIPTS-->
  <script type="text/javascript" src="../JS/RoomBookingValidation.js"></script>
  <script>history.forward();</script>

<!--TITLE OF PG-->
<title>Book Room</title>
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
		<%if(session.getAttribute("CustomerName")==null){
response.sendRedirect("/JSP/Login.jsp");
} %>

<%
String name=session.getAttribute("CustomerName").toString();
%> 
 <div id="user">
WELCOME  <%=name %>
<br/>
<a href="<%=request.getContextPath() %>/JSP/Logout.jsp">Logout</a>
</div>

		<div id="strip"></div>

		<!--TOP MENU-->
		<div id="top_menu">
			<ul id="menu" style="list-style: none;">
		<%if(session.getAttribute("CustomerName")!=null){%><li><a href="<%=request.getContextPath() %>/JSP/Home.jsp">Home</a> </li><%}else{%>
<li><a href="<%=request.getContextPath() %>/JSP/Login.jsp">Home</a> </li><%} %> 
<li><a href="<%=request.getContextPath() %>/JSP/Aboutus.jsp">About Us</a> </li>
<li><a href="<%=request.getContextPath() %>/JSP/Contactus.jsp">Contact Us</a> </li>
			</ul>
		</div>
	</div>

	<!-- DROP MENU-->
	<div class="drop-menu">
		<span class="plus">Search Rooms</span>
		<ul style="list-style: none;" class="sub-menu">
			

<li><a href="<%=request.getContextPath() %>/JSP/searchByCategory.jsp" >&nbsp;View by Category</a> </li>
<li><a href="<%=request.getContextPath() %>/JSP/searchByTariff.jsp" >&nbsp;&nbsp;View by Tariff</a> </li>
<li><a href="<%=request.getContextPath() %>/JSP/SearchViewAll.jsp">&nbsp;&nbsp;View all rooms</a> </li>		</ul>
	</div>


	<!--MIDDLE STRIP-->
	<div id="middle_strip">
		<div id="customer_navigation_table">
			<table border="1" cellpadding="25" style="border-collapse: collapse">
				<tr>
					<td><a href="<%=request.getContextPath() %>/JSP/customerHome.jsp">Customer Home</a></td>
				</tr>
				<tr>
					<td><a href="<%=request.getContextPath() %>/JSP/Search.jsp">Book Room</a></td>
				</tr>
				<tr>
					<td><a href="<%=request.getContextPath() %>/JSP/CancelBooking.jsp">Cancel Room</a></td>
				</tr>
			</table>
		</div>


		<div id="room_booking_form">
			<center>
				<h1>Room Booking Form</h1>
			</center>
			<form name="RoomBookingForm"
			onsubmit="return validateRoomBookingForm();"
				action="<%=request.getContextPath() %>/CustomerController" method="post">
				<table class="tb1" border="0" align="center">

					<tr>
						<td>Customer Name:</td>
						<td><input type="text" name="name" id="name"></td>
						<td>
							<p id=custName></p>
						</td>
					</tr>
					<tr>
						<td>User Name:</td>
						<td><input type="text" name="userName" id="userName"></td>
						<td>
							<p id=userName></p>
						</td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><input type="password" name="password" id="password"></td>
						<td>
							<p id=pwd></p>
						</td>
					</tr>
					<tr>
						<td>Email Id:</td>
						<td id=><input type="text" name="email" id="email">
						</td>
						<td>
							<p id=emailId></p>
						</td>
					</tr>
					<tr>
						<td>Contact Number:</td>
						<td><input type="text" name="contactNo" id="contactNo">
						</td>
						<td>
							<p id=contact></p>
						</td>
					</tr>
					<tr>
					<% 
					String str=request.getParameter("roomNo");
					
					String []res=str.split(","); %>
					<td> Room No:</td>
					<td> <input type="text" name="roomNo" id="roomNo" value="<%=res[0] %>" readonly>
					<tr>
					<tr>
					<td> From date:</td>
					<td> <input type="text" name="from" id="from" value="<%=res[1]%>" readonly>
					<tr>
					<tr>
					<td> To date:</td>
					<td> <input type="text" name="to" id="to" value="<%=res[2] %>" readonly>
					<tr>
						<td>&nbsp;</td>
						<td><input type="hidden" value="RoomBooking" name="action">
							<input type="submit" value="Confirm" /> <input type="reset"
							value="Cancel" /></td>
					</tr>
				</table>
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