package databaser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class db 
{
	final String DATABAS = "epic_rpg";
	final String URL = "jdbc:mysql://localhost/";
	final String USER = "root";
	final String PWORD = "hej";
	final String SELECT_QUERY = "SELECT * FROM Characters";
	
	public void kopplaTillDB()
	{
		try
		(
			Connection conn = DriverManager.getConnection(URL + DATABAS, USER, PWORD);
			Statement stmt = conn.createStatement();
		)
		{
			stmt.executeUpdate("INSERT INTO Characters VALUES (\"hej\", \"då\"");
			ResultSet rSet = stmt.executeQuery(SELECT_QUERY);
			ResultSetMetaData metaData = rSet.getMetaData();
			int numOfColumns = metaData.getColumnCount();
			
			for(int i = 1; i <= numOfColumns; i++)
			{
				System.out.printf("%-8s\t", metaData.getColumnName(i).toUpperCase());	
			}
			System.out.println();
			System.out.println();
			while(rSet.next())
			{
				for(int i = 1; i <= numOfColumns; i++)
				{
					System.out.printf("%-8s\t", rSet.getObject(i));
				}
				System.out.println();
			}
		}
		catch(SQLException sqlException)
		{
			
		}
		
	} 
	
	public static void main(String[] args) 
	{
		db d = new db();
		d.kopplaTillDB();
	}

}
