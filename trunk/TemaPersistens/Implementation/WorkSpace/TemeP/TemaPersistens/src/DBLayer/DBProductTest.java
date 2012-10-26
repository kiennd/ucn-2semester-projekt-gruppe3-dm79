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
		fail("Not yet implemented");
	}

	@Test
	public void testSearchProductname() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchProductSupId() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertProduct() {
		fail("Not yet implemented");
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
