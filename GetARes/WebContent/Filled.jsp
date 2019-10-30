<%@page import="com.mysql.cj.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%

	response.setHeader("Cache-Control","no-cache");
	response.setHeader("Cache-Control","no-store");
	response.setHeader("Pragma","no-cache");
	response.setDateHeader ("Expires", 0);
	HttpSession oldSession=request.getSession(false);
	if(oldSession.getAttribute("idcode")==null||oldSession.getAttribute("designation")==null)
		response.sendRedirect("Index.jsp");
			 
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get-A-Res</title>

	<style>
			.button {
			  background-color: #4CAF50;
			  border: none;
			  color: white;
			  padding: 15px 32px;
			  text-align: center;
			  text-decoration: none;
			  display: inline-block;
			  font-size: 16px;
			  margin: 4px 2px;
			  cursor: pointer;
			  
			}
			</style>

</head>

<body style="background-color:#ffff99">
	<!--tomato  -->
	<input type="hidden" id="refreshed" value="no">

	
	<h1 style="color:red;background-color:#e6e600;;border:4px solid Tomato; padding: 25px;margin:40px;"> 
		<span style="font-size:60px">Get-A-Res</span>
		<span style="float:right;">YOUR ONLINE<br> RESUME CREATOR</span>
	</h1>
	
    <hr>
    
   <b>Name:</b> ${name}<br>
   <b>Date of Birth:</b> ${dob}<br>
   <b>Mobile no.:</b> ${mob_no}<br>
   <b>Email ID:</b> ${user_id}<br>
   <br><b style="font-size: 22">10th Details:</b><br>
   <b>Board:</b>${board_10}<br>
   <b>Percentage:</b> ${tenth}<br> 
   <b>School:</b> ${tenscl}<br>
   <b>Year of Passing:</b> ${year_10}<br>
   <br><b style="font-size: 22">12th Details</b><br>
   <b>Board:</b>${board_12}<br>
   <b>Percentage:</b> ${twelth}<br>
   <b>School:</b> ${twescl}<br>
   <b>Year of Passing:</b>${year_12}<br>
   <br><b style="font-size: 22">Graduation Details:</b><br>
   <b>University:</b>${university}<br> 
   <b>Percentage:</b> ${bclg}<br>
   <b>College Name:</b> ${clgname}<br>
   <b>Year of Passing:</b>${year_clg}<br>
   <br>
   <b>Skills:</b><br>
   ${skills}<br>
   <br>
   <b>Projects:</b><br>
   ${projects}<br>
   <br>
   <b>Certifications</b><br>
   ${certi}<br>
   <br>
   <b>Designation</b>: ${designation}<br>
   
   <a href="Resume" class="button">Get A Resume</a>
   <a href="Logout" class="button">Logout</a>

</body>
</html>