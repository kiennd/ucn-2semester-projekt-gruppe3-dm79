package ModelLayer;
import java.util.ArrayList;

public class mfColumn {
	
	private int colNo;
	private int numOfCol;
	private ArrayList<mfCage> myCage;
	
	
	public mfColumn(int colNo, int numOfCol)
	{
		this.colNo = colNo;
		this.numOfCol = numOfCol;
	}
	
	public mfColumn()
	{
		
	}
	
	
	public void setMyCage(ArrayList<mfCage> myCage) {
		this.myCage = myCage;
	}

	public mfColumn(int colNo, int numOfCol, int cageNo) {
		this.colNo = colNo;
		this.numOfCol = numOfCol;
	}
	
	public void setColNo(int colNo) {
		this.colNo = colNo;
	}
	
	public int getColNo() {
		return colNo;
	}
	
	public void setNumOfCol(int numOfCol) {
		this.numOfCol = numOfCol;
	}
	
	public int getNumOfCol() {
		return numOfCol;
	}

}
