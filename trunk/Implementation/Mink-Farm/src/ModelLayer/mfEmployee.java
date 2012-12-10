package ModelLayer;

public class mfEmployee {
	
	private String address;
	private String email;
	private String zipCode;
	private String phoneNo;
	private String employeeID;
	
	
	public mfEmployee(String address, String email, String zipCode, String phoneNo, String employeeID)
	{
		this.address = address;
		this.email = email;
		this.zipCode = zipCode;
		this.phoneNo = phoneNo;
		this.employeeID = employeeID;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return address;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	
	
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	public String getPhoneNo() {
		return phoneNo;
	}
	
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	
	public String getEmployeeID() {
		return employeeID;
	}
	
	
}
