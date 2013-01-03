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
	private String clinicName, clinicCVR, diseaseName;
	
	/**
	 * get and set methods.
	 */
	
	public int getDiseaseId() 
	{
		return diseaseId;
	}
	
	public void setDiseaseId(int diseaseId) {
		this.diseaseId = diseaseId;
	}

	
	public String getClinicName() 
	{
		return clinicName;
	}
	
	public void setClinicName(String clinicName) 
	{
		this.clinicName = clinicName;
	}
	
	public String getClinicCVR() 
	{
		return clinicCVR;
	}
	
	public void setClinicCVR(String clinicCVR) 
	{
		this.clinicCVR = clinicCVR;
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
	
	public PlasmaDisease(int diseaseId, String clinicName, String clinicCVR, String diseaseName) 
	{
		this.diseaseId = diseaseId;
		this.clinicName = clinicName;
		this.clinicCVR = clinicCVR;
		this.diseaseName = diseaseName;
	}
	
	
	//constructor with disease id.
	
	public PlasmaDisease(int diseaseId) 
	{
		this.diseaseId = diseaseId;
	}
	
	public PlasmaDisease()
	{
		
	}
	
}//End of class PlasmaDisease
