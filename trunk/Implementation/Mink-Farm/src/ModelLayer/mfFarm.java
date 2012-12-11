package ModelLayer;
import java.util.ArrayList;

public class mfFarm {
	
	private int cvrNo;
	private String name;
	private String address;
	private int zipCode;
	private String city;
	private int phoneNo;
	private String email;
	private ArrayList<mfEmployee> employee;

	
	public mfFarm(int cvrNo, String name, String address, int zipCode, String city, int phoneNo, String email)
	{
		this.cvrNo = cvrNo;
		this.name = name;
		this.address = address;
		this.zipCode = zipCode;
		this.city = city;
		this.phoneNo = phoneNo;
		this.email = email;
		ArrayList<mfEmployee> employee;
	}
	
	public void  addEmployee(mfEmployee myEmployee)
	{
		employee.add(myEmployee);
	}
	
	public void setCvrNo(int cvrNo) {
		this.cvrNo = cvrNo;
	}
	
	public int getCvrNo() {
		return cvrNo;
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
