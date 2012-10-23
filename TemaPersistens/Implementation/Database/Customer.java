package ModelLayer;


/**
 * Creates an instance of Customer with parameters name, address, zipCode ,city
 * 
 * @author (CF, MO, RH, FN) 
 * @version (2012-05-24)
 */
public class Customer
{
    // instance variables
    
    private String name;
    private String address;
    private int zipcode;
    private String city;
    
    /**
     * Constructor for objects of class Customer
     */
    public Customer(String name, String address, int zipcode, String city)
    {
        this.name = name;
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;
    }
    //setters and getters
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setAddress(String address)
    {
        this.address = address;
    }
    
    public String getAddress()
    {
        return address;
    }
    
    public void setZipcode(int zipcode)
    {
        this.zipcode = zipcode;
    }
    
    public int getZipcode()
    {
        return zipcode;
    }
    
    public void setCity(String city)
    {
        this.city = city;
    }
    
    public String getCity()
    {
        return city;
    }
}
