<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	response.setHeader("Cache-Control","no-cache");
	response.setHeader("Cache-Control","no-store");
	response.setHeader("Pragma","no-cache");
	response.setDateHeader ("Expires", 0);
	
	HttpSession oldSession=request.getSession(false);
	if(oldSession.getAttribute("idcode")!=null)
		response.sendRedirect("Filled.jsp");
	System.out.println(oldSession.getAttribute("idcode"));		 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
	

	
	<h1 style="color:red;background-color:#e6e600;;border:4px solid Tomato; padding: 25px;margin:40px;"> 
		<span style="font-size:60px">Get-A-Res</span>
		<span style="float:right;">YOUR ONLINE<br> RESUME CREATOR</span>
	</h1>
	
	<hr>

	<div style="position: relative; top: 50px; left: 700px; ">
			<form method="post" action="logIn">
					Id:<br>
					<input type="email" name="user_id">
					<br>
					Password:<br>
					<input type="password" name="password">
					<br>
					<input type="submit" class="button" value="Login">
			</form>

			<h3>OR SIGNUP :</h3>
			<a class="button" href="Signup.html">Sign Up</a>
	</div>



</body>
</html>