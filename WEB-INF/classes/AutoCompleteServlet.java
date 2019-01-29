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

public class AutoCompleteServlet extends HttpServlet {

    protected void processReq(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
			
	MySqlDataStoreUtilities mysql = new MySqlDataStoreUtilities();
	ArrayList<String> autoprod = mysql.autoCompleteCar();
	int cnt =0;
	String query = (String)request.getParameter("q");
	response.setHeader("Content-Type", "text/html");
	java.io.PrintWriter out = response.getWriter();
	for(int i=0;i<autoprod.size();i++)
	{
		if (i%2==0){
		if(autoprod.get(i).toUpperCase().contains(query.toUpperCase()))
		{
			out.print(autoprod.get(i) + " in " + autoprod.get(i+1) +"\n");
			if(cnt>=10)
				break;
			cnt++;
			i++;
		}
		}
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
