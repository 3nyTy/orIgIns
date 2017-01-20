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
<script type="text/javascript" src="<%=request.getContextPath() %>/JS/CategoryValidation.js"></script>
<script>history.forward();</script>

<!--TITLE OF PG-->
<title>Search By Category</title>


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

<div id="search_category">
<center><h1 style="font-size:20px">Rooms By Category</h1></center>
<form name="category" onsubmit="return validateCategory();" action="<%=request.getContextPath() %>/SearchController" method="post" >
<table >
<tr><td><font color="red">Select from the following:</font></td></tr>
<tr><td></td></tr>
 <tr>
 <td>Standard Rooms:</td>
 <td><input type="radio" name="room" value="a/cstandard" id="room">AC</td>
 <td><input type="radio" name="room" value="nona/cstandard" id="room">Non-AC</td>
 </tr>
 <tr>
 <td>Deluxe Rooms:</td>
 <td><input type="radio" name="room" value="a/cdeluxe" id="room">AC</td>
 <td><input type="radio" name="room" value="nona/cdeluxe" id="room">Non-AC</td>
 </tr>
 <tr>
 <td>Premium Rooms:</td>
 <td><input type="radio" name="room" value="premium" id="room">AC</td></tr>
 <tr><td>Enter the dates of stay:</td>
 </tr>
 <tr><td>From:</td><td><input type="text" name="fdate" id="fdate" ></td>
 <td>(in dd/mm/yyyy format)</td></tr>
 <tr><td>To:</td><td><input type="text" name="tdate" id="tdate"></td>
 <td>(in dd/mm/yyyy format)</td></tr>

 
   
 </table>
   <center><input type="submit" value="Search Rooms"></center>
   <input type="hidden" name="action" value="searchByCategory">
 
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