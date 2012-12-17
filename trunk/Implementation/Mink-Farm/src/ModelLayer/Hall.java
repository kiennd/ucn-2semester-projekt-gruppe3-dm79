package ModelLayer;
import java.util.ArrayList;

public class Hall 
{
	private int hallNo;
	private int numbOfCages;
	private ArrayList<Column> myColumn;
	
	public Hall(int hallNo, int numbOfCages)
	{
		this.hallNo = hallNo;
		this.numbOfCages = numbOfCages;
		ArrayList<Column> myColumn;
	}

	public int getHallNo() {
		return hallNo;
	}

	public void setHallNo(int hallNo) {
		this.hallNo = hallNo;
	}

	public ArrayList<Column> getMyColumn() {
		return myColumn;
	}

	public void setMyColumn(ArrayList<Column> myColumn) {
		this.myColumn = myColumn;
	}

	public int getNumbOfCages() {
		return numbOfCages;
	}

	public void setNumbOfCages(int numbOfCages) {
		this.numbOfCages = numbOfCages;
	}
	
	
	
	
	
}

