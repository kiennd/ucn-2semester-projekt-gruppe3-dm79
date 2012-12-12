package ModelLayer;

/**
*
* @author DM79_group 3
* @version December 2012.
*/


/*
 * This class is used for creating Bite objects, which is one of the two types of Diseases that can be tested for 
 * in a mink cage.
 */

public class BiteDisease {
	private int diseaseId;
	private String diseaseType, bitelocation, diagnosisDate, treatmentStartDate, treatmentType;

	
/*
 * set and get methods.
 */
	
	public int getDiseaseId() 
	{
		return diseaseId;
	}
	
	public void setDiseaseId(int diseaseId) 
	{
		this.diseaseId = diseaseId;
	}
	
	public String getDiseaseType() 
	{
		return diseaseType;
	}
	
	public void setDiseaseType(String diseaseType) 
	{
		this.diseaseType = diseaseType;
	}
	
	public String getBitelocation() 
	{
		return bitelocation;
	}
	
	public void setBitelocation(String bitelocation) 
	{
		this.bitelocation = bitelocation;
	}
	
	public String getDiagnosisDate() 
	{
		return diagnosisDate;
	}
	public void setDiagnosisDate(String diagnosisDate) {
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
	
	public String getTreatmentType() 
	{
		return treatmentType;
	}
	
	public void setTreatmentType(String treatmentType) 
	{
		this.treatmentType = treatmentType;
	}
	
	
	
	/*
	 * Constructor with parameters.
	 */
	
	public BiteDisease(int diseaseId, String diseaseType, String bitelocation, String diagnosisDate, String treatmentStartDate, String treatmentType) 
	{
		this.diseaseId = diseaseId;
		this.diseaseType = diseaseType;
		this.bitelocation = bitelocation;
		this.diagnosisDate = diagnosisDate;
		this.treatmentStartDate = treatmentStartDate;
		this.treatmentType = treatmentType;
	}
	
	
	/*
	 * Empty Parameters Constructor.
	 */
	
	public BiteDisease()
	{
		
	}
	

}//end of class BiteDisease
