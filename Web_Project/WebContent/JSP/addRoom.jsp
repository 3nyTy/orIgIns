<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!--META TAGS-->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!--STYLE SHEETS-->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/CSS/home_style.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/CSS/adminPage_style.css" />

<!--SCRIPTS-->
<script type="text/javascript" src="<%=request.getContextPath() %>/JS/adminValidation.js"></script>
<script>
history.forward(); </script>

<!--TITLE OF PG-->
<title>Room Registration</title>

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
<li><a href="<%=request.getContextPath()%>/JSP/searchByCategory.jsp" >&nbsp;View by Category</a> </li>
<li><a href="<%=request.getContextPath()%>/JSP/searchByTariff.jsp" >&nbsp;&nbsp;View by Tariff</a> </li>
<li><a href="<%=request.getContextPath()%>/JSP/SearchViewAll.jsp">&nbsp;&nbsp;View all rooms</a> </li>
</ul>
</div>

<!--MIDDLE STRIP-->
<div id="middle_strip">

 <div id="admin_navigation_table">
	<table border="1" cellpadding="25" style="border-collapse:collapse">
	   <tr>
	      <td><a href="<%=request.getContextPath()%>/JSP/adminHome.jsp">Admin Home</a></td>
	   </tr>
	   <tr>
	      <td><a href="<%=request.getContextPath()%>/JSP/addRoom.jsp">Add New Room</a></td>
	   </tr>
	   <tr>
	      <td><a href="<%=request.getContextPath()%>/RoomManagementController?name=update">Update Room Details </a></td>
	   </tr>
	   <tr>
	      <td><a href="<%=request.getContextPath()%>/RoomManagementController?state=activate">Activate Room</a></td>
	   </tr>
	   <tr>
	      <td><a href="<%=request.getContextPath()%>/RoomManagementController?status=deactivate">Deactivate Room</a></td>
	   </tr>
	</table>
 </div>	
 
<div id="roomRegistrationform">
  <h1>Room Registration Form</h1>
  <form name="addRoom"  onsubmit="return validateof();" action="<%=request.getContextPath()%>/RoomManagementController" method="post" enctype="multipart/form-data" >
   <table cellpadding="2" >
    <tr>
        <td><label id="roomno1" >Room No:</label></td>
        <td><input type="text" name="roomno" id="roomno"/></td>
    </tr>
    <tr>
        <td><label id="category1" >Category:</label></td>
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
        <td><label id="speciality1" >Speciality:</label></td>
        <td><input type="checkbox" name="speciality" id="speciality" value="balcony"/>Balcony</td>
    </tr>
    <tr>
        <td></td>
        <td><input type="checkbox" name="speciality" id="speciality" value="eastfacing"/>East Facing</td>
    </tr>
    <tr>
        <td></td>
        <td><input type="checkbox" name="speciality" id="speciality" value="topfloor"/>Top Floor</td>
    </tr>
    
    <tr>
        <td><label id="tariff1" >Tariff:</label></td>
        <td><input type="text" name="tariff" id="tariff"/></td>
    </tr>
    
   
    <tr>
        <td><label id="adstatus1" >Status:</label></td>
        <td><input type="radio" name="adstatus" id="adstatus" value="Activated"/>Activated
        <input type="radio" name="adstatus" id="adstatus" value="Deactivated"/>De-activated
        </td>
    </tr>
    <tr><td colspan="2">
   <b>Note:</b> Please Enter Start Date and End Date only if room is deactivated.
    </td>
    </tr> 
     <tr>
        <td><label id="startdate1" >Start Date:</label></td>
        <td><input type="text" name="startdate" id="startdate"/>
        (in dd/mm/yyyy format)</td>
    </tr>
    
    <tr>
        <td><label id="enddate1" >End Date:</label></td>
        <td><input type="text" name="enddate" id="enddate"/>
        (in dd/mm/yyyy format)</td>
    </tr>
     
       <tr>
        <td><label id="photo1" >IMAGE</label></td>
        <td><input type="file" name="photo" id="photo"/></td>
    </tr>
    
    <tr>
        <td><input type="submit" value="submit"/></td>
        <td><input type="reset" value="reset"/></td>
    </tr>
    
  </table>
  
  <input type="hidden" value="addroom" name="action"/>
 
 


  </form>
 <center><%String msg=(String)request.getAttribute("message");
 if(msg==null){
	 
 }
 else{
	%>
	<p><%=msg %></p>
	<%
	 }
 %></center>
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