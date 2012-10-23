package ModelLayer;

public class Customer
{
	private int custID;
	private String fname;
	private String lname;
	private String address;
	private String email;
	private String custType;
	private String zipCode;
	private String city;
	
	
	public Customer(int custID, String fname, String lname, String address, String email, String custType, String zipCode, String city)
	{
		this.custID = custID;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.email = email;
		this.custType = custType;
		this.zipCode = zipCode;
		this.city = city;
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