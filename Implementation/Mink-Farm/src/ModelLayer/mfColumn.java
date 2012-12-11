package ModelLayer;

public class mfColumn {
	
	private String colNo;
	private String numOfCol;
	
	public mfColumn(String colNo, String numOfCol) {
		this.colNo = colNo;
		this.numOfCol = numOfCol;
	}
	
	public void setColNo(String colNo) {
		this.colNo = colNo;
	}
	
	public String getColNo() {
		return colNo;
	}
	
	public void setNumOfCol(String numOfCol) {
		this.numOfCol = numOfCol;
	}
	
	public String getNumOfCol() {
		return numOfCol;
	}

}
