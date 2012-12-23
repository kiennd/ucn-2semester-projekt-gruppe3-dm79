package DBLayer;

import static org.junit.Assert.*;

import org.junit.Test;
import ModelLayer.*;


public class DBPlasmaDiseaseTest 
{

	@Test
	public void testSearchDiseaseById() 		
	{
		DBPlasmaDisease dbplasma = new DBPlasmaDisease();
		PlasmaDisease plasma = dbplasma.searchDiseaseById(1500, false);	
		if(plasma != null)
		{
			System.out.println("returned a disease with id " + plasma.getDiseaseId() + " and the disease name is: " + plasma.getDiseaseName());
		}
		else
		{
			fail("could not retun a disease with this id.");
		}
	}

	
	@Test
	public void testSearchPlasmaDiseaseByName() 
	
	{
		DBPlasmaDisease dbplasma = new DBPlasmaDisease();
		PlasmaDisease plasmaObj = dbplasma.searchPlasmaDiseaseByName("Plasmacytosis", false);
		//String s = "Plasmacytosis";
		if(plasmaObj !=null)
		{
			System.out.println("Returned a disease named: " +plasmaObj.getDiseaseName());
			System.out.println("Returned a disease with Id: " +plasmaObj.getDiseaseId());
		}
		
		else
		{
			fail("Not yet implemented");
		}
	}

	
	
	@Test
	public void testUpdatePlasmaDisease() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertPlasmaDisease() 
	{
		DBPlasmaDisease dbplas = new DBPlasmaDisease();		
		PlasmaDisease plasObj = new PlasmaDisease(1800, "PlasmaAalborg", "NULL", "NULL", "NULL", "NULL", "NULL", "Plasma2TEST");
		dbplas.insertPlasmaDisease(plasObj);
		PlasmaDisease plasObj2 = dbplas.searchDiseaseById(1800, false);
		if(plasObj2 != null)
		{
			System.out.println("A new disease has been successfully added to the db. Disease id is" + plasObj2.getDiseaseId() + "and the disease name is: " + plasObj2.getDiseaseName());
		}
		else
		{
			fail("Insertion unsuccessful.");
		}
	}
	
	
	@Test
	public void testDeletePlasmaDisease() 
	{	
		DBPlasmaDisease dbplasObj = new DBPlasmaDisease();
		PlasmaDisease plasObj = new PlasmaDisease(1700, "Plasma≈rhus", "23/12/2012", "antibioticcs", "23/12/2012", "23/12/2012", "23/12/2012", "PlasmacytosisTEST");
		if(plasObj != null)
		{
			System.out.println("A new disease was created with the id: " + plasObj.getDiseaseId() + " and the name of the disease is: " + plasObj.getDiseaseName());
			
		}
		
		dbplasObj.insertPlasmaDisease(plasObj);
		PlasmaDisease plasma1 = dbplasObj.searchDiseaseById(1700, false);
		
		if(plasma1 != null)
		{
			System.out.println("A disease with the id: " + plasma1.getDiseaseId() + " and name: " + plasma1.getDiseaseName() + " has been inserted into the database.");
		}
		
		dbplasObj.deletePlasmaDisease(1700);
		PlasmaDisease plasma2 = dbplasObj.searchPlasmaDiseaseByName("PlasmacytosisTEST", false);
		if(plasma2 == null)
		{
			System.out.println("Passed: Object deleted.");
			System.out.println("############################################");
		}
		else
		
		{
		
			fail("Failed: object was not deleted.");
		}
	}
	
	
	
}