package DBLayer;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

public class DbConnection1Test {

	@Test
	public void testGetInstance() {

		Connection con = DbConnection1.getInstance().getDBcon();
		if(con != null)
		{
			System.out.println("Connection to Database");
		}
		else
		{
			fail("Not yet implemented");
		}
		
		
	}

}