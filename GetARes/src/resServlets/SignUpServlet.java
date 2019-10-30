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

public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String f_name;
	private String l_name;
	private String user_id;
	private String password;
	private String dob;
	private String mob_no;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		f_name=request.getParameter("firstname");
		l_name=request.getParameter("lastname");
		user_id=request.getParameter("user_id");
		password=request.getParameter("password");
		dob=request.getParameter("dob");
		mob_no=request.getParameter("mob_no");
		
		Connection con=DbConnection.makeConnection();
		
		PreparedStatement st = con.prepareStatement("insert into signup (firstname,lastname,id,password,mobile_no,dob) values(?,?,?,?,?,?)");
		st.setString(1, f_name);
		st.setString(2, l_name);
		st.setString(3, user_id);
		st.setString(4, password);
		st.setString(5, mob_no);
		st.setString(6, dob);
		
		st.executeUpdate();
		st.close();
		con.close();
		
		
		Connection con2=DbConnection.makeConnection();
		PreparedStatement st2 = con2.prepareStatement("select idcode from signup where id=?");
		
		st2.setString(1, user_id);
		
		ResultSet rs = st2.executeQuery();
		rs.first();
		int idcode=rs.getInt("idcode");
		rs.close();
		st2.close();
	
		con2.close();
		
		HttpSession oldSession = request.getSession(false);
        if (oldSession != null) {
            oldSession.invalidate();
        }	
        
		HttpSession hs=request.getSession(true);
		hs.setMaxInactiveInterval(30*60);
		
		hs.setAttribute("name", f_name+" "+l_name);
		hs.setAttribute("user_id", user_id);
		hs.setAttribute("dob", dob);
		hs.setAttribute("mob_no", mob_no);
		hs.setAttribute("idcode", idcode);
		
		RequestDispatcher rd=request.getRequestDispatcher("/Profile.jsp");
		rd.forward(request, response);
		
		}catch(Exception e) {
			 e.printStackTrace();
		}
	}
	

}
