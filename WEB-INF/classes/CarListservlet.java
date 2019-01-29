
import java.util.*;
import java.lang.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.RequestDispatcher;

import java.io.FileNotFoundException;

public class CarListservlet extends HttpServlet {

  protected void processReq(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
		response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();
		if (request.getParameter("location")!=null){
		String location = request.getParameter("location");
		String date = request.getParameter("date");
		String locarr[] = location.split(",");
		String datearr[] = date.split("-");
		location=locarr[0];
		String startdate = datearr[0].trim();
		String enddate = datearr[1].trim();
		out.println(location + startdate + enddate);
		MySqlDataStoreUtilities mysql = new MySqlDataStoreUtilities();
		ArrayList<String> searchcar = mysql.selectCarDetail(location);
		//out.println(searchcar);
		request.setAttribute("Carlist",searchcar);
		request.setAttribute("startdate",startdate);
		request.setAttribute("enddate",enddate);
		request.getRequestDispatcher("booklist.jsp").forward(request, response);
		out.close();
		}else {
			request.getRequestDispatcher("booklist.jsp").forward(request, response);
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
