import java.util.Scanner;
import java.lang.Math;

public class Main 
{
	public static void main(String[] args) 
	{
		System.out.println("You play to 3");
		
		Scanner scan = new Scanner(System.in);
		
		String[] choices = {"sten", "sax", "påse"};
		
		int randomNumber;
		randomNumber = (int) Math.random() * 3;
		
		
		String playerChoice = scan.nextLine();

		
	}
	
	public static void calculating(int a)
	{
		if(playerChoice.equalsIgnoreCase(choices[0]))
		{
			System.out.println("Working");
		}
		
		else
		{
			System.out.println("Not working");
		}
	}

}
