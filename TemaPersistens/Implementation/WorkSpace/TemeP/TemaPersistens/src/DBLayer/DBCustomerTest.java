package DBLayer;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import ModelLayer.*;
public class DBCustomerTest
{
@Test
public void getAllCustomers()
{
	DBCustomer dbCus = new DBCustomer();
	ArrayList<Customer> list = dbCus.getAllCustomer(false);
	if(list.size() == 5)
	{
		System.out.println("okey");
	}
	else
	{
		fail("Error in CUSTOMER");
	}
}
}
