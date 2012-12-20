package DBLayer;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import ModelLayer.Employee;

public class DBEmployeeTest {

	@Test
	public void testGetAllEmployees() {
		DBEmployee emp = new DBEmployee();
		ArrayList<Employee> mylist = emp.getAllEmployees(false);
		if(mylist.size()== 5)
		{
			System.out.println("Working");
			
		}
		
		else
		{
			fail("Error in getAllEmployees ");
		}
		
	}

	@Test
	public void testFindEmployeeByFname() {
		DBEmployee dbEmp = new DBEmployee();
		Employee emp = dbEmp.findEmployeeByFname("Pilatos", false);
		if(emp != null)
		{
			System.out.println("Returned an employee with name " + emp.getFname());
			System.out.println("Working");
		}
		else
		{
		fail("could not return an employee with this name.");
		}
	}

	@Test
	public void testFindEmployeeByLname() {
		DBEmployee dbEmp = new DBEmployee();
		Employee emp = dbEmp.findEmployeeByLname("Andeby", false);
		if(emp != null)
		{
			System.out.println("Returned an employee with name " + emp.getLname());
			System.out.println("Working");
		}
		else
		{
		fail("could not return an employee with this name.");
		}
	}
	
	@Test
	public void testFindEmployeeID() {
		DBEmployee dbEmp = new DBEmployee();
		Employee emp = dbEmp.findEmployeeByID(3003, true);
		if(emp != null)
		{
			System.out.println("The employee's name is: " + emp.getFname() + " and his telephone number is: " + emp.getPhoneNo());
		}
		else
		{
		fail("failed to search with an ID.");
		}
	}

	@Test
	public void testInsertEmployee() {
		DBEmployee dbEmp = new DBEmployee();
		//TODO !!! redefine the constructor of Product class.
		//Product testProd = new Product(123, 200.0, 220.0, 20.0, "Canada", 100, "small", "green", null, null, null, 334, null, "Hippyhat", "Clothing");
		
		try{
			int x = dbprod.insertProduct(null);

		if(x > 0)
		{
			Product prod = dbprod.findProduct(123, false);
			System.out.println("A new product has been created with the following values: " + "Product Id: " + prod.getProductId() + "Product name" + prod.getName() + "and the purchase price is: " + prod.getPurchasePrice());
		}
		else
		{
				
		fail("Nothing new was created");
		}
	}
	catch(Exception e)
	{
		System.out.println("Nothing new was created");
	}
	}
	
	
//	@Test
//	public void testUpdateProduct() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDeleteProduct() {
//		fail("Not yet implemented");
//	}

}
