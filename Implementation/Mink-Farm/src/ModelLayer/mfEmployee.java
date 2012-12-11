package ModelLayer;

public class mfEmployee {
	
	private int employeeID;
	private String address;
	private int zipCode;
	private int phoneNo;
	private String email;

	
	public mfEmployee(int employeeID, String address, int zipCode, int phoneNo, String email)
	{
		this.address = address;
		this.email = email;
		this.zipCode = zipCode;
		this.phoneNo = phoneNo;
		this.employeeID = employeeID;
	}


	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	
	public int getEmployeeID() {
		return employeeID;
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
