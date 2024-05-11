package bean;

public class Order {
	private int id;
	private String name;
	private String date1;
	private String productname;
	
	public Order() {
		
	}
	
	public void setId(int id) {
		
		this.id = id;
	}
	
	public void setName(String name) {
		
		this.name = name;
	}
	
	public void setdate1(String date1) {
		
		this.date1 = date1;
	}
	
	public void setProductName(String productname) {
		
		this.productname = productname;
	}
	
	public int getId() {
		
		return this.id;
	}
	
	public String getName() {
		
		return this.name;
	}
	
	public String getdate1() {
		
		return this.date1;
	}
	
	public String getProductName() {
		
		return this.productname;
	}
	

}
