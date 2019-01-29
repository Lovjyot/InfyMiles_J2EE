
import java.util.*;
import java.lang.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.RequestDispatcher;

import java.io.FileNotFoundException;

public class CarDetailServlet extends HttpServlet {

  protected void processReq(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
		response.setContentType("text/html");
		HttpSession session= request.getSession();
        java.io.PrintWriter out = response.getWriter();
		String carid = request.getParameter("carid");
		//out.println(request.getParameter("location"));
		if (request.getParameter("location")!=null){
		String location = request.getParameter("location");
		String date = request.getParameter("date");
		//out.println(request.getParameter("location"));
		String locarr[] = location.split(",");
		location=locarr[0];
		String datearr[] = date.split("-");
		String startdate = datearr[0].trim();
		String enddate = datearr[1].trim();
		request.setAttribute("startdate",startdate);
		request.setAttribute("enddate",enddate);
		}
		MySqlDataStoreUtilities mysql = new MySqlDataStoreUtilities();
		ArrayList<String> searchcar = mysql.showCarDetail(carid);
		request.setAttribute("Carlist",searchcar);
		session.setAttribute("carlist",searchcar);
		out.println(searchcar);
		request.getRequestDispatcher("ViewCarDetail.jsp").forward(request, response);
		out.close();
		
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
