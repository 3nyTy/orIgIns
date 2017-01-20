<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<script type="text/javascript" src="<%=request.getContextPath() %>/JS/TariffValidation.js"></script>
<script>history.forward();</script>

<!--TITLE OF PG-->
<title>Search By Tariff</title>

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

<div id="search_tariff">
<center><h1 style="font-size:20px"> Rooms By Tariff</h1></center>
<form name="tariff" onsubmit="return validateTariff();" method="post" action="<%=request.getContextPath() %>/SearchController">
<table>
<tr>
<td><font color="red">Type of room</font></td>
<td><font color="red">Tariff per day</font></td>
</tr>
<tr><td></td></tr>
<tr><td></td></tr>
<tr>
<td>Standard Rooms:</td>
<td><input type="radio" name="room" value="1">Rs.2500-3000 Non-AC</td>
<td><input type="radio" name="room" value="2">Rs.3000-4000 AC</td>
</tr>
<tr>
<td>Deluxe Rooms:</td>
<td><input type="radio" name="room" value="3">Rs.4500-5500 Non-AC</td>
<td><input type="radio" name="room" value="4">Rs.6500-7000 AC</td>
</tr>
<tr>
<td>Premium Rooms:</td>
<td><input type="radio" name="room" value="5">Rs.10000-15000 AC</td>
</tr>
<tr><td>Please enter your dates of stay:(in dd/mm/yyyy format)
<tr><td>From:</td><td><input type="text" name="fdate" id="fdate" ></td></tr>
<tr><td>To:</td><td><input type="text" name="tdate" id="tdate"></td></tr>


</table>
<center><input type="submit" value="Check Avaialability"></center>
<input type="hidden" value="tariff" name="action">

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