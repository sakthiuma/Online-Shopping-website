import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import bean.*;
import Dao.*;

public class NonVegController extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		NonVegDao vg=new NonVegDao();
		NonVegi v=new NonVegi();
		String ret;
		vg.retrieveCategory(v);
		ret=v.getCategory();
		String parts[]=ret.split("&");
		out.println("<html><head><link rel='text/stylesheet' src='maincss.css'></head>");
		for(String w:parts)
			out.println("<button class='butn2'  onclick='retrievenonitem(this.value)' style='display:block' value='"+w+"'>"+w+"</button><br>");
	out.println("</html>");
	}
}
		