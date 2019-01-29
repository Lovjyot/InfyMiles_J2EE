import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.sql.ResultSet;

public class SaveCars extends HttpServlet {

    private Connection conn = null;
    private PreparedStatement pst = null;

        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {

                // ArrayList<Product> product = new ArrayList<Product>();
                response.setContentType("text/html");
             //   Utilities utility = new Utilities();
                PrintWriter out = response.getWriter();
                HttpSession session = request.getSession();
        String usertype = (String)session.getAttribute("usertype");
        String sessionId =new String("sessionId");
        String userInfo = new String("Info");
        //String name ="";
        /*if (usertype!=null ) {
            utility.printHtml("../webapps/csj/Headr.html",response);        

        }

        else{
            utility.printHtml("../webapps/csj/Header.html",response);       
        }*/

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
                String reservationStatus = request.getParameter("reservationStatus");
                String action = request.getParameter("action");


try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/InfyMiles", "root", "root");

//          String insertIntoCustomerRegisterQuery = "INSERT INTO Register values(fName,lName,email,cNumber,uname,password,usertype) "
            
            String query = "INSERT INTO Cars(carId, carName, carCategory, carBrandName, carModel,carMileage,carProductionYear,carColor,carImagePath,carPrice,carReservationStatus,location) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, productId);
            pst.setString(2, name);
            pst.setString(3, type);
            pst.setString(4, brand);
            pst.setString(5, model);
            pst.setString(6, mileage);
            pst.setString(7, productionYear);
            pst.setString(8, color);
            pst.setString(9, imagePath);
            pst.setString(10, price);
            pst.setString(11, reservationStatus);
            pst.setString(12, location);
            pst.executeUpdate();            
            conn.close();           
            //return true;
        } 
        catch (Exception e) {
            //return false;
            out.println(e);
        }



               /* Product product = new Product();
                SalesManager manager = new SalesManager();

                if (!action.equals("3")) {
                        Logger.getLogger(SaxParserUtility.class.getName()).log(Level.INFO, "entering action 3");

                        if(productId.isEmpty() || productId==null){
                            Logger.getLogger(SaxParserUtility.class.getName()).log(Level.INFO, "entering empty");
                            response.sendRedirect("AddProducts");
                            return;

                        }
                        else{
                        Logger.getLogger(SaxParserUtility.class.getName()).log(Level.INFO, "entering not empty");
                    }

                        product = new Product(Integer.parseInt(productId), brand, model, Double.parseDouble(price),
                                        Double.parseDouble(discount), Double.parseDouble(rebate), Integer.parseInt(quantity), imagePath,
                                        type);

                        // out.println(Integer.parseInt(productId)+brand+model+Double.parseDouble(price)+
                        //                 Double.parseDouble(discount)+Double.parseDouble(rebate)+Integer.parseInt(quantity)+ imagePath+
                        //                 type);
                        
                }
                else{
                        int productIdNew = Integer.parseInt(productId);
                        HashMap<String,Product> products = SmartPhone.buildBasicSmartPhoneList();
                        for(HashMap.Entry<String, Product> myKey: products.entrySet()){

                            String key = myKey.getKey();
                            Product ph1 = myKey.getValue();

                            if(ph1.getProductId()==productIdNew){
                                product=ph1;
                            }
                    }
                }

                if (action.equals("1")) {
                        manager.addProduct(product);
                } else if (action.equals("2")) {
                        manager.updateProduct(product);
                } else {
                        manager.deleteProduct(product);
                }
*/
               // utility.printHtml("../webapps/csj/Header.html", response);
                out.println("<div id='body'>");
                out.println("<section id='content'>");

                if(!action.equals("3")){
				//	RequestDispatcher rd = response.getRequestDispatcher("/SuccessfullyAdded.jsp");
					//rd.forward(request,response);

                out.println("<br><p>You have successfully added/updated below product:</p>");
                out.println("<table>");
                out.println("<tr>");
                out.println("<th>");
                out.println("Product Id");
                out.println("</th>");
                out.println("<th>");
                out.println("Category");
                out.println("</th>");
                out.println("<th>");
                out.println("Brand");
                out.println("</th>");
                out.println("<th>");
                out.println("Model");
                out.println("</th>");
                out.println("<th>");
                out.println("Price");
                out.println("</th>");
                out.println("<th>");
                out.println("Discount");
                out.println("</th>");
                out.println("<th>");
                out.println("Rebate");
                out.println("</th>");
                out.println("<th>");
                out.println("Quantity");
                out.println("</th>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>");
                out.println(productId);
                out.println("</td>");
                out.println("<td>");
                out.println(type);
                out.println("</td>");
                out.println("<td>");
                //out.println(brand);
                out.println("</td>");
                out.println("<td>");
                out.println(model);
                out.println("</td>");
                out.println("<td>");
                out.println(price);
                out.println("</td>");
                out.println("<td>");
               // out.println(discount);
                out.println("</td>");
                out.println("<td>");
                //out.println(rebate);
                out.println("</td>");
                out.println("<td>");
                //out.println(quantity);
                out.println("</td>");
                out.println("</tr>");
                out.println("</table>");
        }
        else{
                out.println("<br><p>You have successfully deleted the product:</p>");
        }
                // out.println(productId+type+brand+model+price+discount+rebate+quantity+imagePath);
                out.println("</section>");
              //  utility.printHtml("../webapps/csj/LeftNavigationBar.html", response);
               // utility.printHtml("../webapps/csj/Footer.html", response);
        }
}