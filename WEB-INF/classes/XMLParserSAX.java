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

public class XMLParserSAX {

	

   public String processReq(){
		        
		int nw = 0;
		String z=null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		String i=null;
		try{
        SAXParser saxParser = saxParserFactory.newSAXParser();
        MyHandler handler = new MyHandler();
        saxParser.parse(new File("C:\\apache-tomcat-7.0.34\\webapps\\InfyMiles_6\\data\\CarsData.xml"), handler);
        Map<String, Car> prodList = handler.getCarList();
		i = prodList.toString();
        } catch (Exception e) {
		}
		return i;

    }
	

}