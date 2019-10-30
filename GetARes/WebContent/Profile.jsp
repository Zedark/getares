<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%

	response.setHeader("Cache-Control","no-cache");
	response.setHeader("Cache-Control","no-store");
	response.setHeader("Pragma","no-cache");
	response.setDateHeader ("Expires", 0);
	HttpSession oldSession=request.getSession(false);
	if(oldSession.getAttribute("idcode")==null)
		response.sendRedirect("Index.jsp");
	else if(oldSession.getAttribute("idcode")!=null && oldSession.getAttribute("designation")!=null)
		response.sendRedirect("Filled.jsp");
			 
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
	

	
	<h1 style="color:red;background-color:#e6e600;;border:4px solid Tomato; padding: 25px;margin:40px;"> 
		<span style="font-size:60px">Get-A-Res</span>
		<span style="float:right;">YOUR ONLINE<br> RESUME CREATOR</span>
	</h1>
	
    <hr>
    
   <b>Name:</b>${name}<br>
   <b>Date of Birth:</b>${dob}<br>
   <b>Mobile no.:</b>${mob_no}<br>
   <b>Email ID:</b>${user_id}<br>
      
   <form action="after" method="post">
   <br><b style="font-size: 22">10th Schooling:</b><br>
   <b>Board:</b><br>
   <input type="text" name="board_10" required>
   <br>
   <b>Percentage:</b><br>
   <input type="text" name="tenth" required>
   <br>
   <b>School:</b><br>
   <input type="text" name="tenscl" required>
   <br>
   <b>Year of Passing:</b><br>
   <input type="number" name="year_10" required>
   <br>
   <br><b style="font-size: 22">12th Schooling:</b><br>
   <b>Board:</b><br>
   <input type="text" name="board_12" required>
   <br>
   <b>Percentage:</b><br>
   <input type="text" name="twelth" required>
   <br>
   <b>School:</b><br>
   <input type="text" name="twescl" required>
   <br>
   <b>Year of Passing:</b><br>
   <input type="number" name="year_12" required>
   <br>  
   <br><b style="font-size: 22">Graduation Details:</b><br>
   <b>University:</b><br>
   <input type="text" name="university" required>
   <br>
   <b>Percentage:</b><br>
   <input type="text" name="bclg" required>
   <br>
   <b>Name of the Institute:</b><br>
   <input type="text" name="clgname" required>
   <br>
   <b>Year of Passing:</b><br>
   <input type="number" name="year_clg" required>
   <br>  
   <b>Skills:</b>Enter your skills here (Hit 'Enter' to enter a new skill)<br>      
   <textarea rows="5" cols="50" name="skills">
   
   </textarea>
   <br>
   <b>Projects:</b>Enter your certifications here (Hit 'Enter' to enter a new project)<br>
   <textarea rows="5" cols="50" name="projects">
   
   </textarea>
   <br>
   <b>Certifications:</b>Enter your certifications here (Hit 'Enter' to enter about a new certification<br>
   <textarea rows="5" cols="50" name="certi">
   
   </textarea>
   <br>
   <b>Designation:</b><br>
   <input type="text" name="designation" required>
   <br>
   <input type="submit" value="Complete Sign Up" name="Save Details" class="button">
   </form> 
    
</body>
</html>