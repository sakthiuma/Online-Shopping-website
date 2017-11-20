import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import bean.*;
import Dao.*;

public class CartController extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String item=request.getParameter("item");
		String quantity=request.getParameter("qty");
		String price=request.getParameter("price");
		StringBuilder sb=new StringBuilder("");
		/*sb.append(item);
		sb.append("&");
		sb.append(quantity);
		sb.append("&");
		sb.append(price);
		sb.append("&");*/
        List<String> al=new ArrayList<String>();
		String c_value="",cc_value="hey",check="";
		String name=request.getParameter("name");
		Cookie c=null;
		int counter=0,qu,totprice,cal,sum=0,pr,dis_cost=0;
		Cookie ci[]=request.getCookies();
        //String spl[]=null;
        //c_value=ci[0].getValue();
		if(ci!=null)
		{
           
            for(int i=0;i<ci.length;i++)
            {
                if(ci[i].getName().equals(name))
                {
                    c=ci[i];
                   c_value=c.getValue();
                    if(c_value.length()==0)
                    {
                        
                        sb.append(item);
                        sb.append("&");
                        sb.append(quantity);
                        sb.append("&");
                        qu=Integer.parseInt(quantity);
                        pr=Integer.parseInt(price);
						totprice=qu*pr;
                        sb.append(String.valueOf(totprice));
                        sb.append("&");
                        //out.println("in if");
                        break;
                    }
                    else
                    {
                         String spl[]=c_value.split("&");
                        int len=spl.length;
                        //out.println(len);
                        for(i=0;i<spl.length;i++)
						{
							if(spl[i].contains(item))
							{
                                int quant=Integer.parseInt(quantity);
								if(quant > 0)
								{
									 qu=Integer.parseInt(spl[i+1]);
									qu=qu+1;
                                    pr=Integer.parseInt(price);
									 totprice=qu*pr;
									spl[i+2]=String.valueOf(totprice);
									spl[i+1]=String.valueOf(qu);
								}
                                else
								{
                                    //check="name1";
									qu=Integer.parseInt(spl[i+1]);
									qu=qu-1;
                                    pr=Integer.parseInt(price);
									totprice=qu*pr;
									spl[i+2]=String.valueOf(totprice);
									spl[i+1]=String.valueOf(qu);
									if(qu==0)
									{
										spl[i]="&";
										spl[i+1]="&";
										spl[i+2]="&";
									}
                                    
								}
                                counter=1;
                                break;
                            }
                            
                            
                        }
                        //out.println(counter);
                        if(counter != 1)
                        {
                             //out.println(counter);
                            int quant=Integer.parseInt(quantity);
				
								
									// qu=Integer.parseInt(spl[i+1]);
				            qu=1;
                            pr=Integer.parseInt(price);
							totprice=qu*pr;
                            al.add(item);
                            al.add(String.valueOf(qu));
							al.add(String.valueOf(totprice));
                                
									
                            
								
                        }
                       
                        for(i=0;i<spl.length;i++)
                        {
                            String splspl=spl[i];
                            sb.append(splspl);
                            sb.append("&");
                           
                        }
                        if(counter==0)
                        {
                            String[] desp=new String[al.size()];
                            desp=al.toArray(desp);
                            for(i=0;i<desp.length;i++)
                            {
                            String despl=desp[i];
                            sb.append(despl);
                            sb.append("&");
                           
                            }
                        }
                        break;
                    }
                }
            }
                c_value=sb.toString();
                c.setValue(c_value);
		        response.addCookie(c);
                c_value=c.getValue();
                String ret[]=c_value.split("&");
		        //  out.println(c_value);
		          for(int i=0;i<ret.length;i++)
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
}
            
        

