package DBLayer;

import ModelLayer.*;
import java.sql.*;
import java.util.ArrayList;

public interface IFDBmfEmployee {

	
	// Get all employees
	public ArrayList<mfEmployee> getAllEmployees(boolean retriveAssociation);
	//get one employee by id
	public mfEmployee findEmployeeByID(int employeeID, boolean retriveAssociation);
	public mfEmployee findEmployeeByFname(String fname, boolean retriveAssociation);
	public mfEmployee findEmployeeByLname(String lname, boolean retriveAssociation);
	//insert a new employee
	public int insertEmployee(mfEmployee emp) throws Exception;
	//update information about an employee
	public int updateCustomer(mfEmployee emp);
	
}
