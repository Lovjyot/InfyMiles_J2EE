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

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bson.Document;
import com.mongodb.client.MongoCollection; 
import com.mongodb.client.MongoDatabase; 
import org.bson.Document; 
import com.mongodb.MongoClient; 
import com.mongodb.MongoCredential;

public class ViewReviewServlet extends HttpServlet {

	
    protected void processReq(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
		
		
       response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		Map<String, Integer> map = new HashMap<String, Integer>();
    	Map<Integer, String> map2 = new HashMap<Integer, String>();
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("InfyMiles");
		MongoCollection<Document> col = database.getCollection("Reviews");
		
        int cnt =1;
        List<String> list = null;
		List<String> newlist = new ArrayList<String>();
        try (MongoCursor<Document> cur = col.find().iterator()) {
            while (cur.hasNext()) {
				Document doc = cur.next();
                list = new ArrayList(doc.values());
                newlist.addAll(list);    
            }
		
        session.setAttribute("reviewlist",newlist);
		//out.println(newlist);
		response.sendRedirect("ViewCarDetail.jsp?check=done");
        
		}
		
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
