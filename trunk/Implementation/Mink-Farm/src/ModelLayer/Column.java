package ModelLayer;
import java.util.ArrayList;

public class Column {
	
	private int colNo;
	private int numOfCol;
	private ArrayList<Cage> myCage;
	
	
	public Column(int colNo, int numOfCol)
	{
		this.colNo = colNo;
		this.numOfCol = numOfCol;
	}
	
	public Column()
	{
		
	}
	
	
	public void setMyCage(ArrayList<Cage> myCage) {
		this.myCage = myCage;
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
