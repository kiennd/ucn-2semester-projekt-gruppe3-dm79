package ControlLayer;
import ModelLayer.*;
import DBLayer.*;

import java.util.ArrayList;

public class CTRCustomer {
	
	public CTRCustomer()
	{
		
	
	}
	public ArrayList<Customer> findAllCustomer()
	{
		IFDBCustomer ifdbCus = new DBCustomer();
		ArrayList<Customer> allCus = new ArrayList<Customer>();
		allCus = ifdbCus.getAllCustomer(false);
		return allCus;
	}
	public Customer findbyFname(String fname)
	{
		IFDBCustomer ifdbCus = new DBCustomer();
		return ifdbCus.findCustomerByFname(fname, true);
	}
	public Customer findbyLname(String lname)
	{
		IFDBCustomer ifdbCus = new DBCustomer();
		return ifdbCus.findCustomerByLname(lname, true);
	}
	public Customer findbyPno(String pno)
	{
		IFDBCustomer ifdbCus = new DBCustomer();
		return ifdbCus.findCustomerByFname(pno, true);
	}
	public int updateCustomer(String fname,String lname, int id, String address, String zipcode, String city, String phoneno, String email, String type)
	{
		IFDBCustomer ifdbCus = new DBCustomer();
		Customer cus = new Customer();
		cus.setFname(fname);
		cus.setLname(lname);
		cus.setCustID(id);
		cus.setAddress(address);
		cus.setZipCode(zipcode);
		cus.setCity(city);
		cus.setPno(phoneno);
		cus.setEmail(email);
		cus.setType(type);
		return ifdbCus.updateCustomer(cus);	
	}
	public void insertNewCustomer(String fname,String lname, int id, String address, String zipcode, String city, String phoneno, String email, String type)
			{
				Customer cusobj = new Customer();
				cusobj.setFname(fname);
				cusobj.setLname(lname);
				cusobj.setCustID(id);
				cusobj.setAddress(address);
				cusobj.setZipCode(zipcode);
				cusobj.setCity(city);
				cusobj.setPno(phoneno);
				cusobj.setEmail(email);
				cusobj.setType(type);
				
			try
			{
				
			DbConnection1.startTransaction();
			DBCustomer dbCus = new DBCustomer();
			dbCus.insertCustomer(cusobj);
			DbConnection1.commitTransaction();
			}
			catch(Exception e)
			{
				DbConnection1.rollbackTransaction();
			}
				
			}
	

}
