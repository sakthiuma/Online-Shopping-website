import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import bean.*;
import Dao.*;

public class RegisterController extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
	
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	String name=request.getParameter("name");
	String password=request.getParameter("pass");
	String repassword=request.getParameter("pass1");
	if(password.equals(repassword))
	{
		User u=new User();
		UserDao ud=new UserDao();
		u.setName(name);
		u.setPassword(password);
		int f=ud.addUser(u);
		if(f>=0){
			 Cookie c = new Cookie(name,"");
          response.addCookie(c);
		name=c.getName();
		out.println(name);
			request.getRequestDispatcher("main.jsp").forward(request,response);}
		else
		{
			out.println("<html>");
			out.println("<body><p> Sorry You are already registered</p>");
			out.println("</body></html>");
		}
	}
	else
	{
		out.println(" Passwords do not match");
		out.println("<a href='index.html'>GO BACK TO SIGNUP PAGE </a>");
	}
	}
} 