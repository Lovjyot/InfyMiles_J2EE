import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
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
				return "error";
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
			PreparedStatement pst = conn.prepareStatement("select carId,    carName,    carCategory,    carBrandName,    carModel,    carMileage,    carProductionYear,    carColor,    carImagePath,    carPrice,    carReservationStatus,    location,case when (round(avg(a.rating))*2)/2=0 then '0' when (round(avg(a.rating))*2)/2=0.5 then '10' when (round(avg(a.rating))*2)/2=1 then '20' when (round(avg(a.rating))*2)/2=1.5 then '30' when (round(avg(a.rating))*2)/2=2 then '40' when (round(avg(a.rating))*2)/2=2.5 then '50' when (round(avg(a.rating))*2)/2=3 then '60' when (round(avg(a.rating))*2)/2=3.5 then '70' when (round(avg(a.rating))*2)/2=4 then '80' when (round(avg(a.rating))*2)/2=4.5 then '90' when (round(avg(a.rating))*2)/2=5 then '100' else '0' end as rating,count(*) cnt from (select a.*,rating from cars a left outer join carrating b on a.carid = b.carid order by carprice*1 desc ) a group by carId,carName,carCategory,carBrandName,carModel,carMileage,carProductionYear,carColor,carImagePath,carPrice,carReservationStatus,location order by carprice*1 desc limit 15 ");
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
	
	
	
	public ArrayList<String> autoCompleteSearchCar(String carname){


		java.sql.Statement stm = null;
		ArrayList<String> list = new ArrayList<String>();
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/InfyMiles", "root", "root");
			stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			PreparedStatement pst = conn.prepareStatement("select carId,    carName,    carCategory,    carBrandName,    carModel,    carMileage,    carProductionYear,    carColor,    carImagePath,    carPrice,    carReservationStatus,    location,case when (round(avg(a.rating))*2)/2=0 then '0' when (round(avg(a.rating))*2)/2=0.5 then '10' when (round(avg(a.rating))*2)/2=1 then '20' when (round(avg(a.rating))*2)/2=1.5 then '30' when (round(avg(a.rating))*2)/2=2 then '40' when (round(avg(a.rating))*2)/2=2.5 then '50' when (round(avg(a.rating))*2)/2=3 then '60' when (round(avg(a.rating))*2)/2=3.5 then '70' when (round(avg(a.rating))*2)/2=4 then '80' when (round(avg(a.rating))*2)/2=4.5 then '90' when (round(avg(a.rating))*2)/2=5 then '100' else '0' end as rating,count(*) cnt from (select a.*,rating from cars a left outer join carrating b on a.carid = b.carid where concat(carName,' in ', carCategory) like ? ) a group by carId,carName,carCategory,carBrandName,carModel,carMileage,carProductionYear,carColor,carImagePath,carPrice,carReservationStatus,location");
			ResultSet rst;
			pst.setString(1,"%" + carname + "%");
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
	
	
	
		public String insertRating(String user,String carid,String rating ){


		java.sql.Statement stm = null;
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/InfyMiles", "root", "root");
			stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			PreparedStatement pst = conn.prepareStatement("delete from carrating where emailid = ? and carid = ?");
			PreparedStatement pst2 = conn.prepareStatement("Insert into carrating values(?,?,?)");
			pst.setString(1,user);
			pst.setString(2,carid);
			pst2.setString(1,user);
			pst2.setString(2,carid);
			pst2.setString(3,rating);
			pst.executeUpdate();
			pst2.executeUpdate();
		return "success";
		}
		catch(Exception e){
			return "faile" + e;
		}

	}
	
<<<<<<< HEAD
	
	
=======
>>>>>>> adb2f60ce35d08f15691c82161f3987a433edb1a
	public ArrayList<String> graphGenration2(){
		ArrayList<String> list = new ArrayList<String>();
		try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/InfyMiles", "root", "root");
            PreparedStatement ps = conn.prepareStatement("select carName, sum(amount) as finalAmount  from cars a,orders b where a.carid=b.carid group by carName;");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
           
            while(rs.next()){
                //String name = rs.getString(1);
                //String quantity = rs.getString(2);
                list.add(rs.getString(1));
                list.add(rs.getString(2));
            }
           
            return list;

        }
        catch(Exception e)
        {

            //out.println(e);
        }
        return list;
    
	}
	
	public ArrayList<String> graphGenration(){
        ArrayList<String> list = new ArrayList<String>();
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/InfyMiles", "root", "root");
            PreparedStatement ps = conn.prepareStatement("select location, count(*) as counting  from cars group by location;");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
           
            while(rs.next()){
                //String name = rs.getString(1);
                //String quantity = rs.getString(2);
                list.add(rs.getString(1));
                list.add(rs.getString(2));
            }
           
            return list;

        }
        catch(Exception e)
        {

            //out.println(e);
        }
        return list;
    }


public ArrayList<String> graphGenration3(){
		ArrayList<String> list = new ArrayList<String>();
		try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/InfyMiles", "root", "root");
            PreparedStatement ps = conn.prepareStatement("select carName, count(b.carId) as counter from cars a, orders b where a.carId = b.carId group by carName;");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
           
            while(rs.next()){
                //String name = rs.getString(1);
                //String quantity = rs.getString(2);
                list.add(rs.getString(1));
                list.add(rs.getString(2));
            }
           
            return list;

        }
        catch(Exception e)
        {

            //out.println(e);
        }
        return list;
    
	}

	public boolean bookcar(int carId, String userName, String orderDate, String startDate, String endDate, String amount, String cardNumber, String address, String status, String licenseId, String paymentMethod) {/*, String fName, String lName, String email, String cnumber,String usertype)*/ 
		

		System.out.println("Order details:"+carId+ userName+ orderDate+ startDate+ endDate+ amount+ cardNumber+ address+ status+licenseId+ paymentMethod);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/InfyMiles", "root", "root");
			
			//java.util.Date date = new java.util.Date();
			//orderDate = date.toString();

			Random random = new Random();
			int  orderId = random.nextInt(50) + 1;
			
			String query = "INSERT INTO orders VALUES (?,?,?,current_date(),?,?,?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setInt(1, orderId);
			pst.setInt(2, carId);
			pst.setString(3, userName);
			//pst.setString(4, orderDate);						
			pst.setString(4, startDate);
			pst.setString(5, endDate);
			pst.setString(6, amount);
			pst.setString(7, cardNumber);						
			pst.setString(8, address);
			pst.setString(9, status);
			pst.setString(10, licenseId);
			pst.setString(11, paymentMethod);
			
			pst.executeUpdate();			
			conn.close();			
			return true;
		} 
		catch (Exception e) {
			System.out.println("Error"+e.toString());
			return false;
		}

	}

	
	
	
/*public ArrayList<String> changeProducts(){
	ArrayList<String> list = new ArrayList<String>();
	try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/InfyMiles","root","root");  
		String sql = "SELECT * from Cars";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs=st.executeQuery(); 
		while(rs.next()){
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
		}


	}catch(Exception e){
	}
	return list; 
}*/

public void cancelOrder(String orderid){
	try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/InfyMiles","root","root");  
		String sql2 = "update orders set status='cancelled' where orderid = ?";
		PreparedStatement st2 = con.prepareStatement(sql2);
		st2.setString(1, orderid); 
		st2.executeUpdate();
	}catch(Exception e){ 
	e.printStackTrace();
	}	
}
	
public ArrayList<String> changeProducts(){
		ArrayList<String> list = new ArrayList<String>();
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/InfyMiles","root","root");  
			String sql = "SELECT * from Cars";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rst=pst.executeQuery(); 
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
			}
			return list; 

		}
		catch(Exception e){
				return null;
		}
		
	}

	public String updateDeleteProducts(String task,int productId, String carName, String carCategory,String carBrandName, String carModel, String carMileage, String carProductionYear, String carColor, String carImagePath, String carPrice, int carReservationStatus, String location){
		//boolean check = false;
		try{  

			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/InfyMiles","root","root");  
			String sql = "Update Cars set carId = ?,carName = ?, carCategory = ?,carBrandName = ?,carModel = ?,carMileage = ?,carProductionYear = ?,carColor = ?, carImagePath = ?, carPrice = ?,carReservationStatus = ?,location = ? where carId= ?";
			String sql2 = "Delete from Cars where carId = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			PreparedStatement pst2 = con.prepareStatement(sql2);
			pst.setInt(1, productId);
			pst.setString(2, carName);
			pst.setString(3, carCategory);
			pst.setString(4, carBrandName);
			pst.setString(5, carModel);
			pst.setString(6, carMileage);
			pst.setString(7, carProductionYear);
			pst.setString(8, carColor);
			pst.setString(9, carImagePath);
			pst.setString(10, carPrice);
			pst.setInt(11, carReservationStatus);
			pst.setString(12, location);
			pst.setInt(13,productId);
			/*if(task.equals("delete")){
				pst2.executeUpdate(); 
				 return true;
			}
			else {*/
				pst.executeUpdate();
				return "true";
			//}
		}catch(Exception e){
			//return false;
			String error = "this:"+e;
			return error;
		}	
	}

	public boolean deleteCars(int productId){

		boolean check = false;
		try{  

			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/InfyMiles","root","root");  
			
			String sql = "Delete from Cars where carId = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setInt(1, productId);
			pst.executeUpdate();
				return true;	

		}
		catch(Exception e){
				return false;
		}
	}

	
	public ArrayList<String> MostLiked(){

			ArrayList<String> list = new ArrayList<String>();
		try{  

			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/InfyMiles","root","root");  
			
			String sql = "select carId,    carName,    carCategory,    carBrandName,    carModel,    carMileage,    carProductionYear,    carColor,    carImagePath,    carPrice,    carReservationStatus,    location,  case when (round(avg(a.rating))*2)/2=0 then '0' when (round(avg(a.rating))*2)/2=0.5 then '10'  when (round(avg(a.rating))*2)/2=1 then '20' when (round(avg(a.rating))*2)/2=1.5 then '30' when (round(avg(a.rating))*2)/2=2 then '40' when (round(avg(a.rating))*2)/2=2.5 then '50' when (round(avg(a.rating))*2)/2=3 then '60' when (round(avg(a.rating))*2)/2=3.5 then '70' when (round(avg(a.rating))*2)/2=4 then '80' when (round(avg(a.rating))*2)/2=4.5 then '90' when (round(avg(a.rating))*2)/2=5 then '100' else '0' end as rating,count(*) cnt from (select a.*,rating from cars a left outer join carrating b on a.carid = b.carid ) a  group by carId,carName,carCategory,carBrandName,carModel,carMileage,carProductionYear,carColor, carImagePath,carPrice,carReservationStatus,location order by rating desc limit 5";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rst=pst.executeQuery(); 
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
			}
			return list; 


		}
		catch(Exception e){
		return null;
		}
	}

	public ArrayList<String> MostBought(){

			ArrayList<String> list = new ArrayList<String>();
		try{  

			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/InfyMiles","root","root");  
			
			String sql = "select * from cars where carid in (select carid from (select carid,count(*) cnt from orders group by carid order by cnt desc limit 5)a ) ";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rst=pst.executeQuery(); 
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
			}
			return list; 


		}
		catch(Exception e){
		return null;
		}
	}
	
		public ArrayList<String> mostSoldLocation(){

			ArrayList<String> list = new ArrayList<String>();
		try{  

			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/InfyMiles","root","root");  
			
			String sql = "select z.*,max(cnt) maxcnt from (select a.*,count(*) cnt from cars a, orders o where a.carid=o.carid group by location) z group by location";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rst=pst.executeQuery(); 
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
			}
			return list; 


		}
		catch(Exception e){
		return null;
		}
	}
	
	
	
	public ArrayList<String> getAllData(){

			ArrayList<String> list = new ArrayList<String>();
		try{  

			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/InfyMiles","root","root");  
			
			String sql = "select * from cars";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rst=pst.executeQuery(); 
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
			}
			return list; 


		}
		catch(Exception e){
		return null;
		}
	}
	
	
	public ArrayList<String> userDetails(String username){
		ArrayList<String> userdetails = new ArrayList<String>();
		try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/InfyMiles","root","root"); 
				String sql = "Select name,emailId, address,phoneNumber,city,state,zipcode from Register where name =?" ; 
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, username);
				ResultSet rst = pst.executeQuery();
				while(rst.next()){
				userdetails.add(rst.getString(1));
				userdetails.add(rst.getString(2));
				userdetails.add(rst.getString(3));
				userdetails.add(rst.getString(4));
				userdetails.add(rst.getString(5));
				userdetails.add(rst.getString(6));
				userdetails.add(rst.getString(7));
			}
			return userdetails;
		}
		catch(Exception e){ 
			String error = "the error is:"+e; 			
			userdetails.add(error);
			return userdetails;
		}
	}
	
	
		public ArrayList<String> getAllDiscountData(){

			ArrayList<String> list = new ArrayList<String>();
		try{  

			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/InfyMiles","root","root");  
			
			String sql = "select * from cars a, discount b where a.carid= b.carid";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rst=pst.executeQuery(); 
			while(rst.next()){
				list.add(rst.getString(1));
				list.add(rst.getString(2));
				list.add(rst.getString(3));
				list.add(rst.getString(4));
				list.add(rst.getString(5));
				list.add(rst.getString(6));
				list.add(rst.getString(7));
				list.add(rst.getString(8));
				list.add(rst.getString(9));
				list.add(rst.getString(10));	
				list.add(rst.getString(11));
				list.add(rst.getString(12));
				list.add(rst.getString(14));
			}
			return list; 


		}
		catch(Exception e){
		return null;
		}
	}
	
	
	public ArrayList<String> getRentCars(){

			ArrayList<String> list = new ArrayList<String>();
		try{  

			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/InfyMiles","root","root");  
			
			String sql = "select carid,orderdate,sum(amount) amt from orders group by carid,orderdate";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rst=pst.executeQuery(); 
			while(rst.next()){
				list.add(rst.getString("carid"));
				list.add(rst.getString("orderDate"));
				list.add(rst.getString("amt"));
			}
			return list; 


		}
		catch(Exception e){
		return null;
		}
	}


	public ArrayList<String> getDailyTrans(){

			ArrayList<String> list = new ArrayList<String>();
		try{  

			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/InfyMiles","root","root");  
			
			String sql = "select orderdate,count(*) cnt from orders group by orderdate";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rst=pst.executeQuery(); 
			while(rst.next()){
				list.add(rst.getString("orderDate"));
				list.add(rst.getString("cnt"));
			}
			return list; 


		}
		catch(Exception e){
		return null;
		}
	}	

public Map<Integer,String> SelectProducts(){
Map<Integer,String> map = new HashMap<Integer,String>();
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/InfyMiles","root","root");  
String sql = "SELECT * from Cars";
PreparedStatement st = con.prepareStatement(sql);
ResultSet rst=st.executeQuery(); 
int i = 0;
while(rst.next()){
	
	map.put(i,rst.getString("carid"));
	map.put(i+1,rst.getString("carname"));
	map.put(i+2,rst.getString("carCategory"));
	map.put(i+3,rst.getString("carBrandName"));
	map.put(i+4,rst.getString("carModel"));
	map.put(i+5,rst.getString("carMileage"));
	map.put(i+6,rst.getString("carProductionYear"));
	map.put(i+7,rst.getString("carColor"));
	map.put(i+8,rst.getString("carImagePath"));
	map.put(i+9,rst.getString("carPrice"));	
	map.put(i+10,rst.getString("carReservationStatus"));
	map.put(i+11,rst.getString("location"));
	i=i+12;
}


}catch(Exception e){
}
return map; 
}	
	
	
	
}

