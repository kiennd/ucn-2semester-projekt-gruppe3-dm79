
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
	private int cageNo, diseaseId_p, diseaseId_b;
	private String disease_present, okayDate;
	
	
/*
 * set and get methods.
 * 
 */
	
	public int getCageId() 
	{
		return cageNo;
	}
	
	public void setCageNo(int cageNo) 
	{
		this.cageNo = cageNo;
	}
	
	
	public int getDiseaseId_b() 
	{
		return diseaseId_b;
	}

	public void setDiseaseId_b(int diseaseId_b) 
	{
		this.diseaseId_b = diseaseId_b;
	}

	public int getDiseaseId_p() 
	{
		return diseaseId_p;
	}

	public void setDiseaseId_p(int diseaseId_p) 
	{
		this.diseaseId_p = diseaseId_p;
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
	
	public CageHealthStatus(int cageNo, int diseaseId_p, int diseaseId_b, String disease_present, String okayDate) 
	{
		this.cageNo = cageNo;
		this.diseaseId_p = diseaseId_p;
		this.diseaseId_b = diseaseId_b;
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
