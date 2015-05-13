package epic_rpg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Player 
{
	final String DATABASE = "epic_rpg";
	final String URL = "jdbc:mysql://localhost/";
	final String USER = "root";
	final String PWORD = "hej";
	
	public static ArrayList<Object> reslutSetObjects = new ArrayList<>();
	public static ArrayList<String> columnNames = new ArrayList<>();
	public static int numOfColumns;
	
	public Player()
	{
		connectToDatabase();
	}
	
	public void connectToDatabase() // ansluter till databasen och hämtar information
	{
		try
		(
			Connection conn = DriverManager.getConnection(URL + DATABASE, USER, PWORD);
			Statement stmt = conn.createStatement();
		)
		{
			System.out.println("ok");
			if(!Main.insertQuery.isEmpty())
			{
				System.out.println(Main.insertQuery);
				stmt.executeUpdate(Main.insertQuery);
			}
			
			ResultSet rSet = stmt.executeQuery("SELECT  * FROM Characters");
			ResultSetMetaData metaData = rSet.getMetaData();
			numOfColumns = metaData.getColumnCount();
			
			if(!columnNames.isEmpty())
			{
				columnNames.clear();
				reslutSetObjects.clear();
			}
			
			for(int i = 1; i <= numOfColumns; i++)
			{
				columnNames.add(metaData.getColumnName(i));
			}
			
			while(rSet.next())
			{
				for(int i = 1; i <= numOfColumns; i++)
				{
					reslutSetObjects.add(rSet.getObject(i));
				}
			}
		}
		catch(SQLException sqlE)
		{
			sqlE.printStackTrace();
			System.out.println("noo");
		}
	}
}
