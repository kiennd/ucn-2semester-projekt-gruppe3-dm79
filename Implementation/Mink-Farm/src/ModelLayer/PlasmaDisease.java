package ModelLayer;

/**
*
* @author DM79_group 3
* @version December 2012.
*/



/*
 * This class is used for creating Plasmacytosis objects, which is one of the two types of Diseases that can be tested 
 * for in a mink cage.
 */

public class PlasmaDisease 
{
	private int diseaseId;
	private String clinicName, nextTestDate, treatmentType, diagnosisDate, treatmentStartDate, testDate, diseaseName;
	
	
	
	/**
	 * get and set methods.
	 */
	
	public int getDiseaseId() 
	{
		return diseaseId;
	}
	
	public void setDiseaseId(int diseaseId) 
	{
		this.diseaseId = diseaseId;
	}
	
	public String getDiseaseName() 
	{
		return diseaseName;
	}
	
	public void setDiseaseName(String diseaseName) 
	{
		this.diseaseName = diseaseName;
	}
	
	public String getClinicName() 
	{
		return clinicName;
	}
	
	public void setClinicName(String clinicName) 
	{
		this.clinicName = clinicName;
	}
	
	public String getNextTestDate() 
	{
		return nextTestDate;
	}
	
	public void setNextTestDate(String nextTestDate) 
	{
		this.nextTestDate = nextTestDate;
	}
	
	public String getTreatmentType() 
	{
		return treatmentType;
	}
	
	public void setTreatmentType(String treatmentType) 
	{
		this.treatmentType = treatmentType;
	}
	
	public String getDiagnosisDate() 
	{
		return diagnosisDate;
	}
	
	public void setDiagnosisDate(String diagnosisDate) 
	{
		this.diagnosisDate = diagnosisDate;
	}
	
	public String getTreatmentStartDate() 
	{
		return treatmentStartDate;
	}
	
	public void setTreatmentStartDate(String treatmentStartDate) 
	{
		this.treatmentStartDate = treatmentStartDate;
	}
	
	public String getTestDate() 
	{
		return testDate;
	}
	
	public void setTestDate(String testDate) 
	{
		this.testDate = testDate;
	}

	
	/*
	 * Constructor with parameters.
	 */
	
	public PlasmaDisease(int diseaseId, String clinicName, String nextTestDate, String treatmentType, 
			String diagnosisDate,String treatmentStartDate, String testDate, String diseaseName) 
	{
		this.diseaseId = diseaseId;
		this.clinicName = clinicName;
		this.nextTestDate = nextTestDate;
		this.treatmentType = treatmentType;
		this.diagnosisDate = diagnosisDate;
		this.treatmentStartDate = treatmentStartDate;
		this.testDate = testDate;
		this.diseaseName = diseaseName;
	}
	
	
	
	/*
	 * Empty Parameters Constructor.
	 */
	
	public PlasmaDisease()
	{
		
	}
	
	//constructor to get disease id.
	
	public PlasmaDisease(int diseaseId) 
	{
		this.diseaseId = diseaseId;
	}
	


}//End of class PlasmaDisease
