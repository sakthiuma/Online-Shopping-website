import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import bean.*;
import Dao.*;

public class LoginController extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
	
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	int exist=0;
	String name=request.getParameter("name");
	String password=request.getParameter("pass");
	User u=new User();
	UserDao ud=new UserDao();
	u.setName(name);
	u.setPassword(password);
	int ret=ud.authenticate(u);
	out.println("<html><head>");
	Cookie ci[]=request.getCookies();
	
		
	if(ret==11)
	{
		if(ci!=null)
		{
			for(int i=0;i<ci.length;i++)
			{
				if((ci[i].getName()).equals(name))
				{
					exist=1;
					//out.println(ci[i].getName());
					break;
				}
			}
		}
		if(exist!=1)
		{
			Cookie c=new Cookie(name,"");
			response.addCookie(c);
			out.println(c.getName());
		}		
		request.getRequestDispatcher("main.jsp").forward(request,response);
		
	}
	else if(ret==10)
	{
		out.println("<p> Incorrect Password</p>");
	}
	
	else if(ret==01)
	{
		out.println("<p> Incorrect UserName</p>");
	
	}
	else
		out.println("<p> Unsuccessful Login</p>");
	out.println("</body></html>");
	}
}
