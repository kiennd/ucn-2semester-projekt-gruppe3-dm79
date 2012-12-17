package ControlLayer;
import ModelLayer.*;
import DBLayer.*;

import java.util.ArrayList;

public class CTREmployee {
	
	public CTREmployee() {
		
	}
	
	public ArrayList<Employee> findAllEmployees() {
		IFDBEmployee dbEmp = new DBEmployee();
		ArrayList<Employee> allEmp = new ArrayList<Employee>();
		allEmp = dbEmp.getAllEmployees(false);
		return allEmp;
	}
	
	public Employee findByFname(String fname) {
		IFDBEmployee dbEmp = new DBEmployee();
		return dbEmp.findEmployeeByFname(fname, true);
	}
	
	public Employee findByLname(String lname) {
		IFDBEmployee dbEmp = new DBEmployee();
		return dbEmp.findEmployeeByLname(lname, true);
	}
	
	public Employee findEmployeeByID(int employeeID) {
		IFDBEmployee dbEmp = new DBEmployee();
		return dbEmp.findEmployeeByID(employeeID, true);
	}
	
	public int updateEmployee(int employeeID, String fname, String lname, String address, int zipCode, String city, int phoneNo, String email) {
		IFDBEmployee dbEmp = new DBEmployee();
		Employee emp = new Employee();
		emp.setEmployeeID(employeeID);
		emp.setFname(fname);
		emp.setLname(lname);
		emp.setAddress(address);
		emp.setZipCode(zipCode);
		emp.setCity(city);
		emp.setPhoneNo(phoneNo);
		emp.setEmail(email);
		return dbEmp.updateEmployee(emp);
	}
	
	public void insertEmployee(int employeeID, String fname, String lname, String address, int zipCode, String city, int phoneNo, String email) {
		Employee empObj = new Employee();
		empObj.setEmployeeID(employeeID);
		empObj.setFname(fname);
		empObj.setLname(lname);
		empObj.setAddress(address);
		empObj.setZipCode(zipCode);
		empObj.setCity(city);
		empObj.setPhoneNo(phoneNo);
		empObj.setEmail(email);
		
		try{
			DbConnection.startTransaction();
			DBEmployee dbEmp = new DBEmployee();
			dbEmp.insertEmployee(empObj);
			DbConnection.commitTransaction();
		}
		catch(Exception e)
		{
			DbConnection.rollbackTransaction();
		}
	}

}
