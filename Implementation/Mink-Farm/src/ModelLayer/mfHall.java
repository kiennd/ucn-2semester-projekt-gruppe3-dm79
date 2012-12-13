package ModelLayer;
import java.util.ArrayList;

public class mfHall 
{
	private int hallNo;
	private int numbOfCages;
	private ArrayList<mfColumn> myColumn;
	
	public mfHall(int hallNo, int numbOfCages)
	{
		this.hallNo = hallNo;
		this.numbOfCages = numbOfCages;
		ArrayList<mfColumn> myColumn;
	}

	public int getHallNo() {
		return hallNo;
	}

	public void setHallNo(int hallNo) {
		this.hallNo = hallNo;
	}

	public ArrayList<mfColumn> getMyColumn() {
		return myColumn;
	}

	public void setMyColumn(ArrayList<mfColumn> myColumn) {
		this.myColumn = myColumn;
	}

	public int getNumbOfCages() {
		return numbOfCages;
	}

	public void setNumbOfCages(int numbOfCages) {
		this.numbOfCages = numbOfCages;
	}
	
	
	
	
	
}

