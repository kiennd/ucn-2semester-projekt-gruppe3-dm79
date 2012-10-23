package ModelLayer;

public class Invoice {

	private int invoiceNo;
	private String paymentDate;
	private double totalAmount;
	
	private Invoice (int invoiceNo, String paymentDate, double totalAmount)
	{
	this.invoiceNo = invoiceNo;
	this.paymentDate = paymentDate;
	this.totalAmount = totalAmount;
	}

	public int getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(int invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	
	
	
}
