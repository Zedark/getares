package resServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int idcode;
	private String lastname;
	private String firstname;
	private String user_id;
	private String password;
	private String mobile_no;
	private String dob;
	
	private double tenth;
	private double twelth;
	private double bclg;
	private String tenscl;
	private String twescl;
	private String clgname;
	private String skills;
	private String certi;
	private String designation;
	private String projects;
	private String board_10;
	private String board_12;
	private String university;
	private int year_10;
	private int year_12;
	private int year_clg;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		response.setContentType("text/html");
		
		HttpSession oldSession = request.getSession(false);
        if (oldSession != null) {
            oldSession.invalidate();
        }	
        
        HttpSession newSession=request.getSession(true);
        newSession.setMaxInactiveInterval(30*60);
        
		PrintWriter out=response.getWriter();
		user_id=request.getParameter("user_id");
		String password_html=request.getParameter("password");
		
		Connection con=DbConnection.makeConnection();
		PreparedStatement st = con.prepareStatement("select password from signup where id=?");
		st.setString(1,user_id);
		
		ResultSet rs=st.executeQuery();
		
		if(rs.next()==false)
		{
			//not closing the connection here
			response.sendRedirect("LoginFailed.html");
		}
		else
		{
			rs.first();
			password=rs.getString("password");
			st.close();
		}
		
		if(password.equals(password_html)) {
			
			PreparedStatement st1 = con.prepareStatement("select * from signup where id=?");
			st1.setString(1, user_id);
			ResultSet rs1=st1.executeQuery();
			rs1.first();
			
			idcode=rs1.getInt("idcode");
			firstname=rs1.getString("firstname");
			lastname=rs1.getString("lastname");
			user_id=rs1.getString("id");
			password=rs1.getString("password");
			mobile_no=rs1.getString("mobile_no");
			dob=rs1.getString("dob");
			
			rs1.close();
			st1.close();
			
			PreparedStatement st2 = con.prepareStatement("select * from resdetails where idcode=?");
			st2.setInt(1, idcode);
			ResultSet rs2=st2.executeQuery();
			rs2.first();
			
			tenth=rs2.getDouble("tenth");
			twelth=rs2.getDouble("twelth");
			bclg=rs2.getDouble("bclg");
			tenscl=rs2.getString("tenscl");
			twescl=rs2.getString("twescl");
			clgname=rs2.getString("clgname");
			skills=rs2.getString("skills");
			certi=rs2.getString("certi");
			designation=rs2.getString("designation");
			projects=rs2.getString("projects");
			board_10=rs2.getString("board_10");
			board_12=rs2.getString("board_12");
			university=rs2.getString("university");
			year_10=rs2.getInt("year_10");
			year_12=rs2.getInt("year_12");
			year_clg=rs2.getInt("year_clg");
			
			rs2.close();
			st2.close();
			
			newSession.setAttribute("name", firstname+" "+lastname);
			newSession.setAttribute("idcode", idcode);
			newSession.setAttribute("user_id", user_id);
			newSession.setAttribute("password", password);
			newSession.setAttribute("mob_no", mobile_no);
			newSession.setAttribute("dob", dob);
						
			newSession.setAttribute("tenth", tenth);
			newSession.setAttribute("twelth", twelth);
			newSession.setAttribute("bclg", bclg);
			newSession.setAttribute("tenscl", tenscl);
			newSession.setAttribute("twescl", twescl);
			newSession.setAttribute("clgname", clgname);
			newSession.setAttribute("skills", skills);
			newSession.setAttribute("certi", certi);
			newSession.setAttribute("designation", designation);
			newSession.setAttribute("projects", projects);
			newSession.setAttribute("board_10", board_10);
			newSession.setAttribute("board_12", board_12);
			newSession.setAttribute("university", university);
			newSession.setAttribute("year_10", year_10);
			newSession.setAttribute("year_12", year_12);
			newSession.setAttribute("year_clg", year_clg);
			
			con.close();
			
			RequestDispatcher rd=request.getRequestDispatcher("/Filled.jsp");
			rd.forward(request, response);
			
		}
		
		else
		{
			con.close();
			response.sendRedirect("LoginFailed.html");
		}
		
		}catch(Exception e) {
			 e.printStackTrace();
		}
	}

}
