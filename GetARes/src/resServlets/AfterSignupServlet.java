package resServlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AfterSignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		try {
		HttpSession oldSession=request.getSession(false);
		
		int idcode=(int)oldSession.getAttribute("idcode");
		String tenth=request.getParameter("tenth");
		String tenscl=request.getParameter("tenscl");
		String twelth=request.getParameter("twelth");
		String twescl=request.getParameter("twescl");
		String bclg=request.getParameter("bclg");
		String clgname=request.getParameter("clgname");
		String sk=(String)request.getParameter("skills");
		String ce=(String)request.getParameter("certi");
		String pr=(String)request.getParameter("projects");
		String designation=request.getParameter("designation");
		String year_10=request.getParameter("year_10");
		String year_12=request.getParameter("year_12");
		String year_clg=request.getParameter("year_clg");
		String board_10=request.getParameter("board_10");
		String board_12=request.getParameter("board_12");
		String university=request.getParameter("university");
		
		sk=sk.trim();
		ce=ce.trim();
		pr=pr.trim();
		String skills = "";
		for(int i=0;i<sk.length();i++)
		{
			
			if(sk.charAt(i)=='\n')
			{
				skills=skills+"<br>";
			}
			else
				skills=skills+sk.charAt(i);
		}
		System.out.println(skills);
		
		
		String certi = "";
		for(int i=0;i<ce.length();i++)
		{
			if(ce.charAt(i)=='\n')
			{
				certi=certi+"<br>";
			}
			else
				certi=certi+ce.charAt(i);
		}
		
		System.out.println(certi);
		
		String projects = "";
		for(int i=0;i<pr.length();i++)
		{
			if(pr.charAt(i)=='\n')
			{
				projects=projects+"<br>";
			}
			else
				projects=projects+pr.charAt(i);
		}
		
		System.out.println(projects);
		
		ServletContext sc=this.getServletContext();
		RequestDispatcher rd=sc.getRequestDispatcher("/Filled.jsp");
		
		Connection con=DbConnection.makeConnection();
		PreparedStatement st = con.prepareStatement("insert into resdetails values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
		st.setInt(1, idcode);
		st.setString(2,tenth);
		st.setString(3,twelth);
		st.setString(4,bclg);
		st.setString(5,tenscl);
		st.setString(6,twescl);
		st.setString(7,clgname);
		st.setString(8,skills);
		st.setString(9,certi);
		st.setString(10,designation);
		st.setString(11,projects);
		st.setString(12,year_10);
		st.setString(13,year_12);
		st.setString(14,year_clg);
		st.setString(15,board_10);
		st.setString(16,board_12);
		st.setString(17,university);
		
		st.executeUpdate();
		st.close();
		
		PreparedStatement st2 = con.prepareStatement("select tenth,twelth,bclg,year_10,year_12,year_clg from resdetails where idcode=?");
		st2.setInt(1, idcode);
		ResultSet rs2=st2.executeQuery();
		rs2.first();
		
		//getting the double and int value after conversion from database
		double tenth2=rs2.getDouble("tenth");
		double twelth2=rs2.getDouble("twelth");
		double bclg2=rs2.getDouble("bclg");
		int year10=rs2.getInt("year_10");
		int year12=rs2.getInt("year_12");
		int yearclg=rs2.getInt("year_clg");
		
		rs2.close();
		st2.close();
		con.close();
		
		oldSession.setAttribute("tenth", tenth2);
		oldSession.setAttribute("twelth", twelth2);
		oldSession.setAttribute("bclg", bclg2);
		oldSession.setAttribute("tenscl", tenscl);
		oldSession.setAttribute("twescl", twescl);
		oldSession.setAttribute("clgname", clgname);
		oldSession.setAttribute("skills", skills);
		oldSession.setAttribute("certi", certi);
		oldSession.setAttribute("designation", designation);
		oldSession.setAttribute("projects", projects);
		oldSession.setAttribute("year_10",year10);
		oldSession.setAttribute("year_12", year12);
		oldSession.setAttribute("year_clg", yearclg);
		oldSession.setAttribute("board_10", board_10);
		oldSession.setAttribute("board_12", board_12);
		oldSession.setAttribute("university", university);
		
		rd.forward(request, response);
	
		}catch(Exception e) {
			 e.printStackTrace();
		}
	}
}
