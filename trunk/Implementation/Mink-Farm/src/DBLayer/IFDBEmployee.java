package DBLayer;

import ModelLayer.*;
import java.sql.*;
import java.util.ArrayList;

public interface IFDBEmployee {

	
	// Get all employees
	public ArrayList<Employee> getAllEmployees(boolean retriveAssociation);
	//get one employee by id.
	public Employee findEmployeeByID(int employeeID, boolean retriveAssociation);
	//get employee by fName.
	public Employee findEmployeeByFname(String fname, boolean retriveAssociation);
	//get employee by lName.
	public Employee findEmployeeByLname(String lname, boolean retriveAssociation);
	//insert a new employee
	public int insertEmployee(Employee emp) throws Exception;
	//update information about an employee
	public int updateEmployee(Employee emp);
	//delete employee
	public int deleteEmployee(int employeeID);
	
}
