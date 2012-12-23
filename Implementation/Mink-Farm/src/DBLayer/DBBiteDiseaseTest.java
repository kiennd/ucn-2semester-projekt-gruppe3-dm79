package DBLayer;
import static org.junit.Assert.*;
import org.junit.Test;
import ModelLayer.*;

public class DBBiteDiseaseTest {

		@Test
		public  void testsearchBiteDiseaseById() 
		{
			DBBiteDisease dbbite = new DBBiteDisease();
			BiteDisease bite = dbbite.searchBiteDiseaseById(1600, false);	
			if(bite != null)
			{
				System.out.println("returned a disease with id: " + bite.getDiseaseId() + " and the disease name is: " + bite.getDiseaseName());
				System.out.println("############################################");
			}
			else
			{
				fail("could not retun a disease with this id.");
			}
		}

		

	@Test
	public void testSearchBiteDiseaseByName() 
	{
		DBBiteDisease dbbite = new DBBiteDisease();
		BiteDisease bite = dbbite.searchBiteDiseaseByName("BideSår", false);	
		if(bite != null)
		{
			System.out.println("returned a disease called: " + bite.getDiseaseName() + " and the disease Id is: " + bite.getDiseaseId());
			System.out.println("############################################");
		}
		else
		{
			fail("could not retun a disease with this id.");
		}
	}

	
	
	@Test
	public void testUpdateBiteDisease() 
	{
		fail("Not yet implemented");
	}

	@Test
	public void testInsertBiteDisease() 
	{
		DBBiteDisease dbbitedis = new DBBiteDisease();
		BiteDisease bitedisObj = new BiteDisease(2000, "leg", "20/12/2012", "22/12/2012", "treatment", "description here", "Bidesår3");
		dbbitedis.insertBiteDisease(bitedisObj);
		BiteDisease bite1 = dbbitedis.searchBiteDiseaseById(2000, false);
		if(bite1.getDiseaseId() == 2000)
		{
			System.out.println("Returned a disease  called : " + bite1.getDiseaseName());
			System.out.println("Successfully created a new disease with id " + bite1.getDiseaseId());
			System.out.println("############################################");
		}
		else
		{
			
			fail("Not yet implemented");
		}
	}

	@Test
	
	public void testDeleteBiteDiseaseWithId() 
	{	
		DBBiteDisease dbbitedis = new DBBiteDisease();
		BiteDisease bitedisObj = new BiteDisease(1700, "head", "23/12/2012", "23/12/2012", "seperation", "description from medarbejder", "Bidesår2");
		if(bitedisObj != null)
		{
			System.out.println("A new disease was created with the id: " + bitedisObj.getDiseaseId() + " and the name of the disease is: " + bitedisObj.getDiseaseName());
			
		}
		
		dbbitedis.insertBiteDisease(bitedisObj);
		BiteDisease bite1 = dbbitedis.searchBiteDiseaseById(1700, false);
		
		if(bite1 != null)
		{
			System.out.println("A disease with the id: " + bitedisObj.getDiseaseId() + " and name: " + bitedisObj.getDiseaseName() + " has been inserted into the database.");
		}
		
		dbbitedis.deleteBiteDiseaseWithId(1700);
		BiteDisease bite2 = dbbitedis.searchBiteDiseaseByName("BideSår2", false);
		
		if(bite2 == null)
		{
			System.out.println("Passed: Object deleted.");
			System.out.println("############################################");
		}
		else
		
		{
		
		fail("Failed: because object was not deleted.");
		}
}

	}

