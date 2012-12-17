package DBLayer;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import ModelLayer.BiteDisease;

public class DBBiteDiseaseTest{
@Test
public  void testsearchBiteDiseaseById() 
{
	DBBiteDisease dbbite = new DBBiteDisease();
	BiteDisease bite = dbbite.searchBiteDiseaseById(300, false);	
	if(bite != null)
	{
		System.out.println("returned a disease with id " + bite.getDiseaseId() + " and the disease name is: " + bite.getDiseaseType());
	}
	else
	{
		fail("could not retun a disease with this id.");
	}
}

}

