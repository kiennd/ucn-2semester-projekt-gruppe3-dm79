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
	private String diseaseName;

	
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

	/*
	 * Constructor with parameters.
	 */
	
	public BiteDisease(int diseaseId, String diseaseName) 
	{
		this.diseaseId = diseaseId;
		this.diseaseName = diseaseName;
	}
	
	
	// constructor to instantiate a disease id.
	public BiteDisease(int diseaseId) 
	{
		this.diseaseId = diseaseId;
	}
	
	
	public BiteDisease()
	{
	}
	
	

}//end of class BiteDisease
