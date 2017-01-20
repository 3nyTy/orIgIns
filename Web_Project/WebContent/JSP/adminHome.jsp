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
 


 <!--SCRIPTS-->
 <script>history.forward();</script>


 <!--TITLE OF PG-->
 <title>Admin Home</title>
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

<center>
   <table border="0" cellpadding="20"  style="border-collapse:collapse">
      <tr>
	     <td><a href="<%=request.getContextPath() %>/JSP/addRoom.jsp" ><img src="<%=request.getContextPath() %>/images/add.png"  alt="addRoom" width="182" height="168"/></a></td>
		 <td></td>
		 <td><a href="<%=request.getContextPath() %>/RoomManagementController?name=update" ><img src="<%=request.getContextPath() %>/images/update.png" alt="updateRoom" width="182" height="168"/></a></td>
	  </tr>
	  <tr>
	     <td><a href="<%=request.getContextPath() %>/RoomManagementController?state=activate" ><img src="<%=request.getContextPath() %>/images/activate.png" alt="activateRoom" width="182" height="168"/></a></td>
		 <td></td>
		 <td><a href="<%=request.getContextPath() %>/RoomManagementController?status=deactivate" ><img src="<%=request.getContextPath() %>/images/deactivate.png" alt="deactivateRoom" width="182" height="168"/></a></td>
	  </tr>
   
   </table>
	</center>
	
	 <center><%String msg1=(String)request.getAttribute("message1");
 if(msg1==null){
	 
 }
 else{
	%>
	<p><%=msg1 %></p>
	<%
	 }
 %></center>
  <center><%String msg=(String)request.getAttribute("message7");
 if(msg==null){
	 
 }
 else{
	%>
	<p><%=msg %></p>
	<%
	 }
 %></center>
 
 <center><%String msg2=(String)request.getAttribute("message3");
 if(msg2==null){
	 
 }
 else{
	%>
	<p><%=msg2 %></p>
	<%
	 }
 %></center>
 
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