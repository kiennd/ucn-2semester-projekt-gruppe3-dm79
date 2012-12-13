package DBLayer;

import ModelLayer.*;
import java.sql.*;
import java.util.ArrayList;

public interface IFDBmfEmployee {

	
	// Get all employees
	public ArrayList<mfEmployee> getAllEmployees(boolean retriveAssociation);
	//get one employee by id.
	public mfEmployee findEmployeeByID(int employeeID, boolean retriveAssociation);
	//get employee by fName.
	public mfEmployee findEmployeeByFname(String fname, boolean retriveAssociation);
	//get employee by lName.
	public mfEmployee findEmployeeByLname(String lname, boolean retriveAssociation);
	//insert a new employee
	public int insertEmployee(mfEmployee emp) throws Exception;
	//update information about an employee
	public int updateEmployee(mfEmployee emp);
	
}
