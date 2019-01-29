import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import javax.servlet.*;
import javax.servlet.http.*;

import org.xml.sax.SAXException;
import java.util.*;

public class SubmitRatingServlet extends HttpServlet {

    protected void processReq(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
			
	response.setHeader("Content-Type", "text/html");
	java.io.PrintWriter out = response.getWriter();
			String i = request.getParameter("select");
			HttpSession session = request.getSession();
			String username = (String) session.getAttribute("username");
			if (session.getAttribute("username")==null){
				response.sendRedirect("login.jsp");
			}else {
			ArrayList<String> carlist = (ArrayList<String>) session.getAttribute("carlist");
			MySqlDataStoreUtilities mysql = new MySqlDataStoreUtilities();
			String s = carlist.get(0);
			String suc = mysql.insertRating(username,s,i);
			out.println(suc);
			request.getRequestDispatcher("CarDetailServlet?carid="+s).forward(request, response);
			}
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
