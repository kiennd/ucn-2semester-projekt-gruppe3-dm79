package ModelLayer;

public class SalesOrder 
{
	private int salesOrderID;
	private String creationDate;
	private String deliveryDate;
	private String deliveryStatus;
	private String status;
	private double totalAmount;
	private Customer myCustomer;
	private Invoice Myinvoice;
	
	private SalesOrder(int salesOrderID, String creationDate, String deliveryDate, String deliveryStatus, String status, double totalAmount, Customer customer, Invoice invoice)
	{
		this.salesOrderID = salesOrderID;
		this.creationDate = creationDate;
		this.deliveryDate = deliveryDate;
		this.deliveryStatus = deliveryStatus;
		this.status = status;
		this.totalAmount = totalAmount;
		myCustomer = customer;
		Myinvoice = invoice;
	}

	public int getSalesOrderID() {
		return salesOrderID;
	}

	public void setSalesOrderID(int salesOrderID) {
		this.salesOrderID = salesOrderID;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Customer getCustomer() {
		return myCustomer;
	}

	public void setCustomer(Customer customer) {
		this.myCustomer = customer;
	}

	public Invoice getInvoice() {
		return Myinvoice;
	}

	public void setInvoice(Invoice invoice) {
		this.Myinvoice = invoice;
	}
	

}