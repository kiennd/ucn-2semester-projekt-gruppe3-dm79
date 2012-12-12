package ModelLayer;

/**
*
* @author DM79_group 3
* @version December 2012.
*/


/*
 * Objects of this class are created whenever Bites or Plasmacytosis disease is found in a cage.  
 */

public class Transfer 
{
	private int transferId;
	private String transferDate;
	private mfCage cage;
	private PlasmaDisease disease_p;
	private BiteDisease disease_b;
	private mfEmployee employee; 
	
	
	
	/*
	 * set and get methods.
	 */
	
	public int getTransferId() 
	{
		return transferId;
	}
	
	public void setTransferId(int transferId) 
	{
		this.transferId = transferId;
	}
	
	public String getTransferDate() 
	{
		return transferDate;
	}
	
	public void setTransferDate(String transferDate) 
	{
		this.transferDate = transferDate;
	}
	
	public BiteDisease getDisease_b() 
	{
		return disease_b;
	}
	
	public void setDisease_b(BiteDisease disease_b) 
	{
		this.disease_b = disease_b;
	}
	
	public PlasmaDisease getDisease_p() 
	{
		return disease_p;
	}
	
	public void setDisease_p(PlasmaDisease disease_p) 
	{
		this.disease_p = disease_p;
	}
	
	public mfEmployee getEmployee() 
	{
		return employee;
	}
	
	public void setEmployee(mfEmployee employee) 
	{
		this.employee = employee;
	}
	
	public mfCage getCage() 
	{
		return cage;
	}
	
	public void setCage(mfCage cage) 
	{
		this.cage = cage;
	}

	
	/*
	 * Constructor with parameters.
	 */
	
	public Transfer(int transferId, String transferDate, mfCage cage, PlasmaDisease disease_p, BiteDisease disease_b, mfEmployee employee) 
	{
		this.transferId = transferId;
		this.transferDate = transferDate;
		this.cage = cage;
		this.disease_p = disease_p;
		this.disease_b = disease_b;
		this.employee = employee;
		
	}
	
	
	/*
	 * Empty Parameters Constructor.
	 */
	
	public Transfer()
	{
		
	}


}//end of Transfer class.
