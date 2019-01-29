import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.*;

import com.mongodb.AggregationOutput;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;
import com.mongodb.WriteResult;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class MongoDBDataStoreUtilities extends HttpServlet {
	MongoClient mongo = new MongoClient("localhost", 27017);
	DBCollection myReviews=null;
	
    public void addReview(HashMap<String,BeanReviewAdd> beanvalue) throws ClassNotFoundException
	{
	BeanReviewAdd addBean =  new BeanReviewAdd();
	Set set = beanvalue.entrySet();
		Iterator iterator = set.iterator();
		while(iterator.hasNext())
		{
			Map.Entry entry = (Map.Entry)iterator.next();
			addBean = (BeanReviewAdd)entry.getValue();
		}
	        String carType = addBean.getCarType();
            String carName = addBean.getCarName();
			String price = addBean.getPrice();
			String manufacturerName = addBean.getManufacturerName();
			String carID = addBean.getCarID();
			String userName = addBean.getUserName();
			String userAge = addBean.getUserAge();
			String userGender = addBean.getUserGender();
			String userOccupation = addBean.getUserOccupation();
			String reviewRating = addBean.getReviewRating();	
			String reviewDate = addBean.getReviewDate();
			String reviewText = addBean.getReviewText();
			
			try
			{   
				DB db = mongo.getDB("InfyMiles");
				myReviews = db.getCollection("Reviews");
				
				BasicDBObject bobj = new BasicDBObject("title", "Reviews").
			
				append("carTypeDB", carType).
				append("carNameDB", carName).
                append("priceDB", price).
				append("manufacturerNameDB", manufacturerName).
				append("carIDDB", carID).
				append("userNameDB",userName).
				append("userAgeDB", userAge).
				append("userGenderDB", userGender).
				append("userOccupationDB", userOccupation).
				append("reviewRatingDB", reviewRating).
				append("reviewDateDB", reviewDate).
				append("reviewTextDB", reviewText);
			    myReviews.insert(bobj);
			}
			catch(Exception e)
			{
                System.out.println("Error:"+e.getMessage());
				e.printStackTrace();
			}
	
	}
	

	public HashMap<String,ArrayList<BeanReviewAdd>> viewReview(String carName)
	{
		HashMap<String,ArrayList<BeanReviewAdd>> entriesadd = new HashMap<String, ArrayList<BeanReviewAdd>>();
		ArrayList<BeanReviewAdd> beanreviews = new  ArrayList<BeanReviewAdd>();
	
	    DB db = mongo.getDB("InfyMiles");
	    myReviews = db.getCollection("Reviews");
			
	    BasicDBObject bobj = new BasicDBObject();
		bobj.put("carNameDB", carName);

		DBCursor cursor = myReviews.find(bobj);
	        
		try{
				
			while (cursor.hasNext())
			{
			    BasicDBObject bobj2 = (BasicDBObject) cursor.next();
				BeanReviewAdd addproducts = new BeanReviewAdd();
				addproducts.setCarType(bobj2.getString("carTypeDB"));
				addproducts.setCarName(bobj2.getString("carNameDB"));
				addproducts.setPrice(bobj2.getString("priceDB"));
				addproducts.setManufacturerName(bobj2.getString("manufacturerNameDB"));
				addproducts.setCarID(bobj2.getString("carIDDB"));
				addproducts.setUserName(bobj2.getString("userNameDB"));
				addproducts.setUserAge(bobj2.getString("userAgeDB"));
				addproducts.setUserGender(bobj2.getString("userGenderDB"));
				addproducts.setUserOccupation(bobj2.getString("userOccupationDB"));
				addproducts.setReviewRating(bobj2.getString("reviewRatingDB"));
				addproducts.setReviewDate(bobj2.getString("reviewDateDB"));
				addproducts.setReviewText(bobj2.getString("reviewTextDB"));
					 
				beanreviews.add(addproducts);
									 
				entriesadd.put("Reviews",beanreviews);
			}
		}
		
        catch(Exception e)
		{			
			e.printStackTrace();
		}
					 
		return entriesadd;
	
	}
}
