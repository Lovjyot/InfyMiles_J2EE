
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;

public class LoginServlet extends HttpServlet{
	int usersearch=0;
	//ArrayList<Pojo_user> list = new ArrayList<>();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

    	String emailId = request.getParameter("emailId");
    	String password = request.getParameter("password");
    	String role = request.getParameter("role");
		

    	HttpSession session = request.getSession();

    	MySqlDataStoreUtilities msdsu = new MySqlDataStoreUtilities();
    	//list = msdsu.selectUser();
    	String name = msdsu.checkUser(emailId,password,role);
       
      PrintWriter out = response.getWriter();
     //String filePath = "../webapps/csj/Users/Pojo_user.txt";

      if(name!=null){
        if(role.equalsIgnoreCase("storemanager") && !(name.equalsIgnoreCase("error"))){
          session.setAttribute("username",name); 
          response.sendRedirect("StoreManager.jsp");
        }
		else if(role.equalsIgnoreCase("customer") && !(name.equalsIgnoreCase("error"))){
          session.setAttribute("username",name); 
          response.sendRedirect("home.jsp"); 
        }
		 else if (name.equalsIgnoreCase("error")){
		   out.println("ErrorLogin");
          response.sendRedirect("login.jsp?login=invalid");
       }
      
	  }

         
		
       
       response.setContentType("text/html");
   }
}