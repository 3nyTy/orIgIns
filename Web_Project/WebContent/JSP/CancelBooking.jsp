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
<script type="text/javascript" src="<%=request.getContextPath() %>/JS/CancelBookingValidation.js">
</script>

<script>history.forward();</script>

<!--TITLE OF PG-->
<title>Booking Cancellation Form</title>
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
response.sendRedirect("Login.jsp");
} %>
<%
String name=session.getAttribute("CustomerName").toString();
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

 <div id="customer_navigation_table">
	<table border="1" cellpadding="25" style="border-collapse:collapse">
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
 
 <div id="cancel_room_form">
<center><h1>Booking Cancellation Form</h1></center>
<form name="BookingCancellationForm" onsubmit="return validateCancelBookingForm();" action="<%=request.getContextPath() %>/CustomerController" method="post">
<table border="0" align="center">
<tr> 
<td>Booking Id:</td>
<td id=> <input type="text" name="bookingId" id="bookingId">
</td>
<td> <p id=booking></p></td>
</tr>
<tr>
<td>&nbsp;</td>
<td>
<input type="hidden" value="CancelBooking" name="action">
<input type="submit" value="Confirm"/>
 <input type="reset" value="Cancel"/></td>
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