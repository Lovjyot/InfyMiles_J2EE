import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import javax.servlet.RequestDispatcher;

import java.io.FileNotFoundException;

public class DealMatches extends HttpServlet{

public void processReq(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
	response.setContentType("text/html");
    java.io.PrintWriter out = response.getWriter();
	Map<Integer,String> map = new HashMap<Integer,String>();
	MySqlDataStoreUtilities mysql = new MySqlDataStoreUtilities();
	map = mysql.SelectProducts();

	HttpSession session = request.getSession();
	session.setAttribute("dealmatch",map);
	out.println(map);
	response.sendRedirect("home.jsp");
		

}

 protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        processReq(request, response);
		  
    } 
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
         processReq(request, response);
    }


}