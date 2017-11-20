import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import bean.*;
import Dao.*;

public class VegItemController extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String cate=request.getParameter("it");
		VegDao vg=new VegDao();
		Vegi v=new Vegi();
		String retit,retprice,retdesp;
		v.setCategory(cate);
		retprice=vg.retrieveItem(v);
		retit=v.getItem();
		retdesp=v.getDescription();
		String partsit[]=retit.split("&");
		String partsdesp[]=retdesp.split("&");
		String partsprice[]=retprice.split("&");
		out.println("<html><head><link rel='text/stylesheet' src='maincss.css'></head>");
		out.println("<script type='text/javascript' src='func.js'> </script>");
		for(int i=0;i<partsit.length;i++){
			String item=partsit[i].replace("_"," ");
			out.println("<p>"+item+"<br> "+partsdesp[i]+"<br>PRICE:: "+partsprice[i]+"</p>");
			
			out.println("<input type='hidden' value="+partsprice[i]+" name='"+partsit[i]+"price'></input>");
			out.println("<button class='butn3'  id='"+partsit[i]+"'onclick='increasecart(this.id)'>+</button>");
			out.println("<button class='butn3' id='"+partsit[i]+"'onclick='decreasecart(this.id)'>-</button>");
			out.println("<button class='butn4' id='"+partsit[i]+"'onclick='deletefromcart(this.id)'>Delete from Cart</button>");
		}
		out.println("</html>");
	}
}
		