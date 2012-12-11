package ModelLayer;

public class mfEmployee {
	
	private int employeeID;
	private String fname;
	private String lname;
	private String address;
	private int zipCode;
	private String city;
	private int phoneNo;
	private String email;

	
	public mfEmployee(int employeeID, String fname, String lname, String address, int zipCode, String city, int phoneNo, String email)
	{
		this.employeeID = employeeID;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.zipCode = zipCode;
		this.city = city;
		this.phoneNo = phoneNo;
		this.email = email;
	}
	
	public mfEmployee() {
		// EMPTY
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	
	public int getEmployeeID() {
		return employeeID;
	}
	
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public String getFname() {
		return fname;
	}
	
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public String getLname() {
		return lname;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	
	public int getZipCode() {
		return zipCode;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCity() {
		return city;
	}
	
	
	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	public int getPhoneNo() {
		return phoneNo;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
}
