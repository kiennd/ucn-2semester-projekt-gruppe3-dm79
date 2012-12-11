package ModelLayer;

public class mfColumn {
	
	private int colNo;
	private int numOfCol;
	private int cageNo;
	
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
	
	public void setCageNo(int cageNo) {
		this.cageNo = cageNo;
	}
	
	public int getCageNo() {
		return cageNo;
	}

}
