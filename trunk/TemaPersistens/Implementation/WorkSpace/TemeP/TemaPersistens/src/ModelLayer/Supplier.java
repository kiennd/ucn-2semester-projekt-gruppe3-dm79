package ModelLayer;

public class Supplier 
{
	//instance variables
	
	private int supplierId;
	private String name;
	private String address;
	private String country;
	private String email;
		

	
	/**
	 * Constructor for objects of class Supplier
	 */
	public Supplier(int supplierId, String name, String address, String country, String email)
	{
		this.supplierId = supplierId;
		this.name = name;
		this.address = address;
		this.country = country;
		this.email = email;
	}
	
	
	/**
	 * Empty constructor for creating an empty object of class Supplier.
	 */
	public Supplier()
	{
		
	}


	/**
	 * 
	 * getters and setters.
	 */

	public int getSupplierId() 
	{
		return supplierId;
	}



	public void setSupplierId(int supplierId)
	{
		this.supplierId = supplierId;
	}



	public String getName() 
	{
		return name;
	}



	public void setName(String name) 
	{
		this.name = name;
	}



	public String getAddress() 
	{
		return address;
	}



	public void setAddress(String address) 
	{
		this.address = address;
	}



	public String getCountry() 
	{
		return country;
	}


	
	public void setCountry(String country) 
	{
		this.country = country;
	}


	
	public String getEmail() 
	{
		return email;
	}


	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	
	
	
}// end of class Supplier.
