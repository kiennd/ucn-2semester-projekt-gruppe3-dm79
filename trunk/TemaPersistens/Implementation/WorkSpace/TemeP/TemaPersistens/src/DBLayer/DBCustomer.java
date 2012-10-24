package DBLayer;
import ModelLayer.*;

import java.sql.*;
import java.util.ArrayList;

public class DBCustomer implements IFDBCustomer
{
private Connection con;

public DBCustomer()
{
	//**Opretter en ny instance af DBCustomer
	con = DbConnection1.getInstance().getDBcon();
}

public ArrayList<Customer> getAllCustomer(boolean retriveAssociation)
{
	
}

private ArrayList<Customer> miscWhere(String wClause, boolean retrieveAssociation)
{
        ResultSet results;
    ArrayList<Customer> list = new ArrayList<Customer>();	
	
    String query =  buildQuery(wClause);

        try{ // read the employee from the database
	Statement stmt = con.createStatement();
 	stmt.setQueryTimeout(5);
 	results = stmt.executeQuery(query);
 	

	while( results.next() ){
		Customer cusObj = new Customer();
		cusObj = buildCustomer(results);	
             list.add(cusObj);	
	}//end while
             stmt.close();     
             if(retrieveAssociation)
             {   //The supervisor and department is to be build as well
                 for(Customer cusObj : list){
                    String superssn = empObj.getSupervisor().getSsn();
                    Employee superEmp = singleWhere(" ssn = '" + superssn + "'",false);
                    empObj.setSupervisor(superEmp);
                    System.out.println("Supervisor is seleceted");
                   // here the department has to be selected as well
                 }
             }//end if   
		
	}//slut try	
 	catch(Exception e){
 		System.out.println("Query exception - select: "+e);
		e.printStackTrace();
 	}
	return list;
}
private Customer singleWhere(String wClause, boolean retrieveAssociation)
{
	ResultSet results;
	Customer cusObj = new Customer();
            
        String query =  buildQuery(wClause);
            System.out.println(query);
	try{ // read the employee from the database
 		Statement stmt = con.createStatement();
 		stmt.setQueryTimeout(5);
 		results = stmt.executeQuery(query);
 		
 		if( results.next() ){
 			cusObj = buildCustomer(results);
                        //assocaition is to be build
                        stmt.close();
                        if(retrieveAssociation)
                        {   //The supervisor and department is to be build as well
                            String superssn = empObj.getSupervisor().getSsn();
                            Employee superEmp = singleWhere(" ssn = '" + superssn + "'",false);
                            empObj.setSupervisor(superEmp);
                            System.out.println("Supervisor is seleceted");
                           // here the department has to be selected as well
                            DBDepartment dbdept = new DBDepartment();
                            empObj.setDepartment(dbdept. findDepartment(empObj.getDept().getDnumber(), false));
                       
                        }
		}
                    else{ //no employee was found
                        empObj = null;
                    }
	}//end try	
 	catch(Exception e){
 		System.out.println("Query exception: "+e);
 	}
	return empObj;
}
//method to build the query
private String buildQuery(String wClause)
{
    String query="SELECT fname, minit,lname,ssn, address, bdate,sex, salary, superssn,dno  FROM employee";
	
	if (wClause.length()>0)
		query=query+" WHERE "+ wClause;
		
	return query;
}
private Customer buildCustomer(ResultSet results)
{  Customer cusObj = new Customer();
    try{ // the columns from the table emplayee  are used
    	cusObj.setCustID(results.getInt("custID"));
    	cusObj.setFname(results.getString("fname"));
    	cusObj.setLname(results.getString("lname"));
    	cusObj.setPno(results.getString("pno"));
    	cusObj.setEmail(results.getString("email"));
    	cusObj.setCustType(results.getString("custType"));
    	cusObj.setZipCode(results.getString("zipcode"));
    	cusObj.setCity(results.getString("city"));
    	
    	
    }
   catch(Exception e)
   {
       System.out.println("error in building the employee object");
   }
   return cusObj;
}



}
