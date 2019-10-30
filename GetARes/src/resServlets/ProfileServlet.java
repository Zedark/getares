package resServlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession hs=request.getSession();
		
		ServletContext sc=this.getServletContext();
		RequestDispatcher rd=sc.getRequestDispatcher("/Profile.jsp");
		
		String f_name=request.getParameter("firstname");
		String l_name=request.getParameter("lastname");
		String user_id=request.getParameter("user_id");
		String dob=request.getParameter("dob");
		String mob_no=request.getParameter("mob_no");
		
		
		
		rd.forward(request, response);
		
	}
	
	protected void doget() {
		
	}

}
