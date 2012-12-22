
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
	private String plasmacytosisObserveret, bideSårObserveret, okayDate;
	
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


	public String getBideSårObserveret() 
	{
		return bideSårObserveret;
	}


	public void setBideSårObserveret(String bideSårObserveret) 
	{
		this.bideSårObserveret = bideSårObserveret;
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
	 * @param bideSårObserveret
	 * @param okayDate
	 */
	public CageHealthStatus(int cageNumber, String plasmacytosisObserveret, String bideSårObserveret, String okayDate) 
	{
		this.cageNumber = cageNumber;
		this.plasmacytosisObserveret = plasmacytosisObserveret;
		this.bideSårObserveret = bideSårObserveret;
		this.okayDate = okayDate;
	}


	/*
	 * Empty Parameters Constructor.
	 */
	public CageHealthStatus()
	{
		
	}


}// end of CageHealthStatus class.
