package ModelLayer;

import static org.junit.Assert.*;

import org.junit.Test;

import DBLayer.DBCustomer;
import DBLayer.DBProduct;

public class SalesOrderTest {

	@Test
	public void testSalesOrder()
	{
		DBProduct dbprod = new DBProduct();
		Product prod = dbprod.findProduct(113, false);
		Product prod1 = dbprod.findProduct(111, false);
		Product prod2 = dbprod.findProduct(112, false);
		DBCustomer dbcust = new DBCustomer();
		Customer cust = dbcust.findCustomerByPno("53501204", false);
		System.out.println("================================================");
		SalesOrder salesord = new SalesOrder(11, cust); 
		
		System.out.println("Created a new Order with the following items:");
		System.out.println("================================================");
		
		salesord.addProductSalesOrder(salesord, prod, 5);
		System.out.println("Sales Id: " + salesord.getSalesOrderID());
		System.out.println("Product Id: " + prod.getProductId());
		System.out.println("Product name: " + prod.getName());
		System.out.println("total quantity " + 5);
		System.out.println("Product price " + prod.getSalesPrice());
		
		System.out.println("================================================");
		
		salesord.addProductSalesOrder(salesord, prod1, 10);
		System.out.println("Sales Id: " + salesord.getSalesOrderID());
		System.out.println("Product Id: " + prod1.getProductId());
		System.out.println("Product name: " + prod1.getName());
		System.out.println("total quantity " + 10);
		System.out.println("Product price " + prod1.getSalesPrice());
		
		System.out.println("================================================");
		
		salesord.addProductSalesOrder(salesord, prod2, 15);
		System.out.println("Sales Id: " + salesord.getSalesOrderID());
		System.out.println("Product Id: " + prod2.getProductId());
		System.out.println("Product name: " + prod2.getName());
		System.out.println("total quantity " + 15);
		System.out.println("Product price " + prod2.getSalesPrice());
		
	}

	

	@Test
	public void testAddProductSalesOrder() 
	{
		
		fail("Not yet implemented");
	}

}
