package ControlLayer;
import ModelLayer.*;
import DBLayer.*;

public class CTRBiteDisease 
{
	/**
	 * Creates a new instance of CTRBiteDisease.
	 */
	
	public CTRBiteDisease()
	{
	}
	
	public BiteDisease findDiseaseById(int diseaseId)
	{
		IFDBBiteDisease dbBiteDisease = new DBBiteDisease();
		return dbBiteDisease.searchBiteDiseaseById(diseaseId, true);
	}
	
	public BiteDisease findDiseaseByName(String diseasename)
	{
		IFDBBiteDisease dbBiteDisease = new DBBiteDisease();
		return dbBiteDisease.searchBiteDiseaseByName(diseasename, true);
	}
	
	
    public int updateDiseaseBite(int diseaseId, String diseaseName)
    {
    	IFDBBiteDisease dbBiteDisease = new DBBiteDisease();
    	return dbBiteDisease.updateBiteDisease(new BiteDisease(diseaseId, diseaseName));  
    }
	
} //end of class CTRBiteDisease.
