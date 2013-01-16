package DBLayer;

import static org.junit.Assert.*;

import java.sql.Statement;
import java.util.ArrayList;

import org.junit.Test;
import ModelLayer.*;

public class DBTransferTest {

	@Test
	public void testGetAllTransfer() 
	{
		DBTransfer dbtransfer = new DBTransfer();
		ArrayList<Transfer> mytransferlist = dbtransfer.getAllTransfer(false);
		
		int count = mytransferlist.size();
		
		if(mytransferlist.size()== 5)
		{
			System.out.println("Database contains " + count + "tuples");
		}
		
		int store = mytransferlist.get(6).getCage().getCageNo();
		if(store != 0)
		{
			System.out.println("Cage Id of the item in position 6 is:" + store);
		}
		else
		fail("no item was found.");
	}

	

	
	@Test
	public void testSearchTransfersByCageId() 
	{
		DBTransfer dbtransfer = new DBTransfer();
		Transfer transObj = dbtransfer.searchTransfersByCageNo(300, false);
		int store = transObj.getCage().getCageNo();
		if (store == 300)
		{
			System.out.println("found a cage with id " + transObj.getCage().getCageNo());
		}
		else
		{
			fail("Error in transfer Find ");
		}
	}
	

	@Test
	public void testFindTransfersBydiseaseid()
	{
		DBTransfer dbtransfer = new DBTransfer();
		ArrayList<Transfer> transObj = dbtransfer.findTransfersBydiseaseId(1500, false);
		int store = transObj.get(0).getPlasmadisease().getDiseaseId();
		if(store == 1500)
		{
			System.out.println("found a disease with id " + transObj.get(0).getPlasmadisease().getDiseaseId());
		}
		else
		{
			System.out.println("Error in transfer Find");
				//fail("Error in transfer Find ");
		}
	}



	@Test
	public void testInsertTransfer() throws Exception
	{
		DBCage dbcage = new DBCage();
		Cage cageObj = dbcage.findCage(203, false);
		int storecageId = cageObj.getCageNo();
		System.out.println("output" + storecageId);
		System.out.println("###########################");
		
		
		DBEmployee dbemp = new DBEmployee();
		Employee empObj = dbemp.findEmployeeByID(3005, false);
		int storeEmpId = empObj.getEmployeeID();
		System.out.println("output" + storeEmpId);
		System.out.println("###########################");
		
		DBBiteDisease dbbite = new DBBiteDisease();
		BiteDisease biteObj = dbbite.searchBiteDiseaseById(1600, false);
		int storebiteId = biteObj.getDiseaseId();
		System.out.println("output" + storebiteId);
		System.out.println("###########################");
		
		DBPlasmaDisease dbplasma = new DBPlasmaDisease();
		PlasmaDisease plasmaObj = dbplasma.searchDiseaseById(1500, false); 
		int storeplasId = plasmaObj.getDiseaseId(); 
		System.out.println("output" + storeplasId);
		System.out.println("###########################");
		
		
		DBTransfer dbtransfer = new DBTransfer();
		Transfer newtransferObj = new Transfer(70, cageObj, biteObj, empObj, "10/12/2012");	
		try
		{
			dbtransfer.insertTransfer(newtransferObj);
		} 
		catch (Exception e) 
		{
			System.out.println("Error in insertion");
			e.printStackTrace();
		}
}
	

	@Test
	public void testDeleteTransfer() 
	{
		DBCage dbcage = new DBCage();
		Cage cageObj = dbcage.findCage(203, false);
		//int storecageId = cageObj.getCageNo();
		//System.out.println("output" + storecageId);
		System.out.println("###########################");
		
		
		DBEmployee dbemp = new DBEmployee();
		Employee empObj = dbemp.findEmployeeByID(3005, false);
		//int storeEmpId = empObj.getEmployeeID();
		//System.out.println("output" + storeEmpId);
		System.out.println("###########################");
		
		DBBiteDisease dbbite = new DBBiteDisease();
		BiteDisease biteObj = dbbite.searchBiteDiseaseById(1600, false);
		//int storebiteId = biteObj.getDiseaseId();
		//System.out.println("output" + storebiteId);
		System.out.println("###########################");
		
		DBPlasmaDisease dbplasma = new DBPlasmaDisease();
		PlasmaDisease plasmaObj = dbplasma.searchDiseaseById(1500, false); 
		//int storeplasId = plasmaObj.getDiseaseId(); 
		//System.out.println("output" + storeplasId);
		System.out.println("###########################");
		
		
		DBTransfer dbtrans = new DBTransfer();
		Transfer trans = new Transfer(47, cageObj, plasmaObj, empObj, "10/10/2013");
		dbtrans.insertTransfer(trans);
		Transfer trans1 = dbtrans.searchTransfersByTransferId(47, false);
		int store = trans1.getTransferId();
		if(store == 47)
		{
			System.out.println("A new transfer has been inserted into the DB with id: " + trans1.getTransferId());
		}
		System.out.println("about to delete transfer with the id: " + trans.getTransferId());
		dbtrans.deleteTransfer(47);
		System.out.println("deleted transfer with Id" + trans.getTransferId());
		Transfer transObj = dbtrans.searchTransfersByTransferId(store, false);
		if(transObj == null)
		{
			System.out.println("Passed: Object deleted.");
			System.out.println("############################################");
		}
		else
		{
			fail("Failed: Object was not deleted.");
		}

	}




}
