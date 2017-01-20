<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--META TAGS-->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!--STYLE SHEETS-->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/home_style.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/CustomerHome_Style.css" />

<!--SCRIPTS-->
<script>history.forward();</script>

<!--TITLE OF PG-->
<title>Customer Home</title>
</head>
<body>

<!--HEADER-->
<!-- TOP GREEN STRIP-->
<div id="top_strip">

<!-- EXOTIC LOGO-->
<center>
<div id="logo">
<a href="<%=request.getContextPath() %>/JSP/Login.jsp"><img src="<%=request.getContextPath()%>/images/logo.jpg" /></a>
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
	<center>
	<div id="customerHome_table">
   <table border="0"  cellpadding="20" style="border-collapse:collapse">
      <tr>
	     <td><a href="<%=request.getContextPath() %>/JSP/Search.jsp" ><img src="<%=request.getContextPath() %>/images/book.png"  alt="bookRoom" /></a></td>
		 <td></td>
		 <td><a href="<%=request.getContextPath() %>/JSP/CancelBooking.jsp" ><img src="<%=request.getContextPath() %>/images/cancel.png" alt="cancelRoom" /></a></td>
	  </tr>
	  <tr>
	     <td align="center"><a href="<%=request.getContextPath() %>/JSP/Search.jsp" >Book Room</a></td>
		 <td></td>
		 <td align="center"><a href="<%=request.getContextPath() %>/JSP/CancelBooking.jsp" >Cancel Room</a></td>
	  </tr>
  </table>
  </div>
	</center>
</div>

<!--FOOTER-->
<div id="footer">
<div id="footer_content">
@2014 The Exotic Hotels company ltd. All rights Reserved.
contact us :9674839362 
</div>
</div>

<p>
</p>

</body>
</html>