package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.google.inject.Singleton;

@Singleton
public class ActionServlet extends HttpServlet {

	private static final long serialVersionUID = -416566523583300983L;
	@Override
	protected void service(HttpServletReuest request,HttpServletResponse response)throws ServletException,IOException
	Long ID = request.getParameter("Id");
	String userName = request.getParameter("userName");
	String password = request.getParameter("password");
	
	response.getWriter().println("Id"+id+ " User name: " +UserName +"and Password :"password");
	
}
