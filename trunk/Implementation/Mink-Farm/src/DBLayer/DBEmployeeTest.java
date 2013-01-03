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
		//TODO !!! redefine the constructor of Employee class.
		Employee testEmp = new Employee(3006,"Frodo", "Bagins", "Shire Ave 342", 6558, "The Shire", 88339955, "hobbit@lame.com");
		
		try{
			int x = dbEmp.insertEmployee(null);

		if(x > 0)
		{
			Employee emp = dbEmp.findEmployeeByID(3006, false);
			System.out.println("A new employee has been created with the following values: " + "Employee ID: " + emp.getEmployeeID() + "First name: " + emp.getFname() + "Last name: " + emp.getLname() + "lives at: " + emp.getAddress() + "zipcode: " + emp.getZipCode() + "city: " + emp.getCity() + "Phone number: " + emp.getPhoneNo() + "Email: " + emp.getEmail());
		}
		else
		{
		fail("Nothing new was created FAILS");
		}
	}
		catch(Exception e)
		{
			System.out.println("Nothing new was created");
		}
	}
	
//	@Test
//	public void testUpdateEmployee() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDeleteEmployee() {
//		fail("Not yet implemented");
//	}

}
