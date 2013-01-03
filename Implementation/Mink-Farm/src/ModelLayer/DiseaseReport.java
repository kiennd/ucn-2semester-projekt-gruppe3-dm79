package ModelLayer;

public class DiseaseReport {
	
private int cageNo;
private int diseaseId;
private String reportDate;

public int getCageNo() {
	return cageNo;
}

public int getDiseaseId() {
	return diseaseId;
}

public String getReportDate() {
	return reportDate;
}

public DiseaseReport(int cageNo, int diseaseId, String reportdate) {
	super();
	this.cageNo = cageNo;
	this.diseaseId = diseaseId;
	this.reportDate = reportdate;
}


}
