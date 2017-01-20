<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!--META TAGS-->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!--STYLE SHEETS-->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/CSS/home_style.css" />


<!--SCRIPTS-->
<script type="text/javascript" src="<%=request.getContextPath() %>/JS/RegistrationValidation.js"> </script>

<!--TITLE OF PG-->
<title>Customer Registration Page</title>
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
<center><h1 >Customer Registration</h1></center>	
	<div id="customer_registration_table">



<form name="RegistrationForm"  onsubmit="return validateRegistrationForm();" action="<%=request.getContextPath() %>/CustomerController" method="post">
<table  cellpadding="8">

<tr> 
<td>Customer Name:</td>
<td> <input type="text" name="name" id="name">
</td>
<td id=ctname></td>
</tr>
<tr>
<td> Address:</td>
<td> <textarea rows="2" cols="16" name="address" id="address"></textarea>
</td>
<td> <p id=custAddress></p></td>
</tr>
<tr> 
<td>Email Id:</td>
<td id=> <input type="text" name="email" id="email" >
</td>
<td> <p id=emailId></p></td>
</tr>
<tr> 
<td id="td">Contact Number:</td>
<td id=> <input type="text" name="contactNo" id="contactNo">
</td>
<td id=contact></td>
</tr>
<tr> 
<td id="td">User Id:</td>
<td id=> <input type="text" name="userId" id="userId">
</td>
<td> <p id=uId></p></td>
</tr>
<tr> 
<td id="td">Password:</td>
<td id=> <input type="password" name="password" id="password">
</td>
<td> <p id=pwd></p></td>
</tr>
<tr> 
<td id="td">Confirm Password:</td>
<td id=> <input type="password" name="confirmPassword" id="confirmPassword">
</td>
<td> <p id=confirmPwd></p></td>
</tr>
<tr>
<td>&nbsp;</td>
<td>

<input type="submit" value="Confirm"/>
 <input type="reset" value="Cancel"/>
 <input type="hidden" value="Registration" name="action"></td>
</tr>
</table>
</form>
<center>
<%if(request.getAttribute("mismatch")==null){
	
}else{
	%>
	<%=request.getAttribute("mismatch") %>
	<% }%>
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