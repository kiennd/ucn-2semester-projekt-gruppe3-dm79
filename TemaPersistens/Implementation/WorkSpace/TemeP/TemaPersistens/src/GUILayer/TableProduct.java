package GUILayer;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import ModelLayer.Product;
public class TableProduct extends DefaultTableModel {
        /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private ArrayList<Product> data;

        public TableProduct()
        {
            data = new ArrayList<Product>();
        }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    
        
    public void setData(ArrayList<Product> data)
    {
        this.data = data;
        fireTableDataChanged();
    }

    public ArrayList<Product> getData() {
        return data;
    }
    
    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public int getRowCount() 
    {
        if(data == null)
        {
            return 0;
        }
        else
        {
            return data.size();
        }
    }

    @Override
    public String getColumnName(int column) {
        String columnName = "";
        switch(column)
        {
            case 0:
            columnName = "Product ID";
            break;  
            case 1:
            columnName = "Supplier ID";
            break;
            case 2:
            columnName = "Product Name";
            break;
            
            
        }        
        return columnName;
    }
    
    

    @Override
    public Object getValueAt(int row, int column) 
    {
        Object value = null;
        switch(column)
        {
            case 0:
                value = data.get(row).getProductId();
                break;
            case 1:
                value = data.get(row).getSupplier();
                break;
            case 2:
                value = data.get(row).getName();
                break;
            
        }
                
        return value;
    }        
        
}
