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
<script type="text/javascript" src="<%=request.getContextPath() %>/JS/LoginValidation.js"></script>
<script>history.forward();</script>
<!--TITLE OF PG-->
<title>Exotic-Home</title>


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

<!--HOTEL IMAGE-->
<div id="hotelimage">
<img src="<%=request.getContextPath() %>/images/img.png" alt="hotel"/>
</div>

<!--WELCOME QUOTE-->
<div id="welcome">
<img src="<%=request.getContextPath() %>/images/welcome3.png" alt="welcome"/>
</div>

<!--HISTORY-->

<div id="history">
The Indian Hotels Company Limited (IHCL) and its subsidiaries are collectively known as Exotic Hotels and is recognized as one of the Asia's largest and finest hostel company. 
Incorporated by the founder of the VS Group,Mr.Viaml,  the company opened its first property,The Exotic Hotel ,in Bombay in 1922.
The Exotic, a symbol of Indian Hospitality,completed its centenary year in 2000.
</div>

<!--LOGIN-->
<div id="login">
<form name="LoginForm" onsubmit="return validateLoginForm();" action="<%=request.getContextPath() %>/LoginController" method="post">
<table border="0" align="center">
<caption>Login Form</caption>
<tr> 
<td id="td">User Id:</td>
<td id=> <input type="text" name="userId" id="userId">
</td>
</tr>
<tr> 
<td id="td">Password:</td>
<td id=> <input type="password" name="password" id="password">
<input type="hidden" name="action" value="login">
</td>
</tr>
<tr>
<td>&nbsp;</td>
<td>
<input type="submit" value="Sign in"/></td>
</tr>
<tr>
<td> New Customer?</td>
<td> <a href="<%=request.getContextPath() %>/JSP/Registration.jsp"><u>Register</u></a></td>
</table>
</form>

<%if(request.getAttribute("fail")!=null)
	{%>
	<p><%=request.getAttribute("fail") %></p>
	<%} %>
	
	<%if(request.getAttribute("msg")!=null)
	{%>
	<p><%=request.getAttribute("msg") %></p>
	<%} %>
	
	

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