import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.io.*;
import java.util.logging.*;


public class ValidRegistration extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
			
		PrintWriter out = response.getWriter();		
		String fname="";
		String name = request.getParameter("name");		
		String email = request.getParameter("emailId");		
		HttpSession session = request.getSession(true);
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String phoneNumber = request.getParameter("phoneNumber");
		String state = request.getParameter("state");
		String city = request.getParameter("city");
		String zipcode = request.getParameter("zipcode");
		String info = new String("Info");
		String role =  request.getParameter("role");
		MySqlDataStoreUtilities msdsu = new MySqlDataStoreUtilities();

		
		Boolean bol = false;
			bol = msdsu.insertUser(email,name,password,role,address,phoneNumber,city,state,zipcode);
		
			if(bol == true){
				response.sendRedirect("login.jsp");
			}
		


			HttpSession sessionOld = request.getSession(true);
			String userInfoOld = new String("Info");

			/*if (null == sessionOld.getAttribute(userInfoOld)) {        

				//HttpSession session = request.getSession(true);
				//String info = new String("Info"); 
				session.setAttribute(info, pojo_user);
			}
			Pojo_user user1;
			if (null != session.getAttribute(info)) {
				/*user1 = (Pojo_user) session.getAttribute(info);
				fname = user1.getFName();*/

			//	session.setAttribute(info,uname);
			//}*/

		
    }

    





protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
}

}
