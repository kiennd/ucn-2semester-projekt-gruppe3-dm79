package ModelLayer;

import java.sql.Date;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class SalesOrder 
{
	private int salesOrderID;
	private String creationDate;
	private String deliveryDate;
	private String deliveryStatus;
	private double totalAmount;
	private Customer myCustomer;
	ArrayList <ProductSalesOrder> productsalesorderlist;
	
	private SalesOrder(int salesOrderID, Customer myCustomer)
	{
		this.salesOrderID = salesOrderID;
		this.myCustomer = myCustomer;
		creationDate = this.getTodaysDate();
		deliveryDate = "";
		deliveryDate = "";
		deliveryStatus = "Order Confirmed";
		totalAmount = 0;
		productsalesorderlist = new ArrayList<ProductSalesOrder>();   
	}

	

	//Empty constructor for creating objects of SalesOrder.
	public SalesOrder()
	{
		
	}
	
	
	//add ProductSalesOrder - adds products and quantity to the list.
	
	public void addProductSalesOrder(SalesOrder salesOrder, Product product, int quantity)
    {
        totalAmount += product.getSalesPrice()*quantity;
        ProductSalesOrder prodsale = new ProductSalesOrder(salesOrder, product, quantity);
        productsalesorderlist.add(product.getProductId(), prodsale);
    }
	

	
//methods.
	
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


	
    public void addProductSalesOrder(ProductSalesOrder newitem)
    {
    	productsalesorderlist.add(newitem);
    }
    

    
    /** A Private Method to find todays date, and return the date in String format.
     * @return returns todays date as a string
     */
    public String getTodaysDate() 
      {
        
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(calendar.getTime());
      }

}
