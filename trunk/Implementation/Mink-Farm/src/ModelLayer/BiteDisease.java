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
	private String bitelocation, diagnosisDate, treatmentStartDate, treatmentType, description, diseaseName;

	
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
	
	public String getDiseaseName() 
	{
		return diseaseName;
	}
	
	public void setDiseaseName(String diseaseName) 
	{
		this.diseaseName = diseaseName;
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
	
	
	public String getDescription() 
	{
		return description;
	}

	public void setDescription(String description) 
	{
		this.description = description;
	}
	
	
	
	/*
	 * Constructor with parameters.
	 */
	
	public BiteDisease(int diseaseId, String bitelocation, String diagnosisDate, String treatmentStartDate, String treatmentType, String description, String diseaseName) 
	{
		this.diseaseId = diseaseId;
		this.bitelocation = bitelocation;
		this.diagnosisDate = diagnosisDate;
		this.treatmentStartDate = treatmentStartDate;
		this.treatmentType = treatmentType;
		this.description = description;
		this.diseaseName = diseaseName;
	}
	
	
	/*
	 * Empty Parameters Constructor.
	 */
	
	public BiteDisease()
	{
		
	}

	
	//constructor to get disease id.
	
	public BiteDisease(int diseaseId) 
	{
		this.diseaseId = diseaseId;
	}
	


}//end of class BiteDisease
