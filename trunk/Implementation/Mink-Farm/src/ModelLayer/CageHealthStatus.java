
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
	private int cageNumber;
	private String plasmacytosisObserveret, bideS�rObserveret, okayDate;
	
	/*
	 * set and get methods.
	 * 
	 */
	public int getCageNumber()
	{
		return cageNumber;
	}


	public void setCageNumber(int cageNumber) 
	{
		this.cageNumber = cageNumber;
	}


	public String getPlasmacytosisObserveret() 
	{
		return plasmacytosisObserveret;
	}


	public void setPlasmacytosisObserveret(String plasmacytosisObserveret) 
	{
		this.plasmacytosisObserveret = plasmacytosisObserveret;
	}


	public String getBideS�rObserveret() 
	{
		return bideS�rObserveret;
	}


	public void setBideS�rObserveret(String bideS�rObserveret) 
	{
		this.bideS�rObserveret = bideS�rObserveret;
	}


	public String getOkayDate() 
	{
		return okayDate;
	}


	public void setOkayDate(String okayDate) 
	{
		this.okayDate = okayDate;
	}

	
//constructor with parameters.
	/**
	 * @param cageNumber
	 * @param plasmacytosisObserveret
	 * @param bideS�rObserveret
	 * @param okayDate
	 */
	public CageHealthStatus(int cageNumber, String plasmacytosisObserveret, String bideS�rObserveret, String okayDate) 
	{
		this.cageNumber = cageNumber;
		this.plasmacytosisObserveret = plasmacytosisObserveret;
		this.bideS�rObserveret = bideS�rObserveret;
		this.okayDate = okayDate;
	}


	/*
	 * Empty Parameters Constructor.
	 */
	public CageHealthStatus()
	{
		
	}


}// end of CageHealthStatus class.
