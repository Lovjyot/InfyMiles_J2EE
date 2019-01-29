import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.HashMap;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import java.sql.SQLException;
import java.util.*;


public class ChartGeneration extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		response.setContentType("text/html");  
		int index=0;
        //String type=request.getParameter("type");
		
		
		
		PrintWriter out = response.getWriter();
		//utility.printHtml("../webapps/csj/startbootstrap-shop-item-gh-pages/LeftNavigationBar.html",response);
		HttpSession session = request.getSession();
		String usertype = (String)session.getAttribute("usertype");
		String sessionId =new String("sessionId");
		String userInfo = new String("Info");
		MySqlDataStoreUtilities msdsu = new MySqlDataStoreUtilities();

		ArrayList<String> list = new ArrayList<String>();
		list = msdsu.graphGenration();

		ArrayList<String> list2 = new ArrayList<String>();
		list2 = msdsu.graphGenration2();

		ArrayList<String> list3 = new ArrayList<String>();
		list3 = msdsu.graphGenration3();




		request.setAttribute("graph",list);
		request.setAttribute("graph2",list2);
		request.setAttribute("graph3",list3);
		RequestDispatcher rd=request.getRequestDispatcher("ChartGenerate.jsp");
		rd.forward(request,response);
	}
}