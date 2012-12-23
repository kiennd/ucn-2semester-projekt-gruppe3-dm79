package DBLayer;
import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;
import ModelLayer.CageHealthStatus;

public class DBCageHealthStatusTest {

	@Test
	public void testDeleteHealthStatusWithCageNo() 
	{
		DBCageHealthStatus dbhealthstat = new DBCageHealthStatus();
		CageHealthStatus healthstat = new CageHealthStatus(405,"JA", "NEJ", "TEST");
		dbhealthstat.insertHealthStatus(healthstat);
		CageHealthStatus chstat1 = dbhealthstat.searchHealthStatusByCageNumber(405, false);
		int store = chstat1.getCageNumber();
		if(store == 405)
		{
			System.out.println("A new health record has been inserted into the DB with id: " + chstat1.getCageNumber());
		}
	
		dbhealthstat.deleteHealthStatusWithCageNo(405);
		CageHealthStatus chsObj = dbhealthstat.searchHealthStatusByCageNumber(405, false);
		if(chsObj == null)
		{
			System.out.println("Passed: Object deleted.");
			System.out.println("############################################");
		}
		else
		
		{
		
		fail("Failed: Object was not deleted.");
		}
		
	}
	
	
	@Test
	public void testGetAllCageHealthStatus() 
	{
		DBCageHealthStatus dbhealthstat = new DBCageHealthStatus();
		ArrayList<CageHealthStatus> mylist = dbhealthstat.getAllCageHealthStatus(false);
		int store = mylist.get(2).getCageNumber();
		System.out.println("Database contains " + store + " health records");
	}
		
/*		{
			fail("Error in CageHealthStatus");
		}
		*/
	
	

	@Test
	public void testFindHealthStatusByCageNo() 
	{
		DBCageHealthStatus dbhealthstat = new DBCageHealthStatus();;
		CageHealthStatus chs = dbhealthstat.searchHealthStatusByCageNumber(102, false);
		int store = chs.getCageNumber();
		if (store == 102)
		{
			System.out.println("found a cage with id " + chs.getCageNumber());
		}
		else
	
		{
			fail("Error in CageHealthStatus Find ");
		}
	}


	@Test
	public void testInsertHealthStatus() 
	{
		DBCageHealthStatus dbchs = new DBCageHealthStatus();
		CageHealthStatus newChsObj = new CageHealthStatus(303,"JA", "NEJ", "TEST");
		if(newChsObj != null)
		System.out.println("A new health record for cage Number :" +newChsObj.getCageNumber() +" was successfully created.");
		
		dbchs.insertHealthStatus(newChsObj);
		CageHealthStatus testchs = dbchs.searchHealthStatusByCageNumber(303, false);
		if(testchs.getCageNumber() == 303)
		{
			
			System.out.println("Returned a health record for cage Id : " + testchs.getCageNumber());
			System.out.println("Successfully inserted a new health record for cage Id: " + testchs.getCageNumber());
			System.out.println("############################################");
			
		}
		else
	
		{
			fail("Insertion Error in CageHealthStatus. ");
		}
		

	}


	@Test
	public void testUpdateHealthStatus() 
	{
		
		DBCageHealthStatus dbchs = new DBCageHealthStatus();
		
		CageHealthStatus newChsObj = dbchs.searchHealthStatusByCageNumber(403, false);
		if(newChsObj != null)
		{
			System.out.println("Found a health status with the Cage Id: " + newChsObj.getCageNumber());
		}
		dbchs.updateHealthStatus(newChsObj);
		
		{
		
		fail("Not yet implemented");
		}
	}
	
	



}
