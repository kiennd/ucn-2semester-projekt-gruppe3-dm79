package DBLayer;
import ModelLayer.*;
import java.sql.*;
import java.util.ArrayList;

public interface IFDBCustomer
{
	// Get all customers
	public ArrayList<Customer> getAllCustomer(boolean retriveAssociation);
	//get one customer by pno
	public Customer findCustomerByPno(String pno, boolean retriveAssociation);
	public Customer findCustomerByFname(String pno, boolean retriveAssociation);
	public Customer findCustomerByLname(String pno, boolean retriveAssociation);
	//insert a new customer
	public int insertCustomer(Customer cus) throws Exception;
	//update information about an customer
	public int updateCustomer(Customer cus);
	
	

}
