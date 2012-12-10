package ModelLayer;


public class mfFarm {
	
	private String name;
	private String address;
	private String email;
	private String zipCode;
	private String city;
	private String phoneNo;
	private String cvrNo;
	
	public mfFarm(String name, String address, String email, String zipCode, String city, String phoneNo, String cvrNo)
	{
		this.name = name;
		this.address = address;
		this.email = email;
		this.zipCode = zipCode;
		this.city = city;
		this.phoneNo = phoneNo;
		this.cvrNo = cvrNo;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
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
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	public String getPhoneNo() {
		return phoneNo;
	}
	
	public void setCvrNo(String cvrNo) {
		this.cvrNo = cvrNo;
	}
	
	public String getCvrNo() {
		return cvrNo;
	}
	
}
