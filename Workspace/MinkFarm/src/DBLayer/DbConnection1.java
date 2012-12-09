package DBLayer;
import java.sql.*;
public class DbConnection1 
{
	 //constants used to get access to the database
		//SQL Server
	   private static final String  driver =  "jdbc:sqlserver://balder.ucn.dk:1433";
	   private static final String  databaseName = ";databaseName=dm79_3";
	//jdbc:sqlserver://URL\SQLEXPRESS/Databases/EPS:1357;user=epsingall;password=welkom1;
	    //SQL Server
	  //  private static String  userName = ";user=DM79_3";
	    private static String  userName = "; user=DM79_3";
	    private static String password = ";password=MaaGodt";
	   
	  
	    private DatabaseMetaData dma;
	    private static Connection con;
	    // an instance of the class is generated
	    private static DbConnection1  instance = null;

	    // the constructor is private to ensure that only one object of this class is created
	    private DbConnection1()
	    {
	    	String url = driver + databaseName + userName + password;

	        try{
	            //load driver
	            //SQL Server
	            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	            System.out.println("Load of class ok");
	          
	        }
	        catch(Exception e){
	            System.out.println("Cannot find the driver");
	            System.out.println(e.getMessage());
	        }//end catch
	        try{
	            //connection to the database
	           
	            con = DriverManager.getConnection(url);
	            //set auto commit
	            con.setAutoCommit(true);
	            dma = con.getMetaData(); // get meta data
	            System.out.println("Connection to " + dma.getURL());
	            System.out.println("Driver " + dma.getDriverName());
	            System.out.println("Database product name " + dma.getDatabaseProductName());
	        }//end try
	        catch(Exception e){

	            System.out.println("Problems with the connection to the database");
	            System.out.println(e.getMessage());
	            System.out.println(url);
	        }//end catch
	    }//end  constructor
		   
	  //closeDb: closes the connection to the database
	    public static void closeConnection()
	    {
	       	try{
	            con.close();
	            System.out.println("The connection is closed");
	        }
	         catch (Exception e){
	            System.out.println("Error trying to close the database " +  e.getMessage());
	         }
	    }//end closeDB
			
	    //getDBcon: Get-metode, returnerer forbindelsen til databasen
	    public  Connection getDBcon()
	    {
	       return con;
	    }
	    //this method is used to get the instance of the connection
	    public static DbConnection1 getInstance()
	    {
	        if (instance == null)
	        {
	          instance = new DbConnection1();
	        }
	        return instance;
	    }
	    public static void startTransaction()
	    { try{
	        con.setAutoCommit(false);
	        }
	      catch(Exception e){
	        System.out.println("fejl start transaction");
	        System.out.println(e.getMessage());
	      }
	    }
	    public static void commitTransaction()
	    { try{
	        con.setAutoCommit(true);
	        }
	      catch(Exception e){
	        System.out.println("fejl commit transaction");
	        System.out.println(e.getMessage());
	      }
	    }
	    public static void rollbackTransaction()
	    { try{
	        con.rollback();
	        con.setAutoCommit(true);
	        }
	      catch(Exception e){
	        System.out.println("fejl rollback transaction");
	        System.out.println(e.getMessage());
	      }
	    }
	}//end DbConnection
