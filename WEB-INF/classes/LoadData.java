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
import java.util.Map;
import java.util.HashMap;
import java.util.*;
import java.lang.*;

public class LoadData extends HttpServlet {


    protected void processReq(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
		response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();
			XMLParserSAX xml = new XMLParserSAX();
			String map = xml.processReq();
			String parts[] = map.split("=");
			int nw=1;
			String s = null;
			MySqlDataStoreUtilities mysql = new MySqlDataStoreUtilities();
			boolean check = mysql.checkData();
			if (check==false){
		while (nw < parts.length){
			s= parts[nw];
		s = s.replaceAll("\\w+$", "").trim();
		s = s.substring(0, s.length() - 1);
		s = s.replaceAll(",", "','");
		s= "'" + s + "'";
		mysql.insertCarData(s);
		out.print(s + "<br/>");
		nw=nw+1;
		}
			}
		response.sendRedirect("home.jsp?check=done");
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
