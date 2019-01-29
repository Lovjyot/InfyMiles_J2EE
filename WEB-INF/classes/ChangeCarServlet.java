
import java.util.HashMap;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.RequestDispatcher;	

import java.io.FileNotFoundException;

public class ChangeCarServlet extends HttpServlet {

protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, java.io.IOException {
		

		
		response.setContentType("text/html");
		java.io.PrintWriter out = response.getWriter();
		MySqlDataStoreUtilities mysqlsm = new MySqlDataStoreUtilities();
		ArrayList<String> list = mysqlsm.changeProducts();
		String task = request.getParameter("task");
		String check1;
		boolean check = false;

		if (task!=null && task.equals("update")){
		 		int productId = Integer.parseInt(request.getParameter("prodId"));
		 		String name = request.getParameter("name");
                String type = request.getParameter("prodCategory");
                String brand = request.getParameter("brandName");
                String model = request.getParameter("model");
                String price = request.getParameter("price");
                String mileage = request.getParameter("mileage");
                String productionYear = request.getParameter("productionYear");
                String color = request.getParameter("color");
                String imagePath = request.getParameter("imagePath");
                String location = request.getParameter("location");
                int reservationStatus = Integer.parseInt(request.getParameter("reservationStatus").trim());

		
			//mysqlsm.updateDeleteProducts();
			check1 = mysqlsm.updateDeleteProducts(task,productId,name,type,brand,model, mileage,productionYear ,color,imagePath,price,reservationStatus,location);
			if(check1.equals("true")){

				list = mysqlsm.changeProducts();
				request.setAttribute("wholeList",list);
				RequestDispatcher rd=request.getRequestDispatcher("/ChangeCars.jsp");
				rd.forward(request,response);
			}
			else{
				out.println(check1);
				out.println("Update get Something is wrong, either u updated a primary key already existing or reservation status as a string, or database connection problem."+task+productId);
				out.println(productId + name + type + brand + model + price + mileage + productionYear +color + imagePath + reservationStatus + location);
			}
		}
		else if(task!= null && task.equals("delete")){
			int productId = Integer.parseInt(request.getParameter("prodId"));
			check = mysqlsm.deleteCars(productId);
				if(check == true){
					list = mysqlsm.changeProducts();
					request.setAttribute("wholeList",list);
			RequestDispatcher rd=request.getRequestDispatcher("/ChangeCars.jsp");
			rd.forward(request,response);
				}
			else{
				out.println("Something is wrong, either u updated a primary key already existing or reservation status as a string, or database connection problem."+task+productId);
			}
			
						
		}

		else{

		request.setAttribute("wholeList",list);

			RequestDispatcher rd=request.getRequestDispatcher("/ChangeCars.jsp");
			rd.forward(request,response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		  	
		
		response.setContentType("text/html");
		java.io.PrintWriter out = response.getWriter();
		MySqlDataStoreUtilities mysqlsm = new MySqlDataStoreUtilities();
		ArrayList<String> list = mysqlsm.changeProducts();
		String task = request.getParameter("task");
		boolean check = false;
		String check1;

		if (task.equals("update")){
		 		int productId = Integer.parseInt(request.getParameter("prodId"));
		 		String name = request.getParameter("name");
                String type = request.getParameter("prodCategory");
                String brand = request.getParameter("brandName");
                String model = request.getParameter("model");
                String price = request.getParameter("price");
                String mileage = request.getParameter("mileage");
                String productionYear = request.getParameter("productionYear");
                String color = request.getParameter("color");
                String imagePath = request.getParameter("imagePath");
                String location = request.getParameter("location");
                int reservationStatus = Integer.parseInt(request.getParameter("reservationStatus").trim());

		
			//mysqlsm.updateDeleteProducts();
			check1 = mysqlsm.updateDeleteProducts(task,productId,name,type,brand,model, mileage,productionYear ,color,imagePath,price,reservationStatus,location);
			if(check1.equals("true")){
				list = mysqlsm.changeProducts();
				request.setAttribute("wholeList",list);
			RequestDispatcher rd=request.getRequestDispatcher("/ChangeCars.jsp");
			rd.forward(request,response);
			}
			else{
				out.println(check1);
				out.println("update post Something is wrong, either u updated a primary key already existing or reservation status as a string, or database connection problem."+task+productId);
				out.println(productId + name + type + brand + model + price + mileage + productionYear +color + imagePath + reservationStatus + location);
			}
			}
		else if(task.equals("delete")){
			int productId = Integer.parseInt(request.getParameter("prodId"));
			check = mysqlsm.deleteCars(productId);
				if(check == true){
					list = mysqlsm.changeProducts();
				request.setAttribute("wholeList",list);
			RequestDispatcher rd=request.getRequestDispatcher("/ChangeCars.jsp");
			rd.forward(request,response);
			}
			else{

				out.println("Something is wrong, either u updated a primary key already existing or reservation status as a string, or database connection problem."+task+productId);
				
				}		
		}

		else{

		request.setAttribute("wholeList",list);

			RequestDispatcher rd=request.getRequestDispatcher("/ChangeCars.jsp");
			rd.forward(request,response);
		}
	}
	}