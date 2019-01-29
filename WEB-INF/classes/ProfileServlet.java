
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
import java.util.*;
import java.util.logging.*;
import java.io.PrintWriter;
import java.sql.ResultSet;


public class ProfileServlet extends HttpServlet{
  int usersearch=0;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
    	PrintWriter out = response.getWriter();
    	HttpSession session = request.getSession();
    	String username = (String) session.getAttribute("username");
    	MySqlDataStoreUtilities msdsu = new MySqlDataStoreUtilities();
    	ArrayList<String> userlist = new ArrayList<String>();
    	userlist = msdsu.userDetails(username);

    	if(userlist!=null){
    	request.setAttribute("userdetails",userlist);	
    	RequestDispatcher rd=request.getRequestDispatcher("/Profile.jsp");
        rd.forward(request,response);
        }
        else{
        	out.println(userlist.get(0));
        }

    }

 protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
     
    }
}