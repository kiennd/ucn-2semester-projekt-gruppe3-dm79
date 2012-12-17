
package ModelLayer;

/**
*
* @author DM79_group 3
* @version December 2012.
* 
*/

/*
 * This class is used for creating objects that shows HealthStatus information for all the cages.
 *  
 */

public class CageHealthStatus 
{
	private int cageId, diseaseId;
	private String disease_present, okayDate;
	
	
/*
 * set and get methods.
 * 
 */
	
	public int getCageId() 
	{
		return cageId;
	}
	
	public void setCageId(int cageId) 
	{
		this.cageId = cageId;
	}
	
	public int getDiseaseId() 
	{
		return diseaseId;
	}
	
	public void setDiseaseId(int diseaseId) 
	{
		this.diseaseId = diseaseId;
	}
	
	public String getDisease_present() 
	{
		return disease_present;
	}
	
	public void setDisease_present(String disease_present) 
	{
		this.disease_present = disease_present;
	}
	
	public String getOkayDate() 
	{
		return okayDate;
	}
	
	public void setOkayDate(String okayDate)
	{
		this.okayDate = okayDate;
	}
	
	
	/*
	 * Constructor with parameters.
	 * 
	 */
	
	public CageHealthStatus(int cageId, int diseaseId, String disease_present, String okayDate) 
	{
		this.cageId = cageId;
		this.diseaseId = diseaseId;
		this.disease_present = disease_present;
		this.okayDate = okayDate;
	}
	
	
	/*
	 * Empty Parameters Constructor.
	 */
	
	public CageHealthStatus()
	{
		
	}

}// end of CageHealthStatus class.
