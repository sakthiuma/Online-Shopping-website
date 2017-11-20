import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import bean.*;
import Dao.*;

public class RemoveCartController extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String item=request.getParameter("item");
		String quantity=request.getParameter("qty");
		String price=request.getParameter("price");
		StringBuilder sb=new StringBuilder("");
		StringBuilder sbn=new StringBuilder("");
		/*sb.append(item);
		sb.append("&");
		sb.append(quantity);
		sb.append("&");
		sb.append(price);
		sb.append("&");*/
		String tostr="";
		String c_value,cc_value="hey";
		String name=request.getParameter("name");
		Cookie c=null;
		int i,m=0,sum=0,dis_cost=0,cal;
		Cookie ci[]=request.getCookies();
		String repla="hey";
		if(ci!=null)
		{
			
			for( i=0;i<ci.length;i++)
			{
				if((ci[i].getName()).equals(name))
				{
					cc_value="hello";
					c=ci[i];
					c_value=ci[i].getValue();
					String str[]=c_value.split("&");
					for(i=0;i<str.length;i++)
					{
						if(str[i].contains(item))
						{
							
								m=i;
								str[i]="&";
								str[i+1]="&";
								str[i+2]="&";
							
							
							break;
						}
					}
					for(i=0;i<str.length;i++)
					{
						sb.append(str[i]);
						sb.append("&");
					}
					 tostr=sb.toString();
					c.setValue(tostr);
					response.addCookie(c);
					break;
				}
			}
		}
		String ret[]=tostr.split("&");
		
		for(i=0;i<ret.length;i++)
		{
			sbn.append(ret[i]);
			sbn.append("&");
		}
		tostr=sbn.toString();
		c.setValue(tostr);
		response.addCookie(c);
		//out.println(tostr);
		for( i=0;i<ret.length;i++)
		{
			String r=ret[i].replace("_"," ");
			
			out.println(r+"&nbsp &nbsp &nbsp &nbsp &nbsp");
			if((i+1)%3==0 )
                    {
                        out.println("<br>");
                        cal=Integer.parseInt(ret[i]);
                         sum=sum+cal;
                    }
			
		}
		//out.println("</p>");
out.println("<br>Total Amount"+sum);
                if(sum>450)
                {
                     dis_cost=(sum*90)/100;
                    // dis_cost=dis_cost+60;
                }
		else
			dis_cost=sum;
                out.println("<br> Discount amount::10%");
                out.println("<br>CGST:: Rs.30");
                out.println("<br>SGST:: Rs.30");
                dis_cost=dis_cost+60;
                out.println("<br> Net Amount::Rs."+dis_cost);
	}
}