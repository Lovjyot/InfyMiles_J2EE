import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.*;
import java.util.logging.*;
import java.io.PrintWriter;
import java.sql.ResultSet;

public class MySqlDataStoreUtilities {

	private Connection conn = null;
	private PreparedStatement pst = null;
	//Utilities utility = new Utilities();

			//PrintWriter out = response.getWriter();
	public boolean insertUser(String emailId,String name, String password, String role, String address, String phoneNumber, String city, String state, String zipcode) {/*, String fName, String lName, String email, String cnumber,String usertype)*/ 
		boolean addSuccess = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/InfyMiles", "root", "root");

//			String insertIntoCustomerRegisterQuery = "INSERT INTO Register values(fName,lName,email,cNumber,uname,password,usertype) "
			
			String query = "INSERT INTO Register VALUES (?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, emailId);
			pst.setString(2, name);
			pst.setString(3, password);						
			pst.setString(4, role);
			pst.setString(5, address);
			pst.setString(6, phoneNumber);
			pst.setString(7, city);						
			pst.setString(8, state);
			pst.setString(9, zipcode);
			pst.executeUpdate();			
			conn.close();			
			return true;
		} 
		catch (Exception e) {
			return false;
		}

	}

	public String checkUser(String emailId, String password,String role){


		java.sql.Statement stm = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/InfyMiles", "root", "root");
			stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String name;
			PreparedStatement pst = conn.prepareStatement("Select emailId,password,userType, name from Register where emailId=? and password=? and userType=?");
			pst.setString(1, emailId);
			pst.setString(2, password);
			pst.setString(3, role);
			
			ResultSet rst;
			rst = pst.executeQuery();
			if(rst.next()){
				
				return rst.getString(4);	
			}

			else{
			//check = false;
				return "Something is wrong";
			}
		
		}
		catch(Exception e){
			return "Error";
		}

	}
	
	
		public void insertCarData(String data){

		java.sql.Statement stm = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/InfyMiles", "root", "root");
			stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			PreparedStatement pst = conn.prepareStatement("Insert into Cars values("+ data+")");
			pst.executeUpdate();
			pst.close();
			conn.close();	
		}
		catch(Exception e){
			}

	}

	public boolean bookcar(int carId, String userName, String orderDate, String startDate, String endDate, String amount, String cardNumber, String address, String status, String licenseId, String paymentMethod) {/*, String fName, String lName, String email, String cnumber,String usertype)*/ 
		

		System.out.println("Order details:"+carId+ userName+ orderDate+ startDate+ endDate+ amount+ cardNumber+ address+ status+licenseId+ paymentMethod);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/InfyMiles", "root", "root");
			
			java.util.Date date = new Date();
			orderDate = date.toString();

			Random random = new Random();
			int  orderId = random.nextInt(50) + 1;
			
			String query = "INSERT INTO orders VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setInt(1, orderId);
			pst.setInt(2, carId);
			pst.setString(3, userName);
			pst.setString(4, orderDate);						
			pst.setString(5, startDate);
			pst.setString(6, endDate);
			pst.setString(7, amount);
			pst.setString(8, cardNumber);						
			pst.setString(9, address);
			pst.setString(10, status);
			pst.setString(11, licenseId);
			pst.setString(12, paymentMethod);
			
			pst.executeUpdate();			
			conn.close();			
			return true;
		} 
		catch (Exception e) {
			System.out.println("Error"+e.toString());
			return false;
		}

	}

	
	
	
	
	public boolean checkData(){


		java.sql.Statement stm = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/InfyMiles", "root", "root");
			stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			PreparedStatement pst = conn.prepareStatement("Select * from cars");
			ResultSet rst;
			rst = pst.executeQuery();
			if(rst.next()){
				return true;	
			}

			else{
				return false;
			}
		
		}
		catch(Exception e){
			return false;
		}

	}
	
	
	
		public ArrayList<String> selectCarDetail(String location){


		java.sql.Statement stm = null;
		ArrayList<String> list = new ArrayList<String>();
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/InfyMiles", "root", "root");
			stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			PreparedStatement pst = conn.prepareStatement("select carId,    carName,    carCategory,    carBrandName,    carModel,    carMileage,    carProductionYear,    carColor,    carImagePath,    carPrice,    carReservationStatus,    location,case when (round(avg(a.rating))*2)/2=0 then '0' when (round(avg(a.rating))*2)/2=0.5 then '10' when (round(avg(a.rating))*2)/2=1 then '20' when (round(avg(a.rating))*2)/2=1.5 then '30' when (round(avg(a.rating))*2)/2=2 then '40' when (round(avg(a.rating))*2)/2=2.5 then '50' when (round(avg(a.rating))*2)/2=3 then '60' when (round(avg(a.rating))*2)/2=3.5 then '70' when (round(avg(a.rating))*2)/2=4 then '80' when (round(avg(a.rating))*2)/2=4.5 then '90' when (round(avg(a.rating))*2)/2=5 then '100' else '0' end as rating,count(*) cnt from (select a.*,rating from cars a left outer join carrating b on a.carid = b.carid where lower(location)=?) a group by carId,carName,carCategory,carBrandName,carModel,carMileage,carProductionYear,carColor,carImagePath,carPrice,carReservationStatus,location order by carName");
			pst.setString(1,location.toLowerCase());
			ResultSet rst;
			rst = pst.executeQuery();
			while(rst.next()){
			list.add(rst.getString("carid"));
			list.add(rst.getString("carname"));
			list.add(rst.getString("carCategory"));
			list.add(rst.getString("carBrandName"));
			list.add(rst.getString("carModel"));
			list.add(rst.getString("carMileage"));
			list.add(rst.getString("carProductionYear"));
			list.add(rst.getString("carColor"));
			list.add(rst.getString("carImagePath"));
			list.add(rst.getString("carPrice"));	
			list.add(rst.getString("carReservationStatus"));
			list.add(rst.getString("location"));
			list.add(rst.getString("rating"));	
			list.add(rst.getString("cnt"));			
			}
		
		}
		catch(Exception e){
			
		}
		return list;

	}
	
	
	public ArrayList<String> searchCarDetail(String brandname,String categoryname,String first,String last){


		java.sql.Statement stm = null;
		ArrayList<String> list = new ArrayList<String>();
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/InfyMiles", "root", "root");
			stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			PreparedStatement pst=conn.prepareStatement("");
			if (categoryname!="" && brandname != "" && first!= "" && last!=""){
			pst = conn.prepareStatement("select carId,    carName,    carCategory,    carBrandName,    carModel,    carMileage,    carProductionYear,    carColor,    carImagePath,    carPrice,    carReservationStatus,    location,case when (round(avg(a.rating))*2)/2=0 then '0' when (round(avg(a.rating))*2)/2=0.5 then '10' when (round(avg(a.rating))*2)/2=1 then '20' when (round(avg(a.rating))*2)/2=1.5 then '30' when (round(avg(a.rating))*2)/2=2 then '40' when (round(avg(a.rating))*2)/2=2.5 then '50' when (round(avg(a.rating))*2)/2=3 then '60' when (round(avg(a.rating))*2)/2=3.5 then '70' when (round(avg(a.rating))*2)/2=4 then '80' when (round(avg(a.rating))*2)/2=4.5 then '90' when (round(avg(a.rating))*2)/2=5 then '100' else '0' end as rating,count(*) cnt from (select a.*,rating from cars a left outer join carrating b on a.carid = b.carid where a.carid in (select carid from cars where carbrandname in ("+ brandname +"))"+
			"and a.carid in (select carid from cars where carCategory in ("+ categoryname +"))" +
			"and a.carid in (select carid from cars where carPrice between "+ first +" and "+ last +")) a group by carId,carName,carCategory,carBrandName,carModel,carMileage,carProductionYear,carColor,carImagePath,carPrice,carReservationStatus,location order by carName");}
			else if (brandname=="" && categoryname!="" && first!= "" && last!=""){
			pst = conn.prepareStatement("select carId,    carName,    carCategory,    carBrandName,    carModel,    carMileage,    carProductionYear,    carColor,    carImagePath,    carPrice,    carReservationStatus,    location,case when (round(avg(a.rating))*2)/2=0 then '0' when (round(avg(a.rating))*2)/2=0.5 then '10' when (round(avg(a.rating))*2)/2=1 then '20' when (round(avg(a.rating))*2)/2=1.5 then '30' when (round(avg(a.rating))*2)/2=2 then '40' when (round(avg(a.rating))*2)/2=2.5 then '50' when (round(avg(a.rating))*2)/2=3 then '60' when (round(avg(a.rating))*2)/2=3.5 then '70' when (round(avg(a.rating))*2)/2=4 then '80' when (round(avg(a.rating))*2)/2=4.5 then '90' when (round(avg(a.rating))*2)/2=5 then '100' else '0' end as rating,count(*) cnt from (select a.*,rating from cars a left outer join carrating b on a.carid = b.carid where "+
			"a.carid in (select carid from cars where carCategory in ("+ categoryname +"))" +
			"and a.carid in (select carid from cars where carPrice between "+ first +" and "+ last +")) a group by carId,carName,carCategory,carBrandName,carModel,carMileage,carProductionYear,carColor,carImagePath,carPrice,carReservationStatus,location order by carName");}
			else if (first=="" && last=="" && categoryname!="" && brandname != ""){
			pst = conn.prepareStatement("select carId,    carName,    carCategory,    carBrandName,    carModel,    carMileage,    carProductionYear,    carColor,    carImagePath,    carPrice,    carReservationStatus,    location,case when (round(avg(a.rating))*2)/2=0 then '0' when (round(avg(a.rating))*2)/2=0.5 then '10' when (round(avg(a.rating))*2)/2=1 then '20' when (round(avg(a.rating))*2)/2=1.5 then '30' when (round(avg(a.rating))*2)/2=2 then '40' when (round(avg(a.rating))*2)/2=2.5 then '50' when (round(avg(a.rating))*2)/2=3 then '60' when (round(avg(a.rating))*2)/2=3.5 then '70' when (round(avg(a.rating))*2)/2=4 then '80' when (round(avg(a.rating))*2)/2=4.5 then '90' when (round(avg(a.rating))*2)/2=5 then '100' else '0' end as rating,count(*) cnt from (select a.*,rating from cars a left outer join carrating b on a.carid = b.carid where "+
			" a.carid in (select carid from cars where carbrandname in ("+ brandname +"))"+
			"and a.carid in (select carid from cars where carCategory in ("+ categoryname +"))) a group by carId,carName,carCategory,carBrandName,carModel,carMileage,carProductionYear,carColor,carImagePath,carPrice,carReservationStatus,location order by carName");}
			else if (categoryname=="" && first!= "" && last!="" && brandname != "" ){
			pst = conn.prepareStatement("select carId,    carName,    carCategory,    carBrandName,    carModel,    carMileage,    carProductionYear,    carColor,    carImagePath,    carPrice,    carReservationStatus,    location,case when (round(avg(a.rating))*2)/2=0 then '0' when (round(avg(a.rating))*2)/2=0.5 then '10' when (round(avg(a.rating))*2)/2=1 then '20' when (round(avg(a.rating))*2)/2=1.5 then '30' when (round(avg(a.rating))*2)/2=2 then '40' when (round(avg(a.rating))*2)/2=2.5 then '50' when (round(avg(a.rating))*2)/2=3 then '60' when (round(avg(a.rating))*2)/2=3.5 then '70' when (round(avg(a.rating))*2)/2=4 then '80' when (round(avg(a.rating))*2)/2=4.5 then '90' when (round(avg(a.rating))*2)/2=5 then '100' else '0' end as rating,count(*) cnt from (select a.*,rating from cars a left outer join carrating b on a.carid = b.carid where "+
			" a.carid in (select carid from cars where carbrandname in ("+ brandname +"))"+
			"and a.carid in (select carid from cars where carPrice between "+ first +" and "+ last +")) a group by carId,carName,carCategory,carBrandName,carModel,carMileage,carProductionYear,carColor,carImagePath,carPrice,carReservationStatus,location order by carName");}
			else if (categoryname=="" && brandname == ""&& first!= "" && last!=""){
			pst = conn.prepareStatement("select carId,    carName,    carCategory,    carBrandName,    carModel,    carMileage,    carProductionYear,    carColor,    carImagePath,    carPrice,    carReservationStatus,    location,case when (round(avg(a.rating))*2)/2=0 then '0' when (round(avg(a.rating))*2)/2=0.5 then '10' when (round(avg(a.rating))*2)/2=1 then '20' when (round(avg(a.rating))*2)/2=1.5 then '30' when (round(avg(a.rating))*2)/2=2 then '40' when (round(avg(a.rating))*2)/2=2.5 then '50' when (round(avg(a.rating))*2)/2=3 then '60' when (round(avg(a.rating))*2)/2=3.5 then '70' when (round(avg(a.rating))*2)/2=4 then '80' when (round(avg(a.rating))*2)/2=4.5 then '90' when (round(avg(a.rating))*2)/2=5 then '100' else '0' end as rating,count(*) cnt from (select a.*,rating from cars a left outer join carrating b on a.carid = b.carid where "+
			" a.carid in (select carid from cars where carPrice between "+ first +" and "+ last +")) a group by carId,carName,carCategory,carBrandName,carModel,carMileage,carProductionYear,carColor,carImagePath,carPrice,carReservationStatus,location order by carName");}
			else if (brandname=="" && first== "" && last=="" && categoryname!=""){
			pst = conn.prepareStatement("select carId,    carName,    carCategory,    carBrandName,    carModel,    carMileage,    carProductionYear,    carColor,    carImagePath,    carPrice,    carReservationStatus,    location,case when (round(avg(a.rating))*2)/2=0 then '0' when (round(avg(a.rating))*2)/2=0.5 then '10' when (round(avg(a.rating))*2)/2=1 then '20' when (round(avg(a.rating))*2)/2=1.5 then '30' when (round(avg(a.rating))*2)/2=2 then '40' when (round(avg(a.rating))*2)/2=2.5 then '50' when (round(avg(a.rating))*2)/2=3 then '60' when (round(avg(a.rating))*2)/2=3.5 then '70' when (round(avg(a.rating))*2)/2=4 then '80' when (round(avg(a.rating))*2)/2=4.5 then '90' when (round(avg(a.rating))*2)/2=5 then '100' else '0' end as rating,count(*) cnt from (select a.*,rating from cars a left outer join carrating b on a.carid = b.carid where "+
			"a.carid in (select carid from cars where carCategory in ("+ categoryname +"))) a group by carId,carName,carCategory,carBrandName,carModel,carMileage,carProductionYear,carColor,carImagePath,carPrice,carReservationStatus,location order by carName");}
			else if (categoryname=="" && first== "" && last==""){
			pst = conn.prepareStatement("select carId,    carName,    carCategory,    carBrandName,    carModel,    carMileage,    carProductionYear,    carColor,    carImagePath,    carPrice,    carReservationStatus,    location,case when (round(avg(a.rating))*2)/2=0 then '0' when (round(avg(a.rating))*2)/2=0.5 then '10' when (round(avg(a.rating))*2)/2=1 then '20' when (round(avg(a.rating))*2)/2=1.5 then '30' when (round(avg(a.rating))*2)/2=2 then '40' when (round(avg(a.rating))*2)/2=2.5 then '50' when (round(avg(a.rating))*2)/2=3 then '60' when (round(avg(a.rating))*2)/2=3.5 then '70' when (round(avg(a.rating))*2)/2=4 then '80' when (round(avg(a.rating))*2)/2=4.5 then '90' when (round(avg(a.rating))*2)/2=5 then '100' else '0' end as rating,count(*) cnt from (select a.*,rating from cars a left outer join carrating b on a.carid = b.carid where "+
			"a.carid in (select carid from cars where carbrandname in ("+ brandname +"))) a group by carId,carName,carCategory,carBrandName,carModel,carMileage,carProductionYear,carColor,carImagePath,carPrice,carReservationStatus,location order by carName");}
			ResultSet rst;
			rst = pst.executeQuery();
			while(rst.next()){
			list.add(rst.getString("carid"));
			list.add(rst.getString("carname"));
			list.add(rst.getString("carCategory"));
			list.add(rst.getString("carBrandName"));
			list.add(rst.getString("carModel"));
			list.add(rst.getString("carMileage"));
			list.add(rst.getString("carProductionYear"));
			list.add(rst.getString("carColor"));
			list.add(rst.getString("carImagePath"));
			list.add(rst.getString("carPrice"));	
			list.add(rst.getString("carReservationStatus"));
			list.add(rst.getString("location"));
			list.add(rst.getString("rating"));	
			list.add(rst.getString("cnt"));				
			}
		
		}
		catch(Exception e){
		}
		return list;

	}
	
	
	
	
	public ArrayList<String> showCarDetail(String carid){


		java.sql.Statement stm = null;
		ArrayList<String> list = new ArrayList<String>();
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/InfyMiles", "root", "root");
			stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			PreparedStatement pst = conn.prepareStatement("select carId,    carName,    carCategory,    carBrandName,    carModel,    carMileage,    carProductionYear,    carColor,    carImagePath,    carPrice,    carReservationStatus,    location,case when (round(avg(a.rating))*2)/2=0 then '0' when (round(avg(a.rating))*2)/2=0.5 then '10' when (round(avg(a.rating))*2)/2=1 then '20' when (round(avg(a.rating))*2)/2=1.5 then '30' when (round(avg(a.rating))*2)/2=2 then '40' when (round(avg(a.rating))*2)/2=2.5 then '50' when (round(avg(a.rating))*2)/2=3 then '60' when (round(avg(a.rating))*2)/2=3.5 then '70' when (round(avg(a.rating))*2)/2=4 then '80' when (round(avg(a.rating))*2)/2=4.5 then '90' when (round(avg(a.rating))*2)/2=5 then '100' else '0' end as rating,count(*) cnt from (select a.*,rating from cars a left outer join carrating b on a.carid = b.carid where  a.carid=?) a group by carId,carName,carCategory,carBrandName,carModel,carMileage,carProductionYear,carColor,carImagePath,carPrice,carReservationStatus,location order by carName");
			pst.setString(1,carid);
			ResultSet rst;
			rst = pst.executeQuery();
			while(rst.next()){
			list.add(rst.getString("carid"));
			list.add(rst.getString("carname"));
			list.add(rst.getString("carCategory"));
			list.add(rst.getString("carBrandName"));
			list.add(rst.getString("carModel"));
			list.add(rst.getString("carMileage"));
			list.add(rst.getString("carProductionYear"));
			list.add(rst.getString("carColor"));
			list.add(rst.getString("carImagePath"));
			list.add(rst.getString("carPrice"));	
			list.add(rst.getString("carReservationStatus"));
			list.add(rst.getString("location"));
			list.add(rst.getString("rating"));	
			list.add(rst.getString("cnt"));				
			}
		
		}
		catch(Exception e){
		}
		return list;

	}
	
	public ArrayList<String> showhomeCarDetail(){


		java.sql.Statement stm = null;
		ArrayList<String> list = new ArrayList<String>();
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/InfyMiles", "root", "root");
			stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			PreparedStatement pst = conn.prepareStatement("select carId,    carName,    carCategory,    carBrandName,    carModel,    carMileage,    carProductionYear,    carColor,    carImagePath,    carPrice,    carReservationStatus,    location,case when (round(avg(a.rating))*2)/2=0 then '0' when (round(avg(a.rating))*2)/2=0.5 then '10' when (round(avg(a.rating))*2)/2=1 then '20' when (round(avg(a.rating))*2)/2=1.5 then '30' when (round(avg(a.rating))*2)/2=2 then '40' when (round(avg(a.rating))*2)/2=2.5 then '50' when (round(avg(a.rating))*2)/2=3 then '60' when (round(avg(a.rating))*2)/2=3.5 then '70' when (round(avg(a.rating))*2)/2=4 then '80' when (round(avg(a.rating))*2)/2=4.5 then '90' when (round(avg(a.rating))*2)/2=5 then '100' else '0' end as rating,count(*) cnt from (select a.*,rating from cars a left outer join carrating b on a.carid = b.carid order by carprice*1 desc limit 15 ) a group by carId,carName,carCategory,carBrandName,carModel,carMileage,carProductionYear,carColor,carImagePath,carPrice,carReservationStatus,location order by carprice*1 desc limit 15 ");
			ResultSet rst;
			rst = pst.executeQuery();
			while(rst.next()){
			list.add(rst.getString("carid"));
			list.add(rst.getString("carname"));
			list.add(rst.getString("carCategory"));
			list.add(rst.getString("carBrandName"));
			list.add(rst.getString("carModel"));
			list.add(rst.getString("carMileage"));
			list.add(rst.getString("carProductionYear"));
			list.add(rst.getString("carColor"));
			list.add(rst.getString("carImagePath"));
			list.add(rst.getString("carPrice"));	
			list.add(rst.getString("carReservationStatus"));
			list.add(rst.getString("location"));
			list.add(rst.getString("rating"));	
			list.add(rst.getString("cnt"));				
			}
		
		}
		catch(Exception e){
		}
		return list;

	}
	
	public ArrayList<String> autoCompleteCar(){


		java.sql.Statement stm = null;
		ArrayList<String> list = new ArrayList<String>();
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/InfyMiles", "root", "root");
			stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			PreparedStatement pst = conn.prepareStatement("select carName,carCategory from cars");
			ResultSet rst;
			rst = pst.executeQuery();
			while(rst.next()){
			list.add(rst.getString("carname"));
			list.add(rst.getString("carCategory"));		
			}
		
		}
		catch(Exception e){
		}
		return list;

	}
	
}

