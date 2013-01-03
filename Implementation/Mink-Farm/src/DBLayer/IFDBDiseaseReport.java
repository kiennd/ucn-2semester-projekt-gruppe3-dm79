package DBLayer;

import java.util.ArrayList;

import ModelLayer.*;

public interface IFDBDiseaseReport {

	// Prints health status information for all the cages.
	public ArrayList<DiseaseReport> getAllDiseaseReport(boolean retriveAssociation);
	

	//find a single health status using the cage Id.
	public DiseaseReport searchDiseaseReportByCageNumber(int cageNo, boolean retriveAssociation);
	
	
	//inserts a new health record.
    public int insertDiseaseReport(DiseaseReport diseasereport);
    
    //delete a health record using a CageNo.
    public int deleteDiseaseReportWithCageNo(int cageNo);
	
}
