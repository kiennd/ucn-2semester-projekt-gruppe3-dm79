package ModelLayer;


import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class SalesOrder 
{
	private int salesOrderID;
	private String creationDate;
	private String deliveryDate;
	private double deliveryCost;
	private double percentageDiscount;
	private String deliveryStatus;
	private double totalAmount;
	private Customer myCustomer;
	private Invoice invoice;
	
	ArrayList <ProductSalesOrder> productsalesorderlist;
	
	public SalesOrder(int salesOrderID, Customer myCustomer)
	{
		this.salesOrderID = salesOrderID;
		this.myCustomer = myCustomer;
		creationDate = this.getTodaysDate();
		deliveryDate = "";
		deliveryCost = 45;
		percentageDiscount = 0;
		deliveryStatus = "Order Confirmed";
		totalAmount = 0;
		productsalesorderlist = new ArrayList<ProductSalesOrder>();  
		this.invoice = null;
	}

	

	//Empty constructor for creating objects of SalesOrder.
	public SalesOrder()
	{
		
	}
	
	
    
    
//Set and get methods.
	
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
	
	
	public Invoice getInvoice(){
		return invoice;
	}
	
	public void setInvoice(Invoice invoice){
		this.invoice = invoice;
	}


	
   // public void addProductSalesOrder(ProductSalesOrder newitem)
    //{
    	//productsalesorderlist.add(newitem);
   // }
    
    
	public double getDeliveryCost() {
		return deliveryCost;
	}


	public void setDeliveryCost(double deliveryCost) {
		this.deliveryCost = deliveryCost;
	}

	
	public double getPercentageDiscount() {
		return percentageDiscount;
	}



	public void setPercentageDiscount(double percentageDiscount) {
		this.percentageDiscount = percentageDiscount;
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

    
	//add ProductSalesOrder - adds products and quantity to the list.
	
	public void addProductSalesOrder(SalesOrder salesOrder, Product product, int quantity)
    {
        
		
		totalAmount += product.getSalesPrice()*quantity;
        ProductSalesOrder prodsale = new ProductSalesOrder(salesOrder, product, quantity);
        productsalesorderlist.add(prodsale);
        
        //check for customertype discount
        String custType = myCustomer.getType();
        
        if(custType == "private")
        {
        	if(totalAmount > 2500 )
        		setDeliveryCost(0);
        }
        else if(custType == "club")
        {
        	if(totalAmount > 1500)
        		setPercentageDiscount(0.05);
        }
    }
	
	
	
    /**
     * removes a product and it's quantities from a salesorder and resets the price.
     * 
     */
    public void removeProductSalesOrder(Product product)
    {
    	ProductSalesOrder pso = productsalesorderlist.get(product.getProductId());
    	totalAmount -= product.getSalesPrice()*pso.getQuantity();
    	productsalesorderlist.remove(product.getProductId());	
        String custType = myCustomer.getType();
        //reset customertype discount 
        if(custType == "private")
        {
        	if(totalAmount <= 2500 )
        		setDeliveryCost(45);
        }
        else if(custType == "club")
        {
        	if(totalAmount <= 1500)
        		setPercentageDiscount(0.00);
        }
    }
    
    
    
    





}//end of class SalesOrder. 
