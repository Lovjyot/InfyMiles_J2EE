
import java.util.*;
import java.lang.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.RequestDispatcher;

import java.io.FileNotFoundException;

public class LeftNavSearch extends HttpServlet {

  protected void processReq(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
		response.setContentType("text/html");
		String brandname="";
		String categoryname="";
		String pricerangename="";
		String first="";
		String last="";
        java.io.PrintWriter out = response.getWriter();

		request.setAttribute("startdate","12/1/2017 12:00 AM");
		request.setAttribute("enddate","12/31/2017 12:00 AM");
		if (request.getParameter("location")!=null){
		String location = request.getParameter("location");
		String locarr[] = location.split(",");
			location=locarr[0];
		}
		if (request.getParameterValues("brand")!=null){
		String brand[] = request.getParameterValues("brand");
		
		for (int i=0;i<brand.length;i++){
			 brandname += "'" + brand[i] + "'" +  ","; 
			
		}
		brandname = brandname.replaceAll(",$","");}
		if (request.getParameterValues("category")!=null){
		String category[] = request.getParameterValues("category");
		
		for (int i=0;i<category.length;i++){
			 categoryname += "'" + category[i] + "'" +  ","; 
			
		}
		categoryname = categoryname.replaceAll(",$","");
		}
		if (request.getParameterValues("pricerange")!=null){
		String pricerange[] = request.getParameterValues("pricerange");
		
		for (int i=0;i<pricerange.length;i++){
			 pricerangename +=   pricerange[i] +  ","; 
			
		}
		pricerangename = pricerangename.replaceAll(",$","");
		String pricerangenamearr[] = pricerangename.split(",");
		first = pricerangenamearr[0];
		last = pricerangenamearr[pricerangenamearr.length-1];
		}
		MySqlDataStoreUtilities mysql = new MySqlDataStoreUtilities();
		ArrayList<String> searchcar = mysql.searchCarDetail(brandname,categoryname,first,last);
		/*String locarr[] = location.split(",");
		String datearr[] = date.split("-");
		location=locarr[0];
		String startdate = datearr[0].trim();
		String enddate = datearr[1].trim();
		out.println(location + startdate + enddate);
		MySqlDataStoreUtilities mysql = new MySqlDataStoreUtilities();
		ArrayList<String> searchcar = mysql.selectCarDetail(location);*/
		//out.println(searchcar);
		request.setAttribute("Carlist",searchcar);
		request.getRequestDispatcher("booklist.jsp").forward(request, response);
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
