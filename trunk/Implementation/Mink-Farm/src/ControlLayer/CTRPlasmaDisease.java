package ControlLayer;
import ModelLayer.*;
import DBLayer.*;

public class CTRPlasmaDisease {

	
	public CTRPlasmaDisease()
	{	
	}
	
	public PlasmaDisease findDiseaseById(int diseaseId)
	{
		IFDBPlasmaDisease dbPlasmaDisease = new DBPlasmaDisease();
		return dbPlasmaDisease.searchDiseaseById(diseaseId, true);
	}
	
	public PlasmaDisease findDiseaseByName(String diseasename)
	{
		IFDBPlasmaDisease dbPlasmaDisease = new DBPlasmaDisease();
		return dbPlasmaDisease.searchPlasmaDiseaseByName(diseasename, true);
	}
	
	
    public int updatePlasmaDisease(int diseaseId, String clinicName, String clinicCVR, String diseaseName)
    {
    	IFDBPlasmaDisease dbPlasmaDisease = new DBPlasmaDisease();
    	return dbPlasmaDisease.updatePlasmaDisease(new PlasmaDisease(diseaseId, clinicName, clinicCVR, diseaseName));  
    }

} //end of class CTRPlasmaDisease.
