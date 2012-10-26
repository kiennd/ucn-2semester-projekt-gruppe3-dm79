package ModelLayer;

import java.util.ArrayList;

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
	ArrayList <ProductSalesOrder> productsalesorderlist;
	
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
		productsalesorderlist = new ArrayList<ProductSalesOrder>();   
	}

	//Empty constructor for creating objects of SalesOrder.
	public SalesOrder()
	{
		
	}
	
	
	/**
	 * 
	 * constructor for creating objects of salesorder with the given id.
	 */
	
	public SalesOrder(int salesOrderID)
	{
		this.salesOrderID = salesOrderID;
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
	
	
    public void addProductSalesOrder(ProductSalesOrder newitem)
    {
    	productsalesorderlist.add(newitem);
    }
    
	

}
