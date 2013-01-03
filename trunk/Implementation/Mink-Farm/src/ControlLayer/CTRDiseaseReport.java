package ControlLayer;

import ModelLayer.*;
import DBLayer.*;

import java.util.ArrayList;


public class CTRDiseaseReport {
	
    public ArrayList<DiseaseReport> getAllDiseaseReport()
    {
    	IFDBDiseaseReport dbDiseaseReport = new DBDiseaseReport();
        ArrayList<DiseaseReport> allDiseaseReport = new ArrayList<DiseaseReport>();
		allDiseaseReport = dbDiseaseReport.getAllDiseaseReport(false);
        return allDiseaseReport;
    }

    public DiseaseReport findDiseaseReportByCageNo(int cageNo)
    {
    	IFDBDiseaseReport dbDiseaseReport = new DBDiseaseReport();
		return dbDiseaseReport.searchDiseaseReportByCageNumber(cageNo, true);
    }

	public int insertDiseaseReport(int cageNo, int diseaseId)
	{
		int rc = -1;
		DiseaseReport diseasereport = new DiseaseReport(
				cageNo,
				diseaseId,
				""); // Today date added in DB-layer
		try
		{
			DbConnection.startTransaction();
			DBDiseaseReport dbreport = new DBDiseaseReport();
			rc = dbreport.insertDiseaseReport(diseasereport);
			DbConnection.commitTransaction();
		}
		catch(Exception e)
		{
			DbConnection.rollbackTransaction();
			System.out.println(e.getMessage());
		}
		
		return rc;
	}


}
