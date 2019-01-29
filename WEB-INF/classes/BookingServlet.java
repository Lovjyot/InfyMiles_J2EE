import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BookingServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			HttpSession session = request.getSession();
			ArrayList<String> carlist = (ArrayList<String>) session.getAttribute("carlist");

			PrintWriter out = response.getWriter();
			MySqlDataStoreUtilities dataStore = new MySqlDataStoreUtilities();
			
			boolean flag  = false;
			
			//Integer carName = Integer.parseInt(request.getParameter("carName"));
			Integer carId = Integer.parseInt(carlist.get(0));
			String userName = request.getParameter("userName");
			String startDate = request.getParameter("From");
			String endDate = request.getParameter("To");
			String price = request.getParameter("price");
			String cardNumber = request.getParameter("cardNumber");
			String address = request.getParameter("Address");
			String licenceId = request.getParameter("licenceId");
			
			System.out.println("Card Number:"+ cardNumber);
			
			
			flag = dataStore.bookcar(carId, userName, "11/17/2017", startDate, endDate, price, cardNumber, address, "0", licenceId, "Debit Card");
			
			if(flag){
			  response.sendRedirect("bookinghistory.jsp");
			}
			
			else {
				out.println("Booking failed!");
			}
			
		}
		
}