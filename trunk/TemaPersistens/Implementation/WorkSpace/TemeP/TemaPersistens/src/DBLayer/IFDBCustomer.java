package DBLayer;
import ModelLayer.*;
import java.util.ArrayList;

public interface IFDBCustomer
{
	// Get all customers
	public ArrayList<Customer> getAllCustomer(boolean retriveAssociation);
	//get one customer by pno
	public Customer findCustomer(String pno, boolean retriveAssociation);
	//insert a new customer
	public int insertEmployee(Customer cus) throws Exception;
	//update information about an customer
	public int updateCustomer(Customer cus);
	
	

}
