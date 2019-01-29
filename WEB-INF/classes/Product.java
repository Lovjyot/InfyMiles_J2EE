public class Product {
    private String id;
    private String type;
    private String name;
    private String Price;
    private String Image;
    private String manufacturer;
	private String condition;
	private String discount;
	private String accessories;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
	 public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
	
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPrice() {
        return Price;
    }
    public void setPrice(String Price) {
        this.Price = Price;
    }
    public String getImage() {
        return Image;
    }
    public void setImage(String Image) {
        this.Image = Image;
    }
    public String getmanufacturer() {
        return manufacturer;
    }
    public void setmanufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
   public String getdiscount() {
        return discount;
    }
    public void setdiscount(String discount) {
        this.discount = discount;
    } 
	   public String getcondition() {
        return condition;
    }
    public void setcondition(String condition) {
        this.condition = condition;
    } 

    public String getaccessories() {
        return accessories;
    }
    public void setaccessories(String accessories) {
        this.accessories = accessories;
    } 

 
    @Override
    public String toString() {
        return this.id+ "," + this.type + "," + this.name +"," + this.Image + "," + this.Price +"," + this.manufacturer + "," + condition + "," + discount + "," + accessories;
    }
    
}