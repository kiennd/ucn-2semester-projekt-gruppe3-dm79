package ModelLayer;
import java.util.ArrayList;

public class Customer
{
	private int custID;
	private String fname;
	private String lname;
	private String address;
	private String pno;
	private String email;
	private String custType;
	private String zipCode;
	private String city;
	private String type;
	private ArrayList<SalesOrder> saleOrder;
	
	
	public Customer(int custID, String fname, String lname, String address, String pno, String email, String custType, String zipCode, String city, String type)
	{
		this.custID = custID;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.pno = pno;
		this.email = email;
		this.custType = custType;
		this.zipCode = zipCode;
		this.city = city;
		this.type = type;
		ArrayList<SalesOrder> saleOrder;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Customer()
	{
		//tom
	}
	 
	public void  addSaleOrder(SalesOrder mySalesOrder)
	{
		saleOrder.add(mySalesOrder);
	}


	public String getPno() {
		return pno;
	}




	public void setPno(String pno) {
		this.pno = pno;
	}




	public int getCustID() {
		return custID;
	}


	public void setCustID(int custID) {
		this.custID = custID;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCustType() {
		return custType;
	}


	public void setCustType(String custType) {
		this.custType = custType;
	}


	public String getZipCode() {
		return zipCode;
	}


	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


}