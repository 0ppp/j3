a <HTML>
<BODY>
<form method=get action=”Slip3.java”>
Enter Bill Number : <input type=”text”  billnum=”billnum”>
<input type=SUBMIT>
</BODY>
</HTML>


JAVA FILE:

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Slip4 extends HttpServlet
{
            public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
{
            response.setContentType(“text/html”);
            PrintWriter out= res.getWriter();
            String billnum=req.getParmeter(“billnum”),msg;
            int billno=Integer.parseInt(billnum);
            Connection con=null;
            Statement st=null;
ResultSet rs=null,rs1=null;
out.println(“<HTML>”);
out.println(“<BODY>”);
try
{
                        Class.forName(“org.postgresql.Driver”);
con=DriverManager.getConnection(“jdbc:postgresql://192.168.100.254/Bill”,”oracle”,”oracle”);
if(con==null)
                                                msg=”Connection to databse failed”;
                                    else
                                    {
                                                st=con.createStatement();
                                                rs=st.executeQuery(“select * from BillMaster where billno =”+billno);
                                                rs1=st.executeQuery(“select * from BillDetails where billno =”+billno);
                                                if(rs==null || rs1==null)
                                                            out.println(“Invalid bill number”);
                                                else
                                                {
                                                            rs.next();
                                                            rs1.next();
                                                            int i=1;
                                                            out.println(“Bill Number:”+rs.getInt(1)+” \t\t\tBill Date:”+rs.getString(3)+”\n”+”Customer Name”+rs.getString(2)+”\n”);
                                                            out.println(“Sr No.\t\t Item Name \t\t Quantity \t\t Rate \t\tTotal\n”);
                                                            int netB=0,sumT=0;
                                                            while(rs1.next())
                                                            {
                                                                        sumT=rs1.getInt(2)*rs1.getInt(3);
                                                                        out.println(i +”\t\t\t”+rs1.getString(1)+”\t\t”+ rs1.getInt(2)+”\t\t”+ rs1.getInt(3)+”\t\t”+sumT+”\n”);
                                                                        netB=netB+sumT;
}
out.println(“\t\t\t\t\t\t\t\t\t\tNet Bill : ”+ netB);
                                                }
}
catch(Exception e) { }
out.println(“</BODY>”);
out.println(“</HTML>”);
}
}