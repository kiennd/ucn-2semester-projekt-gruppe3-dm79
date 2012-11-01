package DBLayer;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import ModelLayer.Product;

public class DBProductTest {

	@Test
	public void testGetAllProducts() {
		DBProduct dbprod = new DBProduct();
		ArrayList<Product> mylist = dbprod.getAllProducts(false);
		if(mylist.size()== 12)
		{
			System.out.println("okay");
			
		}
		
		else
		{
			fail("Error in getAllProducts ");
		}
		
	}
	

	@Test
	public void testFindProduct() {
		DBProduct dbprod = new DBProduct();
		Product prod = dbprod.findProduct(111, false);
		if(prod != null)
		{
			System.out.println("returned a product with id " + prod.getProductId() + " and product name is: " + prod.getName());
		}
		else
			
		
		fail("could not retun a product with this id.");
	}

	@Test
	public void testSearchProductname() {
		DBProduct dbprod = new DBProduct();
		Product prod = dbprod.searchProductname("Poncho", false);
		if(prod != null)
		{
			System.out.println("returned a product with name " + prod.getName() + " and there it has a minimum stock of " + prod.getMinStock());
		}
			
		fail("could not retun a product with this name.");
	}

	@Test
	public void testSearchProductSupId() {
		DBProduct dbprod = new DBProduct();
		Product prod = dbprod.searchProductSupId(333, true);
		if(prod != null)
		{
			System.out.println("Product's Supplier name is: " + prod.getSupplier().getName() + " and his telephone number is: " + prod.getSupplier().getPhonenum());
		}
			
			
		fail("failed to search wit a product name.");
	}

	@Test
	public void testInsertProduct() {
		DBProduct dbprod = new DBProduct();
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
	
	
	@Test
	public void testUpdateProduct() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteProduct() {
		fail("Not yet implemented");
	}

}
