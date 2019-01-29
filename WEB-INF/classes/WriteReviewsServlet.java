import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;


public class WriteReviewsServlet extends HttpServlet {

    BeanReviewAdd reviewBean = new BeanReviewAdd();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String carType = request.getParameter("cartype");
        String carName = request.getParameter("carName");
		String carPrice = request.getParameter("price");
		String carId = request.getParameter("carID");
        String userName = request.getParameter("userName");
		String userAge = request.getParameter("userAge");
		String userGender = request.getParameter("userGender");
		String userOccupation = request.getParameter("userOccupation");
		String manufacturerName = request.getParameter("manufacturer");
		String reviewRating = request.getParameter("rating");	
		String reviewDate = request.getParameter("reviewDate");
		String reviewText = request.getParameter("comments");   

        reviewBean.setCarType(carType);
        reviewBean.setCarName(carName);
        reviewBean.setPrice(carPrice);
        reviewBean.setCarID(carId);
        reviewBean.setUserName(userName);
        reviewBean.setUserAge(userAge);
        reviewBean.setUserGender(userGender);
        reviewBean.setUserOccupation(userOccupation);
        reviewBean.setManufacturerName(manufacturerName);
        reviewBean.setReviewRating(reviewRating);
        reviewBean.setReviewDate(reviewDate);
        reviewBean.setReviewText(reviewText);
        
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        HashMap<String,BeanReviewAdd> hashObj = new HashMap<String,BeanReviewAdd>();

        try{
            hashObj.put(reviewBean.getCarName(), reviewBean);
            MongoDBDataStoreUtilities database = new MongoDBDataStoreUtilities();
            database.addReview(hashObj);

            HashMap<String,ArrayList<BeanReviewAdd>> hashObj1 = new HashMap<String, ArrayList<BeanReviewAdd>>();
            hashObj1 = database.viewReview(reviewBean.getCarName());
            //session.setAttribute("hashObj",hashObj);
            System.out.println("hashobj1"+ hashObj1);
            String name = "";
            String date = "";
            String text = "";
			for(Map.Entry<String, ArrayList<BeanReviewAdd>> map : hashObj1.entrySet()){
                for(BeanReviewAdd reviewview : map.getValue()){
                    System.out.println("Name:"+ reviewview.getUserName());                           
                    name = name + reviewview.getUserName() + ",";
					date = date + reviewview.getReviewDate() + ",";
					text = text + reviewview.getReviewText() + ",";
                    
                                           
                }       
            }

            session.setAttribute("name",name);
            session.setAttribute("date",date);
            session.setAttribute("text",text);
            // out.println("<h4> Review submitted for:"+ reviewBean.getCarName() + "</h4>");
            System.out.println("review");
            
            response.sendRedirect("ViewCarDetail.jsp");

            }catch(Exception e){
                e.printStackTrace();
        }
    }

}